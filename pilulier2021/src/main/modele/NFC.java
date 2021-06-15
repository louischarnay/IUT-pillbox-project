/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

import java.util.ArrayList;

/**
 *
 * @author p2007867
 */
public class NFC {
    protected ArrayList<Integer> carte;
    
    public ArrayList<Integer> getCarte(){
        return carte;
    }
    public void setCarte(int carte){
        this.carte.add(carte);
    }
    // public int scan(){
        
    //}
}
