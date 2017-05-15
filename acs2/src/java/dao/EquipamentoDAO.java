package dao;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NBIService;
import com.alcatel.hdm.service.nbi2.NbiDeviceActionResult;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.alcatel.hdm.service.nbi2.NbiFirmwareImageData;
import com.alcatel.hdm.service.nbi2.NbiOperationStatus;
import com.alcatel.hdm.service.nbi2.NbiParameter;
import com.alcatel.hdm.service.nbi2.NbiSupportedRPCMethod;
import com.alcatel.hdm.service.nbi2.NbiTemplate;
import com.google.gson.Gson;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.SynchDeviceOperationsService;
import com.motive.www.remotehdm.NBIService._1_0.NBIServiceLocator;
import com.motive.www.remotehdm.NBIService._1_0.NBIServicePortStub;
import com.sun.xml.wss.XWSSConstants;
import dao.util.NbiDecorator;
import dao.util.SoapUtil;
import dao.util.acao.AtivarWifi;
import dao.util.acao.DesativarWifi;
import dto.nbi.service.hdm.alcatel.com.NBIDeviceID;
import dto.nbi.service.hdm.alcatel.com.NBIFirmwareImageData;
import exception.HdmException;
import exception.JsonUtilException;
import exception.UnsupportedException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;
import model.device.DmzInfo;
import model.device.ddns.DdnsInfo;
import model.device.dhcp.Dhcp;
import model.device.dhcp.DhcpSet;
import model.device.firmware.FirmwareInfo;
import model.device.interfacestatistics.InterfaceStatistics;
import model.device.lanhost.LanDevice;
import model.device.log.DeviceLog;
import model.device.ping.PingRequest;
import model.device.ping.PingResponse;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.serviceclass.ServiceClass;
import model.device.sipactivation.SipActivation;
import model.device.sipdiagnostics.SipDiagnostics;
import model.device.traceroute.TraceRouteRequest;
import model.device.wan.WanInfo;
import model.device.wifi.WifiInfoFull;
import model.device.wifi.WifiInfoSet;
import model.device.xdsldiagnostics.XdslDiagnostics;
import motive.hdm.synchdeviceops.GetParameterNamesDTO;
import motive.hdm.synchdeviceops.GetParameterNamesResponseDTO;
import motive.hdm.synchdeviceops.GetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationOptions;
import motive.hdm.synchdeviceops.ParameterInfoStructDTO;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;
import motive.hdm.synchdeviceops.SetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.StringResponseDTO;
import org.apache.axis.AxisFault;
import util.GsonUtil;
import util.JsonUtil;

/**
 *
 * @author G0042204
 */
public class EquipamentoDAO {

    private NBIService nbi;

    private NBIServicePortStub remote;

    private SynchDeviceOperationsService synch;

