/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.factory.FactoryDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.net.gvt.efika.acs.model.entity.LogEntity;
import model.service.factory.FactoryService;
import br.net.gvt.efika.acs.model.search.FindDevice;
import br.net.gvt.efika.acs.model.search.SearchIn;

/**
 *
 * @author G0042204
 */
@Path("/search")
public class SearchController extends RestAbstractController {

    private FindDevice find;

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(SearchIn in) {
        System.out.println("36");
        LogEntity l = in.create();
        System.out.println("38");
        try {
            System.out.println("40");
            find = FactoryService.createFindDevice();
            System.out.println("42");
            List<NbiDeviceData> lst = find.find(in);
            System.out.println("44");
            l.setSaida(lst);
            System.out.println("46");
            return ok(lst);
        } catch (Exception e) {
            System.out.println("49");
            l.setSaida(e.getMessage());
            System.out.println("51");
            return internalServerError(e);
        } finally {
            System.out.println("54");
            try {
                System.out.println("56");
                FactoryDAO.createLogDAO().cadastrar(l);
                System.out.println("58");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
