/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.pi4j.io.gpio.RaspiBcmPin;
import main.modele.Moteur;
import main.vue.Interface;

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

//        Moteur motor = new Moteur(-1, RaspiBcmPin.GPIO_22, RaspiBcmPin.GPIO_23, RaspiBcmPin.GPIO_24, RaspiBcmPin.GPIO_25);
//        motor.start();

//        int i = 0;
//        while(i == 0){
//            fenetre.setHeureAffiche();
//            Thread.sleep(1000);
//        }

        // test
    }
 
}
