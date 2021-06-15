/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

/**
 *
 * @author p2018172
 */
public class Case {
    protected int index;
    protected boolean etatRemplissage;
    protected boolean retardAccepte;
    
    public Case(int index){
        this.index = index;
        this.etatRemplissage = false;
        this.retardAccepte = false;
    }
    
    public int getIndex(){
        return this.index;
    }
    
    public boolean getEtatRemplissage(){
        return this.etatRemplissage;
    }
    
    public boolean getRetardAccepte(){
        return this.retardAccepte;
    }
    
    public void setIndex(int index){
        this.index = index;
    }
    
    public void setEtatRemplissage(boolean etatRemplissage){
        this.etatRemplissage = etatRemplissage;
    }
    
    public void setRetardAccepte(boolean retardAccepte){
        this.retardAccepte = retardAccepte;
    }
}
