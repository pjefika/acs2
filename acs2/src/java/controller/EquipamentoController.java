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
import model.device.ddns.DdnsInfo;
import model.device.dhcp.Dhcp;
import model.device.interfacestatistics.InterfaceStatistics;
import model.device.lanhost.LanDevice;
import model.device.ping.PingResponse;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.serviceclass.ServiceClass;
import model.device.sipdiagnostics.SipDiagnostics;
import model.device.wan.WanInfo;
import model.device.wifi.WifiInfoFull;
import model.device.xdsldiagnostics.XdslDiagnostics;
import model.service.dto.DetailOut;
import model.entity.LogEntity;
import model.log.AcaoAcsEnum;
import model.service.device.MotiveService;
import model.service.factory.FactoryService;
import model.service.dto.DetailIn;
import model.service.dto.DhcpIn;
import model.service.dto.GetDeviceDataIn;
import model.service.dto.PingDiagnosticIn;
import model.service.dto.ServiceClassIn;
import model.service.dto.SetWifiIn;
import model.service.dto.SipActivationIn;
import model.service.dto.SipDiagnosticsIn;
import model.service.factory.FactoryMotiveService;

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
            WifiInfoFull wifi = FactoryService.createWiFiService().consultar(in.getDevice());
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
            WifiInfoFull wifi = FactoryService.createWiFiService().alterar(in.getDevice(), in.getWifi());
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
    @Path("/getPortMapping")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getPortMapping(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_PORT_MAPPING);
        LogEntity l = in.create();
        try {
            List<PortMappingInfo> w = FactoryDAO.createSynch().getPortMapping(in.getDevice());
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

    @POST
    @Path("/getDhcp")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDhcp(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_PPPOE_CREDENTIALS);
        LogEntity l = in.create();
        try {
            Dhcp w = FactoryDAO.createSynch().getDhcp(in.getDevice());
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
    @Path("/setDhcp")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setDhcp(DhcpIn in) {
        LogEntity l = in.create();
        try {
            MotiveService<Dhcp> fac = (MotiveService<Dhcp>) FactoryMotiveService.create(in.getDhcp());
            Dhcp dhcp = fac.alterar(in.getDevice(), in.getDhcp());
            l.setSaida(dhcp);
            return ok(dhcp);
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
    @Path("/getDdns")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDdns(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_DDNS);
        LogEntity l = in.create();
        try {
            DdnsInfo w = FactoryDAO.createSynch().getDdns(in.getDevice());
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
    @Path("/getServiceClass")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getServiceClass(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_SERVICE_CLASS);
        LogEntity l = in.create();
        try {
            ServiceClass w = FactoryDAO.createSynch().getServiceClass(in.getDevice());
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
    @Path("/setServiceClass")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setServiceClass(ServiceClassIn in) {
        LogEntity l = in.create();
        try {
            Boolean w = FactoryDAO.createSynch().setServiceClass(in.getDevice(), in.getService());
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
    @Path("/getSipDiagnostics")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getSipDiagnostics(SipDiagnosticsIn in) {
        in.setAcao(AcaoAcsEnum.SIP_DIAGNOSTICS);
        LogEntity l = in.create();
        try {
            SipDiagnostics w = FactoryDAO.createSynch().getSipDiagnostics(in.getDevice(), in.getPhyref());
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
    @Path("/setSipActivation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setSipActivation(SipActivationIn in) {
        LogEntity l = in.create();
        try {
            Boolean w = FactoryDAO.createSynch().setSipActivation(in.getDevice(), in.getSip());
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

}
