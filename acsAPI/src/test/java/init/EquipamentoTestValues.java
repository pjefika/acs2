/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.SynchDeviceDAO;
import dao.factory.FactoryDAO;

/**
 * 74021 -> wan nao 89013 -> wan ok 102015 102017 102017 146024 74021 (firmware
 * ok) 147035 - primeira migracao 152015 - sip 151061 - PACE 151031 - REALTEK
 * 149041 - sip
 *
 * @author G0042204
 */
public class EquipamentoTestValues {

    /**
     *
     */
    public static Long GUID = new Long(31394283);

    private SynchDeviceDAO instance = FactoryDAO.createSynch();
    private NbiDeviceData eqp = SingletonDeviceTest.getInstance().getDevice();

    public NbiDeviceData getEqp() {
        return eqp;
    }

}
