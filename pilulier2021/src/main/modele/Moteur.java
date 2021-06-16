/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiBcmPin;
import ss2_rpi_2021.StepperMotorGpio;

/**
 *
 * @author p2007867
 */
public class Moteur {
    protected int angleRotation;
    
    public Moteur(int angle){
        angleRotation= angle;
        
    }
    private void setAngle(int angle){
        angleRotation= angle;
    }
    private int getAngleRotation(){
        return angleRotation;
    }
    public boolean rotation(){
        StepperMotorGpio motor = new StepperMotorGpio(RaspiBcmPin.GPIO_22, RaspiBcmPin.GPIO_23, RaspiBcmPin.GPIO_24, RaspiBcmPin.GPIO_25);
        motor.start();
        return true;
    }
}