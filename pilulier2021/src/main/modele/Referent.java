/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

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
    public String getInfo(){
        
        String newLine=System.getProperty("line.separator");
        String res="";
        res+="Nom : "+nom+newLine+"Prenom : "+prenom+newLine+"Mail : "+mail+newLine+"Tel : "+tel+newLine;
        
        return res;
    }
    
    @Override
    public String toString(){
        return this.getPrenom()+" "+this.getNom()+" "+this.getFonction()+" "+this.getAdresse()+" "+mail+" "+tel+" ";
    }
}
