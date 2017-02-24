/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import java.util.List;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class dev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            EquipamentoDAO d = new EquipamentoDAO();
            List<NbiDeviceData> eqp = d.listarEquipamentosPorSerial("LU1322503001553");
            SoutUtil.print(eqp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
