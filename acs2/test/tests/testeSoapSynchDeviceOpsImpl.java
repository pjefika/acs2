/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

/**
 *
 * @author G0042204
 */
public class testeSoapSynchDeviceOpsImpl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            motive.hdm.synchdeviceops.NbiDeviceID arg0 = null;
            java.util.List arg1 = null;
            int arg2 = 0;
            motive.hdm.synchdeviceops.NbiSingleDeviceOperationOptions arg3 = null;
            long arg4 = 0;
            java.lang.String arg5 = "";
            com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.SynchDeviceOperationsNBIService service = new com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.SynchDeviceOperationsNBIService();
            com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.SynchDeviceOperationsService port = service.getSynchDeviceOperationsWSImplPort();
            // TODO process result here
            java.lang.Object result = port.executeFunction(arg0, arg1, arg2, arg3, arg4, arg5);
            System.out.println("Result = " + result);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
