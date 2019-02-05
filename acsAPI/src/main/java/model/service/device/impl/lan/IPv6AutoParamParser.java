/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.lan;

import br.net.gvt.efika.acs.model.dto.LANIPv6Auto;
import java.util.ArrayList;
import java.util.List;
import model.service.device.impl.SetParameters;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0041775
 */
public class IPv6AutoParamParser {

    public static List<ParameterValueStructDTO> parse(LANIPv6Auto t) {
        List<ParameterValueStructDTO> l = new ArrayList<>();
        if (t.getEnabled() != null) {
            l.add(SetParameters.setIPv6Auto(t.getEnabled()));
        }
        return l;
    }

}
