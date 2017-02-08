/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NBIService;
import com.alcatel.hdm.service.nbi2.NBIService_Service;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;

/**
 *
 * @author G0042204
 */
public class EquipamentoDAO {

    private NBIService_Service service = new NBIService_Service();
    private NBIService port = service.getNBIServiceImplPort();

    public EquipamentoDAO() {
        service.setHandlerResolver(new HeaderHandlerResolver());
        port = service.getNBIServiceImplPort();
    }

    public void listarEquipamentosPorMac() {

        try {
            Long arg0 = new Long(23006);
            NbiDeviceData result = port.findDeviceByGUID(arg0);
            System.out.println("Result = " + result);
        } catch (NBIException_Exception ex) {
            ex.printStackTrace();
        }

    }

    public void templates() {

        try {
            java.util.List<com.alcatel.hdm.service.nbi2.NbiTemplate> result = port.getAvailableCriteriaTemplates();
        } catch (NBIException_Exception ex) {
            ex.printStackTrace();
        }

    }

}
