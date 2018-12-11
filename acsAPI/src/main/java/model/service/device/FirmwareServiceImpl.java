/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device;

import br.net.gvt.efika.acs.model.device.firmware.FirmwareInfo;
import br.net.gvt.efika.acs.model.exception.TratativaExcessao;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;

public class FirmwareServiceImpl extends ServiceAbstract implements FirmwareService {

    @Override
    public Boolean firmwareUpdate(NbiDeviceData eqp, FirmwareInfo info) throws Exception {
        try {
            Long l = remote().firmwareUpdate(eqp, info);
            return l != null && l.compareTo(0l) > 0;
        } catch (Exception e) {
            TratativaExcessao.treatException(e);
        }
        return null;
    }

}
