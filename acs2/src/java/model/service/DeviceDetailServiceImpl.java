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
import model.dto.DeviceDetail;
import model.dto.FirmwareDetail;
import model.exception.JsonUtilException;

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
            try {
                Thread.sleep(5000l);
                result.setFirmware(new FirmwareDetail(sync.getFirmwareVersion(eqp)));
            } catch (JsonUtilException e) {
                result.setFirmware(null);
            }
        }

        return result;
    }

}
