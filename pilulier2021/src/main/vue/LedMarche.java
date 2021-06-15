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
        @Override
        public Dimension getPreferredSize(){
            Dimension d=new Dimension(20, 20);
            return d;
        }
        @Override
        protected void paintComponent(Graphics gra){
            gra.setColor(Color.white);
            gra.fillOval(0, 0, 20, 20);
            gra.setColor(Color.red);
            gra.fillOval(3, 3, 14, 14);
    }

}
