/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.util;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dto.nbi.service.hdm.alcatel.com.NBIDeviceID;
import java.util.ArrayList;
import java.util.List;
import model.device.wifi.WifiInfo;
import model.device.wifi.WifiInfoFull;
import model.device.wifi.WifiInfoSet;
import motive.hdm.synchdeviceops.NbiDeviceID;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationCallBackInfo;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationOptions;

/**
 *
 * @author G0042204
 */
public class NbiDecorator {

    public static NbiSingleDeviceOperationOptions getDeviceOperationOptionsDefault() {
        NbiSingleDeviceOperationOptions opt = new NbiSingleDeviceOperationOptions();

        NbiSingleDeviceOperationCallBackInfo cb = new NbiSingleDeviceOperationCallBackInfo();
        cb.setRetry(false);

        opt.setDisableCaptureConstraint(true);
        opt.setExecutionTimeoutSeconds(1200);
        opt.setExpirationTimeoutSeconds(60);
        opt.setFailOnConnectionRequestFailure(true);
        opt.setNBISingleDeviceOperationCallBackInfo(cb);
        opt.setOpaqueTransactionId("teste5555");
        opt.setPolicyClass("policytest");
        opt.setPriority(100);
        opt.setReplaceDeviceCachedDataRecord(false);
        opt.setUpdateCachedDataRecord(true);

        return opt;
    }

    public static com.alcatel.hdm.service.nbi2.NbiSingleDeviceOperationOptions getDeviceOperationOptionsDefault2() {
        com.alcatel.hdm.service.nbi2.NbiSingleDeviceOperationOptions opt = new com.alcatel.hdm.service.nbi2.NbiSingleDeviceOperationOptions();

        com.alcatel.hdm.service.nbi2.NbiSingleDeviceOperationCallBackInfo cb = new com.alcatel.hdm.service.nbi2.NbiSingleDeviceOperationCallBackInfo();
        cb.setRetry(false);

        opt.setDisableCaptureConstraint(true);
        opt.setExecutionTimeoutSeconds(1200);
        opt.setExpirationTimeoutSeconds(60);
        opt.setFailOnConnectionRequestFailure(true);
        opt.setNBISingleDeviceOperationCallBackInfo(cb);
        opt.setOpaqueTransactionId("teste5555");
        opt.setPolicyClass("policytest");
        opt.setPriority(100);
        opt.setReplaceDeviceCachedDataRecord(false);
        opt.setUpdateCachedDataRecord(true);
        return opt;
    }

    public static NbiSingleDeviceOperationOptions getDeviceOperationOptionsDefault3() {
        NbiSingleDeviceOperationOptions opt = new NbiSingleDeviceOperationOptions();

        NbiSingleDeviceOperationCallBackInfo cb = new NbiSingleDeviceOperationCallBackInfo();
        cb.setRetry(false);

        opt.setDisableCaptureConstraint(true);
        opt.setExecutionTimeoutSeconds(1200);
        opt.setExpirationTimeoutSeconds(60);
        opt.setFailOnConnectionRequestFailure(true);
        opt.setNBISingleDeviceOperationCallBackInfo(cb);
        opt.setOpaqueTransactionId("teste5555");
        opt.setPolicyClass("policytest");
        opt.setPriority(100);
        opt.setReplaceDeviceCachedDataRecord(false);
        opt.setUpdateCachedDataRecord(false);

        return opt;
    }

//    public static WifiInfoSet getWifiInfoSet(WifiInfo i) {
//        return new WifiInfoSet(true, i.getSsid(), i.getChannel());
//    }

    public static WifiInfoSet getWifiInfoSetFull(WifiInfoFull i) {
        return new WifiInfoSet(i);
    }

    public static NbiDeviceID adapter(NbiDeviceData d) {

        NbiDeviceID id = new NbiDeviceID();
        id.setOUI(d.getDeviceId().getOUI());
        id.setProductClass(d.getDeviceId().getProductClass());
        id.setProtocol(d.getDeviceId().getProtocol());
        id.setSerialNumber(d.getDeviceId().getSerialNumber());

        return id;
    }

    public static NBIDeviceID adapterCaps(NbiDeviceData d) {

        return new NBIDeviceID(d.getDeviceId().getOUI(),
                d.getDeviceId().getProductClass(),
                d.getDeviceId().getProtocol(), d.getDeviceId().getSerialNumber());

    }

    /**
     *
     * @param d
     * @return
     */
    public static com.alcatel.hdm.service.nbi2.NbiDeviceID adapterAlter(NbiDeviceData d) {

        com.alcatel.hdm.service.nbi2.NbiDeviceID id = new com.alcatel.hdm.service.nbi2.NbiDeviceID();
        id.setOUI(d.getDeviceId().getOUI());
        id.setProductClass(d.getDeviceId().getProductClass());
        id.setProtocol(d.getDeviceId().getProtocol());
        id.setSerialNumber(d.getDeviceId().getSerialNumber());

        return id;
    }

    public static List<Object> getEmptyJson() {
        List<Object> a = new ArrayList<>();
        a.add("");
        return a;
    }

    public static NbiDeviceID cast(com.alcatel.hdm.service.nbi2.NbiDeviceID id) {

        NbiDeviceID a = new NbiDeviceID();

        a.setOUI(id.getOUI());
        a.setProductClass(id.getProductClass());
        a.setProtocol(id.getProtocol());
        a.setSerialNumber(id.getSerialNumber());

        return a;
    }
}
