/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.consulta;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;
import dao.EquipamentoDAO;
import exception.HdmException;
import exception.JsonUtilException;
import init.EquipamentoTestValues;
import model.device.wifi.WifiInfoFull;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class GetWifiInfoFullJUnitTest {

    public GetWifiInfoFullJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getWifiInfoFull() throws HdmException {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;

            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            WifiInfoFull info = d.getWifiInfoFull(eqp);
            
            SoutUtil.print(info);
            

//            SoutUtil.print(info);

            assertTrue(true);

        } catch(DeviceOperationException e){
            throw new HdmException("A plataforma falhou ao obter os dados de Wifi do equipamento.");
        } catch(JsonUtilException e){
            throw new HdmException("A plataforma não retornou os dados de Wifi do equipamento devidamente.");
        } catch(NBIException e){
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter os dados de Wifi.");
        } catch(NBIException_Exception e){
            throw new HdmException("A plataforma apresentou um erro generalizado ao obter os dados de Wifi do equipamento.");
        } catch(OperationTimeoutException e){
            throw new HdmException("A plataforma demorou muito para responder ao obter os dados de Wifi.");
        } catch(ProviderException e){
            throw new HdmException("Erro no provedor da plataforma ao obter os dados de Wifi.");
        }
        
        
//        catch (Exception ex) {
//            assertTrue(false);
//        } 
    }
}
