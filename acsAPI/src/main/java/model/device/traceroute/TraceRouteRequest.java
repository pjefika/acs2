/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.traceroute;

/**
 *
 * @author G0042204
 */
public class TraceRouteRequest {

    private String host, numberOfTries, timeout, dataBlockSize, dscp, maxHopCount, ipInterface;

    public TraceRouteRequest(String host) {
        this.numberOfTries = "3";
        this.dataBlockSize = "38";
        this.maxHopCount = "50";
//        this.ipInterface = "Device.IP.Interface.1";
        this.ipInterface = "InternetGatewayDevice.LANDevice.1.LANHostConfigManagement.IPInterface.1";
        this.timeout = "1000";
        this.dscp = "0";
        this.host = host;
    }

    public String getIpInterface() {
        return ipInterface;
    }

    public void setIpInterface(String ipInterface) {
        this.ipInterface = ipInterface;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getNumberOfTries() {
        return numberOfTries;
    }

    public void setNumberOfTries(String numberOfTries) {
        this.numberOfTries = numberOfTries;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getDataBlockSize() {
        return dataBlockSize;
    }

    public void setDataBlockSize(String dataBlockSize) {
        this.dataBlockSize = dataBlockSize;
    }

    public String getDscp() {
        return dscp;
    }

    public void setDscp(String dscp) {
        this.dscp = dscp;
    }

    public String getMaxHopCount() {
        return maxHopCount;
    }

    public void setMaxHopCount(String maxHopCount) {
        this.maxHopCount = maxHopCount;
    }

}
