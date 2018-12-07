/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.NbiDAO;
import dao.factory.FactoryDAO;
import java.util.List;
import br.net.gvt.efika.acs.model.exception.SearchCriteriaException;
import br.net.gvt.efika.acs.model.exception.SearchNotFound;
import br.net.gvt.efika.acs.model.exception.CommunicationFailureException;
import br.net.gvt.efika.acs.model.exception.TratativaExcessao;
import br.net.gvt.efika.acs.model.search.FindDevice;
import static br.net.gvt.efika.acs.model.search.SearchCriteria.*;
import br.net.gvt.efika.acs.model.search.SearchIn;

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
        } catch (Exception e) {
            TratativaExcessao.treatException(e);
        }
        return null;
    }

}
