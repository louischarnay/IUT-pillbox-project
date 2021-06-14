/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author p2008965
 */
public class Interface extends JFrame{
    protected JLabel heure=new JLabel(), prochainTrait=new JLabel(), nbCases=new JLabel();
    protected JButton calendrier=new JButton(), informations=new JButton(), menuSU=new JButton();
    
    public Interface(){
        this.setTitle("fenetre");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialisation();
    }
    
    public void initialisation(){
        JPanel pano=new JPanel();
        pano.setLayout(new GridBagLayout());
        prochainTrait.setText("Prochain traitement dans 19 minutes");
        nbCases.setText("3 cases restantes");
         GridBagConstraints cont=new GridBagConstraints();
        cont.fill=GridBagConstraints.BOTH;
    }
}
