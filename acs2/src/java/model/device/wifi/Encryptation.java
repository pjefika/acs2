/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.wifi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author G0042204
 */
public enum Encryptation {

    WEP("WEP", "None", "None"), WPA("WPA", "PSKAuthentication", "TKIPEncryption"), WPA2("WPA2", "EAPandPSKAuthentication", "TKIPandAESEncryption");

    private String nome, authentication, encryptation;

    private Encryptation(String nome, String authentication, String encryptation) {
        this.nome = nome;
        this.authentication = authentication;
        this.encryptation = encryptation;
    }

    public List<Encryptation> toList() {
        List<Encryptation> l = new ArrayList<>();
        l.addAll(Arrays.asList(this.values()));
        return l;
    }

    public String getNome() {
        return nome;
    }

    public String getAuthentication() {
        return authentication;
    }

    public String getEncryptation() {
        return encryptation;
    }

}
