/**
 * EfikaUsers_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package auth.dal.webservice;

public interface EfikaUsers_PortType extends java.rmi.Remote {
    public java.lang.Boolean autenticarUsuario(java.lang.String login, java.lang.String senha) throws java.rmi.RemoteException;
    public auth.dal.webservice.Usuario consultarUsuario(java.lang.String login) throws java.rmi.RemoteException;
}
