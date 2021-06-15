/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * F@author p2008965
 */
public class Pilulier {
    protected Moteur moteur;
    protected HautParleur buzzer;
    protected Patient patient;
    protected ArrayList<Referent> referents;
    protected ArrayList<Case>calendrier;

    public Pilulier() {
        calendrier=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            calendrier.add(new Case(i));
        }
    }
   
    public Patient getPatient() {
        return patient;
    }
    
    public ArrayList<Case> getCalendrier() {
        return calendrier;
    }

    public ArrayList<Referent> getReferents() {
        return referents;
    }

    public void setBuzzer(HautParleur buzzer) {
        this.buzzer = buzzer;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setReferents(ArrayList<Referent> referents) {
        this.referents = referents;
    }

    public void setCalendrier(ArrayList<Case> calendrier) {
        this.calendrier = calendrier;
    }
    
    public void addReferent(Referent r){
        referents.add(r);
    }
    
    public void addCase(Case c){
        calendrier.add(c);
        
       
    }
    
}
