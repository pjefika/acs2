/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.detail;

import br.net.gvt.efika.acs.model.dto.DetailOut;

/**
 *
 * @author G0042204
 */
public interface DeviceDetailService {

    public DetailOut consultar(Long guid) throws Exception;

}
