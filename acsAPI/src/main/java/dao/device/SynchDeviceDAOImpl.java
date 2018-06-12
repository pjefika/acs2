/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import br.net.gvt.efika.acs.model.device.DmzInfo;
import br.net.gvt.efika.acs.model.device.ddns.DdnsInfo;
import br.net.gvt.efika.acs.model.device.dhcp.Dhcp;
import br.net.gvt.efika.acs.model.device.dhcp.DhcpSet;
import br.net.gvt.efika.acs.model.device.dns.Dns;
import br.net.gvt.efika.acs.model.device.firmware.FirmwareInfo;
import br.net.gvt.efika.acs.model.device.gatewayparameters.GatewayParameters;
import br.net.gvt.efika.acs.model.device.info.DeviceInfo;
import br.net.gvt.efika.acs.model.device.interfacestatistics.InterfaceStatistics;
import br.net.gvt.efika.acs.model.device.lanhost.LanDevice;
import br.net.gvt.efika.acs.model.device.log.DeviceLog;
import br.net.gvt.efika.acs.model.device.ping.PingRequest;
import br.net.gvt.efika.acs.model.device.ping.PingResponse;
import br.net.gvt.efika.acs.model.device.portmapping.PortMappingInfo;
import br.net.gvt.efika.acs.model.device.pppoe.PPPoECredentialsInfo;
import br.net.gvt.efika.acs.model.device.serviceclass.ServiceClass;
import br.net.gvt.efika.acs.model.device.sipactivation.SipActivation;
import br.net.gvt.efika.acs.model.device.sipdiagnostics.SipDiagnostics;
import br.net.gvt.efika.acs.model.device.traceroute.TraceRouteRequest;
import br.net.gvt.efika.acs.model.device.wan.WanInfo;
import br.net.gvt.efika.acs.model.device.wifi.WifiInfoFull;
import br.net.gvt.efika.acs.model.device.wifi.WifiInfoSet;
import br.net.gvt.efika.acs.model.device.xdsldiagnostics.XdslDiagnostics;
import br.net.gvt.efika.util.json.JacksonMapper;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import br.net.gvt.efika.util.json.exception.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.SynchDeviceOperationsService;
import dao.factory.FactoryNBI;
import java.util.ArrayList;
import java.util.List;
import br.net.gvt.efika.acs.model.exception.HdmException;
import br.net.gvt.efika.acs.model.exception.JsonUtilException;
import br.net.gvt.efika.acs.model.exception.SemRespostaException;
import br.net.gvt.efika.acs.model.exception.UnsupportedException;
import br.net.gvt.efika.acs.model.exception.WifiInativoException;
import motive.hdm.synchdeviceops.GetParameterAttributesDTO;
import motive.hdm.synchdeviceops.GetParameterAttributesResponseDTO;
import motive.hdm.synchdeviceops.GetParameterNamesDTO;
import motive.hdm.synchdeviceops.GetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.NbiInitiateConnectionResult;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationOptions;
import motive.hdm.synchdeviceops.ParameterInfoStructDTO;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;
import motive.hdm.synchdeviceops.SetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.StringResponseDTO;

public class SynchDeviceDAOImpl implements SynchDeviceDAO {

