/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.search;

import model.service.search.SearchCriteria;
import model.service.search.SearchIn;
import model.service.search.FindDeviceImpl;
import model.service.search.FindDevice;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.SynchDeviceDAO;
import dao.factory.FactoryDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class FindDeviceOnline {

    FindDevice instance = new FindDeviceImpl();

    private SynchDeviceDAO dao = FactoryDAO.createSynch();

    public FindDeviceOnline() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Não utilizar em produção
     *
     * @throws Exception
     */
    @Test
    public void testDeviceOnline() throws Exception {
        try {
            System.out.println("find - SearchCriteria.SUBCRIBER");
            SearchIn in = new SearchIn(SearchCriteria.SUBSCRIBER, "NO_SUBSCRIBER");
            List<NbiDeviceData> result = instance.find(in);

            System.out.println("Quantidade de equipamentos em teste: " + result.size());
            for (NbiDeviceData nbiDeviceData : result) {
                if (dao.checkOnline(nbiDeviceData)) {
                    System.out.println("|------------------------------|");
                    System.out.println("Equipamento Online!");
                    System.out.println(GsonUtil.serialize(nbiDeviceData));
                    System.out.println("|------------------------------|");
                }
            }

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
