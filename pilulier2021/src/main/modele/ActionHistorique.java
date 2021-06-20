/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

import java.util.Date;

/**
 *
 * @author p2008965
 */
public class ActionHistorique {
    protected String texte;
    protected Date date;

    public ActionHistorique(String texte, Date date) {
        this.texte = texte;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getTexte() {
        return texte;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    public String ToString(){
        String res="";
        if(date.getDate()<=9){
            res+="0"+date.getDate();
        }else{
            res+=date.getDate();
        }
        res+="/";
        if((date.getMonth()+1)<=9){
            res+="0"+(date.getMonth()+1);
        }else{
            res+=(date.getMonth()+1);
        }
        res+=" à ";
        if((date.getHours()+1)<=9){
            res+="0"+(date.getHours()+1);
        }else{
            res+=(date.getHours()+1);
        }
        res+="h";
        if(date.getMinutes()<=9){
            res+="0"+date.getMinutes();
        }else{
            res+=date.getMinutes();
        }
        res+=" : "+texte;
        return res;
    }
}
