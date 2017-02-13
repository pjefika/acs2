/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;

/**
 *
 * @author G0042204
 */
public class testSoapMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            //d.listarEquipamentoPorSerial("c4a81dce6779");
            NbiDeviceData detalheEquipamento = d.detalheEquipamento(new Long(23006));
            System.out.println(detalheEquipamento.getManufacturer());

        } catch (NBIException_Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
