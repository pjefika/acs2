/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.detail;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.NbiDAO;
import dao.device.SynchDeviceDAO;
import dao.factory.FactoryDAO;
import model.device.firmware.FirmwareInfo;
import model.device.info.DeviceInfo;
import model.service.dto.DetailOut;
import model.service.dto.FirmwareOut;

public class DeviceDetailServiceImpl implements DeviceDetailService {

    private NbiDeviceData eqp;
    private DetailOut result;

    public DeviceDetailServiceImpl() {
        result = new DetailOut();
    }

    @Override
    public DetailOut consultar(Long guid) throws Exception {
        NbiDAO dao = FactoryDAO.createNBI();
        SynchDeviceDAO sync = FactoryDAO.createSynch();

        eqp = dao.findDeviceByGUID(guid);
        result.setDevice(eqp);

        try {
            DeviceInfo deviceInfo = sync.getDeviceInfo(eqp);
            result.setOnline(Boolean.TRUE);
            result.setFirmware(new FirmwareOut(new FirmwareInfo(deviceInfo.getFwer(), deviceInfo.getPreferv())));
        } catch (Exception e) {
            e.printStackTrace();
            result.setOnline(Boolean.FALSE);

        }
//        result.setOnline(true);
//
//        if (result.getOnline()) {
//            try {
//                ThreþadControl.sleep();
//                result.setFirmware(new FirmwareOut(sync.getFirmwareVersion(eqp)));
//            } catch (Exception e) {
//                result.setFirmware(null);
//            }
//        }

        return result;
    }

}
