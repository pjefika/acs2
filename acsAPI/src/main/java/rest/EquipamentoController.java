/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import br.net.gvt.efika.acs.model.device.ddns.DdnsInfo;
import br.net.gvt.efika.acs.model.device.dhcp.Dhcp;
import br.net.gvt.efika.acs.model.device.dns.Dns;
import br.net.gvt.efika.acs.model.device.interfacestatistics.InterfaceStatistics;
import br.net.gvt.efika.acs.model.device.lanhost.LanDevice;
import br.net.gvt.efika.acs.model.device.ping.PingResponse;
import br.net.gvt.efika.acs.model.device.portmapping.PortMappingInfo;
import br.net.gvt.efika.acs.model.device.pppoe.PPPoECredentialsInfo;
import br.net.gvt.efika.acs.model.device.serviceclass.ServiceClass;
import br.net.gvt.efika.acs.model.device.sipdiagnostics.SipDiagnostics;
import br.net.gvt.efika.acs.model.device.wan.WanInfo;
import br.net.gvt.efika.acs.model.device.wifi.WifiNets;
import br.net.gvt.efika.acs.model.device.xdsldiagnostics.XdslDiagnostics;
import dao.factory.FactoryDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import br.net.gvt.efika.acs.model.dto.DetailOut;
import br.net.gvt.efika.acs.model.entity.LogEntity;
import br.net.gvt.efika.acs.model.log.AcaoAcsEnum;
import model.service.device.MotiveService;
import model.service.device.impl.PppoeCredentialsInService;
import model.service.device.impl.PppoeCredentialsInServiceImpl;
import model.service.device.impl.SipActivationService;
import model.service.device.impl.SipActivationServiceImpl;
import model.service.device.impl.SipDiagnosticsService;
import model.service.device.impl.SipDiagnosticsServiceImpl;
import model.service.factory.FactoryService;
import br.net.gvt.efika.acs.model.dto.DetailIn;
import br.net.gvt.efika.acs.model.dto.DhcpIn;
import br.net.gvt.efika.acs.model.dto.ForceOnlineDeviceIn;
import br.net.gvt.efika.acs.model.dto.ForceOnlineDevicesIn;
import br.net.gvt.efika.acs.model.dto.GetDeviceDataIn;
import br.net.gvt.efika.acs.model.dto.GetDnsIn;
import br.net.gvt.efika.acs.model.dto.PPPoECredentialsIn;
import br.net.gvt.efika.acs.model.dto.PingDiagnosticIn;
import br.net.gvt.efika.acs.model.dto.ServiceClassIn;
import br.net.gvt.efika.acs.model.dto.SetDnsIn;
import br.net.gvt.efika.acs.model.dto.SetWifiIn;
import br.net.gvt.efika.acs.model.dto.SipActivationIn;
import br.net.gvt.efika.acs.model.dto.SipDiagnosticsIn;
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
    @Path("/forceOnlineDevice")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response forceOnlineDevice(ForceOnlineDeviceIn in) {
        in.setAcao(AcaoAcsEnum.FORCE_ONLINE);
        LogEntity l = in.create();
        try {
            Boolean w = FactoryService.createDeviceOnlineService().isOnline(in.getDevice());
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
    @Path("/forceOnlineDevices")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response forceOnlineDevices(ForceOnlineDevicesIn in) {
        in.setAcao(AcaoAcsEnum.FORCE_ONLINE_ANY);
        LogEntity l = in.create();
        try {
            Boolean w = FactoryService.createDeviceOnlineService().isAnyOnline(in.getDevices());
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
    @Path("/getWifiInfo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getWifiInfo(GetDeviceDataIn in) {
        in.setAcao(AcaoAcsEnum.GET_WIFI_INFO);
        LogEntity l = in.create();
        try {
            if(in.getDevice()==null){
                in.setDevice(FactoryService.createDeviceDetailService().consultar(in.getGuid()).getDevice());
            }
            WifiNets wifi = FactoryService.createWiFiService().consultar(in.getDevice());
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
            if(in.getDevice()==null){
                in.setDevice(FactoryService.createDeviceDetailService().consultar(in.getGuid()).getDevice());
            }
            WifiNets wifi = FactoryService.createWiFiService().alterar(in.getDevice(), in.getWifi());
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
    @Path("/getDns")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDnsInfo(GetDnsIn in) {
        in.setAcao(AcaoAcsEnum.GET_DNS);
        LogEntity l = in.create();
        try {
            Dns w = FactoryDAO.createSynch().getDns(in.getDevice());
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
    @Path("/setDns")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setDnsInfo(SetDnsIn in) {
        in.setAcao(AcaoAcsEnum.SET_DNS);
        LogEntity l = in.create();
        try {
            Boolean w = FactoryDAO.createSynch().setDns(in.getDevice(), in.getDns().getDnsServers());
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
    @Path("/setPPPoECredentials")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response setPPPoECredentials(PPPoECredentialsIn in) {
        LogEntity l = in.create();
        try {
            PppoeCredentialsInService pppoe = new PppoeCredentialsInServiceImpl();
            Boolean ret = pppoe.alterar(in.getDevice(), in.getCredentials());
            l.setSaida(ret);
            return ok(ret);
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
            SipDiagnosticsService sip = new SipDiagnosticsServiceImpl();
            SipDiagnostics w = sip.consultar(in.getDevice(), in.getPhyref());
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
            SipActivationService sip = new SipActivationServiceImpl();
            SipDiagnostics w = sip.ativar(in.getDevice(), in.getSip());
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
