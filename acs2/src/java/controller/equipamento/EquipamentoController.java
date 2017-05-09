/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.equipamento;

import auth.annotation.Logado;
import auth.controller.SessionUsuarioEfika;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.serialization.gson.WithRoot;
import br.com.caelum.vraptor.view.Results;
import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;
import controller.AbstractController;
import dao.EquipamentoDAO;
import dao.LogDAO;
import exception.HdmException;
import exception.JsonUtilException;
import exception.UnsupportedException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import model.device.firmware.FirmwareInfo;
import model.device.ping.PingRequest;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.wifi.WifiInfoFull;
import model.entity.Log;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
@Controller
@RequestScoped
public class EquipamentoController extends AbstractController {

    @Inject
    private EquipamentoDAO dao;

    @Inject
    private LogDAO logDAO;

    @Inject
    private SessionUsuarioEfika sessionUsuarioEfika;

    public EquipamentoController() {
    }

    @Path("/equipamento/detalhe/{guid}")
    @Logado
    public void detalhes(String guid) throws HdmException, InterruptedException {

        JsonObject jobj = new JsonObject();

        NbiDeviceData ndd;
        try {
            ndd = dao.findDeviceByGUID(new Long(guid));
            Boolean checkOnline = false;

            try {
                checkOnline = dao.checkOnline(ndd);

                if (checkOnline) {
                    Thread.sleep(6000);
                    FirmwareInfo oi = dao.getFirmwareVersion(ndd);
                    Boolean getFirmIsOk = oi.isOk();
                    jobj.add("firmWareOk", new Gson().toJsonTree(getFirmIsOk));
                    jobj.add("firmwareVersion", new Gson().toJsonTree(oi));
                }

            } catch (DeviceOperationException e) {
                checkOnline = false;
            } catch (ProviderException ex) {

            } catch (JsonUtilException ex) {

            }

            jobj.add("eqp", new Gson().toJsonTree(ndd));
            jobj.add("checkOn", new Gson().toJsonTree(checkOnline));
            this.gerarLog(ndd, "Detalhes", "");
            result.include("equipamento", new Gson().toJson(jobj));

        } catch (NBIException_Exception ex) {
            result.include("exception", "Equipamento não encontrado.");
        } catch (NBIException e) {
            result.include("exception", "A plataforma apresentou um erro generalizado ao obter os detalhes.");
        } catch (OperationTimeoutException e) {
            result.include("exception", "A plataforma demorou muito para responder ao obter os detalhes.");
        }
    }

