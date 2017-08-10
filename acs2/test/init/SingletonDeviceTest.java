/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.factory.FactoryDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class SingletonDeviceTest {

    private static SingletonDeviceTest instance = null;

    private NbiDeviceData device;

    protected SingletonDeviceTest() {
        // Exists only to defeat instantiation.
    }

    public static SingletonDeviceTest getInstance() {
        if (instance == null) {
            instance = new SingletonDeviceTest();
            System.out.println("Consultando Device: " + EquipamentoTestValues.GUID);
            instance.consultar();
        }
        return instance;
    }

    private void consultar() {
        try {
            device = FactoryDAO.createNBI().findDeviceByGUID(EquipamentoTestValues.GUID);
            System.out.println(GsonUtil.serialize(device));
        } catch (NBIException_Exception ex) {
            Logger.getLogger(SingletonDeviceTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NbiDeviceData getDevice() {
        return device;
    }

}
