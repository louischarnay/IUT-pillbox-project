/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
}
