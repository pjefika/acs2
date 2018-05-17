/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;

/**
 *
 * @author G0041775
 */
public interface DeviceOnlineService {

    public Boolean isOnline(NbiDeviceData eqp) throws Exception;

    public Boolean isAnyOnline(List<NbiDeviceData> eqps) throws Exception;

}
