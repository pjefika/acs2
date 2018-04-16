/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import com.alcatel.hdm.service.nbi2.NBIService;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.SynchDeviceOperationsService;
import com.motive.www.remotehdm.NBIService._1_0.NBIServiceLocator;
import com.motive.www.remotehdm.NBIService._1_0.NBIServicePortStub;
import com.sun.xml.ws.client.BindingProviderProperties;
import com.sun.xml.wss.XWSSConstants;
import dao.util.SoapUtil;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author G0042204
 */
public class FactoryNBI {

    private static EndpointEnum ENDPOINT = EndpointEnum.PROD;

    public static NBIService createNBIService() {

        try {
            applyProxy();

            URL url = new URL("http://" + ENDPOINT.ip + ":" + ENDPOINT.porta + "/NBIServiceImpl/NBIService?wsdl");
            QName qname = new QName("http://nbi2.service.hdm.alcatel.com/", "NBIService");
            Service service = Service.create(url, qname);
            NBIService nbi = service.getPort(NBIService.class);
            ((javax.xml.ws.BindingProvider) nbi).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "synchops");
            ((javax.xml.ws.BindingProvider) nbi).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibr4s1l");

            ((javax.xml.ws.BindingProvider) nbi).getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT, 45000);
            ((javax.xml.ws.BindingProvider) nbi).getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT, 10000);

            return nbi;
        } catch (MalformedURLException e) {
            return null;
        } finally {
            removeProxy();
        }
    }

    public static NBIServicePortStub createRemote() {
        try {
            applyProxy();
            NBIServicePortStub stub = new NBIServicePortStub(new URL("http://" + ENDPOINT.ip + ":" + ENDPOINT.porta + "/remotehdm/NBIService?wsdl"), new NBIServiceLocator());
            return (NBIServicePortStub) SoapUtil.addWsSecurityHeader(stub, "nbi_user", "nbibrasil");
        } catch (Exception e) {
            return null;
        } finally {
            removeProxy();
        }
    }

    public static SynchDeviceOperationsService createSynch() {
        try {
            applyProxy();

            URL url = new URL("http://" + ENDPOINT.ip + ":" + ENDPOINT.porta + "/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService?wsdl");
            QName qname = new QName("http://www.motive.com/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService",
                    "SynchDeviceOperationsNBIService");
            Service service = Service.create(url, qname);
            SynchDeviceOperationsService synch = service.getPort(SynchDeviceOperationsService.class);
//            ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "synchops");
//            ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibr4s1l");
            ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "nbi_user");
            ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibrasil");
            return synch;
        } catch (MalformedURLException e) {
            return null;
        } finally {
            removeProxy();
        }
    }

    public static void applyProxy() {
        if (EndpointEnum.LAB == ENDPOINT) {
            System.setProperty("http.proxyHost", "proxysp.vivo.com.br");
            System.setProperty("http.proxyPort", "8080");
        }
    }

    public static void removeProxy() {
        clearConditionalProperty("http.proxyHost");
        clearConditionalProperty("http.proxyHost");
    }

    protected static void clearConditionalProperty(String prop) {
        try {
            if (!System.getProperty(prop).isEmpty()) {
                System.clearProperty(prop);
            }
        } catch (Exception e) {
        }
    }

}
