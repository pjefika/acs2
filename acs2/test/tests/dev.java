/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.alcatel.hdm.service.nbi2.NbiOperationStatus;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import dao.EquipamentoDAO;
import motive.hdm.synchdeviceops.ExecuteFunctionResponse;
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

            NbiDeviceData eqp;
            eqp = d.findDeviceByGUID(new Long(94015));

            SoutUtil.print(eqp);

            try {
                SoutUtil.print((ExecuteFunctionResponse) d.getDeviceInfo(eqp));
            } catch (DeviceOperationException e) {
                NbiOperationStatus s = d.getDeviceOperationStatus(e.getFaultInfo().getOperationId());
                System.out.println(s.getStatus());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