    private static final Integer TIMEOUT = 150000;

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
            synch().reboot(DeviceOperationFactory.adapter(eqp), DeviceOperationFactory.getDeviceOperationOptionsDefault(), TIMEOUT, "");
            return true;
        } catch (OperationTimeoutException ex) {
            return true;
        }
    }

    @Override
    public Boolean factoryReset(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        synch().factoryReset(DeviceOperationFactory.adapter(eqp), DeviceOperationFactory.getDeviceOperationOptionsDefault(), TIMEOUT, "");
        return true;
    }

    @Override
    public Boolean checkOnline(NbiDeviceData eqp) throws NBIException, ProviderException {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        try {
            synch().checkOnline(DeviceOperationFactory.adapter(eqp), opt, TIMEOUT, "");
            return true;
        } catch (DeviceOperationException | OperationTimeoutException e) {
            return false;
        }
    }

    @Override
    public FirmwareInfo getFirmwareVersion(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9526, opt, TIMEOUT, "");
        System.out.println(new JacksonMapper(StringResponseDTO.class).serialize(a));
        return (FirmwareInfo) new JacksonMapper(FirmwareInfo.class).deserialize(a.getValue());
    }

    @Override
    public List<ParameterInfoStructDTO> getParameters(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        GetParameterNamesDTO g = new GetParameterNamesDTO();
        g.setNextLevel(true);
        try {
            g.setParameterPath("");
            return synch().getParameterNames(DeviceOperationFactory.adapter(eqp), g, opt, TIMEOUT, "").getParameterList();
        } catch (Exception e) {
            g.setParameterPath("InternetGatewayDevice.");
            return synch().getParameterNames(DeviceOperationFactory.adapter(eqp), g, opt, TIMEOUT, "").getParameterList();
        }

    }

    @Override
    public GetParameterValuesResponseDTO getParametersValues(NbiDeviceData eqp, List<String> paths) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();

        motive.hdm.synchdeviceops.GetParameterValuesDTO g = new motive.hdm.synchdeviceops.GetParameterValuesDTO();

        paths.forEach((t) -> {
            g.getParameterNames().add(t);
        });
        try {
            return synch().getParameterValues(DeviceOperationFactory.adapter(eqp), g, opt, TIMEOUT, "");
        } catch (Exception e) {
            try {
                if (forceOnline(eqp)) {
                    try {
                        return synch().getParameterValues(DeviceOperationFactory.adapter(eqp), g, opt, TIMEOUT, "");
                    } catch (Exception ex) {
                        throw new UnsupportedException();
                    }
                } else {
                    throw new SemRespostaException();
                }
            } catch (Exception exc) {
                throw exc;
            }
        }

    }

    @Override
    public DeviceInfo getDeviceInfo(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9527, opt, TIMEOUT, "");
        System.out.println("VALUE=>" + a.getValue());
        return (DeviceInfo) new JacksonMapper(DeviceInfo.class).deserialize(a.getValue());
    }

    @Override
    public GetParameterValuesResponseDTO getParameterValue(NbiDeviceData eqp, String path) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();

        motive.hdm.synchdeviceops.GetParameterValuesDTO g = new motive.hdm.synchdeviceops.GetParameterValuesDTO();
        g.getParameterNames().add(0, path);
        return synch().getParameterValues(DeviceOperationFactory.adapter(eqp), g, opt, TIMEOUT, "");
    }

    public GetParameterAttributesResponseDTO getParameterAttributes(NbiDeviceData eqp, String path) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        GetParameterAttributesDTO g = new GetParameterAttributesDTO();
        g.getParameterNames().add(0, path);
        return synch().getParameterAttributes(DeviceOperationFactory.adapter(eqp), g, opt, TIMEOUT, "");
    }

    @Override
    public void setParametersValues(NbiDeviceData eqp, List<ParameterValueStructDTO> p) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        motive.hdm.synchdeviceops.SetParameterValuesDTO g = new motive.hdm.synchdeviceops.SetParameterValuesDTO();

        p.forEach((t) -> {
            g.getParameterValueStructs().add(t);
        });

        SetParameterValuesResponseDTO s = synch().setParameterValues(DeviceOperationFactory.adapter(eqp), g, opt, TIMEOUT, "");
        System.out.println("Retorno: " + s.getStatus());
    }

    @Override
    public WanInfo getWanInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonParseException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9515, opt, TIMEOUT, "");
        System.out.println("RESULT->" + a.getValue());
        return (WanInfo) new JacksonMapper(WanInfo.class).deserialize(a.getValue());

    }

    @Override
    public ServiceClass getServiceClass(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException, JsonParseException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9505, opt, TIMEOUT, "");
        System.out.println("Value: " + a.getValue());
        if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }
        return (ServiceClass) new JacksonMapper(ServiceClass.class).deserialize(a.getValue());
    }

    @Override
    public Boolean setServiceClass(NbiDeviceData eqp, ServiceClass sc) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        String jsonSc;
        try {
            jsonSc = new JacksonMapper(String.class).serialize(sc);
        } catch (Exception ex) {
            jsonSc = "";
        }
        List<Object> json = DeviceOperationFactory.getEmptyJson();
        json.set(0, jsonSc);
        StringResponseDTO a = this.exec(eqp, json, 9504, opt, TIMEOUT, "");
        //System.out.println(a.getValue());

        return a.getValue().contains("SUCCESS");
    }

    @Override
    public List<LanDevice> getLanHosts(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9517, opt, TIMEOUT, "");
        tratativa(a);
        String json = a.getValue().replace("{", "[{").replace("}", "}]").replaceAll("\"HostNumberOfEntries\":\"[0-9]{1,10}\",", "").replaceAll("Host.[0-9]{1,10}.", "").replace("\",\"IPAddress\"", "\"},{\"IPAddress\"");
        System.out.println(json);
        return (List<LanDevice>) new JacksonMapper(List.class).deserialize(json);
    }

    protected void tratativa(StringResponseDTO response) throws UnsupportedException {
        if (response.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }
    }

    @Override
    public DmzInfo getDmzInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException, JsonParseException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9503, opt, TIMEOUT, "");
        if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }
        return (DmzInfo) new JacksonMapper(DmzInfo.class).deserialize(a.getValue());
    }

    @Override
    public List<WifiInfoFull> getWifiInfoFull(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9529, opt, TIMEOUT, "");

        String wifiDisable = "Nenhuma interface WiFi se encontra habilitada.";
        if (a.getValue().contains(wifiDisable)) {
            
            throw new WifiInativoException();
        }
        System.out.println("Retorno: " + a.getValue());
        List<WifiInfoFull> wifi = (List<WifiInfoFull>) new JacksonMapper(new TypeReference<List<WifiInfoFull>>() {
        }).fromJSON(a.getValue());

        return wifi;
    }

    @Override
    public List<PortMappingInfo> getPortMapping(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonParseException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9513, opt, TIMEOUT, "");
        System.out.println("Value: " + a.getValue());
        List<PortMappingInfo> pmi;
        pmi = (List<PortMappingInfo>) new JacksonMapper(new TypeReference<List<PortMappingInfo>>() {
        }).fromJSON(a.getValue());

        return pmi;
    }

    @Override
    public Dhcp getDhcp(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonParseException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9509, opt, TIMEOUT, "");
        return (Dhcp) new JacksonMapper(Dhcp.class).deserialize(a.getValue());
    }

    @Override
    public Boolean setDhcp(NbiDeviceData eqp, Dhcp dh) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        String jsonD = new JacksonMapper(DhcpSet.class).serialize(new DhcpSet(dh));
        List<Object> json = DeviceOperationFactory.getEmptyJson();
        json.set(0, jsonD);
        StringResponseDTO a = this.exec(eqp, json, 9508, opt, TIMEOUT, "");
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
    public PortMappingInfo traceroute(NbiDeviceData eqp, TraceRouteRequest trace) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        String traceStr;
        traceStr = new JacksonMapper(TraceRouteRequest.class).serialize(trace);
        List<Object> json = DeviceOperationFactory.getEmptyJson();
        json.set(0, traceStr);

        StringResponseDTO a = this.exec(eqp, json, 9524, opt, TIMEOUT, "");
        System.out.println(a.getValue());

        return (PortMappingInfo) new JacksonMapper(PortMappingInfo.class).deserialize(a.getValue());

    }

    @Override
    public Boolean setWifiInfoFull(NbiDeviceData eqp1, WifiInfoFull wifi) throws DeviceOperationException, NBIException, Exception {
//        try {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        WifiInfoSet adapter = DeviceOperationFactory.getWifiInfoSetFull(wifi);
        String jsonWifi;
        jsonWifi = new JacksonMapper(WifiInfoSet.class).serialize(adapter);

        List<Object> json = DeviceOperationFactory.getEmptyJson();
        json.set(0, jsonWifi);

        System.out.println("json: " + json.toString());

        StringResponseDTO a = this.exec(eqp1, json, 9510, opt, TIMEOUT, "");
        System.out.println(a.getValue());

        return a.getValue().contains("SUCCESS");

//        } catch (OperationTimeoutException | ProviderException e) {
//            e.printStackTrace();
//            throw e;
//        }
    }

    @Override
    public DdnsInfo getDdns(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, UnsupportedException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9507, opt, TIMEOUT, "");
        if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }
        return (DdnsInfo) new JacksonMapper(DdnsInfo.class).deserialize(a.getValue());
    }

    @Override
    public XdslDiagnostics getXdslDiagnostic(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, UnsupportedException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9514, opt, TIMEOUT, "");
        if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
            throw new UnsupportedException();
        }
        return (XdslDiagnostics) new JacksonMapper(XdslDiagnostics.class).deserialize(a.getValue());
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
    public List<DeviceLog> getDeviceLog(NbiDeviceData eqp) throws NBIException, OperationTimeoutException, ProviderException, DeviceOperationException, JsonUtilException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9519, opt, TIMEOUT, "");
