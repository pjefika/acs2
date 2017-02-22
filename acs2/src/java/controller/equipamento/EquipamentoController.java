/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.equipamento;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.view.Results;
import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.google.gson.Gson;
import controller.AbstractController;
import dao.EquipamentoDAO;
import javax.inject.Inject;
import javax.xml.ws.soap.SOAPFaultException;

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
        try {
            Gson gson = new Gson();
            String json = gson.toJson(dao.findDeviceByGUID(new Long(guid)), NbiDeviceData.class);
            result.include("equipamento", json);
        } catch (SOAPFaultException | NBIException_Exception ex) {
            this.includeSerializer(ex);
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

    @Override
    public void includeSerializer(Object a) {
        result.use(Results.json()).from(a).recursive().serialize();
    }

}
