/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.search.FindDeviceImpl;

/**
 *
 * @author G0042204
 */
@Path("/search")
public class SearchController extends RestAbstractController {

    private FindDeviceImpl find;

    @GET
    @Path("/{instancia}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCliente(@PathParam("instancia") String instancia) {
        try {
            return ok(instancia);
        } catch (Exception e) {
            return internalServerError(e);
        }
    }

}