    public EquipamentoDAO() {
        System.setProperty("http.proxyHost", "proxysp.vivo.com.br");
        System.setProperty("http.proxyPort", "8080");
        System.setProperty("http.nonProxyHosts", "10.200.35.67");
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

    public Boolean reboot(NbiDeviceData eqp) throws DeviceOperationException, NBIException, ProviderException {
        try {
            this.initSynchDeviceOperations();
            synch.reboot(NbiDecorator.adapter(eqp), NbiDecorator.getDeviceOperationOptionsDefault(), 500, "");
            return true;
        } catch (OperationTimeoutException ex) {
            return true;
        }
    }

    public Boolean factoryReset(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {

        this.initSynchDeviceOperations();
        synch.factoryReset(NbiDecorator.adapter(eqp), NbiDecorator.getDeviceOperationOptionsDefault(), 50000, "");
        return true;

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
     *
     * @param eqp
     */
    public Boolean checkOnline(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        synch.checkOnline(NbiDecorator.adapter(eqp), opt, 15000, "");
        return true;

    }

    public void teste() {

    }

    public Long firmwareUpdate(NbiDeviceData eqp, FirmwareInfo info) throws NBIException_Exception, RemoteException {
        this.initRemote();
        System.out.println("PreferredVersion: " + info.getPreferredVersion());
        return remote.createSingleFirmwareUpdateOperation(new NBIDeviceID(eqp.getDeviceId().getOUI(),
                eqp.getDeviceId().getProductClass(),
                eqp.getDeviceId().getProtocol(), eqp.getDeviceId().getSerialNumber()),
                info.getPreferredVersion(), 15000);
    }

    public void getAvailableFirmwareImages(NbiDeviceData eqp) {
        try {
            this.initRemote();
            for (NBIFirmwareImageData firm : remote.getAvailableFirmwareImages(cast(eqp))) {
                System.out.println(firm.getName());
                System.out.println(firm.getDescription());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public NBIDeviceID cast(NbiDeviceData eqp) {
        return new NBIDeviceID(eqp.getDeviceId().getOUI(),
                eqp.getDeviceId().getProductClass(),
                eqp.getDeviceId().getProtocol(), eqp.getDeviceId().getSerialNumber());
    }

    public NbiDeviceActionResult getDeviceOperationStatus(NbiDeviceData eqp, Long operationId) throws NBIException_Exception {
        this.initNbi();
        return nbi.getDeviceOperationStatus(eqp.getDeviceId(), operationId);
    }

    public List<NbiDeviceData> listarEquipamentosPorSubscriber(String subscriber) throws NBIException_Exception {
        try {
            this.initNbi();
            return nbi.findDevicesBySubscriberId(subscriber);
        } catch (NBIException_Exception ex) {
            if (ex.getFaultInfo().getFaultCode().contentEquals("devices.for.subscriberid.could.not.be.found")) {
                return new ArrayList<NbiDeviceData>();
            }
            throw ex;
        }

    }

    public void getSup() {
        try {
            this.initNbi();
            for (NbiSupportedRPCMethod a : nbi.getSupportedRPCMethods()) {
                System.out.println("Nome: " + a.getName() + "|   Function:" + a.getFunctionCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    /**
     * Realizada adaptação (metodo retorna objeto simples e não lista
     *
     * @author G0042204
     * @param ip
     * @return
     * @throws NBIException_Exception
     */
    public List<NbiDeviceData> listarEquipamentosPorIp(String ip) throws NBIException_Exception {

        List<NbiDeviceData> r = new ArrayList<>();

        this.initNbi();
        NbiDeviceData d = nbi.findDeviceByExternalIPAddress(ip);

        if (d != null) {
            r.add(d);
        }

        return r;
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

    public FirmwareInfo getFirmwareVersion(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9526, opt, 55000, "");
        return JsonUtil.firmwareInfo(a);
    }

//    public WifiInfo getWifiInfo(NbiDeviceData eqp) throws Exception {
//        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
//        this.initSynchDeviceOperations();
//        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9511, opt, 30000, "");
//        String wifiDisable = "Nenhuma interface WiFi se encontra habilitada.";
//        if (a.getValue().contains(wifiDisable)) {
//            throw new HdmException(wifiDisable);
//        }
//        return JsonUtil.getWifiInfo(a);
//    }
    public void getParameters(NbiDeviceData eqp) throws Exception {
        this.initSynchDeviceOperations();
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        GetParameterNamesDTO g = new GetParameterNamesDTO();
        g.setParameterPath("InternetGatewayDevice.");
        GetParameterNamesResponseDTO r = synch.getParameterNames(NbiDecorator.adapter(eqp), g, opt, 30000, "");
        for (ParameterInfoStructDTO p : r.getParameterList()) {
            System.out.println(p.getName());
        }
    }

    public void getParametersWifi(NbiDeviceData eqp) throws Exception {
        this.initSynchDeviceOperations();
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        GetParameterNamesDTO g = new GetParameterNamesDTO();
        g.setParameterPath("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.");
        GetParameterNamesResponseDTO r = synch.getParameterNames(NbiDecorator.adapter(eqp), g, opt, 30000, "");
        for (ParameterInfoStructDTO p : r.getParameterList()) {
            System.out.println(p.getName());
        }
    }

    public void getParametersValues(NbiDeviceData eqp, List<String> paths) throws Exception {
        this.initSynchDeviceOperations();
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();

        motive.hdm.synchdeviceops.GetParameterValuesDTO g = new motive.hdm.synchdeviceops.GetParameterValuesDTO();
        for (int i = 0; i < paths.size(); i++) {
            g.getParameterNames().add(i, paths.get(i));
        }
        GetParameterValuesResponseDTO r = synch.getParameterValues(NbiDecorator.adapter(eqp), g, opt, 30000, "");
        for (ParameterValueStructDTO p : r.getParameterList()) {
            System.out.println("Nome: " + p.getName());
            System.out.println("Type: " + p.getType());
            System.out.println("Value: " + p.getValue());
        }

    }

    public void getParameterValue(NbiDeviceData eqp, String path) throws Exception {
        this.initSynchDeviceOperations();
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();

        motive.hdm.synchdeviceops.GetParameterValuesDTO g = new motive.hdm.synchdeviceops.GetParameterValuesDTO();
        g.getParameterNames().add(0, path);
        GetParameterValuesResponseDTO r = synch.getParameterValues(NbiDecorator.adapter(eqp), g, opt, 50000, "");
        for (ParameterValueStructDTO p : r.getParameterList()) {
            System.out.println("Nome: " + p.getName());
            System.out.println("Type: " + p.getType());
            System.out.println("Value: " + p.getValue());
        }

    }

    public void ativarWifi(NbiDeviceData eqp) throws Exception {
        this.setParametersValues(eqp, new AtivarWifi());
    }

    public void desativarWifi(NbiDeviceData eqp) throws Exception {
        this.setParametersValues(eqp, new DesativarWifi());
    }

    public void setParametersValues(NbiDeviceData eqp, ParameterValueStructDTO p) throws Exception {
        this.initSynchDeviceOperations();
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        motive.hdm.synchdeviceops.SetParameterValuesDTO g = new motive.hdm.synchdeviceops.SetParameterValuesDTO();
        g.getParameterValueStructs().add(p);
        SetParameterValuesResponseDTO s = synch.setParameterValues(NbiDecorator.adapter(eqp), g, opt, 50000, "");
        System.out.println("Retorno: " + s.getStatus());
    }

    public WanInfo getWanInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9515, opt, 30000, "");
        System.out.println(a.getValue());
        return (WanInfo) GsonUtil.convert(a.getValue(), WanInfo.class);
    }

    public ServiceClass getServiceClass(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9505, opt, 30000, "");
        if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }
        return (ServiceClass) GsonUtil.convert(a.getValue(), ServiceClass.class);
    }

    public Boolean setServiceClass(NbiDeviceData eqp, ServiceClass sc) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        String jsonSc = GsonUtil.serialize(sc);
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, jsonSc);
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9504, opt, 30000, "");
//        System.out.println(a.toString());
        if (a.toString().contains("SUCCESS")) {
            return true;
        } else {
            return false;
        }

    }

    public List<LanDevice> getLanHosts(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9517, opt, 30000, "");

        List<LanDevice> i;
        try {
            i = JsonUtil.getLanHosts(a);
        } catch (JsonUtilException e) {
            System.out.println("Falha getLanHosts no deviceGUID " + eqp.getDeviceGUID());
            System.out.println("StringResponseDTO fornecida: " + a.getValue());
            throw new JsonUtilException(e.getMessage());
        }
        return i;
    }

    public DmzInfo getDmzInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9503, opt, 30000, "");
        System.out.println(a.getValue());
        //return JsonUtil.dmzInfo(a);
        return (DmzInfo) GsonUtil.convert(a.getValue(), DmzInfo.class);
    }

