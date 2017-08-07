/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.factory.FactoryDAO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.service.dto.DetailOut;
import model.entity.LogEntity;
import model.service.factory.FactoryService;
import model.service.dto.DetailIn;

/**
 *
 * @author G0042204
 */
@Path("/device")
public class EquipamentoController extends RestAbstractController {

    @POST
    @Path("/detail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response detail(DetailIn in) {
        LogEntity l = in.create();
        try {
            DetailOut detail = FactoryService.createDeviceDetailService().consultar(in.getGuid());
            l.setSaida(detail);
            return ok(detail);
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

    @POST
    @Path("/getWifiInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getWifiInfo(DetailIn in) {
        LogEntity l = in.create();
        try {
            DetailOut detail = FactoryService.createDeviceDetailService().consultar(in.getGuid());
            l.setSaida(detail);
            return ok(detail);
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
