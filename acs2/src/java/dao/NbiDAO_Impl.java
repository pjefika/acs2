/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NBIService;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.alcatel.hdm.service.nbi2.NbiParameter;
import com.alcatel.hdm.service.nbi2.NbiTemplate;
import dao.factory.FactoryNBI_DAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G0042204
 */
public class NbiDAO_Impl implements NbiDAO {

    private final NBIService nbi;

    public NbiDAO_Impl() {
        nbi = FactoryNBI_DAO.createNBIService();
    }

    @Override
    public NbiDeviceData findDeviceByGUID(Long guid) throws NBIException_Exception {
        return nbi.findDeviceByGUID(guid);
    }

    @Override
    public List<NbiDeviceData> findDevicesBySubscriberId(String subscriberId) throws NBIException_Exception {
        try {
            return nbi.findDevicesBySubscriberId(subscriberId);
        } catch (NBIException_Exception ex) {
            if (ex.getFaultInfo().getFaultCode().contentEquals("devices.for.subscriberid.could.not.be.found")) {
                return new ArrayList<>();
            }
            throw ex;
        }
    }

    @Override
    public List<NbiDeviceData> findDevicesByMac(String mac) throws NBIException_Exception {
        NbiTemplate n = new NbiTemplate();
        n.setName("Find Devices By MacAddress");

        NbiParameter param = new NbiParameter();

        param.setName("macAddress");
        param.setValue(mac);

        n.getParameters().add(param);

        return nbi.findDevicesByTemplate(n, 1, -1);
    }

    @Override
    public List<NbiDeviceData> findDeviceByExternalIPAddress(String ipAddress) throws NBIException_Exception {
        List<NbiDeviceData> r = new ArrayList<>();
        NbiDeviceData d = nbi.findDeviceByExternalIPAddress(ipAddress);

        if (d != null) {
            r.add(d);
        }
        return r;
    }

    @Override
    public List<NbiDeviceData> findDeviceBySerialNumber(String serial) throws NBIException_Exception {
        NbiTemplate n = new NbiTemplate();
        n.setName("ct.find.devices.serialNumber");
        NbiParameter param = new NbiParameter();
        param.setName("serialNumber");
        param.setValue(serial);
        n.getParameters().add(param);

        return nbi.findDevicesByTemplate(n, 1, -1);
    }

}
