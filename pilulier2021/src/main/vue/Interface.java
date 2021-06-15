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
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import main.vue.LedMarche;

/**
 *
 * @author p2008965
 */
public class Interface extends JFrame implements ActionListener{
    protected JLabel heureAffiche=new JLabel();
    protected JTextArea infosMenu=new JTextArea();
    protected JButton calendrier=new JButton(), informations=new JButton(), menuSU=new JButton(), panicButton=new JButton(), boutonAlerte=new JButton(), boutonMenuSU=new JButton();
    protected LedMarche ledMarche= new LedMarche();
    
    JPanel pano=new JPanel();
    GridBagConstraints cont=new GridBagConstraints();
    
    ImageIcon imageBase=new ImageIcon(getClass().getResource("panicImage.png"));
    Image image = imageBase.getImage();
    Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon panicImage = new ImageIcon(newimg);
    
    ImageIcon imageBase2=new ImageIcon(getClass().getResource("calendrierImage.png"));
    Image image2 = imageBase2.getImage();
    Image newimg2 = image2.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon calendrierImage = new ImageIcon(newimg2);
    
    ImageIcon imageBase3=new ImageIcon(getClass().getResource("informationImage.png"));
    Image image3 = imageBase3.getImage();
    Image newimg3 = image3.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon informationsImage = new ImageIcon(newimg3);
    
    ImageIcon imageBase4=new ImageIcon(getClass().getResource("menuSUImage.png"));
    Image image4 = imageBase4.getImage();
    Image newimg4 = image4.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon menuSUImage = new ImageIcon(newimg4);
    
    Color transparent=new Color(0, 0, 0, 0);
    Color vertFond=new Color(0, 128, 128, 255);
    
    public JPanel getPano() {
        return pano;
    }

    public GridBagConstraints getCont() {
        return cont;
    }
    
    public Interface() throws InterruptedException{
        this.setTitle("fenetre");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialisation();
        this.setSize(800, 480);
        calendrier.addActionListener(this);
        informations.addActionListener(this);
        menuSU.addActionListener(this);
        panicButton.addActionListener(this);
        boutonAlerte.addActionListener(this);
       
    }
    
    public void initialisation(){
        pano.setLayout(new GridBagLayout());
        Date heure=new Date();
        Border bordure;
        
        setHeureAffiche();
        heureAffiche.setFont(new Font("Arial", Font.BOLD, 65));
        heureAffiche.setForeground(Color.white);
        
        String newLine=System.getProperty("line.separator");
        infosMenu.setFont(new Font("Arial", Font.BOLD, 30));
        infosMenu.setForeground(Color.white);
        infosMenu.setText("Prochain traitement dans 20 minutes"+newLine+newLine+"3 cases restantes");
        infosMenu.setBackground(vertFond);
        
        //création des composants
        
        //création des boutons
        panicButton.setIcon(panicImage);
        panicButton.setBorderPainted(false);
        panicButton.setBackground(vertFond);
        panicButton.setSize(100, 100);
        
        informations.setOpaque(false);
        informations.setBorderPainted(false);
        informations.setBackground(vertFond);
        informations.setIcon(informationsImage);
        
        menuSU.setIcon(menuSUImage);
        menuSU.setOpaque(false);
        menuSU.setBorderPainted(false);
        menuSU.setBackground(vertFond);
        
        calendrier.setIcon(calendrierImage);
        calendrier.setOpaque(false);
        calendrier.setBorderPainted(false);
        calendrier.setBackground(vertFond);
        
        boutonAlerte.setText("Bonjour");
        boutonAlerte.setBackground(vertFond);
        bordure=BorderFactory.createLineBorder(Color.red);
        boutonAlerte.setBorder(bordure);
        boutonAlerte.setForeground(Color.red);
        boutonAlerte.setFont(new Font("Arial", Font.BOLD, 60));
        
        //boutonMenuSU.setText
        
        pano.setBackground(vertFond);
        //placement heure
        heurePlacement(cont, pano);
        //placement prochain traitement + nb cases restantes
        //prochainTraitPlacement(cont, pano);
        boutonAlertePlacement(cont, pano, "Traitement pris");
        //placement bouton calendrier
        
        //placement des boutons menu
        boutonsMenuPlacement(cont, pano);
        //placement led de marche
        ledMarchePlacement(cont, pano);
        
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
        else if(e.getSource()==boutonAlerte)
            System.out.println("bouton alerte pressed");
            boutonAlerte.setVisible(false);
            prochainTraitPlacement(cont, pano);
    }
    
    
    //fonctions de placement des éléments
    public void heurePlacement(GridBagConstraints cont, JPanel pano){
        cont.insets=new Insets(5, 5, 5, 5);
        cont.fill=GridBagConstraints.BOTH;
        cont.anchor=GridBagConstraints.NORTHWEST;
        cont.gridwidth=3;
        cont.gridx=0;
        cont.gridy=0;
        pano.add(heureAffiche, cont);
        cont.gridwidth=1;
    }
    
    public void ledMarchePlacement(GridBagConstraints cont, JPanel pano){
        cont.gridy=0;
        cont.gridx=3;
        cont.fill=GridBagConstraints.NONE;
        cont.anchor=GridBagConstraints.NORTHEAST;
        pano.add(ledMarche, cont);
    }
    
    public void prochainTraitPlacement(GridBagConstraints cont, JPanel pano){
        cont.fill=GridBagConstraints.BOTH;
        cont.gridheight=2;
        cont.gridwidth=4;
        cont.gridy=1;
        cont.gridx=0;
        cont.fill=GridBagConstraints.BOTH;
        cont.insets=new Insets(50, 5, 50, 5);
        pano.add(infosMenu, cont);
        cont.gridheight=1;
        cont.gridwidth=1;
    }
    
    public void boutonsMenuPlacement(GridBagConstraints cont, JPanel pano){
        cont.weightx=1;
        cont.insets=new Insets(5, 5, 5, 5);
        cont.gridy=3;
        cont.gridx=0;
        pano.add(calendrier, cont);
        cont.gridx=1;
        pano.add(informations, cont);
        cont.gridx=2;
        pano.add(menuSU, cont);
        cont.gridx=3;
        pano.add(panicButton, cont);
    }
    
    public void boutonAlertePlacement(GridBagConstraints cont, JPanel pano, String msg){
        boutonAlerte.setText(msg);
        cont.fill=GridBagConstraints.BOTH;
        cont.anchor=GridBagConstraints.CENTER;
        cont.insets=new Insets(70, 5, 70, 5);
        cont.gridx=0;
        cont.gridheight=2;
        cont.gridwidth=4;
        cont.gridy=1;
        pano.add(boutonAlerte, cont);
        cont.gridheight=1;
        cont.gridwidth=1;
    }
    
    public void menuMenuSUPlacement(GridBagConstraints cont, JPanel pano){
        
    }
}
