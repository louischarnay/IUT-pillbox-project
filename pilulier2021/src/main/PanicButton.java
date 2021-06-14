/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author Pablo
 */
    public class PanicButton extends JComponent{
        @Override
        public Dimension getPreferredSize(){
            Dimension d=new Dimension(50, 50);
            return d;
        }
        @Override
        protected void paintComponent(Graphics gra){
            gra.setColor(Color.white);
            gra.fillOval(1, 1, 48, 48);
            gra.setColor(Color.red);
            gra.fillOval(5, 5, 40, 40);
    }

}
