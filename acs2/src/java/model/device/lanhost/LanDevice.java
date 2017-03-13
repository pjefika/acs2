/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.lanhost;

/**
 *
 * @author G0042204
 */
public class LanDevice {

    private String ipAddress;

    private String addressSource;

    private String leaseTimeRemaining;

    private String macAddress;

    private String hostName;

    private String interfaceType;

    private Boolean ativo;

    public LanDevice() {
    }

    public void sout() {
        System.out.println("ipAddress: " + ipAddress);
        System.out.println("addressSource: " + addressSource);
        System.out.println("leaseTimeRemaining: " + leaseTimeRemaining);
        System.out.println("macAddress: " + macAddress);
        System.out.println("hostName: " + hostName);
        System.out.println("interfaceType: " + interfaceType);
        System.out.println("ativo: " + ativo);
        System.out.println("----------------------");
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getAddressSource() {
        return addressSource;
    }

    public void setAddressSource(String addressSource) {
        this.addressSource = addressSource;
    }

    public String getLeaseTimeRemaining() {
        return leaseTimeRemaining;
    }

    public void setLeaseTimeRemaining(String leaseTimeRemaining) {
        this.leaseTimeRemaining = leaseTimeRemaining;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
