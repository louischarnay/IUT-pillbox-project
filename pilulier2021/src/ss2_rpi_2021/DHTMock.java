/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2_rpi_2021;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;

public class DHTMock {


    
    public DHTMock() {
         System.out.println(" this is mock DHT");
    }

    // pinNumber number = Wriring PI 
    public void getTemperature() {
        System.out.println("Temperature = "+ Math.random()*100);
    }
         
}
