/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author G0042204
 */
public class EquipamentoDAO {

    public EquipamentoDAO() {

    }

    public void listarEquipamentosPorMac() {

        try {
            java.lang.Long arg0 = new Long(23006);
            com.alcatel.hdm.service.nbi2.NBIService_Service service = new com.alcatel.hdm.service.nbi2.NBIService_Service();
            service.setHandlerResolver(new HeaderHandlerResolver());
            com.alcatel.hdm.service.nbi2.NBIService port = service.getNBIServiceImplPort();
            // TODO process result here

            com.alcatel.hdm.service.nbi2.NbiDeviceData result = port.findDeviceByGUID(arg0);
            System.out.println("Result = " + result.getModel());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
