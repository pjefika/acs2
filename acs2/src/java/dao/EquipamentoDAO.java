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
import com.alcatel.hdm.service.nbi2.NbiOperationStatus;
import com.alcatel.hdm.service.nbi2.NbiParameter;
import com.alcatel.hdm.service.nbi2.NbiTemplate;
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
import model.device.DmzInfo;
import model.device.ddns.DdnsInfo;
import model.device.firmware.FirmwareInfo;
import model.device.interfacestatistics.InterfaceStatistics;
import model.device.lanhost.LanDevice;
import model.device.log.DeviceLog;
import model.device.ping.PingRequest;
import model.device.ping.PingResponse;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.serviceclass.ServiceClass;
import model.device.traceroute.TraceRouteRequest;
import model.device.wan.WanInfo;
import model.device.wifi.WifiInfo;
import model.device.wifi.WifiInfoFull;
import model.device.wifi.WifiInfoSet;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationOptions;
import motive.hdm.synchdeviceops.StringResponseDTO;
import util.JsonUtil;

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
            synch.reboot(NbiDecorator.adapter(eqp), NbiDecorator.getDeviceOperationOptionsDefault(), 500, "");
            return true;
        } catch (DeviceOperationException | NBIException | ProviderException e) {
            return false;
        } catch (OperationTimeoutException ex) {
            return true;
        }
    }

    public Boolean factoryReset(NbiDeviceData eqp) {
        try {
            this.initSynchDeviceOperations();
            synch.factoryReset(NbiDecorator.adapter(eqp), NbiDecorator.getDeviceOperationOptionsDefault(), 50000, "");
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

    /**
     * *
     * Pendencia na tratativa de Exceção
     */
    public Boolean checkOnline(NbiDeviceData eqp) {
        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();
            synch.checkOnline(NbiDecorator.adapter(eqp), opt, 10000, "");
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

    public List<NbiDeviceData> listarEquipamentosPorSubscriber(String subscriber) {
        try {
            this.initNbi();
            return nbi.findDevicesBySubscriberId(subscriber);
        } catch (Exception e) {
            //e.printStackTrace();
            return new ArrayList<>();
        }

    }

    public List<NbiDeviceData> listarEquipamentosPorMac(String mac) {
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
            return new ArrayList<>();
        }

    }

    public List<NbiDeviceData> listarEquipamentosPorSerial(String serial) {

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
            return new ArrayList<>();
        }
    }

    /**
     * Utilizar output do método Find By GUID
     *
     * @param eqp
     * @return
     * @throws java.lang.Exception
     */
//    public ExecuteFunctionResponse getDeviceInfo(NbiDeviceData eqp) throws Exception {
//        this.initSynchDeviceOperations();
//        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
//        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9527, opt, 10000, "");
//        return JsonUtil.firmwareInfo(a);
//    }
    public FirmwareInfo getFirmwareVersion(NbiDeviceData eqp) {
        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();
            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9526, opt, 10000, "");
            return JsonUtil.firmwareInfo(a);
        } catch (Exception e) {
            return null;
        }
    }

    public WifiInfo getWifiInfo(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9511, opt, 10000, "");
        return JsonUtil.getWifiInfo(a);
    }

    public WanInfo getWanInfo(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9515, opt, 10000, "");
        return JsonUtil.getWanInfo(a);
    }

    public ServiceClass getServiceClass(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9505, opt, 10000, "");
        return JsonUtil.getServiceClass(a);
    }

    public List<LanDevice> getLanHosts(NbiDeviceData eqp) throws Exception {

        List<LanDevice> lst = new ArrayList<>();
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9517, opt, 10000, "");

        return JsonUtil.getLanHosts(a);
    }

    public DmzInfo getDmzInfo(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9503, opt, 10000, "");
        return JsonUtil.dmzInfo(a);
    }

    public WifiInfoFull getWifiInfoFull(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9529, opt, 60000, "");
        return JsonUtil.getWifiInfoFull(a);
    }

    public List<PortMappingInfo> getPortMapping(NbiDeviceData eqp) throws Exception {
        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();
            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9513, opt, 20000, "");
            return JsonUtil.getPortMappingInfo(a);
        } catch (DeviceOperationException | NBIException | OperationTimeoutException | ProviderException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PortMappingInfo traceroute(NbiDeviceData eqp, TraceRouteRequest trace) throws Exception {
        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();

            String traceStr = JsonUtil.serialize(trace, trace.getClass());
            List<Object> json = NbiDecorator.getEmptyJson();
            json.set(0, traceStr);

            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9524, opt, 15000, "");

            System.out.println(a.getValue());

            return null;
        } catch (DeviceOperationException | NBIException | OperationTimeoutException | ProviderException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Somente parâmetros alteraveis podem ser serializados para essa chamada
     *
     * @param eqp
     * @param wifi
     * @return
     * @throws Exception
     */
    public Boolean setWifiInfo(NbiDeviceData eqp, WifiInfo wifi) throws Exception {

        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();

            WifiInfoSet adapter = NbiDecorator.getWifiInfoSet(wifi);

            String jsonWifi = JsonUtil.serialize(adapter, adapter.getClass());
            List<Object> json = NbiDecorator.getEmptyJson();
            json.set(0, jsonWifi);

            System.out.println(jsonWifi);

            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9510, opt, 10000, "");
            return true;
        } catch (OperationTimeoutException | ProviderException e) {
            e.printStackTrace();
            return true;
        } catch (DeviceOperationException | NBIException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean setWifiInfoFull(NbiDeviceData eqp, WifiInfoFull wifi) throws Exception {

        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();

            WifiInfoSet adapter = NbiDecorator.getWifiInfoSetFull(wifi);

            String jsonWifi = JsonUtil.serialize(adapter, adapter.getClass());
            List<Object> json = NbiDecorator.getEmptyJson();
            json.set(0, jsonWifi);

            System.out.println(jsonWifi);

            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9510, opt, 30000, "");
            return true;
        } catch (OperationTimeoutException | ProviderException e) {
            e.printStackTrace();
            return true;
        } catch (DeviceOperationException | NBIException e) {
            e.printStackTrace();
            return false;
        }
    }

    public DdnsInfo getDdns(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9507, opt, 10000, "");
        
        return JsonUtil.ddnsInfo(a);
    }

    public void xDSLDiagnostic(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9514, opt, 10000, "");

        System.out.println(a.getValue());
    }

    public List<DeviceLog> getDeviceLog(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9519, opt, 10000, "");
        return JsonUtil.deviceLog(a);
    }

    public List<InterfaceStatistics> getInterfaceStatistics(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9531, opt, 15000, "");
        return JsonUtil.getInterfaceStatistics(a);
    }

    public PPPoECredentialsInfo getPPPoECredentials(NbiDeviceData eqp) {
        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();
            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9523, opt, 10000, "");
            return JsonUtil.getPPPoECredentialsInfo(a);
        } catch (DeviceOperationException | NBIException | OperationTimeoutException | ProviderException e) {
            e.printStackTrace();
            return null;
        }
    }

    public PingResponse pingDiagnostic(NbiDeviceData eqp, PingRequest p) throws Exception {
        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();
            String jsonPppoe = JsonUtil.serialize(p, p.getClass());
            List<Object> json = NbiDecorator.getEmptyJson();
            json.set(0, jsonPppoe);
            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9530, opt, 15000, "");
            //System.out.println(a.getValue());
            return JsonUtil.pingResponse(a);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public StringResponseDTO setPPPoECredentials(NbiDeviceData eqp, PPPoECredentialsInfo pPPoECredentialsInfo) {
        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();
            String jsonPppoe = JsonUtil.serialize(pPPoECredentialsInfo, pPPoECredentialsInfo.getClass());
            List<Object> json = NbiDecorator.getEmptyJson();
            json.set(0, jsonPppoe);
            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9522, opt, 10000, "");
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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

    public StringResponseDTO setPortMapping(NbiDeviceData eqp, PortMappingInfo portMappingInfo) {
        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();
            String jsonPppoe = JsonUtil.serialize(portMappingInfo, portMappingInfo.getClass());
            List<Object> json = NbiDecorator.getEmptyJson();
            json.set(0, jsonPppoe);
            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9512, opt, 10000, "");
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
