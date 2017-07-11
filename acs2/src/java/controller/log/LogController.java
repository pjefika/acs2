/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.log;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import controller.AbstractController;
import dao.LogDAO;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import model.entity.Log;

/**
 *
 * @author G0034481
 */
@Controller
@RequestScoped
public class LogController extends AbstractController{

    @Inject
    private LogDAO logDAO;
    
    
    @Path("/log/")
    public void create() {       
        
        
    }
    
    @Path("/log/usr/{usr}")
    public void buscaUsr(String usr) {
        List<Log> pusr = this.logDAO.listarPorUsr(usr);
        this.includeSerializer(pusr);
    }
    
    @Path("/log/parametro/{param}")
    public void buscaEquipamento(String param) {
        List<Log> pparam = this.logDAO.listarPorParametro(param);
        this.includeSerializer(pparam);
    }    
    
}
