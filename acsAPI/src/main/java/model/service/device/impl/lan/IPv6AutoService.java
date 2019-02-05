/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.lan;

import br.net.gvt.efika.acs.model.dto.LANIPv6Auto;
import br.net.gvt.efika.acs.model.exception.TratativaExcessao;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.service.device.GenericDeviceService;
import model.service.device.MotiveFromTreeService;
import motive.hdm.synchdeviceops.SetParameterValuesResponseDTO;

/**
 *
 * @author G0041775
 */
public class IPv6AutoService extends GenericDeviceService implements MotiveFromTreeService<LANIPv6Auto> {

    @Override
    public LANIPv6Auto consultar(NbiDeviceData device, LANIPv6Auto ipv6) throws Exception {
//        try {
//            List<String> paths = new ArrayList<>();
//            String value = null;
//            try {
//                paths.add("InternetGatewayDevice.Services.VoiceService." + t38.getIndex() + ".VoiceProfile.1.FaxT38.Enable");
//                value = synch().getParametersValues(device, paths).getParameterList().get(0).getValue();
//            } catch (Exception e) {
//                paths.add("Device.Services.VoiceService." + t38.getIndex() + ".VoiceProfile.1.FaxT38.Enable");
//                value = synch().getParametersValues(device, paths).getParameterList().get(0).getValue();
//            }
//            t38.setEnabled(value.equalsIgnoreCase("1") || value.equalsIgnoreCase("true"));
//            return t38;
//        } catch (Exception ex) {
//            TratativaExcessao.treatException(ex);
//        }
//        return null;
        throw new Exception("Not supported yet.");
    }

    @Override
    public LANIPv6Auto alterar(NbiDeviceData device, LANIPv6Auto t) throws Exception {
        try {   
            SetParameterValuesResponseDTO s = synch().setParamValues(device, IPv6AutoParamParser.parse(t));
            t.setEnabled(s.getStatus() == 0);
            return t;
        } catch (Exception ex) {
            TratativaExcessao.treatException(ex);
        }
        return null;
    }

}
