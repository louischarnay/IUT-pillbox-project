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
public class Personne {
    protected String nom;
    protected String prenom;
    protected String age;
    protected String adresse;
    
    public Personne(String n,String p,String ag,String ad){
        nom=n;
        prenom=p;
        age=ag;
        adresse=ad;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        
        return nom+" "+prenom+" age : "+age+" adresse : "+adresse;
    }
    
}
