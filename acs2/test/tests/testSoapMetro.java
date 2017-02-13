/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.alcatel.hdm.service.nbi2.NBIService;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.sun.xml.wss.XWSSConstants;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author G0042204
 */
public class testSoapMetro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL url = new URL("http://200.168.104.216:7035/NBIServiceImpl/NBIService?wsdl");
            QName qname = new QName("http://nbi2.service.hdm.alcatel.com/",
                    "NBIService");
            Service service = Service.create(url, qname);

            NBIService s = service.getPort(NBIService.class);

            ((javax.xml.ws.BindingProvider) s).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "synchops");
            ((javax.xml.ws.BindingProvider) s).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibr4s1l");

            NbiDeviceData detalheEquipamento = s.findDeviceByGUID(new Long(23006));
            System.out.println(detalheEquipamento);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
