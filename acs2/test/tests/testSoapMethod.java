/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import dao.EquipamentoDAO;

/**
 *
 * @author G0042204
 */
public class testSoapMethod {

    /**
     * @param args the command line arguments
     * @throws com.alcatel.hdm.service.nbi2.NBIException_Exception
     */
    public static void main(String[] args) throws NBIException_Exception {

        EquipamentoDAO d = new EquipamentoDAO();

        d.listarEquipamentoPorSerial("c4a81dce6779");
    }

}
