/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import model.device.DeviceDetail;

/**
 *
 * @author G0042204
 */
interface DeviceDetailService {

    public DeviceDetail consultar(Long guid) throws Exception;

}
