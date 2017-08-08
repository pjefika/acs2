/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.google.gson.Gson;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.SynchDeviceOperationsService;
import dao.factory.FactoryNBI;
import dao.util.NbiDecorator;

import java.util.Arrays;
import java.util.List;
import model.device.DmzInfo;
import model.device.ddns.DdnsInfo;
import model.device.dhcp.Dhcp;
import model.device.dhcp.DhcpSet;
import model.device.firmware.FirmwareInfo;
import model.device.interfacestatistics.InterfaceStatistics;
import model.device.lanhost.LanDevice;
import model.device.log.DeviceLog;
import model.device.log.DeviceLogR;
import model.device.ping.PingRequest;
import model.device.ping.PingResponse;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.pppoe.PPPoECredentialsInfoOut;
import model.device.serviceclass.ServiceClass;
import model.device.sipactivation.SipActivation;
import model.device.sipdiagnostics.SipDiagnostics;
import model.device.traceroute.TraceRouteRequest;
import model.device.wan.WanInfo;
import model.device.wifi.WifiInfoFull;
import model.device.wifi.WifiInfoSet;
import model.device.xdsldiagnostics.XdslDiagnostics;
import model.exception.HdmException;
import model.exception.JsonUtilException;
import model.exception.UnsupportedException;
import motive.hdm.synchdeviceops.GetParameterNamesDTO;
import motive.hdm.synchdeviceops.GetParameterNamesResponseDTO;
import motive.hdm.synchdeviceops.GetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationOptions;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;
import motive.hdm.synchdeviceops.SetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.StringResponseDTO;
import util.GsonUtil;
import util.JsonUtil;

public class SynchDeviceDAOImpl implements SynchDeviceDAO {

    private SynchDeviceOperationsService synch;

    public SynchDeviceDAOImpl() {
    }

    protected SynchDeviceOperationsService synch() {
        if (synch == null) {
            synch = FactoryNBI.createSynch();
        }
        return synch;
    }

    @Override
    public Boolean reboot(NbiDeviceData eqp) throws DeviceOperationException, NBIException, ProviderException {
        try {
            synch().reboot(NbiDecorator.adapter(eqp), NbiDecorator.getDeviceOperationOptionsDefault(), 500, "");
            return true;
        } catch (OperationTimeoutException ex) {
            return true;
        }
    }

    @Override
    public Boolean factoryReset(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        synch().factoryReset(NbiDecorator.adapter(eqp), NbiDecorator.getDeviceOperationOptionsDefault(), 50000, "");
        return true;
    }

    @Override
    public Boolean checkOnline(NbiDeviceData eqp) throws NBIException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        try {
            synch().checkOnline(NbiDecorator.adapter(eqp), opt, 15000, "");
            return true;
        } catch (DeviceOperationException | OperationTimeoutException e) {
            return false;
        }
    }

    @Override
    public FirmwareInfo getFirmwareVersion(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9526, opt, 55000, "");
        return JsonUtil.firmwareInfo(a);
    }

    @Override
    public void getParameters(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        GetParameterNamesDTO g = new GetParameterNamesDTO();
        g.setParameterPath("InternetGatewayDevice.");
        GetParameterNamesResponseDTO r = synch().getParameterNames(NbiDecorator.adapter(eqp), g, opt, 30000, "");
//        for (ParameterInfoStructDTO p : r.getParameterList()) {
//            System.out.println(p.getName());
//        }
    }

    @Override
    public void getParametersWifi(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        GetParameterNamesDTO g = new GetParameterNamesDTO();
        g.setParameterPath("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.");
        GetParameterNamesResponseDTO r = synch().getParameterNames(NbiDecorator.adapter(eqp), g, opt, 30000, "");
//        for (ParameterInfoStructDTO p : r.getParameterList()) {
//            System.out.println(p.getName());
//        }
    }

    @Override
    public void getParametersValues(NbiDeviceData eqp, List<String> paths) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();

        motive.hdm.synchdeviceops.GetParameterValuesDTO g = new motive.hdm.synchdeviceops.GetParameterValuesDTO();
        for (int i = 0; i < paths.size(); i++) {
            g.getParameterNames().add(i, paths.get(i));
        }
        GetParameterValuesResponseDTO r = synch().getParameterValues(NbiDecorator.adapter(eqp), g, opt, 30000, "");
//        for (ParameterValueStructDTO p : r.getParameterList()) {
//            System.out.println("Nome: " + p.getName());
//            System.out.println("Type: " + p.getType());
//            System.out.println("Value: " + p.getValue());
//        }
    }

    @Override
    public void getParameterValue(NbiDeviceData eqp, String path) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();

        motive.hdm.synchdeviceops.GetParameterValuesDTO g = new motive.hdm.synchdeviceops.GetParameterValuesDTO();
        g.getParameterNames().add(0, path);
        GetParameterValuesResponseDTO r = synch().getParameterValues(NbiDecorator.adapter(eqp), g, opt, 50000, "");
