/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author p2007867
 */
public class Referent extends Personne {
    
    protected String mail;
    protected String tel;
    
    public Referent(String n,String p,String ag,String ad,String m, String t){
        super(n,p,ag,ad);
        mail=m;
        tel=t;
    }

    public String getMail() {
        return mail;
    }

    public String getTel() {
        return tel;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
}