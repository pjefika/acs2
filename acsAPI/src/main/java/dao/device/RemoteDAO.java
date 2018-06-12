/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import br.net.gvt.efika.acs.model.device.firmware.FirmwareInfo;
import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dto.nbi.service.hdm.alcatel.com.NBIFirmwareImageData;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author G0042204
 */
public interface RemoteDAO {
    
    public Long firmwareUpdate(NbiDeviceData eqp, FirmwareInfo info) throws NBIException_Exception, RemoteException;
    
    public List<NBIFirmwareImageData> getAvailableFirmwareImages(NbiDeviceData eqp) throws RemoteException;
      
}
