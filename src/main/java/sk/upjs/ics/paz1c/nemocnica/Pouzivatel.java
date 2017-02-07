/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.paz1c.nemocnica;

/**
 *
 * @author szoplakz
 */
public class Pouzivatel {
   private int id;
    private String login;
    private String password;
     

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String meno) {
        this.login = meno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String heslo) {
        this.password = heslo;
    }

  
    
}
