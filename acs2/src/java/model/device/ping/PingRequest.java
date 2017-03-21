/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.ping;

/**
 *
 * @author G0042204
 */
public class PingRequest {

    private String destAddress, $interface, qtdRequisitions;

    public PingRequest() {
        this.$interface = "Device.IP.Interface.1";
//        this.$interface = "InternetGatewayDevice.WANDevice.1.WANConnectionDevice.1.WANPPPConnection.1";
        this.qtdRequisitions = "4";
    }

    public String getDestAddress() {
        return destAddress;
    }

    public void setDestAddress(String destAddress) {
        this.destAddress = destAddress;
    }

    public String get$interface() {
        return $interface;
    }

    public void set$interface(String $interface) {
        this.$interface = $interface;
    }

    public String getQtdRequisitions() {
        return qtdRequisitions;
    }

    public void setQtdRequisitions(String qtdRequisitions) {
        this.qtdRequisitions = qtdRequisitions;
    }

}
