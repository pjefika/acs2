/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import org.apache.axis.client.Stub;
import org.apache.axis.message.SOAPHeaderElement;

/**
 *
 * @author G0042204
 */
public class SoapUtil {

    public static Stub addWsSecurityHeader(org.apache.axis.client.Stub binding, String wsUser, String wsPass) throws SOAPException {
        // Create the top-level WS-Security SOAP header XML name.
        QName headerName = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
        SOAPHeaderElement header = new SOAPHeaderElement(headerName);
        //  no intermediate actors are involved.
        header.setActor(null);
        // not important, "wsse" is standard
        header.setPrefix("wsse");
        header.setMustUnderstand(true);

        // Add the UsernameToken element to the WS-Security header
        SOAPElement utElem = header.addChildElement("UsernameToken");
        SOAPElement userNameElem = utElem.addChildElement("Username");
        userNameElem.removeContents();
        userNameElem.setValue(wsUser);

        SOAPElement passwordElem = utElem.addChildElement("Password");
        passwordElem.setValue(wsPass);
        // Finally, attach the header to the binding.
        binding.setHeader(header);

        return binding;
    }

}
