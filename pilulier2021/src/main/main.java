/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.pi4j.io.gpio.RaspiBcmPin;
import com.pi4j.device.pibrella.PibrellaBuzzer;
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
             
        int i = 0;
        while(i == 0){
            fenetre.setHeureAffiche();
            Thread.sleep(1000);
        }

        // test
    }
 
}
