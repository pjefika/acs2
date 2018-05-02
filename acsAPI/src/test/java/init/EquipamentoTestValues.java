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
     * Prod 18523038 - cliente
     *
     * BANCADA ARNO - QX4S1EB598946 (18358162) 165014 - PACE HOMOLOG 151054 -
     * HOMOLOG 89018 - HOMOLOG
     * 30585765
     * 26737329 - casa Matheus (canelinha)
     */
    public static Long GUID = new Long(33211808);

    private SynchDeviceDAO instance = FactoryDAO.createSynch();
    private NbiDeviceData eqp = SingletonDeviceTest.getInstance().getDevice();

    public NbiDeviceData getEqp() {
        return eqp;
    }
    
    

}
