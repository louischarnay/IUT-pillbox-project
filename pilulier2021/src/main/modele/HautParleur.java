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
public class HautParleur {
    protected int intensite;
    
    public HautParleur(int i){
        intensite= i;
        
    }
    private void setIntensite(int i){
        intensite= i;
    }
    private int getIntensite(){
        return intensite;
    }
    
    //public void bip(){
        
    //}
}
