/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author p2008965
 */
public class Interface extends JFrame implements ActionListener, FocusListener{
    protected JLabel heureAffiche=new JLabel();
    protected JTextArea infosMenu=new JTextArea(), infosEcriture=new JTextArea();
    protected JTextField nomEcriture=new JTextField(), prenomEcriture=new JTextField(), ageEcriture=new JTextField(), adresseEcriture=new JTextField(), mailEcriture=new JTextField(), telEcriture=new JTextField();
    protected JButton calendrier=new JButton(), informations=new JButton(), menuSU=new JButton(), panicButton=new JButton(), boutonAlerte=new JButton(), boutonMenuSU0=new JButton(), boutonMenuSU1=new JButton(), boutonMenuSU2=new JButton(), boutonRetour=new JButton(), flecheGauche=new JButton(), flecheDroite=new JButton();
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
    
    ImageIcon imageBase5=new ImageIcon(getClass().getResource("flecheImage.png"));
    Image image5 = imageBase5.getImage();
    Image newimg5 = image5.getScaledInstance(50, 300,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon flecheGaucheImage = new ImageIcon(newimg5);
    ImageIcon flecheDroiteImage = flecheGaucheImage;
    
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
        boutonRetour.addActionListener(this);
        boutonMenuSU0.addActionListener(this);
        boutonMenuSU1.addActionListener(this);
        boutonMenuSU2.addActionListener(this);
        flecheDroite.addActionListener(this);
        flecheGauche.addActionListener(this);
        nomEcriture.addFocusListener(this);
        prenomEcriture.addFocusListener(this);
        adresseEcriture.addFocusListener(this);
        telEcriture.addFocusListener(this);
        mailEcriture.addFocusListener(this);
        ageEcriture.addFocusListener(this);
    }
    
