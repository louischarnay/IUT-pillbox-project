/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.pi4j.io.gpio.RaspiBcmPin;
import main.modele.Moteur;
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

/**
 *
 * @author p2008965
 */
public class main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {;
        ArrayList<Case> calendrier=new ArrayList<>();
        ArrayList<Referent> referents=new ArrayList<>();
        Referent Michel=new Referent("Michel","Polnareff","Patient","Rue Peter Fink","michelPolnareff@gmail.com","07 88 08 01 40");
        Referent Natacha=new Referent("Natacha","Tte","Referent","Rue Peter Fink","NatachaTte@gmail.com","06 07 30 61 80");
        Referent Salima=new Referent("Salima","Rdigra","Referent","Rue Peter Fink","SalimaRdigra@gmail.com","06 88 64 32 10");
        referents.add(Michel);
        referents.add(Natacha);
        referents.add(Salima);
        calendrier.add(new Case(1,new Date(2021,05,16,15,03,0)));
        for(int i=1;i<10;i++){
            calendrier.add(new Case(i+1,new Date(2020-1900,i,10+i,2*i,12+i,0)));
        }

        
        Moteur motor = null; //moteur non raccordé à la raspberry
//        Moteur motor = new Moteur(0, RaspiBcmPin.GPIO_22, RaspiBcmPin.GPIO_23, RaspiBcmPin.GPIO_24, RaspiBcmPin.GPIO_25);
        HautParleur buzzer = null; //hp non raccordé à la raspberry
//        HautParleur buzzer = new HautParleur(0, RaspiBcmPin.GPIO_26);
        

        
        //HautParleur buzzer=new HautParleur(2);
        Pilulier pilulier=new Pilulier(referents,calendrier,buzzer, motor);

        String res=pilulier.getInfoAll();
        System.out.println(res);
        System.out.println("Calendrier : ");
        
        Interface fenetre=new Interface(pilulier);
        fenetre.setVisible(true);
        
        for(int i=0;i<calendrier.size();i++){

            System.out.println("Case "+(i+1)+" : " + pilulier.getCaseCalendrier(calendrier.get(i))); 

            res="<html>Case "+i+"<br/>"+(calendrier.get(i).getDate().getDate())+" / "+(calendrier.get(i).getDate().getMonth()+1)+"<br/>"+(calendrier.get(i).getDate().getHours()+1)+" : "+(calendrier.get(i).getDate().getMinutes()+1)+"</html>";
            System.out.println("Case "+(i+1)+" : "+pilulier.getCaseCalendrier(calendrier.get(i))); 
            System.out.println(res);

        }
        
        int i = 0;
        int time = 0;
        while(i == 0){
            fenetre.setHeureAffiche();
            time=pilulier.itsTime();
            if(time!=0){
                System.out.println("ITS TIME");
                //fenetre.itsTime();
            }
            Thread.sleep(1000);
        }
    }
}
