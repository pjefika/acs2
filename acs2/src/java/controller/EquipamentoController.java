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
import model.factory.FactoryService;

/**
 *
 * @author G0042204
 */
@Path("/device")
public class EquipamentoController {

    @GET
    @Path("/{guid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response detail(@PathParam("guid") Long guid) {
        try {
            return Response.status(200).entity(FactoryService.createDeviceDetailService().consultar(guid)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }
    }

}
