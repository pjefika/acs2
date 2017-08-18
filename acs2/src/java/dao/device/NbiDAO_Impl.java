/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NBIService;
import com.alcatel.hdm.service.nbi2.NbiCommunicationLog;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.alcatel.hdm.service.nbi2.NbiDeviceID;
import com.alcatel.hdm.service.nbi2.NbiParameter;
import com.alcatel.hdm.service.nbi2.NbiTemplate;
import dao.factory.FactoryNBI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import model.exception.SearchNotFound;

/**
 *
 * @author G0042204
 */
public class NbiDAO_Impl implements NbiDAO {

    private NBIService nbi;

    public NbiDAO_Impl() {
    }

    protected NBIService nbi() {
        if (nbi == null) {
            nbi = FactoryNBI.createNBIService();
        }
        return nbi;
    }

    @Override
    public NbiDeviceData findDeviceByGUID(Long guid) throws Exception {
        try {
            return nbi().findDeviceByGUID(guid);
        } catch (NBIException_Exception e) {
            if (e.getFaultInfo().getFaultCode().equalsIgnoreCase("device.could.not.be.found")) {
                throw new SearchNotFound();
            }
            throw e;
        }
    }

    public List<NbiCommunicationLog> getCommunicationLogsByDeviceID(NbiDeviceID nbi) throws Exception {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(Calendar.getInstance().getTime());
        XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return nbi().getCommunicationLogsByDeviceID(nbi, 0, cal, cal);
    }

    @Override
    public List<NbiDeviceData> findDevicesBySubscriberId(String subscriberId) throws NBIException_Exception {
        try {
            return nbi().findDevicesBySubscriberId(subscriberId);
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

        return nbi().findDevicesByTemplate(n, 9000, -1);
    }

    public List<NbiTemplate> getAvailableCriteriaTemplates() throws NBIException_Exception {
        return nbi().getAvailableCriteriaTemplates();
    }

    /**
     * Implementação divergente entre homolog/prod;
     *
     * @param ipAddress
     * @return
     * @throws NBIException_Exception
     */
    @Override
    public List<NbiDeviceData> findDeviceByExternalIPAddress(String ipAddress) throws NBIException_Exception {
        // Prod
//        NbiTemplate n = new NbiTemplate();
//        n.setName("Find Devices By External IP Address");
//        NbiParameter param = new NbiParameter();
//        param.setName("deviceExternalIPAddress");
//        param.setValue(ipAddress);
//        n.getParameters().add(param);
//
//        return nbi().findDevicesByTemplate(n, 1, -1);

        List<NbiDeviceData> lst = new ArrayList<>();
        lst.add(nbi().findDeviceByExternalIPAddress(ipAddress));
        return lst;
    }

    @Override
    public List<NbiDeviceData> findDeviceBySerialNumber(String serial) throws NBIException_Exception {
        NbiTemplate n = new NbiTemplate();
        n.setName("ct.find.devices.serialNumber");
        NbiParameter param = new NbiParameter();
        param.setName("serialNumber");
        param.setValue(serial);
        n.getParameters().add(param);

        return nbi().findDevicesByTemplate(n, 9000, -1);
    }

}
