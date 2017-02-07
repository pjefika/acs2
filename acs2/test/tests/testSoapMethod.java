/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import dao.EquipamentoDAO;

/**
 *
 * @author G0042204
 */
public class testSoapMethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EquipamentoDAO d = new EquipamentoDAO();

        d.listarEquipamentosPorMac();

    }

}