//        for (ParameterValueStructDTO p : r.getParameterList()) {
//            System.out.println("Nome: " + p.getName());
//            System.out.println("Type: " + p.getType());
//            System.out.println("Value: " + p.getValue());
//        }
    }

    @Override
    public void setParametersValues(NbiDeviceData eqp, ParameterValueStructDTO p) throws Exception {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        motive.hdm.synchdeviceops.SetParameterValuesDTO g = new motive.hdm.synchdeviceops.SetParameterValuesDTO();
        g.getParameterValueStructs().add(p);
        SetParameterValuesResponseDTO s = synch().setParameterValues(NbiDecorator.adapter(eqp), g, opt, 50000, "");
//        System.out.println("Retorno: " + s.getStatus());
    }

    @Override
    public WanInfo getWanInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9515, opt, 30000, "");
//        System.out.println(a.getValue());
        return (WanInfo) GsonUtil.convert(a.getValue(), WanInfo.class);
    }

    @Override
    public ServiceClass getServiceClass(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9505, opt, 30000, "");
        if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }
        return (ServiceClass) GsonUtil.convert(a.getValue(), ServiceClass.class);
    }

    @Override
    public Boolean setServiceClass(NbiDeviceData eqp, ServiceClass sc) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        String jsonSc = GsonUtil.serialize(sc);
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, jsonSc);
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), json, 9504, opt, 30000, "");
        //System.out.println(a.getValue());

        return a.getValue().contains("SUCCESS");
    }

    @Override
    public List<LanDevice> getLanHosts(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, model.exception.JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9517, opt, 30000, "");

        return JsonUtil.getLanHosts(a);
    }

    @Override
    public DmzInfo getDmzInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9503, opt, 30000, "");
        if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }
        return (DmzInfo) GsonUtil.convert(a.getValue(), DmzInfo.class);
    }

    @Override
    public WifiInfoFull getWifiInfoFull(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, JsonUtilException, HdmException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9529, opt, 20000, "");

        String wifiDisable = "Nenhuma interface WiFi se encontra habilitada.";
        if (a.getValue().contains(wifiDisable)) {
            throw new HdmException(wifiDisable);
        }
        WifiInfoFull[] wifi = (WifiInfoFull[]) GsonUtil.convert(a.getValue(), WifiInfoFull[].class);
        return wifi[0];
    }

    @Override
    public List<PortMappingInfo> getPortMapping(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9513, opt, 20000, "");
        //System.out.println(a.getValue());
        PortMappingInfo[] pmi = (PortMappingInfo[]) GsonUtil.convert(a.getValue(), PortMappingInfo[].class);
        //List<PortMappingInfo> l = ;
        return Arrays.asList(pmi);
    }

    @Override
    public Dhcp getDhcp(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9509, opt, 30000, "");
        return (Dhcp) GsonUtil.convert(a.getValue(), Dhcp.class);
    }

    @Override
    public Boolean setDhcp(NbiDeviceData eqp, Dhcp dh) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        String jsonD = GsonUtil.serialize(new DhcpSet(dh));
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, jsonD);
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), json, 9508, opt, 30000, "");
        System.out.println(a.getValue());
        return a.getValue().contains("SUCCESS");
    }

    /**
     * Não há doc do retorno
     *
     * @param eqp
     * @param trace
     * @return
     * @throws DeviceOperationException
     * @throws NBIException
     * @throws OperationTimeoutException
     * @throws ProviderException
     */
    @Override
    public PortMappingInfo traceroute(NbiDeviceData eqp, TraceRouteRequest trace) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        String traceStr = GsonUtil.serialize(trace);
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, traceStr);

        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), json, 9524, opt, 120000, "");
        System.out.println(a.getValue());
        return (PortMappingInfo) GsonUtil.convert(a.getValue(), PortMappingInfo.class);

    }

    @Override
    public Boolean setWifiInfoFull(NbiDeviceData eqp, WifiInfoFull wifi) throws DeviceOperationException, NBIException {
        try {
            NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
            WifiInfoSet adapter = NbiDecorator.getWifiInfoSetFull(wifi);
            //String jsonWifi = JsonUtil.serialize(adapter, adapter.getClass());
            String jsonWifi = GsonUtil.serialize(adapter);
            List<Object> json = NbiDecorator.getEmptyJson();
            json.set(0, jsonWifi);

            System.out.println("json: " + json.toString());

            StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), json, 9510, opt, 30000, "");
            //System.out.println(a.getValue());

            return a.getValue().contains("SUCCESS");

        } catch (OperationTimeoutException | ProviderException e) {
//            e.printStackTrace();
            return true;
        }
    }

    @Override
    public DdnsInfo getDdns(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, UnsupportedException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9507, opt, 30000, "");
        if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }
        return (DdnsInfo) GsonUtil.convert(a.getValue(), DdnsInfo.class);
    }

    @Override
    public XdslDiagnostics getXdslDiagnostic(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, UnsupportedException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9514, opt, 30000, "");
        if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }
        return (XdslDiagnostics) GsonUtil.convert(a.getValue(), XdslDiagnostics.class);
    }

    /**
     * não retorna adequadamente
     *
     * @param eqp
     * @return
     * @throws NBIException
     * @throws OperationTimeoutException
     * @throws ProviderException
     * @throws DeviceOperationException
     * @throws JsonUtilException
     */
    @Override
    public List<DeviceLog> getDeviceLog(NbiDeviceData eqp) throws NBIException, OperationTimeoutException, ProviderException, DeviceOperationException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9519, opt, 30000, "");
        System.out.println(a.getValue());
        return JsonUtil.deviceLog(a);
    }

    @Override
    public List<DeviceLogR> getDeviceLogR(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9519, opt, 30000, "");
        return GsonUtil.deviceLogR(a);
    }

    @Override
    public List<InterfaceStatistics> getInterfaceStatistics(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9531, opt, 30000, "");
        InterfaceStatistics[] is = (InterfaceStatistics[]) GsonUtil.convert(a.getValue(), InterfaceStatistics[].class);
        return Arrays.asList(is);
    }

    @Override
    public PPPoECredentialsInfo getPPPoECredentials(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), NbiDecorator.getEmptyJson(), 9523, opt, 30000, "");
        return (PPPoECredentialsInfo) GsonUtil.convert(a.getValue(), PPPoECredentialsInfo.class);
    }

    @Override
    public PingResponse pingDiagnostic(NbiDeviceData eqp, PingRequest p) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, model.exception.JsonUtilException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        //String jsonPppoe = JsonUtil.serialize(p, p.getClass());
        String jsonPppoe = GsonUtil.serialize(p);
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, jsonPppoe);
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), json, 9530, opt, 150000, "");

        return JsonUtil.pingResponse(a);
    }

    @Override
    public Boolean setPPPoECredentials(NbiDeviceData eqp, PPPoECredentialsInfoOut pPPoECredentialsInfo) throws DeviceOperationException, OperationTimeoutException, NBIException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        //String jsonPppoe = JsonUtil.serialize(pPPoECredentialsInfo, pPPoECredentialsInfo.getClass());
        String jsonPppoe = GsonUtil.serialize(pPPoECredentialsInfo);
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, jsonPppoe);
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), json, 9522, opt, 30000, "");
        System.out.println(a.getValue());
        return a.getValue().contains("SUCCESS");
    }

    @Override
    public Boolean setPortMapping(NbiDeviceData eqp, List<PortMappingInfo> ports) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        List<Object> json = NbiDecorator.getEmptyJson();

        Gson gson = new Gson();
        String jsonPm = gson.toJson(ports);
        json.set(0, jsonPm.toString().toString().replace("\"", "'"));
        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), json, 9512, opt, 20000, "");

        return a.getValue().contains("SUCCESS");
        //System.out.println(a.getValue());
    }

    /**
     * Não segue o padrão para CPEs que não suportam o parâmetro
     *
     * @param eqp
     * @param phyref
     * @return
     * @throws DeviceOperationException
     * @throws NBIException
     * @throws OperationTimeoutException
     * @throws JsonUtilException
     * @throws HdmException
     * @throws ProviderException
     * @throws UnsupportedException
     */
    @Override
    public SipDiagnostics getSipDiagnostics(NbiDeviceData eqp, Integer phyref) throws DeviceOperationException, NBIException, OperationTimeoutException, JsonUtilException, HdmException, ProviderException, UnsupportedException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        String leJson = "{\"phyreferencelist\":\"" + phyref.toString() + "\"}";
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, leJson);

        try {
            StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), json, 9520, opt, 30000, "");
            //System.out.println(a.getValue());        
            if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
                throw new UnsupportedException();
            }
            return (SipDiagnostics) GsonUtil.convertValues(a, SipDiagnostics.class);
        } catch (DeviceOperationException e) {
            throw new UnsupportedException();
        }
    }

    @Override
    public Boolean setSipActivation(NbiDeviceData eqp, SipActivation sip) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        NbiSingleDeviceOperationOptions opt = NbiDecorator.getDeviceOperationOptionsDefault();
        String leJson = GsonUtil.serialize(sip);
        List<Object> json = NbiDecorator.getEmptyJson();
        json.set(0, leJson);

        StringResponseDTO a = (StringResponseDTO) synch().executeFunction(NbiDecorator.adapter(eqp), json, 9500, opt, 30000, "");

        if (a.getValue().contains("SUCCESS") || a.getValue().contains("\"statusCode\":\"0\"")) {
            return true;
        }
        System.out.println(a.getValue());
        return false;
    }

}
