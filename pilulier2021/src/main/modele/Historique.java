/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

import java.util.ArrayList;

/**
 *
 * @author p2008965
 */
public class Historique {
    protected ArrayList<ActionHistorique> listeHistorique;

    public Historique() {
        listeHistorique=new ArrayList<>();
    }

    public ArrayList<ActionHistorique> getListeHistorique() {
        return listeHistorique;
    }

    public void setListeHistorique(ArrayList<ActionHistorique> listeHistorique) {
        this.listeHistorique = listeHistorique;
    }
    
    /**
     * ajoute une action à l’historique, return false si problème, true sinon
     * @param action actionHistorique à ajouter
     */
    public void addActionHistorique(ActionHistorique action){
        //a coder
    }
}
