/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import br.net.gvt.efika.util.json.exception.JsonParseException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;

import java.util.List;
import model.device.DmzInfo;
import model.device.ddns.DdnsInfo;
import model.device.dhcp.Dhcp;
import model.device.firmware.FirmwareInfo;
import model.device.info.DeviceInfo;
import model.device.interfacestatistics.InterfaceStatistics;
import model.device.lanhost.LanDevice;
import model.device.log.DeviceLog;
import model.device.log.DeviceLogR;
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
import model.device.xdsldiagnostics.XdslDiagnostics;
import model.exception.HdmException;
import model.exception.JsonUtilException;
import model.exception.UnsupportedException;
import motive.hdm.synchdeviceops.GetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.ParameterInfoStructDTO;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0042204
 */
public interface SynchDeviceDAO {

    public Boolean reboot(NbiDeviceData eqp) throws DeviceOperationException, NBIException, ProviderException;

    public Boolean factoryReset(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public Boolean checkOnline(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public FirmwareInfo getFirmwareVersion(NbiDeviceData eqp) throws Exception;

    public List<ParameterInfoStructDTO> getParameters(NbiDeviceData eqp) throws Exception;

    public GetParameterValuesResponseDTO getParametersValues(NbiDeviceData eqp, List<String> paths) throws Exception;

    public GetParameterValuesResponseDTO getParameterValue(NbiDeviceData eqp, String path) throws Exception;

    public DeviceInfo getDeviceInfo(NbiDeviceData eqp) throws Exception;

    public void setParametersValues(NbiDeviceData eqp, List<ParameterValueStructDTO> p) throws Exception;

    public WanInfo getWanInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonParseException, Exception;

    public ServiceClass getServiceClass(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException, JsonParseException, Exception;

    public Boolean setServiceClass(NbiDeviceData eqp, ServiceClass sc) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception;

    public List<LanDevice> getLanHosts(NbiDeviceData eqp) throws Exception;

    public DmzInfo getDmzInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException, JsonParseException, Exception;

    public List<WifiInfoFull> getWifiInfoFull(NbiDeviceData eqp) throws Exception;

    public List<PortMappingInfo> getPortMapping(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonParseException, Exception;

    public Dhcp getDhcp(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonParseException, Exception;

    public Boolean setDhcp(NbiDeviceData eqp, Dhcp dh) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonParseException, Exception;

    public PortMappingInfo traceroute(NbiDeviceData eqp, TraceRouteRequest trace) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception;

    public Boolean setWifiInfoFull(NbiDeviceData eqp, WifiInfoFull wifi) throws DeviceOperationException, NBIException, Exception;

    public DdnsInfo getDdns(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, UnsupportedException, Exception;

    public XdslDiagnostics getXdslDiagnostic(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, UnsupportedException, Exception;

    public List<DeviceLog> getDeviceLog(NbiDeviceData eqp) throws JsonUtilException, DeviceOperationException, NBIException, ProviderException, OperationTimeoutException, Exception;

//    public List<DeviceLogR> getDeviceLogR(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception;

    public List<InterfaceStatistics> getInterfaceStatistics(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, Exception;

    public PPPoECredentialsInfo getPPPoECredentials(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, Exception;

    public PingResponse pingDiagnostic(NbiDeviceData eqp, PingRequest p) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, model.exception.JsonUtilException, Exception;

    public Boolean setPPPoECredentials(NbiDeviceData eqp, PPPoECredentialsInfo pPPoECredentialsInfo) throws DeviceOperationException, OperationTimeoutException, NBIException, ProviderException, Exception;

    public Boolean setPortMapping(NbiDeviceData eqp, List<PortMappingInfo> ports) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception;

    public SipDiagnostics getSipDiagnostics(NbiDeviceData eqp, Integer phyref) throws DeviceOperationException, NBIException, OperationTimeoutException, JsonUtilException, HdmException, ProviderException, UnsupportedException, Exception;

    public Boolean setSipActivation(NbiDeviceData eqp, SipActivation sip) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, Exception;

    public Boolean setSipDeactivation(NbiDeviceData eqp, Integer phyref) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public Boolean sipRestart(NbiDeviceData eqp, Integer phyref) throws UnsupportedException, NBIException, OperationTimeoutException, ProviderException, Exception;

}
