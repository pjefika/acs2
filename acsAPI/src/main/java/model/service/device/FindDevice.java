/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.acs.model.search;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;

/**
 *
 * @author G0042204
 */
public interface FindDevice {

    public List<NbiDeviceData> find(SearchIn in) throws Exception;

}