    public WifiInfoFull getWifiInfoFull(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, JsonUtilException, HdmException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9529, opt, 300000, "");

        String wifiDisable = "Nenhuma interface WiFi se encontra habilitada.";
        if (a.getValue().contains(wifiDisable)) {
            throw new HdmException(wifiDisable);
        }
        WifiInfoFull[] wifi = (WifiInfoFull[]) GsonUtil.convert(a.getValue(), WifiInfoFull[].class);
        return wifi[0];
    }

    public List<PortMappingInfo> getPortMapping(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9513, opt, 20000, "");
        //System.out.println(a.getValue());
        PortMappingInfo[] pmi = (PortMappingInfo[]) GsonUtil.convert(a.getValue(), PortMappingInfo[].class);
        //List<PortMappingInfo> l = ;
        return Arrays.asList(pmi);
    }

    public Dhcp getDhcp(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9509, opt, 30000, "");
        return (Dhcp) GsonUtil.convert(a.getValue(), Dhcp.class);
    }

    public Boolean setDhcp(NbiDeviceData eqp, Dhcp dh) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        String jsonD = GsonUtil.serialize(new DhcpSet(dh));
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, jsonD);
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9508, opt, 30000, "");
        
        return a.getValue().contains("SUCCESS");
    }

    public PortMappingInfo traceroute(NbiDeviceData eqp, TraceRouteRequest trace) throws Exception {
        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();

            //String traceStr = JsonUtil.serialize(trace, trace.getClass());            
            String traceStr = GsonUtil.serialize(trace);
            List<Object> json = NbiDecorator.getEmptyJson();
            json.set(0, traceStr);

            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9524, opt, 15000, "");

            //System.out.println(a.getValue());
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
//    public Boolean setWifiInfo(NbiDeviceData eqp, WifiInfo wifi) throws Exception {
//
//        try {
//            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
//            this.initSynchDeviceOperations();
//
//            WifiInfoSet adapter = NbiDecorator.getWifiInfoSet(wifi);
//
//            String jsonWifi = JsonUtil.serialize(adapter, adapter.getClass());
//            List<Object> json = NbiDecorator.getEmptyJson();
//            json.set(0, jsonWifi);
//
//            //System.out.println(jsonWifi);
//            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9510, opt, 30000, "");
//            return true;
//        } catch (OperationTimeoutException | ProviderException e) {
//            e.printStackTrace();
//            return true;
//        } catch (DeviceOperationException | NBIException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    public Boolean setWifiInfoFull(NbiDeviceData eqp, WifiInfoFull wifi) throws DeviceOperationException, NBIException {

        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            this.initSynchDeviceOperations();

            WifiInfoSet adapter = NbiDecorator.getWifiInfoSetFull(wifi);
            //String jsonWifi = JsonUtil.serialize(adapter, adapter.getClass());
            String jsonWifi = GsonUtil.serialize(adapter);
            List<Object> json = NbiDecorator.getEmptyJson();
            json.set(0, jsonWifi);

            StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9510, opt, 30000, "");
            System.out.println(a.getValue());
            
            return a.getValue().contains("SUCCESS");

        } catch (OperationTimeoutException | ProviderException e) {
            e.printStackTrace();
            return true;
        }
    }

    public DdnsInfo getDdns(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9507, opt, 30000, "");
        //System.out.println(a.getValue());               
