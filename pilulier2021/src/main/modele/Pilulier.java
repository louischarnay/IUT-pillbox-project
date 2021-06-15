/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele.modele;

import main.modele.Case;
import java.util.ArrayList;

/**
 *
 * @author p2008965
 */
public class Pilulier {
    protected ArrayList<Case>calendrier;

    public Pilulier() {
        calendrier=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            calendrier.add(new Case(i));
        }
    }
    
    public ArrayList<Case> getCalendrier() {
        return calendrier;
    }

    public void setCalendrier(ArrayList<Case> calendrier) {
        this.calendrier = calendrier;
    }
}
