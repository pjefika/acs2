/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.massivaction.setter;

import br.net.gvt.efika.acs.model.entity.AcaoMassivaEntity;
import br.net.gvt.efika.acs.model.entity.Lote;
import br.net.gvt.efika.acs.model.log.AcaoAcsEnum;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.NbiDAO;
import dao.device.SynchDeviceDAO;
import dao.factory.FactoryDAO;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author G0041775
 */
public class RunnableSetter implements Runnable {

    private Lote lote;

    private SynchDeviceDAO synch = FactoryDAO.createSynch();

    private NbiDAO nbi = FactoryDAO.createNBI();

    public RunnableSetter(Lote lote) {
        this.lote = lote;
    }

    @Override
    public void run() {
        for (AcaoAcsEnum acoe : lote.getAcoes()) {
            for (String entrada : lote.getEntrada()) {
                if (entrada.contains("-")) {
                    try {
                        Calendar inicio = Calendar.getInstance();
                        List<NbiDeviceData> eqps = nbi.findDevicesBySubscriberId(entrada);
                        for (NbiDeviceData eqp : eqps) {
                            AcaoMassivaEntity ame = new AcaoMassivaEntity();
                            ame.setDataInicio(inicio);
                            ame.setAcao(acoe);
                            ame.setLote(lote.getId().toString());
                            ame.setParametro(entrada);
                            ame.setEquipamento(eqp);
                            ame.setResultado(null);
                        }
                        
                    } catch (Exception e) {

                    }

                } else {

                }
            }
        }

    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }

}
