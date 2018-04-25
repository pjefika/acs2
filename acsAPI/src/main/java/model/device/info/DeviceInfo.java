/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.info;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import parser.device.DeviceInfoDeserializer;

/**
 *
 * @author G0042204
 */
@JsonDeserialize(using = DeviceInfoDeserializer.class)
public class DeviceInfo {

    private String manufacid,
            prodclass,
            sn,
            fwer,
            hwer,
            preferv;

    public DeviceInfo() {
    }

    public String getManufacid() {
        return manufacid;
    }

    public void setManufacid(String manufacid) {
        this.manufacid = manufacid;
    }

    public String getProdclass() {
        return prodclass;
    }

    public void setProdclass(String prodclass) {
        this.prodclass = prodclass;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getFwer() {
        return fwer;
    }

    public void setFwer(String fwer) {
        this.fwer = fwer;
    }

    public String getHwer() {
        return hwer;
    }

    public void setHwer(String hwer) {
        this.hwer = hwer;
    }

    public String getPreferv() {
        return preferv;
    }

    public void setPreferv(String preferv) {
        this.preferv = preferv;
    }

}
