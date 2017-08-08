/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.motive.www.remotehdm.NBIService._1_0.NBIServicePortStub;
import dao.factory.FactoryNBI;
import static dao.util.NbiDecorator.adapterCaps;
import dto.nbi.service.hdm.alcatel.com.NBIDeviceID;
import dto.nbi.service.hdm.alcatel.com.NBIFirmwareImageData;
import dto.nbi.service.hdm.alcatel.com.NBITemplate;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.device.firmware.FirmwareInfo;

public class RemoteDAOImpl implements RemoteDAO {

    private NBIServicePortStub remote;

    public RemoteDAOImpl() {
    }

    protected NBIServicePortStub remote() {
        if (remote == null) {
            remote = FactoryNBI.createRemote();
        }
        return remote;
    }

    @Override
    public Long firmwareUpdate(NbiDeviceData eqp, FirmwareInfo info) throws NBIException_Exception, RemoteException {
        return remote().createSingleFirmwareUpdateOperation(new NBIDeviceID(eqp.getDeviceId().getOUI(),
                eqp.getDeviceId().getProductClass(),
                eqp.getDeviceId().getProtocol(), eqp.getDeviceId().getSerialNumber()),
                info.getPreferredVersion(), 15000);
    }

    @Override
    public List<NBIFirmwareImageData> getAvailableFirmwareImages(NbiDeviceData eqp) throws RemoteException {
        List<NBIFirmwareImageData> l = new ArrayList<>();
        l.addAll(Arrays.asList(remote().getAvailableFirmwareImages(adapterCaps(eqp))));
        return l;
    }
    
    public NBITemplate[] getAvailableCriteriaTemplates() throws RemoteException{
        return remote().getAvailableCriteriaTemplates();
    }

}
