/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.pppoe;

/**
 *
 * @author G0042204
 */
public class PPPoECredentialsInfoOut {

    private String username, password;

    public PPPoECredentialsInfoOut() {
    }

    public PPPoECredentialsInfoOut(PPPoECredentialsInfo i) {
        this.username = i.getUsername();
        this.password = i.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
