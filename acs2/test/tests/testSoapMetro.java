/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import motive.hdm.synchdeviceops.ExecuteFunctionResponse;

/**
 *
 * @author G0042204
 */
public class testSoapMetro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            EquipamentoDAO dao = new EquipamentoDAO();

            NbiDeviceData d = dao.detalheEquipamento(new Long(23006));

            ExecuteFunctionResponse r = dao.getDeviceInfo(d);

            System.out.println(r.getReturn());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
