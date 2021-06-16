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
public class Patient extends Personne {

    protected ArrayList<String> maladie;
    protected ArrayList<String> allergie;
    
    

    public Patient(String n, String p, String ag, String ad) {
        super(n, p, ag, ad);
    }

    public ArrayList<String> getAllergie() {
        return allergie;
    }

    public ArrayList<String> getMaladie() {
        return maladie;
    }

    public void addAllergie(String allergie) {
        this.allergie.add(allergie);
    }

    public void addMaladie(String maladie) {
        this.maladie.add(maladie);
    }
    public String getInfo(){
        String newLine=System.getProperty("line.separator");
        String res="";
        res+="Nom : "+nom+newLine+"Prenom : "+prenom+"Allergies : ";
        for (int i = 0; i < allergie.size(); i++) {
            res+="- "+allergie.get(i)+newLine;
        }
        res+="Maladies : ";
        for (int i = 0; i < maladie.size(); i++) {
            res+="- "+maladie.get(i)+newLine;
        }
        return res;
    }
}
