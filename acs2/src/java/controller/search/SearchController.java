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
import model.exception.HdmException;
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
     * @throws model.exception.HdmException
     */
    @Path("/busca/listar/serial/{serial}")
    public void listarPorSerial(String serial) throws HdmException {
        try {
            this.includeSerializer(dao.listarEquipamentosPorSerial(serial));
        } catch (NBIException_Exception ex) {
            ex.printStackTrace();
            this.includeSerializer("A plataforma não respondeu à pesquisa por Serial.");
            throw new HdmException("A plataforma não respondeu à pesquisa por Serial.");
        }
    }

    @Path("/busca/listar/ip/{ip}")
    public void listarPorIp(String ip) throws HdmException {
        try {
            this.includeSerializer(dao.listarEquipamentosPorIp(ip));
        } catch (NBIException_Exception ex) {
            ex.printStackTrace();
            this.includeSerializer("A plataforma não respondeu à pesquisa por IP.");
            throw new HdmException("A plataforma não respondeu à pesquisa por IP.");
        }
    }

    @Path("/busca/listar/subscriber/{subscriber}")
    public void listarPorSubscriber(String subscriber) throws HdmException {
        try {
            this.includeSerializer(dao.listarEquipamentosPorSubscriber(subscriber));
        } catch (NBIException_Exception ex) {
            this.includeSerializer("A plataforma não respondeu à pesquisa por Subscriber.");
            throw new HdmException("A plataforma não respondeu à pesquisa por Subscriber.");
        }
    }

    @Path("/busca/listar/mac/{mac}")
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