//        System.out.println(a.getValue());
        DeviceLog logzao = (DeviceLog) new JacksonMapper(DeviceLog.class).deserialize(a.getValue());
        String[] logs = logzao.getMensagem().replace("\\t", "    ").split("\\n");
        List<DeviceLog> l = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            l.add(new DeviceLog(logs[i]));
        }

        return l;
    }

//    @Override
//    public List<DeviceLogR> getDeviceLogR(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception {
//        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
//        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9519, opt, TIMEOUT, "");
//        System.out.println(a.getValue());
//        DeviceLog d = (DeviceLog) new JacksonMapper(DeviceLog.class).deserialize(a.getValue());
//        String[] logs = d.getMensagem().replace("\"", "").split("\\n");
//        List<DeviceLogR> l = new ArrayList<>();
//        for (String log : logs) {
//            if (!log.isEmpty()) {
//                String[] lineSplit = log.split("\\t");
//                l.add(new DeviceLogR(lineSplit[0], lineSplit[1], lineSplit[2], lineSplit[3], lineSplit[4]));
//            }
//        }
//        return l;
//    }
    @Override
    public List<InterfaceStatistics> getInterfaceStatistics(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9531, opt, TIMEOUT, "");
        System.out.println(a.getValue());
        List<InterfaceStatistics> iS = (List<InterfaceStatistics>) new JacksonMapper(new TypeReference<List<InterfaceStatistics>>() {
        }).fromJSON(a.getValue());
        return iS;
    }

    @Override
    public PPPoECredentialsInfo getPPPoECredentials(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9523, opt, TIMEOUT, "");
        System.out.println("val->" + a.getValue());
        return (PPPoECredentialsInfo) new JacksonMapper(PPPoECredentialsInfo.class).deserialize(a.getValue());
    }

    @Override
    public PingResponse pingDiagnostic(NbiDeviceData eqp, PingRequest p) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, br.net.gvt.efika.acs.model.exception.JsonUtilException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        //String jsonPppoe = JsonUtil.serialize(p, p.getClass());
        String jsonPppoe = new JacksonMapper(PingRequest.class).serialize(p);
        List<Object> json = DeviceOperationFactory.getEmptyJson();
        json.set(0, jsonPppoe);
        StringResponseDTO a = this.exec(eqp, json, 9530, opt, TIMEOUT, "");
        return (PingResponse) new JacksonMapper(PingResponse.class).deserialize(a.getValue());
    }

    @Override
    public Boolean setPPPoECredentials(NbiDeviceData eqp, PPPoECredentialsInfo pPPoECredentialsInfo) throws DeviceOperationException, OperationTimeoutException, NBIException, ProviderException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        String jsonPppoe = new JacksonMapper(PPPoECredentialsInfo.class).serialize(pPPoECredentialsInfo);
        List<Object> json = DeviceOperationFactory.getEmptyJson();
        try {
            json.set(0, jsonPppoe);
            StringResponseDTO a = this.exec(eqp, json, 9522, opt, TIMEOUT, "");
            System.out.println("val->" + a.getValue());
            return a.getValue().contains("SUCCESS");
        } catch (Exception e) {
            json.set(0, jsonPppoe.toLowerCase());
            StringResponseDTO a = this.exec(eqp, json, 9522, opt, TIMEOUT, "");
            System.out.println("val1->" + a.getValue());
            return a.getValue().contains("SUCCESS");
        }

    }

    @Override
    public Boolean setPortMapping(NbiDeviceData eqp, List<PortMappingInfo> ports) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        List<Object> json = DeviceOperationFactory.getEmptyJson();

        String jsonPm = new JacksonMapper(new TypeReference<List<PortMappingInfo>>() {
        }).serialize(ports);
        json.set(0, jsonPm);
        StringResponseDTO a = this.exec(eqp, json, 9512, opt, TIMEOUT, "");

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
    public SipDiagnostics getSipDiagnostics(NbiDeviceData eqp, Integer phyref) throws DeviceOperationException, NBIException, OperationTimeoutException, JsonUtilException, HdmException, ProviderException, UnsupportedException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        String leJson = "{\"phyreferencelist\":\"" + phyref.toString() + "\"}";
        List<Object> json = DeviceOperationFactory.getEmptyJson();
        json.set(0, leJson);

        try {
            StringResponseDTO a = this.exec(eqp, json, 9520, opt, TIMEOUT, "");
            System.out.println(a.getValue());
            if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
                throw new UnsupportedException();
            }
            return (SipDiagnostics) new JacksonMapper(SipDiagnostics.class).deserialize(a.getValue());
        } catch (DeviceOperationException e) {
            throw e;
        }
    }

    @Override
    public Boolean setSipActivation(NbiDeviceData eqp, SipActivation sip) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        String leJson = new JacksonMapper(SipActivation.class).serialize(sip);
        System.out.println(leJson);
        List<Object> json = DeviceOperationFactory.getEmptyJson();
        json.set(0, leJson);

        StringResponseDTO a = this.exec(eqp, json, 9500, opt, TIMEOUT, "");

        if (a.getValue().contains("SUCCESS") || a.getValue().contains("\"statusCode\":\"0\"")) {
            return true;
        }
        System.out.println(a.getValue());
        return false;
    }

    @Override
    public Boolean setSipDeactivation(NbiDeviceData eqp, Integer phyref) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean sipRestart(NbiDeviceData eqp, Integer phyref) throws UnsupportedException, NBIException, OperationTimeoutException, ProviderException, Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        String leJson = "{\"phyreferencelist\":\"" + phyref.toString() + "\"}";
        List<Object> json = DeviceOperationFactory.getEmptyJson();
        json.set(0, leJson);
        try {
            StringResponseDTO a = this.exec(eqp, json, 9521, opt, TIMEOUT, "");
            if (a.getValue().contains("SUCCESS") || a.getValue().contains("\"statusCode\":\"0\"")) {
                return true;
            }
        } catch (DeviceOperationException e) {
            e.printStackTrace();
            throw e;
        }

        return false;
    }

    public StringResponseDTO exec(NbiDeviceData eqp, List<Object> json, int i,
            NbiSingleDeviceOperationOptions opt, long l, String str) throws Exception {
        StringResponseDTO a;
        try {
            a = (StringResponseDTO) synch().executeFunction(DeviceOperationFactory.adapter(eqp), json, i, opt, l, str);
        } catch (Exception e) {
            try {
                if (forceOnline(eqp)) {
                    a = (StringResponseDTO) synch().executeFunction(DeviceOperationFactory.adapter(eqp), json, i, opt, l, str);
                } else {
                    if (forceOnline(eqp)) {
                        a = (StringResponseDTO) synch().executeFunction(DeviceOperationFactory.adapter(eqp), json, i, opt, l, str);
                    } else {
                        throw new SemRespostaException();
                    }
                }
            } catch (Exception ex) {
                throw new SemRespostaException();
            }
        }
        return a;
    }

    @Override
    public Boolean forceOnline(NbiDeviceData eqp) throws Exception {
        Boolean b = false;
        try {
            NbiInitiateConnectionResult r = synch().issueConnectionRequestByDeviceGUID(eqp.getDeviceGUID(), 3000);
            b = r.isSuccess();
        } catch (Exception e) {
        }

        return b;
    }

    @Override
    public Dns getDns(NbiDeviceData eqp) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        StringResponseDTO a = this.exec(eqp, DeviceOperationFactory.getEmptyJson(), 9516, opt, TIMEOUT, "");
        GatewayParameters gp = new JacksonMapper<>(GatewayParameters.class).deserialize(a.getValue());
        System.out.println(a.getValue());
        return new Dns(gp.getDNSServers());
    }

    @Override
    public Boolean setDns(NbiDeviceData eqp, String dnsServers) throws Exception {
        NbiSingleDeviceOperationOptions opt = DeviceOperationFactory.getDeviceOperationOptionsDefault();
        List<Object> json = DeviceOperationFactory.getEmptyJson();
        json.set(0, "{\"dnsservers\":\"" + dnsServers + "\"}");

        StringResponseDTO a = this.exec(eqp, json, 9525, opt, TIMEOUT, "");

        if (a.getValue().contains("SUCCESS") || a.getValue().contains("\"statusCode\":\"0\"")) {
            return true;
        }
        System.out.println(a.getValue());
        return false;
    }

}
