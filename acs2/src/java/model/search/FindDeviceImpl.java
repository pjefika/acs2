/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.search;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;
import model.exception.SearchCriteriaException;

/**
 *
 * @author G0042204
 */
public class FindDeviceImpl implements FindDevice {

    private SearchIn in;
    
    @Override
    public List<NbiDeviceData> find(SearchIn in) throws Exception {

        switch (in.getCriterio()) {
            case IP:
                System.out.println("Domingo");
                break;
          
            default:
                throw new SearchCriteriaException();
        }
        return null;
    }

}
