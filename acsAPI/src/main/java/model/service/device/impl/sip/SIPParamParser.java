/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.sip;

import br.net.gvt.efika.acs.model.device.enums.DeviceTR;
import br.net.gvt.efika.acs.model.dto.T38Enabled;
import java.util.ArrayList;
import java.util.List;
import model.service.device.impl.SetParameters;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0041775
 */
public class SIPParamParser {

    public static List<ParameterValueStructDTO> parse(T38Enabled t, DeviceTR tr) {
        List<ParameterValueStructDTO> l = new ArrayList<>();
        if (t.getEnabled() != null) {
            l.add(SetParameters.setT38Enabled(tr, t.getEnabled().toString(), t.getIndex()));
        }
        return l;
    }

}
