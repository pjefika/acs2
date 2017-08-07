/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.factory.FactoryDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.device.interfacestatistics.InterfaceStatistics;
import model.device.lanhost.LanDevice;
import model.device.ping.PingResponse;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.wan.WanInfo;
import model.device.wifi.WifiInfoFull;
import model.device.xdsldiagnostics.XdslDiagnostics;
import model.service.dto.DetailOut;
import model.entity.LogEntity;
import model.log.AcaoAcsEnum;
import model.service.factory.FactoryService;
import model.service.dto.DetailIn;
import model.service.dto.GetDeviceDataIn;
import model.service.dto.PingDiagnosticIn;
import model.service.dto.SetWifiIn;

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
    public Response getWifiInfo(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_WIFI_INFO);
        LogEntity l = in.create();
        try {
            WifiInfoFull wifi = FactoryDAO.createSynch().getWifiInfoFull(in.getDevice());
            l.setSaida(wifi);
            return ok(wifi);
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
    @Path("/setWifiInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setWifiInfo(SetWifiIn in) {
        LogEntity l = in.create();
        try {
            Boolean wifi = FactoryDAO.createSynch().setWifiInfoFull(in.getDevice(), in.getWifi());
            l.setSaida(wifi);
            return ok(wifi);
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
    @Path("/getLanHosts")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getLanHosts(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_LAN_HOSTS);
        LogEntity l = in.create();
        try {
            List<LanDevice> lst = FactoryDAO.createSynch().getLanHosts(in.getDevice());
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

    @POST
    @Path("/getWanInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getWanInfo(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_WAN_INFO);
        LogEntity l = in.create();
        try {
            WanInfo w = FactoryDAO.createSynch().getWanInfo(in.getDevice());
            l.setSaida(w);
            return ok(w);
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
    @Path("/getInterfaceStatistics")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getInterfaceStatistics(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_INTERFACE_STATISTICS);
        LogEntity l = in.create();
        try {
            List<InterfaceStatistics> w = FactoryDAO.createSynch().getInterfaceStatistics(in.getDevice());
            l.setSaida(w);
            return ok(w);
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
    @Path("/getXdslDiagnostic")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getXdslDiagnostic(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_XDSL_DIAGNOSTIC);
        LogEntity l = in.create();
        try {
            XdslDiagnostics w = FactoryDAO.createSynch().getXdslDiagnostic(in.getDevice());
            l.setSaida(w);
            return ok(w);
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
    @Path("/getPPPoECredentials")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPPPoECredentials(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_PPPOE_CREDENTIALS);
        LogEntity l = in.create();
        try {
            PPPoECredentialsInfo w = FactoryDAO.createSynch().getPPPoECredentials(in.getDevice());
            l.setSaida(w);
            return ok(w);
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
    @Path("/reboot")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response reboot(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.REBOOT);
        LogEntity l = in.create();
        try {
            Boolean w = FactoryDAO.createSynch().reboot(in.getDevice());
            l.setSaida(w);
            return ok(w);
        } catch (Exception e) {
            l.setSaida(false);
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
    @Path("/factoryReset")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response factoryReset(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.FACTORY_RESET);
        LogEntity l = in.create();
        try {
            Boolean w = FactoryDAO.createSynch().factoryReset(in.getDevice());
            l.setSaida(w);
            return ok(w);
        } catch (Exception e) {
            l.setSaida(false);
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
    @Path("/pingDiagnostic")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response pingDiagnostic(PingDiagnosticIn in) {
        in.setAcao(AcaoAcsEnum.FACTORY_RESET);
        LogEntity l = in.create();
        try {
            PingResponse w = FactoryDAO.createSynch().pingDiagnostic(in.getDevice(), in.getRequest());
            l.setSaida(w);
            return ok(w);
        } catch (Exception e) {
            l.setSaida(false);
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
