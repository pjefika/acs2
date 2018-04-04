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
public class PPPoECredentialsInfo {

    private String Username, Password;

    public PPPoECredentialsInfo() {
    }

    public PPPoECredentialsInfo(String username, String password) {
        this.Username = username;
        this.Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

}
