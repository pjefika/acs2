/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.search;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.view.Results;
import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import controller.AbstractController;
import dao.EquipamentoDAO;
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
    public void create() {
    }

    @Path("/action")
    public void action() {
    }

    //@Consumes("application/json")
    /**
     *
     * @param serial
     */
    @Path("/busca/listar/serial/{serial}")
    public void listarPorSerial(String serial) {
        try {
            this.includeSerializer(dao.listarEquipamentosPorSerial(serial));
        } catch (NBIException_Exception ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            this.includeSerializer(ex);
        }
    }

    @Path("/busca/listar/subscriber/{subscriber}")
    public void listarPorSubscriber(String subscriber) {
        try {
            this.includeSerializer(dao.listarEquipamentosPorSubscriber(subscriber));
        } catch (NBIException_Exception ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            this.includeSerializer(ex);
        }
    }

    @Path("/busca/listar/mac/{mac}")
    public void listarPorMac(String mac) {
        try {
            this.includeSerializer(dao.listarEquipamentosPorMac(mac.toUpperCase()));
        } catch (NBIException_Exception ex) {
            Logger.getLogger(SearchController.class.getName()).log(Level.SEVERE, null, ex);
            this.includeSerializer(ex);
        }
    }
    
    @Path("/busca/listar/guid/{guid}")
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
