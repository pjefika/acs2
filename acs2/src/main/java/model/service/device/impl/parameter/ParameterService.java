/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.parameter;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;
import motive.hdm.synchdeviceops.ParameterInfoStructDTO;

/**
 *
 * @author G0042204
 */
public interface ParameterService {

    public List<ParameterInfoStructDTO> getParameters(NbiDeviceData eqp) throws Exception;

}
