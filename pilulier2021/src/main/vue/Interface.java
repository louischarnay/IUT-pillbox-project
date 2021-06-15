/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.border.Border;

/**
 *
 * @author p2008965
 */
public class Interface extends JFrame implements ActionListener{
    protected JLabel heureAffiche=new JLabel(), prochainTrait=new JLabel(), nbCases=new JLabel();
    protected JButton calendrier=new JButton(), informations=new JButton(), menuSU=new JButton(), panicButton=new JButton();
    protected LedMarche ledMarche= new LedMarche();
    
    ImageIcon panicImage=new ImageIcon(getClass().getResource("panicImage.png"));
    ImageIcon calendrierImage=new ImageIcon(getClass().getResource("calendrierImage.png"));
    ImageIcon informationsImage=new ImageIcon(getClass().getResource("informationImage.png"));
    ImageIcon menuSUImage=new ImageIcon(getClass().getResource("menuSUImage.png"));
    
    Color transparent=new Color(0, 0, 0, 0);
    Color vertFond=new Color(0, 128, 128, 255);
    
    public Interface() throws InterruptedException{
        this.setTitle("fenetre");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialisation();
        this.setSize(800, 480);
        calendrier.addActionListener(this);
        informations.addActionListener(this);
        menuSU.addActionListener(this);
        panicButton.addActionListener(this);
       
    }
    
    public void initialisation(){
        JPanel pano=new JPanel();
        pano.setLayout(new GridBagLayout());
        
        setHeureAffiche();
        prochainTrait.setText("Prochain traitement dans 19 minutes");
        nbCases.setText("3 cases restantes");
        //création des boutons
        panicButton.setIcon(panicImage);
        informations.setIcon(informationsImage);
        menuSU.setIcon(menuSUImage);
        calendrier.setIcon(calendrierImage);
        panicButton.setBorderPainted(false);
        panicButton.setBackground(vertFond);
        informations.setOpaque(false);
        informations.setBorderPainted(false);
        informations.setBackground(vertFond);
        menuSU.setOpaque(false);
        menuSU.setBorderPainted(false);
        menuSU.setBackground(vertFond);
        calendrier.setOpaque(false);
        calendrier.setBorderPainted(false);
        calendrier.setBackground(vertFond);
        
        GridBagConstraints cont=new GridBagConstraints();
        cont.insets=new Insets(5, 5, 5, 5);
        heureAffiche.setFont(new Font("Arial", Font.BOLD, 30));
        pano.setBackground(vertFond);
        //placement heure
        cont.anchor=GridBagConstraints.WEST;
        cont.gridwidth=3;
        cont.gridx=0;
        cont.gridy=0;
        Border bordure=BorderFactory.createLineBorder(Color.white);
        heureAffiche.setBorder(bordure);
        pano.add(heureAffiche, cont);
        //placement prochain traitement
        cont.fill=GridBagConstraints.BOTH;
        cont.gridy=1;
        cont.insets=new Insets(15, 5, 15, 5);
        pano.add(prochainTrait, cont);
        //placement nb cases restantes
        cont.gridy=2;
        pano.add(nbCases, cont);
        //placement bouton calendrier
        cont.gridwidth=1;
        cont.gridx=0;
        cont.gridy=3;
        cont.weightx=1;
        cont.insets=new Insets(5, 5, 5, 5);
        pano.add(calendrier, cont);
        //placement bouton informations
        cont.gridx=1;
        pano.add(informations, cont);
        //placement bouton menu SU
        cont.gridx=2;
        pano.add(menuSU, cont);
        //placement panic button
        cont.gridx=3;
        pano.add(panicButton, cont);
        //placement led de marche
        cont.gridy=0;
        cont.gridx=3;
        cont.fill=GridBagConstraints.NONE;
        cont.anchor=GridBagConstraints.NORTHEAST;
        pano.add(ledMarche, cont);
        
        this.setContentPane(pano);
        this.pack();
        
    }
    
    public void setHeureAffiche(){
        Date heure=new Date();
        if (heure.getMinutes() < 10)
            heureAffiche.setText((heure.getHours()+": 0"+heure.getMinutes()));
        else
            heureAffiche.setText((heure.getHours()+":"+heure.getMinutes()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==panicButton)
            System.out.println("panic button pressed");
        else if(e.getSource()==menuSU)
            System.out.println("menu SU pressed");
        else if(e.getSource()==informations)
            System.out.println("informations pressed");
        else if(e.getSource()==calendrier)
            System.out.println("calendrier pressed");
    }
}