//        DdnsInfo i;
//        try {
//            i = JsonUtil.ddnsInfo(a);
//        } catch (JsonUtilException e) {
//            System.out.println("Falha ddnsInfo no deviceGUID " + eqp.getDeviceGUID());
//            System.out.println("StringResponseDTO fornecida: " + a.getValue());
//            throw new JsonUtilException(e.getMessage());
//        }
        return (DdnsInfo) GsonUtil.convert(a.getValue(), DdnsInfo.class);
    }

    public XdslDiagnostics getXdslDiagnostic(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9514, opt, 30000, "");
//        XdslDiagnostics i;
//        try {
//            i = JsonUtil.getXdslDiagnostics(a);
//        } catch (JsonUtilException e) {
//            System.out.println("Falha getXdslDiagnostics no deviceGUID " + eqp.getDeviceGUID());
//            System.out.println("StringResponseDTO fornecida: " + a.getValue());
//            throw new JsonUtilException(e.getMessage());
//        }
        return (XdslDiagnostics) GsonUtil.convert(a.getValue(), XdslDiagnostics.class);
    }

    public List<DeviceLog> getDeviceLog(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9519, opt, 30000, "");
        System.out.println(a.getValue());
        return JsonUtil.deviceLog(a);
    }

    public List<InterfaceStatistics> getInterfaceStatistics(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9531, opt, 30000, "");
        InterfaceStatistics[] is = (InterfaceStatistics[]) GsonUtil.convert(a.getValue(), InterfaceStatistics[].class);
