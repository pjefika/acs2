/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NBIService;
import com.alcatel.hdm.service.nbi2.NbiDeviceActionResult;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.alcatel.hdm.service.nbi2.NbiFunction;
import com.alcatel.hdm.service.nbi2.NbiParameter;
import com.alcatel.hdm.service.nbi2.NbiTemplate;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.SynchDeviceOperationsService;
import com.sun.xml.wss.XWSSConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import motive.hdm.synchdeviceops.CheckOnlineResponse;
import motive.hdm.synchdeviceops.ExecuteFunctionResponse;
import motive.hdm.synchdeviceops.NbiDeviceID;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationOptions;

/**
 *
 * @author G0042204
 */
public class EquipamentoDAO {

    private NBIService nbi;

    private SynchDeviceOperationsService synch;

    public EquipamentoDAO() {
    }

    public void initNbi() {
        try {
            URL url;
            url = new URL("http://200.168.104.216:7035/NBIServiceImpl/NBIService?wsdl");
            QName qname = new QName("http://nbi2.service.hdm.alcatel.com/",
                    "NBIService");
            Service service = Service.create(url, qname);
            nbi = service.getPort(NBIService.class);
            ((javax.xml.ws.BindingProvider) nbi).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "synchops");
            ((javax.xml.ws.BindingProvider) nbi).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibr4s1l");
        } catch (MalformedURLException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initSynchDeviceOperations() {
        try {
            URL url;
            url = new URL("http://200.168.104.216:7025/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService?wsdl");
            QName qname = new QName("http://www.motive.com/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService",
                    "SynchDeviceOperationsNBIService");
            Service service = Service.create(url, qname);
            synch = service.getPort(SynchDeviceOperationsService.class);
            ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "synchops");
            ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibr4s1l");
        } catch (MalformedURLException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param guid
     * @return
     * @throws NBIException_Exception
     */
    public NbiDeviceData detalheEquipamento(Long guid) throws NBIException_Exception {
        this.initNbi();
        return nbi.findDeviceByGUID(guid);
    }

    public List<NbiDeviceData> listarEquipamentosPorMac(String mac) throws NBIException_Exception {
        NbiTemplate n = new NbiTemplate();
        n.setName("Find Devices By MacAddress");

        NbiParameter param = new NbiParameter();

        param.setName("macAddress");
        param.setValue(mac);

        n.getParameters().add(param);

        this.initNbi();
        return nbi.findDevicesByTemplate(n, 1, -1);
    }

    public List<NbiDeviceData> listarEquipamentosPorSerial(String serial) throws NBIException_Exception {

        NbiTemplate n = new NbiTemplate();
        n.setName("ct.find.devices.serialNumber");

        NbiParameter param = new NbiParameter();

        param.setName("serialNumber");
        param.setValue(serial);

        n.getParameters().add(param);

        this.initNbi();
        return nbi.findDevicesByTemplate(n, 1, -1);
    }

    public Boolean checkOnline(NbiDeviceData eqp) {
        NbiDeviceID id = new NbiDeviceID();

        id.setOUI(eqp.getDeviceId().getOUI());
        id.setProductClass(eqp.getDeviceId().getProductClass());
        id.setProtocol(eqp.getDeviceId().getProtocol());
        id.setSerialNumber(eqp.getDeviceId().getSerialNumber());

        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();

        try {
            this.initSynchDeviceOperations();
            synch.checkOnline(id, opt, 10000, "");
            return true;
        } catch (DeviceOperationException | NBIException | OperationTimeoutException | ProviderException e) {
            return false;
        }
    }

    public Long firmwareUpdate(NbiDeviceData eqp) throws NBIException_Exception {
        this.initNbi();
        NbiFunction func = new NbiFunction();
        func.setFunctionCode(1200);
        return nbi.createSingleDeviceOperationByDeviceGUID(eqp.getDeviceGUID(), func, NbiDecorator.getDeviceOperationOptionsDefault2());
    }

    public NbiDeviceActionResult getDeviceOperationStatus(NbiDeviceData eqp, Long operationId) throws NBIException_Exception {
        this.initNbi();
        return nbi.getDeviceOperationStatus(eqp.getDeviceId(), operationId);
    }

    public List<NbiDeviceData> listarEquipamentosPorSubscriber(String subscriber) throws NBIException_Exception {
        this.initNbi();
        return nbi.findDevicesBySubscriberId(subscriber);
    }

    /**
     * Utilizar output do método Find By GUID
     *
     * @param eqp
     * @return
     * @throws java.lang.Exception
     */
    public ExecuteFunctionResponse getDeviceInfo(NbiDeviceData eqp) throws Exception {

        NbiDeviceID id = new NbiDeviceID();

        id.setOUI(eqp.getDeviceId().getOUI());
        id.setProductClass(eqp.getDeviceId().getProductClass());
        id.setProtocol(eqp.getDeviceId().getProtocol());
        id.setSerialNumber(eqp.getDeviceId().getSerialNumber());

        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();

        this.initSynchDeviceOperations();
        return (ExecuteFunctionResponse) synch.executeFunction(id, NbiDecorator.getEmptyJson(), 9527, opt, 10000, "");
    }

    public ExecuteFunctionResponse getFirmwareVersion(NbiDeviceData eqp) throws Exception {

        NbiDeviceID id = new NbiDeviceID();

        id.setOUI(eqp.getDeviceId().getOUI());
        id.setProductClass(eqp.getDeviceId().getProductClass());
        id.setProtocol(eqp.getDeviceId().getProtocol());
        id.setSerialNumber(eqp.getDeviceId().getSerialNumber());

        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();

        this.initSynchDeviceOperations();
        return (ExecuteFunctionResponse) synch.executeFunction(id, NbiDecorator.getEmptyJson(), 9526, opt, 10000, "");
    }

    public List<NbiTemplate> templates() throws NBIException_Exception {
        this.initNbi();
        return nbi.getAvailableCriteriaTemplates();
    }

}
