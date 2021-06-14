package ss2_rpi_2021;

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Examples
 * FILENAME      :  DigitaBCMGpioListener.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2021 Pi4J
 * %%
 * #L%
 */

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.util.Console;
import com.pi4j.util.ConsoleColor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This example code demonstrates how to setup a listener
 * for GPIO pin state changes on the RaspberryPi
 * using the Broadcom chipset GPIO pin numbering scheme.
 *
 * @author Robert Savage
 * adapted by Lionel Buathier
 */
public class DigitaBCMGpioListener implements Execute{

    final private GpioPinDigitalInput myButton;
    final private GpioController gpio;
 
    public DigitaBCMGpioListener(Pin pin) {
               
        
        GpioFactory.setDefaultProvider(new RaspiGpioProvider(RaspiPinNumberingScheme.BROADCOM_PIN_NUMBERING));

    
        // create gpio controller
        gpio = GpioFactory.getInstance();

        // provision broadcom gpio pin #5 as an input pin - No pull down needed for grove push button
        //final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiBcmPin.GPIO_05, "MyButton", PinPullResistance.PULL_DOWN);
        myButton = gpio.provisionDigitalInputPin(pin, "MyButton"); // pull down intégrée sur grove push button

        // unexport the GPIO pin when program exits
        myButton.setShutdownOptions(true);

    }
    
    
    @Override
    public void start()  {
    
            // create Pi4J console wrapper/helper
        // (This is a utility class to abstract some of the boilerplate code)
        final Console console = new Console();

        // print program title/header
        console.title("<-- The Pi4J Project -->", "GPIO BCM_05 Listen Example");

        // allow for user to exit program using CTRL-C
        console.promptForExit();

        // prompt user that we are ready
        console.println(" ... Successfully provisioned [" + myButton.getPin() + "] with PULL resistance = [" + myButton.getPullResistance() + "]");
        console.emptyLine();
        console.box("Please complete the [" + myButton.getPin() + "] circuit and see",
                "the listener feedback here in the console.");
        console.emptyLine();

        // create and register gpio pin listener
        myButton.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                console.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " +
                        ConsoleColor.conditional(
                                event.getState().isHigh(), // conditional expression
                                ConsoleColor.GREEN,        // positive conditional color
                                ConsoleColor.RED,          // negative conditional color
                                event.getState()));        // text to display
            }

        });

        try {
            // wait (block) for user to exit program using CTRL-C
            console.waitForExit();
        } catch (InterruptedException ex) {
            Logger.getLogger(DigitaBCMGpioListener.class.getName()).log(Level.SEVERE, null, ex);
        }

        // forcefully shutdown all GPIO monitoring threads and scheduled tasks
        gpio.shutdown();
    
    }
    
}
