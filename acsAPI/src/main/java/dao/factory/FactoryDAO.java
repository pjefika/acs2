/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.db.InterfaceDAO;
import dao.db.LogDAOImpl;
import dao.device.NbiDAO;
import dao.device.NbiDAO_Impl;
import dao.device.RemoteDAO;
import dao.device.RemoteDAOImpl;
import dao.device.SynchDeviceDAO;
import dao.device.SynchDeviceDAOImpl;
import br.net.gvt.efika.acs.model.entity.LogEntity;
import br.net.gvt.efika.acs.model.entity.Lote;
import dao.db.AcaoMassivaDAOImpl;
import dao.db.LoteDAOImpl;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static NbiDAO createNBI() {
        return new NbiDAO_Impl();
    }

    public static RemoteDAO createRemote() {
        return new RemoteDAOImpl();
    }

    public static SynchDeviceDAO createSynch() {
        return new SynchDeviceDAOImpl();
    }

    public static InterfaceDAO<LogEntity> createLogDAO() {
        return new LogDAOImpl();
    }

    public static InterfaceDAO<Lote> createLoteDAO() {
        return new LoteDAOImpl();
    }
    
    public static AcaoMassivaDAOImpl createAcaoMassivaDAO(){
        return new AcaoMassivaDAOImpl();
    }

}
