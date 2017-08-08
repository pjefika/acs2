/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;

import java.util.List;
import model.device.DmzInfo;
import model.device.ddns.DdnsInfo;
import model.device.dhcp.Dhcp;
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
import model.device.xdsldiagnostics.XdslDiagnostics;
import model.exception.HdmException;
import model.exception.JsonUtilException;
import model.exception.UnsupportedException;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;
import motive.hdm.synchdeviceops.StringResponseDTO;

/**
 *
 * @author G0042204
 */
public interface SynchDeviceDAO {

    public Boolean reboot(NbiDeviceData eqp) throws DeviceOperationException, NBIException, ProviderException;

    public Boolean factoryReset(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public Boolean checkOnline(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public FirmwareInfo getFirmwareVersion(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, ProviderException, model.exception.JsonUtilException;

    public void getParameters(NbiDeviceData eqp) throws Exception;

    public void getParametersWifi(NbiDeviceData eqp) throws Exception;

    public void getParametersValues(NbiDeviceData eqp, List<String> paths) throws Exception;

    public void getParameterValue(NbiDeviceData eqp, String path) throws Exception;

    public void setParametersValues(NbiDeviceData eqp, ParameterValueStructDTO p) throws Exception;

    public WanInfo getWanInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException;

    public ServiceClass getServiceClass(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException;

    public Boolean setServiceClass(NbiDeviceData eqp, ServiceClass sc) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public List<LanDevice> getLanHosts(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, model.exception.JsonUtilException;

    public DmzInfo getDmzInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException;

    public WifiInfoFull getWifiInfoFull(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, JsonUtilException, HdmException, ProviderException;

    public List<PortMappingInfo> getPortMapping(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException;

    public Dhcp getDhcp(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public Boolean setDhcp(NbiDeviceData eqp, Dhcp dh) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public PortMappingInfo traceroute(NbiDeviceData eqp, TraceRouteRequest trace) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public Boolean setWifiInfoFull(NbiDeviceData eqp, WifiInfoFull wifi) throws DeviceOperationException, NBIException;

    public DdnsInfo getDdns(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, UnsupportedException;

    public XdslDiagnostics getXdslDiagnostic(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException, UnsupportedException;

    public List<DeviceLog> getDeviceLog(NbiDeviceData eqp) throws JsonUtilException, DeviceOperationException, NBIException, ProviderException, OperationTimeoutException;

    public List<DeviceLogR> getDeviceLogR(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public List<InterfaceStatistics> getInterfaceStatistics(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException;

    public PPPoECredentialsInfo getPPPoECredentials(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException;

    public PingResponse pingDiagnostic(NbiDeviceData eqp, PingRequest p) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, model.exception.JsonUtilException;

    public StringResponseDTO setPPPoECredentials(NbiDeviceData eqp, PPPoECredentialsInfoOut pPPoECredentialsInfo) throws DeviceOperationException, OperationTimeoutException, NBIException, ProviderException;

    public Boolean setPortMapping(NbiDeviceData eqp, List<PortMappingInfo> ports) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

    public SipDiagnostics getSipDiagnostics(NbiDeviceData eqp, Integer phyref) throws DeviceOperationException, NBIException, OperationTimeoutException, JsonUtilException, HdmException, ProviderException, UnsupportedException;

    public Boolean setSipActivation(NbiDeviceData eqp, SipActivation sip) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException;

}
