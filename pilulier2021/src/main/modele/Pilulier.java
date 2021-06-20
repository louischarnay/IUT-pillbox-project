/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

import com.pi4j.io.gpio.RaspiBcmPin;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    protected Historique historique;
    protected ArrayList<Referent> referents;
    protected ArrayList<Case> calendrier;
    protected FileWriter histoLog;
    protected FileWriter refLog;
    protected ArrayList<String> historiqueLog;

    public Pilulier() {
        calendrier = new ArrayList<>();
        historique = new Historique();
        for (int i = 0; i < 8; i++) {
            calendrier.add(new Case(i + 1, new Date(2020, i, 10 + i, 30 + 2 * i, 0)));
        }
        referents = new ArrayList<>();
    }

    public Pilulier(ArrayList<Referent> r, ArrayList<Case> c, HautParleur b, Moteur m) throws IOException {
        historique = new Historique();
        referents = r;
        calendrier = c;
        buzzer = b;
        moteur = m;
        histoLog = new FileWriter("HistoriqueLogs",true);
        refLog = new FileWriter("ReferentLogs");
        historiqueLog = new ArrayList<>();
    }

    public Patient getPatient() {
        return patient;
    }

    public Case getCase(int index) {
        return calendrier.get(index);
    }

    public ArrayList<Case> getCalendrier() {
        return calendrier;
    }

    public ArrayList<Referent> getReferents() {
        return referents;
    }

    public Moteur getMotor() {
        return moteur;
    }

    public HautParleur getBuzzer() {
        return buzzer;
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

    public void addReferent(Referent r) throws IOException {
        referents.add(r);
        
    }
    public void addReferentLog(int index) throws IOException{
        refLog.write(referents.get(index).getPrenom()+"\n");
        refLog.write(referents.get(index).getNom()+"\n");
        refLog.write(referents.get(index).getAdresse()+"\n");
        refLog.write(referents.get(index).getTel()+"\n");
        refLog.write(referents.get(index).getMail()+"\n");
        refLog.flush();
    } 
    public void chargerInfo(ArrayList<String> info) throws IOException{
        if (info.size()>=5){
        for(int i = 0; i<(info.size()/5);i++ ){
        refLog.write(info.get(0+(i*5))+"\n");
        refLog.write(info.get(1+(i*5))+"\n");
        refLog.write(info.get(2+(i*5))+"\n");
        refLog.write(info.get(3+(i*5))+"\n");
        refLog.write(info.get(4+(i*5))+"\n");
        Referent ref=new Referent(info.get(1+(i*5)),info.get(0+(i*5)),"Patient",info.get(2+(i*5)),info.get(3+(i*5)),info.get(4+(i*5)));
        referents.set(i,ref);
        refLog.flush();
        }
        referents.get(1).setAge("Referent 1");
        referents.get(2).setAge("Referent 2");
        referents.get(3).setAge("Referent 3");
        }
        
    }
    public void loadHistorique() throws FileNotFoundException, IOException{
        BufferedReader buffered = null;
        File histolog=new File("HistoriqueLogs");
        FileReader fileReader = new FileReader(histolog);
        buffered = new BufferedReader(fileReader);
        String line;
        ArrayList<String> listHisto = new ArrayList<>();
        while ((line = buffered.readLine()) != null) {
            historiqueLog.add(line);
        }
        
    }
    public String getLogHistorique(int i){
        return historiqueLog.get(i);
    }
    public int getSizeLogHistorique(){
        return historiqueLog.size();
    }

    public int getCalendrierSize() {
        return calendrier.size();
    }

    public String getDateString(Date d, int ind) {
        String res = "";

        res = "<html>Case " + ind + "<br/>" + (d.getDate()) + " / " + (d.getMonth() + 1) + "<br/>" + (d.getHours() + 1) + " : " + (d.getMinutes() + 1) + "</html>";

        return res;
    }

    public Date getdate(int i) {
        return calendrier.get(i).getDate();
    }

    public void addCase(Case c) {
        c.setEtatRemplissage(true);
        calendrier.add(c);

    }

    public String getInfoAll() {
        String res = "";
        res += "réferents : \n";
        for (int i = 0; i < referents.size(); i++) {
            res += referents.get(i).getNom() + "  " + referents.get(i).getPrenom() + "  " + referents.get(i).getFonction() + "  " + referents.get(i).getMail() + "  " + referents.get(i).getTel() + "\n";
        }

        return res;
    }

    public Date getCaseCalendrier(Case c) {

        return c.getDate();

    }

    public int itsTime() {
        Date d = new Date();
        for (int i = 0; i < calendrier.size(); i++) {
            if (calendrier.get(i).getDate().getMonth() == d.getMonth() && calendrier.get(i).getDate().getDate() == d.getDate() && calendrier.get(i).getDate().getHours() == d.getHours() && calendrier.get(i).getDate().getMinutes() == d.getMinutes() && calendrier.get(i).getDate().getSeconds() == d.getSeconds() && calendrier.get(i).getEtatRemplissage()) {
                return i + 1;
            }
        }
        return 0;
    }

    public String getHistorique(int i) {
        return historique.toString(i);
    }

    public int getSizeHistorique() {
        return historique.getListeHistorique().size();
    }

    public void addHistorique(String txt, Date ajrd) throws IOException {
        ActionHistorique ah = new ActionHistorique(txt, ajrd);
        historique.addActionHistorique(ah);

        histoLog.write(ah.ToString() + "\n");

        histoLog.flush();

    }

    public void closeLog(boolean x) throws IOException {

        if (x) {
            histoLog.close();
            refLog.close();
        }
    }
}
