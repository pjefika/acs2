/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import tests.junit.getFirmwareVersionJUnitTest;
import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class testeSoapGetFirm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;
            eqp = d.detalheEquipamento(new Long(23006));
            SoutUtil.print(eqp);

        } catch (NBIException_Exception ex) {
            Logger.getLogger(getFirmwareVersionJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(getFirmwareVersionJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
