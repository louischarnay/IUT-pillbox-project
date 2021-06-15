
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Pablo
 */
    public class LedMarche extends JComponent{
        private Color couleurLed=Color.red;

    public void setCouleurLed(Color couleurLed) {
        this.couleurLed = couleurLed;
    }
        
        
        @Override
        public Dimension getPreferredSize(){
            Dimension d=new Dimension(20, 20);
            return d;
        }
        
        public void couleurLedChange(Color couleur){
            this.setCouleurLed(couleur);
            System.out.println("fait");
            repaint();
                System.out.println("zebi");
        }
        @Override
        protected void paintComponent(Graphics gra){
            gra.setColor(Color.white);
            gra.fillOval(0, 0, 20, 20);
            gra.setColor(couleurLed);
            gra.fillOval(3, 3, 14, 14);
    }

}

