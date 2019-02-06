/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.massivaction.setter;

import br.net.gvt.efika.acs.model.dto.LANIPv6Auto;
import br.net.gvt.efika.acs.model.entity.AcaoMassivaEntity;
import br.net.gvt.efika.acs.model.entity.Lote;
import br.net.gvt.efika.acs.model.log.AcaoAcsEnum;
import br.net.gvt.efika.util.thread.EfikaThread;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.db.AcaoMassivaDAOImpl;
import dao.device.NbiDAO;
import dao.device.SynchDeviceDAO;
import dao.factory.FactoryDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.service.factory.FactoryMotiveService;

/**
 *
 * @author G0041775
 */
public class RunnableSetter implements Runnable {
    
    private Lote lote;
    
    private SynchDeviceDAO synch = FactoryDAO.createSynch();
    
    private NbiDAO nbi = FactoryDAO.createNBI();
    
    private AcaoMassivaDAOImpl ameDAO = FactoryDAO.createAcaoMassivaDAO();
    
    private int startPos = 0;
    
    public RunnableSetter(Lote lote) {
        this.lote = lote;
    }
    
    public RunnableSetter(Lote lote, int startPos) {
        this.lote = lote;
        this.startPos = startPos;
    }
    
    @Override
    public void run() {
        Integer qntsLotzin = Math.round((lote.getEntrada().size() - startPos) / lote.getQuantSimultaneo());
        int leStartPos = startPos;
        for (int ii = 0; ii < qntsLotzin; ii++) {
            List<EfikaThread> threadList = new ArrayList<>();
            int endPos = (lote.getQuantSimultaneo() + leStartPos) > lote.getEntrada().size() ? lote.getEntrada().size() : (lote.getQuantSimultaneo() + leStartPos);
            for (int i = leStartPos; i < endPos; i++) {
                String entrada = lote.getEntrada().get(i);
                EfikaThread et = new EfikaThread(new Runnable() {
                    @Override
                    public void run() {
                        Calendar inicio = Calendar.getInstance();
                        try {
                            List<NbiDeviceData> eqps = null;
                            if (entrada.contains("-")) {
                                eqps = nbi.findDevicesBySubscriberId(entrada);
                            } else {
                                eqps = nbi.findDeviceBySerialNumber(entrada);
                            }
                            
                            for (NbiDeviceData eqp : eqps) {
                                AcaoMassivaEntity ame = new AcaoMassivaEntity();
                                ame.setDataInicio(inicio);
                                ame.setAcao(AcaoAcsEnum.SET_LANIPv6AUTO);
                                ame.setLote(lote.getId().toString());
                                ame.setParametro(entrada);
                                ame.setEquipamento(eqp);
                                LANIPv6Auto r = (LANIPv6Auto) FactoryMotiveService.createTreeChanger(LANIPv6Auto.class).alterar(eqp, new LANIPv6Auto(false));
                                ame.setResultado(r.getEnabled());
                                ame.setDataFim(Calendar.getInstance());
                                ameDAO.cadastrar(ame);
                            }
                        } catch (Exception e) {
                            AcaoMassivaEntity ame = new AcaoMassivaEntity();
                            ame.setDataInicio(inicio);
                            ame.setAcao(AcaoAcsEnum.SET_LANIPv6AUTO);
                            ame.setLote(lote.getId().toString());
                            ame.setParametro(entrada);
                            ame.setResultado(e);
                            ame.setDataFim(Calendar.getInstance());
                            try {
                                ameDAO.cadastrar(ame);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                threadList.add(et);
            }
            for (EfikaThread efikaThread : threadList) {
                try {
                    efikaThread.join(lote.getTimeOut());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            leStartPos = endPos;
        }
        try {
            lote.setDataFim(Calendar.getInstance());
            FactoryDAO.createLoteDAO().cadastrar(lote);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public Lote getLote() {
        return lote;
    }
    
    public void setLote(Lote lote) {
        this.lote = lote;
    }
    
}
