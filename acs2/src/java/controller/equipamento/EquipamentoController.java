/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.equipamento;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import controller.AbstractController;
import dao.EquipamentoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author G0042204
 */
@Controller
public class EquipamentoController extends AbstractController {

    private EquipamentoDAO dao;

    public EquipamentoController() {
    }

    @Path("/equipamento/detalhe/{guid}")
    public void detalhes(String guid) {
        try {
            this.dao = new EquipamentoDAO();
            this.includeSerializer(dao.detalheEquipamento(new Long(23006)));
        } catch (javax.xml.ws.soap.SOAPFaultException soapFaultException) {
            System.out.println(soapFaultException.getCause().getMessage());
        } catch (NBIException_Exception ex) {
            Logger.getLogger(EquipamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
