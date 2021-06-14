/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2_rpi_2021;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.GpioUtil;

public class DHT {


    private static final int MAXTIMINGS = 85;
    private final int[] dht11_dat = {0, 0, 0, 0, 0};
    
    private int pinNumber;
  

    public DHT(int pinNumber) {

        this.pinNumber = pinNumber;
        // setup wiringPi
        if (Gpio.wiringPiSetup() == -1) {
            System.out.println(" ==>> GPIO SETUP FAILED");
            return;
        }

        GpioUtil.export(pinNumber, GpioUtil.DIRECTION_OUT);
    }

    // pinNumber number = Wriring PI 
    public void getTemperature() {
        boolean done = false;
        int attempts=0;
        while (!done && attempts<100) {
            int laststate = Gpio.HIGH;
            int j = 0;
            attempts++;
            dht11_dat[0] = dht11_dat[1] = dht11_dat[2] = dht11_dat[3] = dht11_dat[4] = 0;

            Gpio.pinMode(pinNumber, Gpio.OUTPUT);
            Gpio.digitalWrite(pinNumber, Gpio.LOW);
            Gpio.delay(18);

            Gpio.digitalWrite(pinNumber, Gpio.HIGH);
            Gpio.pinMode(pinNumber, Gpio.INPUT);

            for (int i = 0; i < MAXTIMINGS; i++) {
                int counter = 0;
                while (Gpio.digitalRead(pinNumber) == laststate) {
                    counter++;
                    Gpio.delayMicroseconds(1);
                    if (counter == 255) {
                        break;
                    }
                }

                laststate = Gpio.digitalRead(pinNumber);

                if (counter == 255) {
                    break;
                }

                /* ignore first 3 transitions */
                if (i >= 4 && i % 2 == 0) {
                    /* shove each bit into the storage bytes */
                    dht11_dat[j / 8] <<= 1;
                    if (counter > 16) {
                        dht11_dat[j / 8] |= 1;
                    }
                    j++;
                }
            }
            // check we read 40 bits (8bit x 5 ) + verify checksum in the last
            // byte
            if (j >= 40 && checkParity()) {
                
                // while (j < 40 && ! checkParity()) {
                float h = (float) ((dht11_dat[0] << 8) + dht11_dat[1]) / 10;
                if (h > 100) {
                    h = dht11_dat[0]; // for DHT
                }
                float c = (float) (((dht11_dat[2] & 0x7F) << 8) + dht11_dat[3]) / 10;
                if (c > 125) {
                    c = dht11_dat[2]; // for DHT
                }
                if ((dht11_dat[2] & 0x80) != 0) {
                    c = -c;
                }
                //final float f = c * 1.8f + 32;
                System.out.println("Humidity = " + h + " % - Temperature = " + c + " °C");
                
                done = true;
            }
        }
        if (!done ){
            System.out.println("Data not good...");
        }
         

    }

    private boolean checkParity() {
        return dht11_dat[4] == (dht11_dat[0] + dht11_dat[1] + dht11_dat[2] + dht11_dat[3] & 0xFF);
    }

    public static void main(final String ars[]) throws Exception {

        int BCM_26 = 25; // wiring Pi number
        
        final DHT dht = new DHT(BCM_26);

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            dht.getTemperature();
        }

        System.out.println("Done!!");

    }
}