    @Path("/equipamento/detalhe/json/{guid}")
    @Logado
    public void detalhesJson(String guid
    ) {
        try {
            this.includeSerializer(dao.findDeviceByGUID(new Long(guid)));
        } catch (NBIException_Exception ex) {
            this.includeSerializer(ex);
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getFirmwareVersion/")
    @Logado
    public void getFirmwareVersion(NbiDeviceData nbiDeviceData) throws HdmException {
        try {
            this.includeSerializer(dao.getFirmwareVersion(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao obter a versão de Firmware do equipamento.");
            throw new HdmException("A plataforma falhou ao obter a versão de Firmwarei do equipamento.");
        } catch (JsonUtilException e) {
            this.includeSerializer("A plataforma não retornou a versão de Firmware do equipamento devidamente.");
            throw new HdmException("A plataforma não retornou a versão de Firmware do equipamento devidamente.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter a versão de Firmware.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter a versão de Firmware.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter a versão de Firmware.");
            throw new HdmException("A plataforma demorou muito para responder ao obter a versão de Firmware.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter a versão de Firmware.");
            throw new HdmException("Erro no provedor da plataforma ao obter a versão de Firmware.");
        }
    }

//
//    @Post
//    @Consumes("application/json")
//    @Path("/equipamento/getWifiInfo/")
//    public void getWifiInfo(NbiDeviceData nbiDeviceData) {
//        try {
//            this.includeSerializer(dao.getWifiInfo(nbiDeviceData));
//        } catch (Exception e) {
//            e.printStackTrace();
////            Throw new HdmException();
//        }
//    }
    @Post
    @Consumes("application/json")
    @Path("/equipamento/getWifiInfoFull/")
    @Logado
    public void getWifiInfoFull(NbiDeviceData nbiDeviceData) throws HdmException {
        try {
            WifiInfoFull wifiInfoFull = dao.getWifiInfoFull(nbiDeviceData);
            this.gerarLog(nbiDeviceData, "getWifi", GsonUtil.serialize(wifiInfoFull));
            this.includeSerializer(wifiInfoFull);
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao obter os dados de Wifi do equipamento.");
            throw new HdmException("A plataforma falhou ao obter os dados de Wifi do equipamento.");
        } catch (JsonUtilException e) {
            this.includeSerializer("A plataforma não retornou os dados de Wifi do equipamento devidamente.");
            throw new HdmException("A plataforma não retornou os dados de Wifi do equipamento devidamente.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter os dados de Wifi.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter os dados de Wifi.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter os dados de Wifi.");
            throw new HdmException("A plataforma demorou muito para responder ao obter os dados de Wifi.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter os dados de Wifi.");
            throw new HdmException("Erro no provedor da plataforma ao obter os dados de Wifi.");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getWanInfo/")
    @Logado
    public void getWanInfo(NbiDeviceData nbiDeviceData) throws HdmException {
        try {
            this.includeSerializer(dao.getWanInfo(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao obter as medições Wan do equipamento.");
            throw new HdmException("A plataforma falhou ao obter as medições Wan do equipamento.");
        } catch (JsonUtilException e) {
            this.includeSerializer("A plataforma não retornou as medições Wan do equipamento devidamente.");
            throw new HdmException("A plataforma não retornou as medições Wan do equipamento devidamente.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter as medições Wan.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter as medições Wan.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter as medições Wan.");
            throw new HdmException("A plataforma demorou muito para responder ao obter as medições Wan.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter as medições Wan.");
            throw new HdmException("Erro no provedor da plataforma ao obter as medições Wan.");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getXdslDiagnostics/")
    @Logado
    public void getXdslDiagnostics(NbiDeviceData nbiDeviceData) throws HdmException {
        try {
            this.includeSerializer(dao.getXdslDiagnostic(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao obter as medições xDSL do equipamento.");
            throw new HdmException("A plataforma falhou ao obter as medições xDSL do equipamento.");
        } catch (JsonUtilException e) {
            this.includeSerializer("A plataforma não retornou as medições xDSL do equipamento devidamente.");
            throw new HdmException("A plataforma não retornou as medições xDSL do equipamento devidamente.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter as medições xDSL.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter as medições xDSL.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter as medições xDSL.");
            throw new HdmException("A plataforma demorou muito para responder ao obter as medições xDSL.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter as medições xDSL.");
            throw new HdmException("Erro no provedor da plataforma ao obter as medições xDSL.");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getInterfaceStatistics/")
    @Logado
    public void getInterfaceStatistics(NbiDeviceData nbiDeviceData) throws HdmException {
        try {
            this.includeSerializer(dao.getInterfaceStatistics(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao obter os dados de Interface Statistics do equipamento.");
            throw new HdmException("A plataforma falhou ao obter os dados de Interface Statistics do equipamento.");
        } catch (JsonUtilException e) {
            this.includeSerializer("A plataforma não retornou os dados de Interface Statistics do equipamento devidamente.");
            throw new HdmException("A plataforma não retornou os dados de Interface Statistics do equipamento devidamente.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter os dados de Interface Statistics.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter os dados de Interface Statistics.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter os dados de Interface Statistics.");
            throw new HdmException("A plataforma demorou muito para responder ao obter os dados de Interface Statistics.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter os dados de Interface Statistics.");
            throw new HdmException("Erro no provedor da plataforma ao obter os dados de Interface Statistics.");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getPortMapping/")
    @Logado

    public void getPortMappingInfo(NbiDeviceData nbiDeviceData) throws HdmException {
        try {
            this.includeSerializer(dao.getPortMapping(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao obter os dados de Port Mapping do equipamento.");
            throw new HdmException("A plataforma falhou ao obter os dados de Port Mapping do equipamento.");
        } catch (JsonUtilException e) {
            this.includeSerializer("A plataforma não retornou os dados de Port Mapping do equipamento devidamente.");
            throw new HdmException("A plataforma não retornou os dados de Port Mapping do equipamento devidamente.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter os dados de Port Mapping.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter os dados de Port Mapping.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter os dados de Port Mapping.");
            throw new HdmException("A plataforma demorou muito para responder ao obter os dados de Port Mapping.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter os dados de Port Mapping.");
            throw new HdmException("Erro no provedor da plataforma ao obter os dados de Port Mapping.");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getLanHosts/")
    @Logado
    public void getLanHosts(NbiDeviceData nbiDeviceData) throws HdmException {
        try {
            this.includeSerializer(dao.getLanHosts(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao obter os dados de Lan Host do equipamento.");
            throw new HdmException("A plataforma falhou ao obter os dados de Lan Host do equipamento.");
        } catch (JsonUtilException e) {
            this.includeSerializer("A plataforma não retornou os dados de Lan Host do equipamento devidamente.");
            throw new HdmException("A plataforma não retornou os dados de Lan Host do equipamento devidamente.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter os dados de Lan Host.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter os dados de Lan Host.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter os dados de Lan Host.");
            throw new HdmException("A plataforma demorou muito para responder ao obter os dados de Lan Host.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter os dados de Lan Host.");
            throw new HdmException("Erro no provedor da plataforma ao obter os dados de Lan Host.");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/updateFirmwareVersion/")
    @Logado
    public void updateFirmwareVersion(NbiDeviceData nbiDeviceData, FirmwareInfo info) throws HdmException {
        try {
            this.gerarLog(nbiDeviceData, "updateFirmwareVersion", info.getPreferredVersion());
            this.includeSerializer(dao.firmwareUpdate(nbiDeviceData, info));
        } catch (NBIException_Exception e) {
            this.includeSerializer("A plataforma apresentou erro ao atualizar o Firmware.");
            throw new HdmException("A plataforma apresentou erro ao atualizar o Firmware.");
        } catch (RemoteException ex) {
            Logger.getLogger(EquipamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/reboot/")
    @Logado
    public void reboot(NbiDeviceData nbiDeviceData) throws HdmException {

        try {
            this.gerarLog(nbiDeviceData, "Reboot", "");
            this.includeSerializer(dao.reboot(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao reiniciar o equipamento.");
            throw new HdmException("A plataforma falhou ao reiniciar o equipamento.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao reiniciar.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao reiniciar.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao reiniciar.");
            throw new HdmException("Erro no provedor da plataforma ao reiniciar.");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/factoryReset/")
    @Logado
    public void factoryReset(NbiDeviceData nbiDeviceData) throws HdmException {

        try {
            this.gerarLog(nbiDeviceData, "Factory Reset", "");
            this.includeSerializer(dao.factoryReset(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao aplicar reset de fábrica no equipamento.");
            throw new HdmException("A plataforma falhou ao aplicar reset de fábrica no equipamento.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao aplicar reset de fábrica.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao aplicar reset de fábrica.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao aplicar reset de fábrica.");
            throw new HdmException("Erro no provedor da plataforma ao aplicar reset de fábrica.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao aplicar reset de fábrica.");
            throw new HdmException("A plataforma demorou muito para responder ao aplicar reset de fábrica.");
        }
    }

//    @Post("/equipamento/setWifiInfo/")
//    @Consumes(value = "application/json", options = WithRoot.class)
//    public void setWifi(NbiDeviceData nbiDeviceData, WifiInfo info) {
//        try {
//            dao.setWifiInfo(nbiDeviceData, info);
//            this.includeSerializer(dao.getWifiInfoFull(nbiDeviceData));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    @Post("/equipamento/setWifiInfoFull/")
    @Consumes(value = "application/json", options = WithRoot.class)
    @Logado
    public void setWifiFull(NbiDeviceData nbiDeviceData, WifiInfoFull info) throws HdmException {
        try {
            Gson gson = new Gson();
            String obj = gson.toJson(info);
            this.gerarLog(nbiDeviceData, "setWifiFull", obj);
            dao.setWifiInfoFull(nbiDeviceData, info);
            getWifiInfoFull(nbiDeviceData);
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao definir as configurações de Wifi do equipamento.");
            throw new HdmException("A plataforma falhou ao definir as configurações de Wifi do equipamento.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao definir as configurações de Wifi.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao definir as configurações de Wifi.");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/checkOnline/")
    @Logado
    public void checkOnline(NbiDeviceData nbiDeviceData) throws HdmException {
        try {
            this.includeSerializer(dao.checkOnline(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("O equipamento está Offline.");
            throw new HdmException("O equipamento está Offline.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter o estado do equipamento (online/offline).");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter o estado do equipamento (online/offline).");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter o estado do equipamento (online/offline).");
            throw new HdmException("A plataforma demorou muito para responder ao obter o estado do equipamento (online/offline).");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter o estado do equipamento (online/offline).");
            throw new HdmException("Erro no provedor da plataforma ao obter o estado do equipamento (online/offline).");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getPPPoe/")
    @Logado
    public void getPPPoECredentials(NbiDeviceData nbiDeviceData) throws HdmException {

        try {
            this.includeSerializer(dao.getPPPoECredentials(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao obter as credenciais de Autenticação do equipamento.");
            throw new HdmException("A plataforma falhou ao obter as credenciais de Autenticação do equipamento.");
        } catch (JsonUtilException e) {
            this.includeSerializer("A plataforma não retornou as credenciais de Autenticação do equipamento devidamente.");
            throw new HdmException("A plataforma não retornou as credenciais de Autenticação do equipamento devidamente.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter as credenciais de Autenticação.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter as credenciais de Autenticação.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter as credenciais de Autenticação.");
            throw new HdmException("A plataforma demorou muito para responder ao obter as credenciais de Autenticação.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter as credenciais de Autenticação.");
            throw new HdmException("Erro no provedor da plataforma ao obter as credenciais de Autenticação.");
        }
    }

    @Post
    @Consumes(value = "application/json", options = WithRoot.class)
    @Path("/equipamento/setPPPoe/")
    @Logado
    public void setPPPoECredentials(NbiDeviceData nbiDeviceData, PPPoECredentialsInfo pPPoECredentialsInfo) throws HdmException {
        try {
            Gson gson = new Gson();
            String obj = gson.toJson(pPPoECredentialsInfo);
            this.gerarLog(nbiDeviceData, "setPPPoECredentials", obj);
            dao.setPPPoECredentials(nbiDeviceData, pPPoECredentialsInfo);
            getPPPoECredentials(nbiDeviceData);
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao definir as credenciais de Autenticação do equipamento.");
            throw new HdmException("A plataforma falhou ao definir as credenciais de Autenticação do equipamento.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao definir as credenciais de Autenticação.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao definir as credenciais de Autenticação.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao definir as credenciais de Autenticação.");
            throw new HdmException("A plataforma demorou muito para responder ao definir as credenciais de Autenticação.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao definir as credenciais de Autenticação.");
            throw new HdmException("Erro no provedor da plataforma ao definir as credenciais de Autenticação.");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getDdns/")
    @Logado
    public void getDdns(NbiDeviceData nbiDeviceData) throws HdmException {

        try {
            this.includeSerializer(dao.getDdns(nbiDeviceData));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao obter as informações de DNS do equipamento.");
            throw new HdmException("A plataforma falhou ao obter as informações de DNS do equipamento.");
        } catch (JsonUtilException e) {
            this.includeSerializer("A plataforma não retornou as informações de DNSo do equipamento devidamente.");
            throw new HdmException("A plataforma não retornou as informações de DNS do equipamento devidamente.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter as informações de DNS.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter as informações de DNS.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter as informações de DNS.");
            throw new HdmException("A plataforma demorou muito para responder ao obter as informações de DNS.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter as informações de DNS.");
            throw new HdmException("Erro no provedor da plataforma ao obter as informações de DNS.");
        }
    }

    @Post
    @Consumes(value = "application/json", options = WithRoot.class)
    @Path("/equipamento/pingDiagnostic/")
    @Logado
    public void pingDiagnostic(NbiDeviceData nbiDeviceData, String request) throws HdmException {

        try {
            PingRequest ping = new PingRequest();
            ping.setDestAddress(request);
            this.includeSerializer(dao.pingDiagnostic(nbiDeviceData, ping));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao efetuar ping para " + request + " do equipamento.");
            throw new HdmException("A plataforma falhou ao efetuar ping para " + request + " do equipamento.");
        } catch (JsonUtilException e) {
            this.includeSerializer("A plataforma não retornou as informações de ping para " + request + " do equipamento devidamente.");
            throw new HdmException("A plataforma não retornou as informações de ping para " + request + " do equipamento devidamente.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter as informações de ping para " + request + ".");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter as informações de ping para " + request + ".");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter as informações de ping para " + request + ".");
            throw new HdmException("A plataforma demorou muito para responder ao obter as informações de ping para " + request + ".");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter as informações de ping para " + request + ".");
            throw new HdmException("Erro no provedor da plataforma ao obter as informações de ping para " + request + ".");
        }
    }

    @Post
    @Consumes(value = "application/json", options = WithRoot.class)
    @Path("/equipamento/setPortMapping/")
    @Logado
    public void setPortMappingInfo(NbiDeviceData nbiDeviceData, List<PortMappingInfo> ports) throws HdmException {

        try {
            Gson gson = new Gson();
            String obj = gson.toJson(ports);
            this.gerarLog(nbiDeviceData, "setPortMappingInfo", obj);
            dao.setPortMapping(nbiDeviceData, ports);
//            this.includeSerializer(dao.getPortMapping(nbiDeviceData));
            getPortMappingInfo(nbiDeviceData);
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao definir os dados de Port Mapping do equipamento.");
            throw new HdmException("A plataforma falhou ao definir os dados de Port Mapping do equipamento.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao definir os dados de Port Mapping.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao definir os dados de Port Mapping.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao definir os dados de Port Mapping.");
            throw new HdmException("A plataforma demorou muito para responder ao definir os dados de Port Mapping.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao definir os dados de Port Mapping.");
            throw new HdmException("Erro no provedor da plataforma ao definir os dados de Port Mapping.");
        }
    }

    @Post
    @Consumes(value = "application/json", options = WithRoot.class)
    @Path("/equipamento/getSipDiagnostics/")
    @Logado
    public void getSipDiagnostics(NbiDeviceData nbiDeviceData, Integer phyref) throws HdmException {
        try {
            this.includeSerializer(this.dao.getSipDiagnostics(nbiDeviceData, phyref));
        } catch (DeviceOperationException e) {
            this.includeSerializer("A plataforma falhou ao obter as informações de SIP do equipamento.");
            throw new HdmException("A plataforma falhou ao obter as informações de SIP do equipamento.");
        } catch (NBIException e) {
            this.includeSerializer("A plataforma apresentou um erro generalizado ao obter as informações de SIP.");
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter as informações de SIP.");
        } catch (OperationTimeoutException e) {
            this.includeSerializer("A plataforma demorou muito para responder ao obter as informações de SIP.");
            throw new HdmException("A plataforma demorou muito para responder ao obter as informações de SIP.");
        } catch (ProviderException e) {
            this.includeSerializer("Erro no provedor da plataforma ao obter as informações de SIP.");
            throw new HdmException("Erro no provedor da plataforma ao obter as informações de SIP.");
        } catch (UnsupportedException e){
            this.includeSerializer(e.getMessage());
            throw new HdmException(e.getMessage());
        }
    }

    public void gerarLog(NbiDeviceData nbiDeviceData, String acao, String valores) {
        Gson gson = new Gson();
        String nbb = gson.toJson(nbiDeviceData);
        Log log = new Log();
        log.setEquipamento(nbb);
        log.setAcao(acao);
        log.setCalendar(Calendar.getInstance());
        log.setLogin(this.sessionUsuarioEfika.getUsuario().getLogin());
        log.setValor(valores);
        this.logDAO.cadastrar(log);
    }

    @Override
    public void includeSerializer(Object a) {
        result.use(Results.json()).from(a).recursive().serialize();
    }

}
