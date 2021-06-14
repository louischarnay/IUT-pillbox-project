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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.border.Border;

/**
 *
 * @author p2008965
 */
public class Interface extends JFrame /*implements ActionListener*/{
    protected JLabel heureAffiche=new JLabel(), prochainTrait=new JLabel(), nbCases=new JLabel();
    protected JButton calendrier=new JButton(), informations=new JButton(), menuSU=new JButton(), panicButton=new JButton();
    
    ImageIcon panicImage=new ImageIcon(getClass().getResource("../icones/panicImage.png"));
    ImageIcon calendrierImage=new ImageIcon(getClass().getResource("../icones/calendrierImage.png"));
    ImageIcon informationsImage=new ImageIcon(getClass().getResource("../icones/informationImage.png"));
    ImageIcon menuSUImage=new ImageIcon(getClass().getResource("../icones/MenuSUImage.png"));
    
    Color transparent=new Color(0, 0, 0, 0);
    Color vertFond=new Color(0, 128, 128, 100);
    
    public Interface(){
        this.setTitle("fenetre");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialisation();
        //calendrier.addActionListener(this);
        //informations.addActionListener(this);
        //menuSU.addActionListener(this);
        //panicButton.addActionListener(this);
    }
    
    public void initialisation(){
        JPanel pano=new JPanel();
        pano.setLayout(new GridBagLayout());
        Date heure=new Date();
        heureAffiche.setText((heure.getHours()+":"+heure.getMinutes()));
        prochainTrait.setText("Prochain traitement dans 19 minutes");
        nbCases.setText("3 cases restantes");
        //création des boutons
        panicButton.setIcon(panicImage);
        informations.setIcon(informationsImage);
        menuSU.setIcon(menuSUImage);
        calendrier.setIcon(calendrierImage);
        panicButton.setBackground(vertFond);
        informations.setBackground(vertFond);
        menuSU.setBackground(vertFond);
        calendrier.setBackground(vertFond);
        
        GridBagConstraints cont=new GridBagConstraints();
        pano.setBackground(vertFond);
        
        cont.anchor=GridBagConstraints.WEST;
        cont.gridwidth=3;
        cont.gridx=0;
        cont.gridy=0;
        Border bordure=BorderFactory.createLineBorder(Color.white);
        heureAffiche.setBorder(bordure);
        pano.add(heureAffiche, cont);
        
        cont.fill=GridBagConstraints.BOTH;
        cont.gridy=1;
        pano.add(prochainTrait, cont);
        
        cont.gridy=2;
        pano.add(nbCases, cont);
        
        cont.gridwidth=1;
        cont.gridx=0;
        cont.gridy=3;
        cont.weightx=1;
        pano.add(calendrier, cont);
        
        cont.gridx=1;
        pano.add(informations, cont);
        
        cont.gridx=2;
        pano.add(menuSU, cont);
        
        cont.gridx=3;
        pano.add(panicButton, cont);
        
        this.setContentPane(pano);
        this.pack();
        
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        switch((int)e.getSource()){
//        }
//    }
}
