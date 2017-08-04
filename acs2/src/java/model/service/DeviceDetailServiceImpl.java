/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.NbiDAO;
import dao.SynchDeviceDAO;
import dao.factory.FactoryDAO;
import model.device.DeviceDetail;

public class DeviceDetailServiceImpl implements DeviceDetailService {

    private NbiDeviceData eqp;
    private DeviceDetail result;

    public DeviceDetailServiceImpl() {
        result = new DeviceDetail();
    }

    @Override
    public DeviceDetail consultar(Long guid) throws Exception {
        NbiDAO dao = FactoryDAO.createNBI();
        SynchDeviceDAO sync = FactoryDAO.createSynch();

        eqp = dao.findDeviceByGUID(guid);
        result.setDevice(eqp);
        result.setOnline(sync.checkOnline(eqp));
        if (result.getOnline()) {
            result.setFirmwareUpdated(sync.getFirmwareVersion(eqp).isOk());
        }

        return result;
    }

}
