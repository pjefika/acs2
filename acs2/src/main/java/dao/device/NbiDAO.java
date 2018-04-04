/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;

/**
 *
 * @author G0042204
 */
public interface NbiDAO {

    public NbiDeviceData findDeviceByGUID(Long guid) throws Exception;

    public List<NbiDeviceData> findDevicesBySubscriberId(String subscriberId) throws NBIException_Exception;

    public List<NbiDeviceData> findDevicesByMac(String mac) throws NBIException_Exception;

    public List<NbiDeviceData> findDeviceByExternalIPAddress(String ipAddress) throws NBIException_Exception;

    public List<NbiDeviceData> findDeviceBySerialNumber(String serial) throws NBIException_Exception;

}
