/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.equipamento;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.view.Results;
import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import controller.AbstractController;
import dao.EquipamentoDAO;
import javax.inject.Inject;
import javax.xml.ws.soap.SOAPFaultException;
import model.device.firmware.FirmwareInfo;
import model.device.wifi.WifiInfo;

/**
 *
 * @author G0042204
 */
@Controller
public class EquipamentoController extends AbstractController {

    @Inject
    private EquipamentoDAO dao;

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
            result.include("equipamento", new Gson().toJson(jobj));

        } catch (NBIException_Exception ex) {
            result.include("exception", "Falha ao consultar Serviços Motive.");
        }

    }

    @Path("/equipamento/detalhe/json/{guid}")
    public void detalhesJson(String guid) {
        try {
            this.includeSerializer(dao.findDeviceByGUID(new Long(guid)));
        } catch (SOAPFaultException | NBIException_Exception ex) {
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
            this.includeSerializer(e);
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/getWifiInfo/")
    public void getWifiInfo(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.getWifiInfo(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer(e);
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/updateFirmwareVersion/")
    public void updateFirmwareVersion(NbiDeviceData nbiDeviceData) {
        try {
            this.includeSerializer(dao.firmwareUpdate(nbiDeviceData));
        } catch (Exception e) {
            this.includeSerializer(e);
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/reboot/")
    public void reboot(NbiDeviceData nbiDeviceData) {
        try {
            dao.reboot(nbiDeviceData);
        } catch (Exception e) {
            this.includeSerializer(e);
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/factoryReset/")
    public void factoryReset(NbiDeviceData nbiDeviceData) {
        try {
            dao.factoryReset(nbiDeviceData);
        } catch (Exception e) {
            this.includeSerializer(e);
        }
    }

    @Post
    @Consumes("application/json")
    @Path("/equipamento/checkOnline/")
    public void checkOnline(NbiDeviceData nbiDeviceData) {
        this.includeSerializer(dao.checkOnline(nbiDeviceData));
    }

    @Override
    public void includeSerializer(Object a) {
        result.use(Results.json()).from(a).recursive().serialize();
    }

}
