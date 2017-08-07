/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.search;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.NbiDAO;
import dao.factory.FactoryDAO;
import java.util.List;
import model.exception.SearchCriteriaException;

/**
 *
 * @author G0042204
 */
public class FindDeviceImpl implements FindDevice {

    @Override
    public List<NbiDeviceData> find(SearchIn in) throws Exception {

        if (in == null) {
            throw new SearchCriteriaException();
        }

        NbiDAO dao = FactoryDAO.createNBI();

        switch (in.getCriterio()) {
            case IP:
                return dao.findDeviceByExternalIPAddress(in.getInput());
            case MAC:
                return dao.findDevicesByMac(in.getInput());
            case SERIAL:
                return dao.findDeviceBySerialNumber(in.getInput());
            case SUBCRIBER:
                return dao.findDevicesBySubscriberId(in.getInput());
            default:
                throw new SearchCriteriaException();
        }
    }

}
