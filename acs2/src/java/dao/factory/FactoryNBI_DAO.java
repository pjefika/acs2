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
public class FactoryNBI_DAO {

    public static NBIService createNBIService() {
        try {
            URL url;
            url = new URL("http://10.113.64.1:7025/NBIServiceImpl/NBIService?wsdl");
            QName qname = new QName("http://nbi2.service.hdm.alcatel.com/", "NBIService");
            Service service = Service.create(url, qname);
            NBIService nbi = service.getPort(NBIService.class);
            ((javax.xml.ws.BindingProvider) nbi).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "synchops");
            ((javax.xml.ws.BindingProvider) nbi).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibr4s1l");
            return nbi;
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public static NBIServicePortStub createRemote() {
        try {
            NBIServicePortStub stub = new NBIServicePortStub(new URL("http://10.113.64.1:7025/remotehdm/NBIService?wsdl"), new NBIServiceLocator());
            return (NBIServicePortStub) SoapUtil.addWsSecurityHeader(stub, "co_efika", "nbibrasilefika02");
        } catch (Exception e) {
            return null;
        }
    }

    public static SynchDeviceOperationsService createSynch() {
        try {
            URL url;
            url = new URL("http://10.113.64.1:7025/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService?wsdl");
//                url = new URL("http://201.95.254.37:7035/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService?wsdl");
            QName qname = new QName("http://www.motive.com/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService",
                    "SynchDeviceOperationsNBIService");
            Service service = Service.create(url, qname);
            SynchDeviceOperationsService synch = service.getPort(SynchDeviceOperationsService.class);
            ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "nbi_user");
            ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibrasil");
            return synch;
        } catch (MalformedURLException e) {
            return null;
        }
    }

}
