/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.iptv.acao;

import br.net.gvt.efika.acs.model.dto.DirectoryNumber;
import br.net.gvt.efika.acs.model.dto.IptvDiagnostics;
import br.net.gvt.efika.acs.model.exception.TratativaExcessao;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.ArrayList;
import java.util.List;
import model.service.device.GenericDeviceService;
import model.service.device.MotiveFromTreeService;
import motive.hdm.synchdeviceops.GetParameterValuesResponseDTO;

/**
 *
 * @author G0041775
 */
public class IptvDiagnosticsService extends GenericDeviceService implements MotiveFromTreeService<IptvDiagnostics> {

    @Override
    public IptvDiagnostics consultar(NbiDeviceData device, IptvDiagnostics id) throws Exception {
        List<String> paths = new ArrayList<>();
        try {
            paths.add("InternetGatewayDevice.WANDevice.1.WANConnectionDevice.1.WANIPConnection.2.ExternalIPAddress");
            paths.add("InternetGatewayDevice.WANDevice.1.WANConnectionDevice.1.WANIPConnection.3.ExternalIPAddress");
            GetParameterValuesResponseDTO getParam = synch().getParametersValues(device, paths);
            getParam.getParameterList().forEach((t) -> {
                if(t.getName().contains("WANIPConnection.2.ExternalIPAddress")){
                    id.setIpVod(t.getValue());
                }
                if(t.getName().contains("WANIPConnection.3.ExternalIPAddress")){
                    id.setIpMulticast(t.getValue());
                }
            });
            id.setIpVod(getParam.getParameterList().get(0).getValue());
            id.setIpMulticast(getParam.getParameterList().get(1).getValue());
            return id;
        } catch (Exception ex) {
            TratativaExcessao.treatException(ex);
        }
        return null;
        
    }

    @Override
    public IptvDiagnostics alterar(NbiDeviceData device, IptvDiagnostics t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
