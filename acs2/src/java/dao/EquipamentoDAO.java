/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NBIService;
import com.alcatel.hdm.service.nbi2.NBIService_Service;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.alcatel.hdm.service.nbi2.NbiParameter;
import com.alcatel.hdm.service.nbi2.NbiTemplate;
import com.sun.xml.wss.XWSSConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author G0042204
 */
public class EquipamentoDAO {

    private NBIService port;

    public EquipamentoDAO() {
        try {
            URL url;
            url = new URL("http://200.168.104.216:7035/NBIServiceImpl/NBIService?wsdl");
            QName qname = new QName("http://nbi2.service.hdm.alcatel.com/",
                    "NBIService");
            Service service = Service.create(url, qname);
            port = service.getPort(NBIService.class);
            ((javax.xml.ws.BindingProvider) port).getRequestContext().put(XWSSConstants.USERNAME_PROPERTY, "synchops");
            ((javax.xml.ws.BindingProvider) port).getRequestContext().put(XWSSConstants.PASSWORD_PROPERTY, "nbibr4s1l");
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
        return port.findDeviceByGUID(guid);
    }

    public List<NbiDeviceData> listarEquipamentosPorMac(String mac) throws NBIException_Exception {
        NbiTemplate n = new NbiTemplate();
        n.setName("Find Devices By MacAddress");

        NbiParameter param = new NbiParameter();

        param.setName("macAddress");
        param.setValue(mac);

        n.getParameters().add(param);

        return port.findDevicesByTemplate(n, 1, -1);
    }

    public List<NbiDeviceData> listarEquipamentosPorSerial(String serial) throws NBIException_Exception {

        NbiTemplate n = new NbiTemplate();
        n.setName("ct.find.devices.serialNumber");

        NbiParameter param = new NbiParameter();

        param.setName("serialNumber");
        param.setValue(serial);

        n.getParameters().add(param);

        return port.findDevicesByTemplate(n, 1, -1);
    }

    public List<NbiDeviceData> listarEquipamentosPorSubscriber(String subscriber) throws NBIException_Exception {
        return port.findDevicesBySubscriberId(subscriber);
    }

    public List<NbiTemplate> templates() throws NBIException_Exception {
        return port.getAvailableCriteriaTemplates();
    }

}
