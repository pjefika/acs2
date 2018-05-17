/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.SynchDeviceDAO;
import dao.factory.FactoryDAO;
import java.util.List;

public class DeviceOnlineServiceImpl implements DeviceOnlineService {

    private SynchDeviceDAO sync = FactoryDAO.createSynch();

    @Override
    public Boolean isOnline(NbiDeviceData eqp) throws Exception {
        try {
            return sync.forceOnline(eqp);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean isAnyOnline(List<NbiDeviceData> eqps) throws Exception {
        Boolean retorno = false;
        for (NbiDeviceData eqp : eqps) {
            try {
                if (sync.forceOnline(eqp)) {
                    retorno = true;
                }
            } catch (Exception e) {
            }
        }
        return retorno;
    }

}