    public void initialisation(){
        pano.setLayout(new GridBagLayout());
        Date heure=new Date();
        Border bordure=BorderFactory.createLineBorder(Color.white);
        String newLine=System.getProperty("line.separator");
        
        setHeureAffiche();
        heureAffiche.setFont(new Font("Arial", Font.BOLD, 65));
        heureAffiche.setForeground(Color.white);
        
        infosMenu.setFont(new Font("Arial", Font.BOLD, 30));
        infosMenu.setForeground(Color.white);
        infosMenu.setText("Prochain traitement dans 20 minutes"+newLine+newLine+"3 cases restantes");
        infosMenu.setBackground(vertFond);
        
        //création des composants
        
        //création des fields infos
        nomEcriture.setBackground(vertFond);
        nomEcriture.setForeground(Color.white);
        nomEcriture.setBorder(bordure);
        nomEcriture.setFont(new Font("Arial", Font.BOLD, 30));
        nomEcriture.setText("Nom : ");
        
        prenomEcriture.setBackground(vertFond);
        prenomEcriture.setForeground(Color.white);
        prenomEcriture.setBorder(bordure);
        prenomEcriture.setFont(new Font("Arial", Font.BOLD, 30));
        prenomEcriture.setText("Prénom : ");
        
        mailEcriture.setBackground(vertFond);
        mailEcriture.setForeground(Color.white);
        mailEcriture.setBorder(bordure);
        mailEcriture.setFont(new Font("Arial", Font.BOLD, 30));
        mailEcriture.setText("Mail : ");
        
        ageEcriture.setBackground(vertFond);
        ageEcriture.setForeground(Color.white);
        ageEcriture.setBorder(bordure);
        ageEcriture.setFont(new Font("Arial", Font.BOLD, 30));
        ageEcriture.setText("Age : ");
        
        adresseEcriture.setBackground(vertFond);
        adresseEcriture.setForeground(Color.white);
        adresseEcriture.setBorder(bordure);
        adresseEcriture.setFont(new Font("Arial", Font.BOLD, 30));
        adresseEcriture.setText("Adresse : ");
        
        telEcriture.setBackground(vertFond);
        telEcriture.setForeground(Color.white);
        telEcriture.setBorder(bordure);
        telEcriture.setFont(new Font("Arial", Font.BOLD, 50));
        telEcriture.setText("Tel : ");
        
//        //création JTextArea infos
//        infosEcriture.setBackground(vertFond);
//        infosEcriture.setForeground(Color.white);
//        infosEcriture.setBorder(bordure);
//        infosEcriture.setFont(new Font("Arial", Font.BOLD, 50));
        
        //création des boutons
        panicButton.setIcon(panicImage);
        bordure = BorderFactory.createLineBorder(Color.red);
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
        
        boutonAlerte.setBackground(vertFond);
        boutonAlerte.setBorder(bordure);
        boutonAlerte.setForeground(Color.red);
        boutonAlerte.setFont(new Font("Arial", Font.BOLD, 30));        
        
        GridBagConstraints cont=new GridBagConstraints();
        boutonAlerte.setFont(new Font("Arial", Font.BOLD, 60));
        
        boutonMenuSU0.setBackground(vertFond);
        bordure=BorderFactory.createLineBorder(Color.white);
        boutonMenuSU0.setBorder(bordure);
        boutonMenuSU0.setForeground(Color.white);
        boutonMenuSU0.setFont(new Font("Arial", Font.BOLD, 50));
        
        boutonMenuSU1.setBackground(vertFond);
        boutonMenuSU1.setBorder(bordure);
        boutonMenuSU1.setForeground(Color.white);
        boutonMenuSU1.setFont(new Font("Arial", Font.BOLD, 50));
        
        boutonMenuSU2.setBackground(vertFond);
        boutonMenuSU2.setBorder(bordure);
        boutonMenuSU2.setForeground(Color.white);
        boutonMenuSU2.setFont(new Font("Arial", Font.BOLD, 50));
        
        boutonRetour.setText("Retour");
        boutonRetour.setBackground(vertFond);
        boutonRetour.setBorder(bordure);
        boutonRetour.setForeground(Color.white);
        boutonRetour.setFont(new Font("Arial", Font.BOLD, 30));
        
        flecheGauche.setIcon(flecheGaucheImage);
        flecheGauche.setBorder(bordure);
        flecheGauche.setBackground(vertFond);
        flecheGauche.setForeground(Color.white);
        
        flecheDroite.setIcon(flecheGaucheImage);
        flecheDroite.setBorder(bordure);
        flecheDroite.setBackground(vertFond);
        flecheDroite.setForeground(Color.white);
        
        
        pano.setBackground(vertFond);
        //placement heure
        heureAffiche(cont, pano);
        //placement prochain traitement + nb cases restantes
        infosMenuAffiche(cont, pano);
        //placement bouton rouge
        //placement des boutons menu
        boutonsMenuAffiche(cont, pano);
        //placement led de marche
        ledMarcheAffiche(cont, pano);
        //placement boutons menu SU
        boutonMenuSUAffiche(cont, pano);
        //placement bouton retour
        boutonRetourAffiche(cont, pano);
        //placement fleches
        flechesAffiche(cont, pano);
        //placement infos ecriture
        infosEcritureAffiche(cont, pano);
        
        
        this.setContentPane(pano);
        this.pack();
        
        infosEcritureVisible(false);
        flechesVisible(false);
        boutonMenuSUVisible(false);
        boutonRetourVisible(false);
        boutonAlerte.setVisible(false);
        
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
        if(e.getSource()==panicButton){
            infosMenuVisible(false);
            boutonAlerteAffiche(cont, pano, "Heure du traitement");
            boutonAlerteVisible(true);
            System.out.println("panic button pressed");
        }
        
        else if(e.getSource()==informations){
            ledMarche.couleurLedChange(Color.green);
            System.out.println("bouton informations pressed");
        }
        else if(e.getSource()==calendrier){
            ledMarche.couleurLedChange(Color.red);
            System.out.println("bouton calendrier pressed");
        }else if(e.getSource()==menuSU){
            boutonAlerteVisible(false);
            boutonsMenuVisible(false);
            infosMenuVisible(false);
            boutonRetourVisible(true);
            boutonMenuSUVisible(true);
        }
        else if(e.getSource()==boutonAlerte){
            System.out.println("bouton alerte pressed");
        }
        else if(e.getSource()==boutonRetour){
            boutonRetourVisible(false);
            boutonMenuSUVisible(false);
            boutonsMenuVisible(true);
            infosMenuVisible(true);
            flechesVisible(false);
            infosEcritureVisible(false);
        }
        else if(e.getSource()==boutonMenuSU0){
            System.out.println("bouton menu SU0 pressed");
            boutonMenuSUVisible(false);
            flechesVisible(true);
            boutonRetourVisible(true);
            infosEcritureVisible(true);
        }
        else if(e.getSource()==boutonMenuSU1)
            System.out.println("bouton menu SU1 pressed");
        else if(e.getSource()==boutonMenuSU2)
            System.out.println("bouton menu SU2 pressed");
        else if(e.getSource()==nomEcriture){
            nomEcriture.setText(" ");
            System.out.println("zebi");
        }
    }
    
    public void infosEcritureAffiche(GridBagConstraints cont, JPanel pano){
        cont.gridwidth=4;
        cont.gridx=2;
        cont.gridy=1;
        pano.add(nomEcriture, cont);
        cont.gridy=2;
        pano.add(prenomEcriture, cont);
        cont.gridy=3;
        pano.add(ageEcriture, cont);
        cont.gridy=4;
        pano.add(adresseEcriture, cont);
        cont.gridy=5;
        pano.add(telEcriture, cont);
        cont.gridy=6;
        pano.add(mailEcriture, cont);
        cont.gridwidth=1;
    }
    
    
    public void flechesAffiche(GridBagConstraints cont, JPanel pano){
        cont.gridwidth=1;
        cont.gridheight=6;
        cont.gridx=0;
        cont.gridy=1;
        pano.add(flecheGauche, cont);
        cont.gridx=6;
        pano.add(flecheDroite, cont);
        cont.gridheight=1;
    }
    
    public void infosReferentEcritureAffiche(GridBagConstraints cont, JPanel pano){
        cont.gridx=1;
        cont.gridy=1;
    }
    
