/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2_rpi_2021;

import com.pi4j.io.gpio.RaspiBcmPin;
import static com.pi4j.io.gpio.RaspiPin.GPIO_05;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author l.buathier
 
  Programme de test du Rpi Base Hat

  attention : WirinPi est la numérotation utilisée par defaut par Pi4j  
 alors que Broadcom est la plus couremment utilisée et 
 c'est celle qui est utilisée pour repérer les connecteurs de la carte chapeau
 
 Ce projet est une compilation des classes utilisées pour tester les cpateurs et actionneurs grove
 utilisables avec le chapeau "Rpi Base Hat"
 Elles ont été adaptées pour la carte à partir des exemples fournis avec lib Pi4j
 
 Liste des conecteurs et modules groves utilisé par les différentes classes :
 BaseHatAnalogInput : A0 -> Rotary Angle / lignt Sensor v1.2 / Temérature Sensor
 DigitaBCMGpio : D16 -> LED  / D5 - push button
 DigitaBCMGpioListener : D16 -> LED  / D5 - push button
 ServoBlaster : D18 -> Servomoteur
 DHT : D26 -> DHT2 (Temerature & Humidity densor Pro)
 * StepperMotorGpio : D22 & D23 / D24 & D25 (!! cables spécifique)
 *          
 */
public class SS2_Rpi_2021 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

         int BCM_26 = 25; // wiringPi number
         try {
               
             
      //      DHT dht22 = new DHT(BCM_26);
            DHTMock dht22 = new DHTMock();
            dht22.getTemperature();
              
//            AnalogInput analogInput = new AnalogInput(0);
//            analogInput.start();
//              
//            DigitaBCMGpio digitaBCMGpio = new DigitaBCMGpio(RaspiBcmPin.GPIO_16);
//            digitaBCMGpio.start();
            
//            DigitaBCMGpioListener digitaBCMGpioListener = new DigitaBCMGpioListener(RaspiBcmPin.GPIO_05);
//            digitaBCMGpioListener.start();
            
//            StepperMotorGpio cx28byj48 = new StepperMotorGpio(RaspiBcmPin.GPIO_22, RaspiBcmPin.GPIO_23, RaspiBcmPin.GPIO_24, RaspiBcmPin.GPIO_25);
////          cx28byj48.start();
           
        } catch (Exception ex) {
            Logger.getLogger(SS2_Rpi_2021.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
