/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.acs.model.search;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.NbiDAO;
import dao.factory.FactoryDAO;
import java.util.List;
import br.net.gvt.efika.acs.model.exception.SearchCriteriaException;
import br.net.gvt.efika.acs.model.exception.SearchNotFound;

/**
 *
 * @author G0042204
 */
public class FindDeviceImpl implements FindDevice {

    public List<NbiDeviceData> methods(SearchIn in) throws Exception {
        List<NbiDeviceData> lst = null;
        NbiDAO dao = FactoryDAO.createNBI();

        if (in == null) {
            throw new SearchCriteriaException();
        }

        switch (in.getCriterio()) {
            case IP:
                return dao.findDeviceByExternalIPAddress(in.getInput());
            case MAC:
                return dao.findDevicesByMac(in.getInput());
            case SERIAL:
                return dao.findDeviceBySerialNumber(in.getInput());
            case SUBSCRIBER:
                return dao.findDevicesBySubscriberId(in.getInput());
            default:
                throw new SearchCriteriaException();
        }
    }

    @Override
    public List<NbiDeviceData> find(SearchIn in) throws Exception {

        try {
            List<NbiDeviceData> lst = methods(in);
            if (lst.isEmpty()) {
                throw new SearchNotFound();
            }
            return lst;
        } catch (NBIException_Exception | SearchCriteriaException e) {
            if (e instanceof NBIException_Exception) {
                throw new SearchNotFound();
            }
        }
        return null;
    }

}
