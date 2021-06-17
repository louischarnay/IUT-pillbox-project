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
        Referent patient=new Referent("...","...","Patient","...","...","...");
        Referent referent1=new Referent("...","...","Référent 1","...","...","...");
        Referent referent2=new Referent("...","...","Référent 2","...","...","...");
        Referent referent3=new Referent("...","...","Référent 3","...","...","...");
        referents.add(patient);
        referents.add(referent1);
        referents.add(referent2);
        referents.add(referent3);
        calendrier.add(new Case(1,new Date(2021, 06, 17, 11, 14)));
        calendrier.add(new Case(2,new Date(2021, 02, 19, 14, 0)));
        calendrier.add(new Case(3,new Date(2021, 02, 19, 14, 0)));
        calendrier.add(new Case(4,new Date(2021, 02, 19, 14, 0)));
        calendrier.add(new Case(5,new Date(2021, 02, 19, 14, 0)));
        calendrier.add(new Case(6,new Date(2021, 02, 19, 14, 0)));
        calendrier.add(new Case(7,new Date(2021, 02, 19, 14, 0)));
        for(int i=2;i<10;i++){
            calendrier.add(new Case(i+1,new Date(2020-1900,i,10+i,2*i,12+i,0)));
        }

        
        Moteur motor = null; //si moteur non raccordé à la raspberry
//        Moteur motor = new Moteur(0, RaspiBcmPin.GPIO_22, RaspiBcmPin.GPIO_23, RaspiBcmPin.GPIO_24, RaspiBcmPin.GPIO_25); //si moteur raccordé à la raspberry
        HautParleur buzzer = null; //si hp non raccordé à la raspberry
//        HautParleur buzzer = new HautParleur(0, RaspiBcmPin.GPIO_26); //si hp raccordé à la raspberry

        Pilulier pilulier=new Pilulier(referents,calendrier,buzzer, motor);
        
        pilulier.addHistorique("referent ajouté",new Date());
        pilulier.addHistorique("patient ajouté ",new Date());
        pilulier.addHistorique("referent ajouté ",new Date());
        pilulier.addHistorique("case1 modifiée",new Date());
        pilulier.addHistorique("case2 sonne",new Date());
        pilulier.addHistorique("moteur tourne sur case 2 ",new Date());
        pilulier.addHistorique("case2 arrete de sonner",new Date());
        pilulier.addHistorique("pablo est tro bo ",new Date());
        pilulier.addHistorique("louis aussi ",new Date());
        
        

//        String res=pilulier.getInfoAll();
//        System.out.println(res);
        
        Interface fenetre=new Interface(pilulier);
        fenetre.setVisible(true);
        
//        for(int i=0;i<calendrier.size();i++){
//
//            System.out.println("Case "+(i+1)+" : " + pilulier.getCaseCalendrier(calendrier.get(i))); 
//
//            res="<html>Case "+i+"<br/>"+(calendrier.get(i).getDate().getDate())+" / "+(calendrier.get(i).getDate().getMonth()+1)+"<br/>"+(calendrier.get(i).getDate().getHours()+1)+" : "+(calendrier.get(i).getDate().getMinutes()+1)+"</html>";
//            System.out.println("Case "+(i+1)+" : "+pilulier.getCaseCalendrier(calendrier.get(i))); 
//            System.out.println(res);
//
//        }
        
        int i = 0;
        int time = 0;
        while(i == 0){
            fenetre.setHeureAffiche();
            time=pilulier.itsTime();
            System.out.println(time);
            if(time!=0){
                System.out.println("ITS TIME");
                fenetre.itsTime(time);
            }
            Thread.sleep(1000);
        }
    }
}
