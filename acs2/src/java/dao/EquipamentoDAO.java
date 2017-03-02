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
import com.alcatel.hdm.service.nbi2.NbiFirmwareImageData;
import com.alcatel.hdm.service.nbi2.NbiFunction;
import com.alcatel.hdm.service.nbi2.NbiOperationProfile;
import com.alcatel.hdm.service.nbi2.NbiOperationStatus;
import com.alcatel.hdm.service.nbi2.NbiParameter;
import com.alcatel.hdm.service.nbi2.NbiTemplate;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.SynchDeviceOperationsService;
import com.sun.xml.wss.XWSSConstants;
import dao.util.NbiDecorator;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import model.device.ddns.DdnsInfo;
import model.device.firmware.FirmwareInfo;
import model.device.log.DeviceLog;
import model.device.pppoe.PPPoECredentialsInfo;
import motive.hdm.synchdeviceops.ExecuteFunctionResponse;
import motive.hdm.synchdeviceops.NbiDeviceID;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationOptions;
import motive.hdm.synchdeviceops.StringResponseDTO;
import util.JsonUtil;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class EquipamentoDAO {

    private NBIService nbi;

    private SynchDeviceOperationsService synch;

    public EquipamentoDAO() {
        System.setProperty("http.proxyHost", "proxysp.vivo.com.br");
        System.setProperty("http.proxyPort", "8080");
    }

    /**
     *
     * @param guid
     * @return
     * @throws NBIException_Exception
     */
    public NbiDeviceData findDeviceByGUID(Long guid) throws NBIException_Exception {
        this.initNbi();
        return nbi.findDeviceByGUID(guid);
    }

    public Boolean reboot(NbiDeviceData eqp) {
        try {
            this.initSynchDeviceOperations();
            synch.reboot(NbiDecorator.adapter(eqp), NbiDecorator.getDeviceOperationOptionsDefault(), 50000, "efika");
            return true;
        } catch (DeviceOperationException | NBIException | OperationTimeoutException | ProviderException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean factoryReset(NbiDeviceData eqp) {
        try {
            this.initSynchDeviceOperations();
            synch.factoryReset(NbiDecorator.adapter(eqp), NbiDecorator.getDeviceOperationOptionsDefault(), 50000, "efika");
            return true;
        } catch (DeviceOperationException | NBIException | OperationTimeoutException | ProviderException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void capture(Long guid) throws NBIException_Exception {
        this.initNbi();
        nbi.captureDevice(guid);
    }

    public void release(Long guid) throws NBIException_Exception {
        this.initNbi();
        nbi.releaseDevice(guid);
    }

    public List<NbiDeviceData> listarEquipamentosPorMac(String mac) throws NBIException_Exception {
        try {
            NbiTemplate n = new NbiTemplate();
            n.setName("Find Devices By MacAddress");

            NbiParameter param = new NbiParameter();

            param.setName("macAddress");
            param.setValue(mac);

            n.getParameters().add(param);

            this.initNbi();
            return nbi.findDevicesByTemplate(n, 1, -1);
        } catch (Exception e) {
            return new ArrayList<NbiDeviceData>();
        }

    }

    public List<NbiDeviceData> listarEquipamentosPorSerial(String serial) throws NBIException_Exception {

        try {
            NbiTemplate n = new NbiTemplate();
            n.setName("ct.find.devices.serialNumber");

            NbiParameter param = new NbiParameter();

            param.setName("serialNumber");
            param.setValue(serial);

            n.getParameters().add(param);

            this.initNbi();
            return nbi.findDevicesByTemplate(n, 1, -1);
        } catch (Exception e) {
            return new ArrayList<NbiDeviceData>();
        }

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
        } catch (Exception e) {
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
        try {
            this.initNbi();
            return nbi.findDevicesBySubscriberId(subscriber);
        } catch (Exception e) {
            return new ArrayList<NbiDeviceData>();
        }

    }

    /**
     * Utilizar output do método Find By GUID
     *
     * @param eqp
     * @return
     * @throws
     * com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException
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

        try {
            return (ExecuteFunctionResponse) synch.executeFunction(id, NbiDecorator.getEmptyJson(), 9527, opt, 10000, "");
        } catch (DeviceOperationException e) {
            System.out.println("OperationId: " + e.getFaultInfo().getOperationId());
            throw e;
        }
    }

    public FirmwareInfo getFirmwareVersion(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9526, opt, 10000, "");
        return JsonUtil.firmwareInfo(a);
    }

    public DdnsInfo getDdns(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9507, opt, 10000, "efika");
        return JsonUtil.ddnsInfo(a);
    }

    public List<DeviceLog> getDeviceLog(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9519, opt, 10000, "");
        return JsonUtil.deviceLog(a);
    }

    public PPPoECredentialsInfo getPPPoECredentials(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9523, opt, 10000, "efika");
        return JsonUtil.getPPPoECredentialsInfo(a);
    }

    public NbiOperationStatus getDeviceOperationStatus(Long operationId) throws NBIException_Exception {
        this.initNbi();
        return nbi.getOperationStatus(operationId);
    }

    public void getAvailableFirmwareImages(NbiDeviceData eqp) throws NBIException_Exception {
        this.initNbi();
        for (NbiFirmwareImageData o : nbi.getAvailableFirmwareImages(NbiDecorator.adapterAlter(eqp))) {
            System.out.println(o.getName());
            System.out.println(o.getDescription());
        }
    }

    public void initNbi() {
        if (nbi == null) {
            try {
                URL url;
                url = new URL("http://200.168.104.216:7015/NBIServiceImpl/NBIService?wsdl");
                QName qname = new QName("http://nbi2.service.hdm.alcatel.com/",
                        "NBIService");
                Service service = Service.create(url, qname);
                nbi
                        = service.getPort(NBIService.class
                        );
                ((javax.xml.ws.BindingProvider) nbi).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "synchops");
                ((javax.xml.ws.BindingProvider) nbi).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibr4s1l");

            } catch (MalformedURLException ex) {
                Logger.getLogger(EquipamentoDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void initSynchDeviceOperations() {
        if (synch == null) {
            try {
                URL url;
                url = new URL("http://200.168.104.216:7015/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService?wsdl");
                QName qname = new QName("http://www.motive.com/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService",
                        "SynchDeviceOperationsNBIService");
                Service service = Service.create(url, qname);
                synch
                        = service.getPort(SynchDeviceOperationsService.class
                        );
                ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "synchops");
                ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibr4s1l");

            } catch (MalformedURLException ex) {
                Logger.getLogger(EquipamentoDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
