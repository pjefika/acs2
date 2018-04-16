/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.parameter;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;
import model.service.device.GenericDeviceService;
import motive.hdm.synchdeviceops.ParameterInfoStructDTO;


public class ParameterServiceImpl extends GenericDeviceService implements ParameterService {

    @Override
    public List<ParameterInfoStructDTO> getParameters(NbiDeviceData eqp) throws Exception {
        return synch().getParameters(eqp);
    }
    
}
