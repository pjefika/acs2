/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.equipamento;

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
import controller.AbstractController;
import dao.EquipamentoDAO;
import java.util.List;
import dao.LogDAO;
import java.util.Calendar;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import model.device.firmware.FirmwareInfo;
import model.device.ping.PingRequest;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.wifi.WifiInfo;
import model.device.wifi.WifiInfoFull;
import model.entity.Log;
import model.entity.Parametro;

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
    public void detalhes(String guid) {

        JsonObject jobj = new JsonObject();

        NbiDeviceData ndd;
        try {
            ndd = dao.findDeviceByGUID(new Long(guid));

            Boolean checkOnline = dao.checkOnline(ndd);

            if (checkOnline) {
                FirmwareInfo oi = dao.getFirmwareVersion(ndd);
                if (oi != null) {
                    Boolean getFirmIsOk = oi.isOk();
                    jobj.add("firmWareOk", new Gson().toJsonTree(getFirmIsOk));
                }
            }

            jobj.add("eqp", new Gson().toJsonTree(ndd));
            jobj.add("checkOn", new Gson().toJsonTree(checkOnline));
            this.gerarLog(ndd, "Detalhes equipamento", "");
            result.include("equipamento", new Gson().toJson(jobj));

        } catch (NBIException_Exception ex) {
            result.include("exception", "Falha ao consultar Serviços Motive.");
        }
    }

    @Path("/equipamento/detalhe/json/{guid}")
    public void detalhesJson(String guid) {
        try {
            this.includeSerializer(dao.findDeviceByGUID(new Long(guid)));
        } catch (NBIException_Exception ex) {
            this.includeSerializer(ex);
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getFirmwareVersion/")
    public void getFirmwareVersion(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getFirmwareVersion(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando getFirmwareVersion");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getWifiInfo/")
    public void getWifiInfo(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getWifiInfo(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando getWifiInfo");
            e.printStackTrace();
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getWifiInfoFull/")
    public void getWifiInfoFull(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getWifiInfoFull(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando getWifiInfoFull");
            e.printStackTrace();
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getWanInfo/")
    public void getWanInfo(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getWanInfo(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando getWanInfo");
            e.printStackTrace();
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getXdslDiagnostics/")
    public void getXdslDiagnostics(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getXdslDiagnostic(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando getXdslDiagnostic");
            e.printStackTrace();
        }
    }
    
    @Post
    @Consumes("application/json")
    @Path("/equipamento/getInterfaceStatistics/")
    public void getInterfaceStatistics(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getInterfaceStatistics(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando getInterfaceStatistics");
            e.printStackTrace();
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getPortMapping/")
    public void getPortMappingInfo(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getPortMapping(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro ao buscar getPortMapping");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getLanHosts/")
    public void getLanHosts(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getLanHosts(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro ao buscar getLanHosts");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/updateFirmwareVersion/")
    public void updateFirmwareVersion(NbiDeviceData nbiDeviceData) {
        try {
            this.gerarLog(nbiDeviceData, "Update Firmware", "");
            this.includeSerializer(dao.firmwareUpdate(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando updateFirmwareVersion");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/reboot/")
    public void reboot(NbiDeviceData nbiDeviceData) {
        try {
            this.gerarLog(nbiDeviceData, "Reboot", "");
            this.includeSerializer(dao.reboot(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando reboot");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/factoryReset/")
    public void factoryReset(NbiDeviceData nbiDeviceData) {
        try {
            this.gerarLog(nbiDeviceData, "Factory Reset", "");
            dao.factoryReset(nbiDeviceData);
        } catch (Exception e) {
            this.includeSerializer("Erro no comando factoryReset");
        }
    }

    @Post("/equipamento/setWifiInfo/")
    @Consumes(value = "application/json", options = WithRoot.class)
    public void setWifi(NbiDeviceData nbiDeviceData, WifiInfo info) {
        try {
            dao.setWifiInfo(nbiDeviceData, info);
            this.includeSerializer(dao.getWifiInfoFull(nbiDeviceData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Post("/equipamento/setWifiInfoFull/")
    @Consumes(value = "application/json", options = WithRoot.class)
    public void setWifiFull(NbiDeviceData nbiDeviceData, WifiInfoFull info) {
        try {
            Gson gson = new Gson();
            String obj = gson.toJson(info);
            this.gerarLog(nbiDeviceData, "SetWifi", obj);

            dao.setWifiInfoFull(nbiDeviceData, info);
            this.includeSerializer(dao.getWifiInfoFull(nbiDeviceData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/checkOnline/")
    public void checkOnline(NbiDeviceData nbiDeviceData) {
        this.includeSerializer(dao.checkOnline(nbiDeviceData));
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getPPPoe/")
    public void getPPPoECredentials(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getPPPoECredentials(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando getPPPoECredentials");
        }
    }

    @Post
    @Consumes(value = "application/json", options = WithRoot.class)
    @Path("/equipamento/setPPPoe/")
    public void setPPPoECredentials(NbiDeviceData nbiDeviceData, PPPoECredentialsInfo pPPoECredentialsInfo) {
        try {
            Gson gson = new Gson();
            String obj = gson.toJson(pPPoECredentialsInfo);
            this.gerarLog(nbiDeviceData, "SetPPPoECredentials", obj);
            this.includeSerializer(dao.setPPPoECredentials(nbiDeviceData, pPPoECredentialsInfo));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando setPPPoECredentials");
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getDdns/")
    public void getDdns(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getDdns(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando getDdns");
        }
    }

    @Post
    @Consumes(value = "application/json", options = WithRoot.class)
    @Path("/equipamento/pingDiagnostic/")
    public void pingDiagnostic(NbiDeviceData nbiDeviceData, String request) {
        try {
            PingRequest ping = new PingRequest();
            ping.setDestAddress(request);
            this.includeSerializer(dao.pingDiagnostic(nbiDeviceData, ping));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando pingDiagnostic");
        }
    }

    @Post
    @Consumes(value = "application/json", options = WithRoot.class)
    @Path("/equipamento/setPortMapping/")
    public void setPortMappingInfo(NbiDeviceData nbiDeviceData, List<PortMappingInfo> ports) {
        try {
            dao.setPortMapping(nbiDeviceData, ports);
            this.includeSerializer(dao.getPortMapping(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer("Erro no comando setPortMappingInfo");
        }
    }

    public void gerarLog(NbiDeviceData nbiDeviceData, String acao, String valores) {
        System.out.println("Entrou Log");
        Gson gson = new Gson();
        String nbb = gson.toJson(nbiDeviceData);
        Log log = new Log();
        log.setEquipamento(nbb);
        log.setAcao(acao);
        log.setCalendar(Calendar.getInstance());
        log.setLogin(this.sessionUsuarioEfika.getUsuario().getLogin());
        this.logDAO.cadastrar(log);
        if (!valores.isEmpty()) {
            System.out.println("Entrou parametros");
            Parametro parametro = new Parametro();
            parametro.setLog(log);
            parametro.setValor(valores);
            this.logDAO.cadastrar(parametro);
        }
    }

    @Override
    public void includeSerializer(Object a) {
        result.use(Results.json()).from(a).recursive().serialize();
    }

}
