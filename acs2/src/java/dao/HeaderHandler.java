/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import org.w3c.dom.DOMException;

/**
 *
 * @author G0042204
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext smc) {

        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty) {

            SOAPMessage message = smc.getMessage();

            try {

                SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.getHeader();

                SOAPElement security
                        = header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

                SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
//                usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

                SOAPElement username = usernameToken.addChildElement("Username", "wsse");
                username.addTextNode("synchops");

                SOAPElement password
                        = usernameToken.addChildElement("Password", "wsse");
//                password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
                password.addTextNode("nbibr4s1l");

                //Print out the outbound SOAP message to System.out
                message.writeTo(System.out);
                System.out.println("");

            } catch (IOException | SOAPException | DOMException e) {
                e.printStackTrace();
            }

        } else {
            try {

                //This handler does nothing with the response from the Web Service so
                //we just print out the SOAP message.
                SOAPMessage message = smc.getMessage();
                message.writeTo(System.out);
                System.out.println("");

            } catch (IOException | SOAPException ex) {
                ex.printStackTrace();
            }
        }

        return outboundProperty;

    }

    @Override
    public Set getHeaders() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }

    @Override
    public void close(MessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