    public void boutonsMenuAffiche(GridBagConstraints cont, JPanel pano){
        cont.weightx=1;
        cont.insets=new Insets(20, 5, 20, 5);
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
    
    public void boutonAlerteAffiche(GridBagConstraints cont, JPanel pano, String msg){
        boutonAlerte.setText(msg);
        cont.fill=GridBagConstraints.BOTH;
        cont.anchor=GridBagConstraints.CENTER;
        cont.insets=new Insets(68, 5, 68, 5);
        cont.gridx=0;
        cont.gridheight=2;
        cont.gridwidth=4;
        cont.gridy=1;
        pano.add(boutonAlerte, cont);
        cont.gridheight=1;
        cont.gridwidth=1;
        cont.insets=new Insets(5, 5, 5, 5);
    }
    
    public void boutonMenuSUAffiche(GridBagConstraints cont, JPanel pano){
        cont.fill=GridBagConstraints.BOTH;
        cont.gridx=0;
        cont.gridy=1;
        cont.gridwidth=4;
        cont.insets=new Insets(45, 5, 5, 5);
        boutonMenuSU0.setText("Informations");
        pano.add(boutonMenuSU0, cont);
        cont.insets=new Insets(5, 5, 5, 5);
        cont.gridy=2;
        boutonMenuSU1.setText("Remplissage");
        pano.add(boutonMenuSU1, cont);
        cont.gridy=3;
        boutonMenuSU2.setText("Historique");
        cont.insets=new Insets(5, 5, 45, 5);
        pano.add(boutonMenuSU2, cont);
        cont.insets=new Insets(5, 5, 5, 5);
        cont.gridwidth=1;
    }
    
    public void boutonRetourAffiche(GridBagConstraints cont, JPanel pano){
        cont.fill=GridBagConstraints.BOTH;
        cont.gridy=8;
        cont.gridx=0;
        cont.gridwidth=10;
        cont.gridheight=1;
        pano.add(boutonRetour, cont);
    }
    
    public void heureAffiche(GridBagConstraints cont, JPanel pano){
        cont.insets=new Insets(5, 5, 5, 5);
        cont.fill=GridBagConstraints.BOTH;
        cont.anchor=GridBagConstraints.NORTHWEST;
        cont.gridwidth=3;
        cont.gridx=0;
        cont.gridy=0;
        pano.add(heureAffiche, cont);
        cont.gridwidth=1;
    }
    
    public void ledMarcheAffiche(GridBagConstraints cont, JPanel pano){
        cont.gridy=0;
        cont.gridx=3;
        cont.fill=GridBagConstraints.NONE;
        cont.anchor=GridBagConstraints.NORTHEAST;
        pano.add(ledMarche, cont);
    }
    
    public void infosMenuAffiche(GridBagConstraints cont, JPanel pano){
        cont.fill=GridBagConstraints.BOTH;
        cont.gridheight=2;
        cont.gridwidth=4;
        cont.gridy=1;
        cont.gridx=0;
        cont.fill=GridBagConstraints.BOTH;
        cont.insets=new Insets(52, 5, 50, 5);
        pano.add(infosMenu, cont);
        cont.gridheight=1;
        cont.gridwidth=1;
        cont.insets=new Insets(5, 5, 5, 5);
    }
    
    
    public void boutonsMenuVisible(boolean b){
        calendrier.setVisible(b);
        informations.setVisible(b);
        menuSU.setVisible(b);
        panicButton.setVisible(b);
    }
     
    public void boutonAlerteVisible(boolean b){
        boutonAlerte.setVisible(b);
    }
    public void boutonRetourVisible(boolean b){
        boutonRetour.setVisible(b);
    }
    
    public void infosMenuVisible(boolean b){
        infosMenu.setVisible(b);
    }
    
    public void ledMarcheVisible(boolean b){
        ledMarche.setVisible(b);
    }
    
    public void heureVisible(boolean b){
        heureAffiche.setVisible(b);
    }
    
    public void boutonMenuSUVisible(boolean b){
        boutonMenuSU0.setVisible(b);
        boutonMenuSU1.setVisible(b);
        boutonMenuSU2.setVisible(b);
    }
    
    public void flechesVisible(boolean b){
        flecheGauche.setVisible(b);
        flecheDroite.setVisible(b);
    }
    
    public void infosEcritureVisible(boolean b){
        nomEcriture.setVisible(b);
        prenomEcriture.setVisible(b);
        ageEcriture.setVisible(b);
        mailEcriture.setVisible(b);
        telEcriture.setVisible(b);
        adresseEcriture.setVisible(b);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource()==nomEcriture)
            nomEcriture.setText("");
        else if(e.getSource()==telEcriture)
        telEcriture.setText("");
        else if(e.getSource()==mailEcriture)
        mailEcriture.setText("");
        else if(e.getSource()==prenomEcriture)
        prenomEcriture.setText("");
        else if(e.getSource()==ageEcriture)
        ageEcriture.setText("");
        else if(e.getSource()==adresseEcriture)
        adresseEcriture.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
