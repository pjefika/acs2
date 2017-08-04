/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.motive.www.remotehdm.NBIService._1_0.NBIServiceLocator;
import com.motive.www.remotehdm.NBIService._1_0.NBIServicePortStub;
import static dao.util.NbiDecorator.adapter;
import static dao.util.NbiDecorator.adapterCaps;
import dao.util.SoapUtil;
import dto.nbi.service.hdm.alcatel.com.NBIDeviceID;
import dto.nbi.service.hdm.alcatel.com.NBIFirmwareImageData;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.device.firmware.FirmwareInfo;

public class RemoteDAOImpl implements RemoteDAO {

    private NBIServicePortStub remote;

    public RemoteDAOImpl() {
        try {
            NBIServicePortStub stub = new NBIServicePortStub(new URL("http://10.113.64.1:7025/NBIServiceImpl/NBIService?wsdl"), new NBIServiceLocator());
            remote = (NBIServicePortStub) SoapUtil.addWsSecurityHeader(stub, "co_efika", "nbibrasilefika02");
        } catch (Exception ex) {
            Logger.getLogger(RemoteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Long firmwareUpdate(NbiDeviceData eqp, FirmwareInfo info) throws NBIException_Exception, RemoteException {
        return remote.createSingleFirmwareUpdateOperation(new NBIDeviceID(eqp.getDeviceId().getOUI(),
                eqp.getDeviceId().getProductClass(),
                eqp.getDeviceId().getProtocol(), eqp.getDeviceId().getSerialNumber()),
                info.getPreferredVersion(), 15000);
    }

    @Override
    public List<NBIFirmwareImageData> getAvailableFirmwareImages(NbiDeviceData eqp) throws RemoteException {
        List<NBIFirmwareImageData> l = new ArrayList<>();
        l.addAll(Arrays.asList(remote.getAvailableFirmwareImages(adapterCaps(eqp))));
        return l;
    }

}
