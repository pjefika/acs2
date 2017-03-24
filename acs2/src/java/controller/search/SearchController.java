/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.search;

import auth.annotation.Logado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.view.Results;
import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import controller.AbstractController;
import dao.EquipamentoDAO;
import exception.HdmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author G0034481
 */
@Controller
public class SearchController extends AbstractController {

    @Inject
    private EquipamentoDAO dao;

    public SearchController() {
    }

    @Path("/busca")
    @Logado
    public void create() {
    }

    @Path("/action")
    @Logado
    public void action() {
    }

    //@Consumes("application/json")
    /**
     *
     * @param serial
     * @throws exception.HdmException
     */
    @Path("/busca/listar/serial/{serial}")
    @Logado
    public void listarPorSerial(String serial) throws HdmException {
        try {
            this.includeSerializer(dao.listarEquipamentosPorSerial(serial));
        } catch (NBIException_Exception ex) {
            this.includeSerializer("A plataforma não respondeu à pesquisa por Serial.");
            throw new HdmException("A plataforma não respondeu à pesquisa por Serial.");
        }
    }

    @Path("/busca/listar/subscriber/{subscriber}")
    @Logado
    public void listarPorSubscriber(String subscriber) throws HdmException {
        try {
            this.includeSerializer(dao.listarEquipamentosPorSubscriber(subscriber));
        } catch (NBIException_Exception ex) {
            if(!ex.getFaultInfo().getFaultCode().contentEquals("devices.for.subscriberid.could.not.be.found")){
                this.includeSerializer("A plataforma não respondeu à pesquisa por Subscriber.");
                throw new HdmException("A plataforma não respondeu à pesquisa por Subscriber.");    
            }
        }
    }

    @Path("/busca/listar/mac/{mac}")
    @Logado
    public void listarPorMac(String mac) throws HdmException {
        try {
            this.includeSerializer(dao.listarEquipamentosPorMac(mac.toUpperCase()));
        } catch (NBIException_Exception ex) {
            ex.printStackTrace();
            this.includeSerializer("A plataforma não respondeu à pesquisa por MAC.");
            throw new HdmException("A plataforma não respondeu à pesquisa por MAC.");
        }
    }

    @Path("/busca/listar/guid/{guid}")
    @Logado
    public void listarPorGuid(Long guid) {
        try {
            this.includeSerializer(dao.findDeviceByGUID(guid));
        } catch (NBIException_Exception ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            this.includeSerializer(ex);
        }
    }

    @Override
    public void includeSerializer(Object a) {
        result.use(Results.json()).from(a).recursive().serialize();
    }

}
