/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.sip;

import br.net.gvt.efika.acs.model.dto.DirectoryNumber;
import br.net.gvt.efika.acs.model.exception.TratativaExcessao;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.ArrayList;
import java.util.List;
import model.service.device.GenericDeviceService;
import model.service.device.MotiveFromTreeService;

/**
 *
 * @author G0041775
 */
public class DirectoryNumberService extends GenericDeviceService implements MotiveFromTreeService<DirectoryNumber> {

    @Override
    public DirectoryNumber consultar(NbiDeviceData device, DirectoryNumber dn) throws Exception {
        List<String> paths = new ArrayList<>();
        try {
            try {
                paths.add("InternetGatewayDevice.Services.VoiceService." + dn.getIndex() + ".VoiceProfile.1.Line.1.DirectoryNumber");
                dn.setPhoneNumber(synch().getParametersValues(device, paths).getParameterList().get(0).getValue());
            } catch (Exception e) {
                paths.add("Device.Services.VoiceService." + dn.getIndex() + ".VoiceProfile.1.Line.1.DirectoryNumber");
                dn.setPhoneNumber(synch().getParametersValues(device, paths).getParameterList().get(0).getValue());
            }
            return dn;
        } catch (Exception ex) {
            TratativaExcessao.treatException(ex);
        }
        return null;
    }

    @Override
    public DirectoryNumber alterar(NbiDeviceData device, DirectoryNumber t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
