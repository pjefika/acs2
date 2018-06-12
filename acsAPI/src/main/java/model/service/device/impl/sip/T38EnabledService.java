/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.sip;

import br.net.gvt.efika.acs.model.device.enums.DeviceTR;
import br.net.gvt.efika.acs.model.dto.T38Enabled;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.ArrayList;
import java.util.List;
import model.service.device.GenericDeviceService;
import model.service.device.MotiveFromTreeService;

/**
 *
 * @author G0041775
 */
public class T38EnabledService extends GenericDeviceService implements MotiveFromTreeService<T38Enabled> {

    @Override
    public T38Enabled consultar(NbiDeviceData device, T38Enabled t38) throws Exception {
        List<String> paths = new ArrayList<>();
        String value = null;
        try {
            paths.add("InternetGatewayDevice.Services.VoiceService." + t38.getIndex() + ".VoiceProfile.1.FaxT38.Enable");
            value = synch().getParametersValues(device, paths).getParameterList().get(0).getValue();
        } catch (Exception e) {
            paths.add("Device.Services.VoiceService." + t38.getIndex() + ".VoiceProfile.1.FaxT38.Enable");
            value = synch().getParametersValues(device, paths).getParameterList().get(0).getValue();
        }
        t38.setEnabled(value.equalsIgnoreCase("1") || value.equalsIgnoreCase("true"));
        return t38;
    }

    @Override
    public T38Enabled alterar(NbiDeviceData device, T38Enabled t) throws Exception {
        try {
            synch().setParametersValues(device, SIPParamParser.parse(t, DeviceTR.TR_098));
        } catch (Exception e) {
            synch().setParametersValues(device, SIPParamParser.parse(t, DeviceTR.TR_181));
        }
        return consultar(device, t);
    }

}
