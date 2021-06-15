/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

import main.modele.Case;
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
    public Pilulier(Patient p, ArrayList<Referent> r,ArrayList<Case> c,HautParleur b, Moteur m){
        patient=p;
        referents=r;
        calendrier=c;
        buzzer=b;
        moteur=m;
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
        c.setEtatRemplissage(true);
        calendrier.add(c);
        
    }
    public void isTime(){
        Date heure=new Date();
        for(int i=0;i<calendrier.size();i++){
            if(heure.getDay()==calendrier.get(i).getDate().getDay() && heure.getHours()==calendrier.get(i).getDate().getHours() && heure.getMinutes()==calendrier.get(i).getDate().getMinutes()){
                //faire tourner le moteur d'une case
                calendrier.remove(i);
               
            }
        }
        
    }
    public String getInfo(){
        String res="";
        res+="réferents : \n";
        for(int i = 0;i < referents.size();i++){
            res+=referents.get(i).getNom()+"  "+referents.get(i).getPrenom()+"  "+referents.get(i).getAge()+"ans  "+referents.get(i).getMail()+"  "+referents.get(i).getTel()+"\n";
        }
        res+="Patient : "+ patient.getNom()+"  "+patient.getPrenom()+"\n";
        for(int i = 0; i<patient.maladie.size();i++){
            res+="- "+ patient.maladie.get(i)+"\n";
        }
        for(int i = 0; i<patient.allergie.size();i++){
            res+="- "+ patient.allergie.get(i)+"\n";
        }
        
        return res;
    }
    
}