//        List<InterfaceStatistics> i;
//        try {
//            i = JsonUtil.getInterfaceStatistics(a);
//        } catch (JsonUtilException e) {
//            System.out.println("Falha getInterfaceStatistics no deviceGUID " + eqp.getDeviceGUID());
//            System.out.println("StringResponseDTO fornecida: " + a.getValue());
//            throw new JsonUtilException(e.getMessage());
//        }
        return Arrays.asList(is);
    }

    public PPPoECredentialsInfo getPPPoECredentials(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {

        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9523, opt, 30000, "");
        System.out.println(a.getValue());
        PPPoECredentialsInfo ppoe = (PPPoECredentialsInfo) GsonUtil.convert(a.getValue(), PPPoECredentialsInfo.class);
        System.out.println(ppoe.getUsername());
//        PPPoECredentialsInfo i;
//        try {
//            i = JsonUtil.getPPPoECredentialsInfo(a);
//        } catch (JsonUtilException e) {
//            System.out.println("Falha getPPPoECredentialsInfo no deviceGUID " + eqp.getDeviceGUID());
//            System.out.println("StringResponseDTO fornecida: " + a.getValue());
//            throw new JsonUtilException(e.getMessage());
//        }
        return ppoe;

    }

    public PingResponse pingDiagnostic(NbiDeviceData eqp, PingRequest p) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {

        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        //String jsonPppoe = JsonUtil.serialize(p, p.getClass());
        String jsonPppoe = GsonUtil.serialize(p);
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, jsonPppoe);
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9530, opt, 150000, "");

        PingResponse i;

        try {
            i = JsonUtil.pingResponse(a);
        } catch (JsonUtilException e) {
            System.out.println("Falha pingResponse no deviceGUID " + eqp.getDeviceGUID());
            System.out.println("StringResponseDTO fornecida: " + a.getValue());
            throw new JsonUtilException(e.getMessage());
        }

        return i;
    }

    public StringResponseDTO setPPPoECredentials(NbiDeviceData eqp, PPPoECredentialsInfo pPPoECredentialsInfo) throws DeviceOperationException, OperationTimeoutException, NBIException, ProviderException {

        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        //String jsonPppoe = JsonUtil.serialize(pPPoECredentialsInfo, pPPoECredentialsInfo.getClass());
        String jsonPppoe = GsonUtil.serialize(pPPoECredentialsInfo);
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, jsonPppoe);
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9522, opt, 30000, "");
        return a;

    }

    public NbiOperationStatus getDeviceOperationStatus(Long operationId) throws NBIException_Exception {
        this.initNbi();
        return nbi.getOperationStatus(operationId);
    }

    public void getAvailableFirmwareImages2(NbiDeviceData eqp) throws NBIException_Exception {
        this.initNbi();
        for (NbiFirmwareImageData o : nbi.getAvailableFirmwareImagesByPrerequsite(eqp.getDeviceId())) {
            System.out.println(o.getName());
            System.out.println(o.getDescription());
        }
    }

    public Boolean setPortMapping(NbiDeviceData eqp, List<PortMappingInfo> ports) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {

        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        List<Object> json = NbiDecorator.getEmptyJson();

        Gson gson = new Gson();
        String jsonPm = gson.toJson(ports);
        json.set(0, jsonPm.toString().toString().replace("\"", "'"));
        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9512, opt, 20000, "");
        
        return a.getValue().contains("SUCCESS");
        //System.out.println(a.getValue());

    }

    public SipDiagnostics getSipDiagnostics(NbiDeviceData eqp, Integer phyref) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();
        String leJson = "{\"phyreferencelist\":\"" + phyref.toString() + "\"}";
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, leJson);

        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9520, opt, 30000, "");

        if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }

        return (SipDiagnostics) GsonUtil.convert(a.getValue(), SipDiagnostics.class);
    }

    public Boolean setSipActivation(NbiDeviceData eqp, SipActivation sip) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        this.initSynchDeviceOperations();

        String leJson = GsonUtil.serialize(sip);
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, leJson);

        StringResponseDTO a = (StringResponseDTO) synch.executeFunction(NbiDecorator.adapter(eqp), json, 9500, opt, 30000, "");

        if (a.getValue().contains("SUCCESS")) {
            return true;
        }

        return false;
    }

    /**
     * User: "nbi_user" Password: "nbibrasil"
     *
     * @throws SOAPException
     * @throws ServiceException
     * @throws AxisFault
     */
    public void initRemote() {
        try {
            if (remote == null) {
                NBIServicePortStub stub = new NBIServicePortStub(new URL("http://200.168.104.216:7025/remotehdm/NBIService?wsdl"), new NBIServiceLocator());
                remote = (NBIServicePortStub) SoapUtil.addWsSecurityHeader(stub, "nbi_user", "nbibrasil");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void initNbi() {
        if (nbi == null) {
            try {
                URL url;
                url = new URL("http://200.168.104.216:7015/NBIServiceImpl/NBIService?wsdl");
//                url = new URL("http://201.95.254.37:7035/NBIServiceImpl/NBIService?wsdl");
                QName qname = new QName("http://nbi2.service.hdm.alcatel.com/",
                        "NBIService");
                Service service = Service.create(url, qname);
                nbi = service.getPort(NBIService.class);
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
//                url = new URL("http://201.95.254.37:7035/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService?wsdl");
                QName qname = new QName("http://www.motive.com/SynchDeviceOpsImpl/SynchDeviceOperationsNBIService",
                        "SynchDeviceOperationsNBIService");
                Service service = Service.create(url, qname);
                synch = service.getPort(SynchDeviceOperationsService.class);
                ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "nbi_user");
                ((javax.xml.ws.BindingProvider) synch).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibrasil");

            } catch (MalformedURLException ex) {
                Logger.getLogger(EquipamentoDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
