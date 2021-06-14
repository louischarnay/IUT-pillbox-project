/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author p2008965
 */
public class Interface extends JFrame{
    protected JLabel heureAffiche=new JLabel(), prochainTrait=new JLabel(), nbCases=new JLabel();
    protected JButton calendrier=new JButton(), informations=new JButton(), menuSU=new JButton();
    
    public Interface(){
        this.setTitle("fenetre");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialisation();
    }
    
    public void initialisation(){
        JPanel pano=new JPanel();
        pano.setLayout(new GridBagLayout());
        Date heure=new Date();
        heureAffiche.setText((heure.getHours()+":"+heure.getMinutes()));
        prochainTrait.setText("Prochain traitement dans 19 minutes");
        nbCases.setText("3 cases restantes");
        calendrier.setText("C");
        informations.setText("I");
        menuSU.setText("M");
        GridBagConstraints cont=new GridBagConstraints();
        
        cont.anchor=GridBagConstraints.WEST;
        cont.gridwidth=3;
        cont.gridx=0;
        cont.gridy=0;
        Border bordure=BorderFactory.createLineBorder(Color.blue);
        heureAffiche.setBorder(bordure);
        pano.add(heureAffiche, cont);
        
        cont.fill=GridBagConstraints.BOTH;
        cont.gridy++;
        pano.add(prochainTrait, cont);
        
        cont.gridy=2;
        pano.add(nbCases, cont);
        
        cont.gridwidth=1;
        cont.gridx=0;
        cont.gridy=3;
        pano.add(calendrier, cont);
        
        cont.gridx++;
        pano.add(informations, cont);
        
        cont.gridx++;
        pano.add(menuSU, cont);
        
        this.setContentPane(pano);
        this.pack();
        
    }
}
