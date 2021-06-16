/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.pi4j.io.gpio.RaspiBcmPin;
import com.pi4j.device.pibrella.PibrellaBuzzer;
import java.util.ArrayList;
import java.util.Date;
import main.modele.Case;
import main.modele.HautParleur;
import main.modele.Moteur;
import main.modele.Patient;
import main.modele.Pilulier;
import main.modele.Referent;
import main.vue.Interface;
import ss2_rpi_2021.DigitaBCMGpio;
import ss2_rpi_2021.StepperMotorGpio;

/**
 *
 * @author p2008965
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Interface fenetre=new Interface();
        fenetre.setVisible(true);
        // TODO code application logic here
        
//        DigitaBCMGpio digitaBCMGpio = new DigitaBCMGpio(RaspiBcmPin.GPIO_26);
//        digitaBCMGpio.start();

//        StepperMotorGpio motor = new StepperMotorGpio(RaspiBcmPin.GPIO_22, RaspiBcmPin.GPIO_23, RaspiBcmPin.GPIO_24, RaspiBcmPin.GPIO_25);
//        motor.start();
        

        
        ArrayList<Case> calendrier=new ArrayList<>();
        ArrayList<Referent> referents=new ArrayList<>();
        Patient Michel=new Patient("Michel","Polnareff","Patitent","Rue Peter Fink");
        Michel.addAllergie("polen");
        Michel.addAllergie("cacahuetes");
        Michel.addMaladie("mal au ventre");
        Michel.addMaladie("Rhum");
        Referent Natacha=new Referent("Natacha","Tte","Referent","Rue Peter Fink","NatachaTte@gmail.com","06 07 30 61 80");
        Referent Salima=new Referent("Salima","Rdigra","Referent","Rue Peter Fink","SalimaRdigra@gmail.com","06 88 64 32 10");
        referents.add(Natacha);
        referents.add(Salima);
        for(int i=0;i<10;i++){
            calendrier.add(new Case(i+1,new Date(2020-1900,i,10+i,2*i,12+i,0)));
        }
        Moteur m=new Moteur(2);
        HautParleur buzzer=new HautParleur(2);
        Pilulier pilulier=new Pilulier(Michel,referents,calendrier,buzzer, m);
        String res=pilulier.getInfoAll();
        System.out.println(res);
        System.out.println("Calendrier : ");
        for(int i=0;i<calendrier.size();i++){
            System.out.println("Case "+(i+1)+" : "+pilulier.getCaseCalendrier(calendrier.get(i))); 
        }
        int i = 0;
        while(i == 0){
            fenetre.setHeureAffiche();
            Thread.sleep(1000);
        }

        // test
    }
 
}
