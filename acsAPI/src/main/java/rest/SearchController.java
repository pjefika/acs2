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
import model.entity.LogEntity;
import model.service.factory.FactoryService;
import model.service.search.FindDevice;
import model.service.search.SearchIn;

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
        LogEntity l = in.create();
        try {
            find = FactoryService.createFindDevice();
            List<NbiDeviceData> lst = find.find(in);
            l.setSaida(lst);
            return ok(lst);
        } catch (Exception e) {
            l.setSaida(e.getMessage());
            return internalServerError(e);
        } finally {
            try {
                FactoryDAO.createLogDAO().cadastrar(l);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
