/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;

/**
 *
 * @author G0042204
 */
public interface MotiveFromTreeService<T> {

    public T consultar(NbiDeviceData device, T t) throws Exception;

    public T alterar(NbiDeviceData device, T t) throws Exception;

}
