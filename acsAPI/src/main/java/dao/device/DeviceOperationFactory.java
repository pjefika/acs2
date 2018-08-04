/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import br.net.gvt.efika.acs.model.device.wifi.WifiInfoFull;
import br.net.gvt.efika.acs.model.device.wifi.WifiInfoSet;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dto.nbi.service.hdm.alcatel.com.NBIDeviceID;
import java.util.ArrayList;
import java.util.List;
import motive.hdm.synchdeviceops.NbiDeviceID;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationCallBackInfo;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationOptions;

/**
 *
 * @author G0042204
 */
public class DeviceOperationFactory {

    private static final int EXECUTION = 1200;

    private static final int EXPIRATION = 60;

    public static NbiSingleDeviceOperationOptions getDeviceOperationOptionsDefault() {
        NbiSingleDeviceOperationOptions opt = new NbiSingleDeviceOperationOptions();

        NbiSingleDeviceOperationCallBackInfo cb = new NbiSingleDeviceOperationCallBackInfo();
        cb.setRetry(false);

        opt.setDisableCaptureConstraint(true);
        opt.setExecutionTimeoutSeconds(EXECUTION);
        opt.setExpirationTimeoutSeconds(EXPIRATION);
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
        opt.setExecutionTimeoutSeconds(EXECUTION);
        opt.setExpirationTimeoutSeconds(EXPIRATION);
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
        opt.setExecutionTimeoutSeconds(EXECUTION);
        opt.setExpirationTimeoutSeconds(EXPIRATION);
        opt.setFailOnConnectionRequestFailure(true);
        opt.setNBISingleDeviceOperationCallBackInfo(cb);
        opt.setOpaqueTransactionId("teste5555");
        opt.setPolicyClass("policytest");
        opt.setPriority(100);
        opt.setReplaceDeviceCachedDataRecord(false);
        opt.setUpdateCachedDataRecord(false);

        return opt;
    }

    public static WifiInfoSet getWifiInfoSetFull(WifiInfoFull i) {
        return new WifiInfoSet(i);
    }

    /**
     * Merges WifiInfoFull from list b into list a based on list order Both
     * lists must have same size
     *
     * @param a
     * @param b
     * @return a with the b parameters from execFunction 9511
     */
    public static List<WifiInfoFull> mergeWifis(List<WifiInfoFull> a, List<WifiInfoFull> b) {

        for (int i = 0; i < a.size(); i++) {
            a.get(i).setIndex(b.get(i).getIndex());
            a.get(i).setAuthentication(b.get(i).getAuthentication());
            a.get(i).setEncryptation(b.get(i).getEncryptation());
            a.get(i).setFrequency(b.get(i).getFrequency());
            a.get(i).setSsidPassword(b.get(i).getSsidPassword());
            a.get(i).setBroadcastEnabled(b.get(i).getBroadcastEnabled());
        }

        return a;
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

    public static dto.nbi.service.hdm.alcatel.com.NBIDeviceID adapterRemote(com.alcatel.hdm.service.nbi2.NbiDeviceID d) {
        NBIDeviceID id = new dto.nbi.service.hdm.alcatel.com.NBIDeviceID();
        id.setOUI(d.getOUI());
        id.setProductClass(d.getProductClass());
        id.setProtocol(d.getProtocol());
        id.setSerialNumber(d.getSerialNumber());
        return id;
    }

    public static com.alcatel.hdm.service.nbi2.NbiDeviceID adapterAlterReal(com.alcatel.hdm.service.nbi2.NbiDeviceID d) {

        com.alcatel.hdm.service.nbi2.NbiDeviceID id = new com.alcatel.hdm.service.nbi2.NbiDeviceID();
        id.setOUI(d.getOUI());
        id.setProductClass(d.getProductClass());
        id.setProtocol(d.getProtocol());
        id.setSerialNumber(d.getSerialNumber());

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
