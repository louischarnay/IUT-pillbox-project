/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiGpioProvider;
import com.pi4j.io.gpio.RaspiPinNumberingScheme;
import java.util.logging.Level;
import java.util.logging.Logger;
import ss2_rpi_2021.DigitaBCMGpio;
import ss2_rpi_2021.Execute;

/**
 *
 * @author p2007867
 */
public class HautParleur implements Execute{
    protected int intensite;
    final private GpioPinDigitalOutput pin;
    final private GpioController gpio;
    
    public HautParleur(int i, Pin pinNumber) throws UnsupportedOperationException{
        intensite= i;
        // in order to use the Broadcom GPIO pin numbering scheme, we need to configure the
        // GPIO factory to use a custom configured Raspberry Pi GPIO provider
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));

        // create gpio controller
        gpio = GpioFactory.getInstance();

        // provision broadcom gpio pin #16 as an output pin and turn on
        pin = gpio.provisionDigitalOutputPin(pinNumber, "MyLED", PinState.HIGH);
        
        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);      
    }
    
    @Override
    public void start()  {
        System.out.println("<--Pi4J--> GPIO Control LED on GPIO BCM_16 ... started.");

        System.out.println("--> GPIO state should be: ON");

        try {
            while (true){
                Thread.sleep(1/100000);

                // turn off gpio pin 
                pin.low();
                Thread.sleep(1/100000);

                // toggle the current state of gpio pin  (should turn on)
                pin.toggle();
                Thread.sleep(1/100000);

                // toggle the current state of gpio pin (should turn off)
                pin.toggle();
                Thread.sleep(1/100000);

                // turn on gpio pin  for 1 second and then off
                pin.pulseSync(1);

                // stop all GPIO activity/threads by shutting down the GPIO controller
                // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
                gpio.shutdown();
            }
            
        
        }catch (InterruptedException ex) {
            Logger.getLogger(DigitaBCMGpio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setIntensite(int i){
        intensite= i;
    }
    private int getIntensite(){
        return intensite;
    }
}
