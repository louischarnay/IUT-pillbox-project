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
public class LedMarche extends JComponent {

    private Color couleurLed = Color.red;
    private Color couleurTour = Color.white;

    public void setCouleurLed(Color couleurLed) {
        this.couleurLed = couleurLed;
        repaint();
    }
    
    public void setCouleurTour(Color couleurLed) {
        this.couleurTour = couleurLed;
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension d = new Dimension(120, 40);
        return d;
    }
    
    public Color getCouleurLed(){
        return couleurLed;
    }

    public void couleurLedChange(Color couleur) {
        this.setCouleurLed(couleur);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics gra) {
        gra.setColor(couleurTour);
        gra.fillOval(90, 10, 40, 40);
        gra.setColor(couleurLed);
        gra.fillOval(96, 16, 28, 28);
    }

}
