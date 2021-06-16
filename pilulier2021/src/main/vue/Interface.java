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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import main.modele.Pilulier;

/**
 *
 * @author p2008965
 */
public class Interface extends JFrame implements ActionListener, FocusListener{
    private JLabel heureAffiche=new JLabel(), infoAdresse=new JLabel(), infoTel=new JLabel(), infoMail=new JLabel(), infoFonction=new JLabel(), infoPrenom=new JLabel(), infoNom=new JLabel(), case1=new JLabel(), case2=new JLabel(), case3=new JLabel(), case4=new JLabel(), case5=new JLabel(), case6=new JLabel(), case7=new JLabel(), case8=new JLabel(), caseRemplissage=new JLabel(), caseMois=new JLabel(), caseJour=new JLabel(), caseHeure=new JLabel(), caseMinute=new JLabel(), retardAccepte=new JLabel();
    private JTextArea infosMenu=new JTextArea();
    private JTextField nomEcriture=new JTextField(), prenomEcriture=new JTextField(), fonctionEcriture=new JTextField(), adresseEcriture=new JTextField(), mailEcriture=new JTextField(), telEcriture=new JTextField();
    private JButton calendrier=new JButton(), informations=new JButton(), menuSU=new JButton(), panicButton=new JButton(), boutonAlerte=new JButton(), boutonMenuSU0=new JButton(), boutonMenuSU1=new JButton(), boutonMenuSU2=new JButton(), boutonRetour=new JButton(), flecheGauche=new JButton(), flecheDroite=new JButton(), validerNom=new JButton(),validerPrenom=new JButton(), validerAdresse=new JButton(), validerFonction=new JButton(), validerMail=new JButton(), validerTel=new JButton();
    private LedMarche ledMarche= new LedMarche();
    private JComboBox boxMois=new JComboBox(), boxJour=new JComboBox(), boxHeure=new JComboBox(), boxMinute=new JComboBox();
    private JCheckBox checkRetard=new JCheckBox();
    
    private Pilulier pilulier;
    
    EnumEtat etat;
    
    JPanel pano=new JPanel();
    GridBagConstraints cont=new GridBagConstraints();
    
    //boolean qui dit si il faure retourner au menu principal ou menu SU
    boolean tmp=true;
    
    ImageIcon imageBase=new ImageIcon(getClass().getResource("images/panicImage.png"));
    Image image = imageBase.getImage();
    Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon panicImage = new ImageIcon(newimg);
    
    ImageIcon imageBase2=new ImageIcon(getClass().getResource("images/calendrierImage.png"));
    Image image2 = imageBase2.getImage();
    Image newimg2 = image2.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon calendrierImage = new ImageIcon(newimg2);
    
    ImageIcon imageBase3=new ImageIcon(getClass().getResource("images/informationImage.png"));
    Image image3 = imageBase3.getImage();
    Image newimg3 = image3.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
    ImageIcon informationsImage = new ImageIcon(newimg3);
    
    ImageIcon imageBase4=new ImageIcon(getClass().getResource("images/menuSUImage.png"));
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
    
    public Interface(Pilulier p) throws InterruptedException{
        pilulier=p;
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
        fonctionEcriture.addFocusListener(this);
        validerNom.addActionListener(this);
        validerPrenom.addActionListener(this);
        validerAdresse.addActionListener(this);
        validerFonction.addActionListener(this);
        validerTel.addActionListener(this);
        validerMail.addActionListener(this);
    }
    
    public void initialisation(){
        pano.setLayout(new GridBagLayout());
        GridBagConstraints cont=new GridBagConstraints();
        Date heure=new Date();
        Border bordure=BorderFactory.createLineBorder(Color.white);
        String newLine=System.getProperty("line.separator");
        
        
        //création des composants
        
        //checkBox remplissage
        
        
        //remplissage des ComboBox (calendrier remplissage)
        boxMois.addItem("Mois");
        for (int i = 1; i < 13; i++) {
            boxMois.addItem(i);
        }
        boxJour.addItem("Jour");
        for (int i = 1; i < 32; i++) {
            boxJour.addItem(i);
        }
        boxHeure.addItem("Heure");
        for (int i = 1; i < 24; i++) {
            boxHeure.addItem(i);
        }
        boxMinute.addItem("Minute");
        for (int i = 0; i < 60; i+=10) {
            boxMinute.addItem(i);
        }
        
        //heure
        setHeureAffiche();
        setLabel(heureAffiche, 65, transparent, false,  "");
        
        //labels information
        setLabel(infoNom, 30, transparent, false, "Nom :");
        setLabel(infoPrenom, 30, transparent, false, "Prenom :");
        setLabel(infoAdresse, 30, transparent, false, "Adresse :");
        setLabel(infoFonction, 30, transparent, false, "Fonction :");
        setLabel(infoTel, 30, transparent, false, "Tel :");
        setLabel(infoMail, 30, transparent, false, "Mail :");
        
        //informations menu
        infosMenu.setFont(new Font("Arial", Font.BOLD, 30));
        infosMenu.setForeground(Color.white);
        infosMenu.setText("Prochain traitement dans 20 minutes"+newLine+newLine+"3 cases restantes");
        infosMenu.setBackground(vertFond);
        
        //label numéro case
        setLabel(caseRemplissage, 30, Color.white, true, "Case 1");
        
        //labels box remplissage
        setLabel(caseMois, 20, Color.white, true, "Mois");
        setLabel(caseJour, 20, Color.white, true, "Jour");
        setLabel(caseHeure, 20, Color.white, true, "Heure");
        setLabel(caseMinute, 20, Color.white, true, "Minute");
        
        //fields information
        setTextFieldInfo(nomEcriture, "Nom");
        setTextFieldInfo(prenomEcriture, "Prenom");
        setTextFieldInfo(adresseEcriture, "Adresse");
        setTextFieldInfo(fonctionEcriture, "Fonction");
        setTextFieldInfo(mailEcriture, "Mail");
        setTextFieldInfo(telEcriture, "Tel");
        
        //boutons menu
        setBoutonMenu(menuSU, menuSUImage);
        setBoutonMenu(calendrier, calendrierImage);
        setBoutonMenu(informations, informationsImage);
        setBoutonMenu(panicButton, panicImage);
        
        //bouton alerte
        setBoutonTexte(boutonAlerte, "", 60, Color.red);     
        
        //boutons menu SU
        setBoutonTexte(boutonMenuSU0, "Informations", 50, Color.white);
        setBoutonTexte(boutonMenuSU1, "Remplissage", 50, Color.white);
        setBoutonTexte(boutonMenuSU2, "Historique", 50, Color.white);
        
        //bouton retour
        setBoutonTexte(boutonRetour, "Retour", 30, Color.white);
        
        //flèches menus
        setFleche(flecheGauche, flecheGaucheImage);
        setFleche(flecheDroite, flecheGaucheImage);
        
        //boutons valider information
        setBoutonIcon(validerNom, flecheGaucheImage);
        setBoutonIcon(validerPrenom, flecheGaucheImage);
        setBoutonIcon(validerAdresse, flecheGaucheImage);
        setBoutonIcon(validerFonction, flecheGaucheImage);
        setBoutonIcon(validerTel, flecheGaucheImage);
        setBoutonIcon(validerMail, flecheGaucheImage);
        
        //cases calendrier
        setLabel(case1, 30, Color.white, true, "<html>Case 1<br/>15 / 06<br/>22 : 15</html>");
        setLabel(case2, 30, Color.white, true, "<html>Case 2<br/>15 / 06<br/>22 : 15</html>");
        setLabel(case3, 30, Color.white, true, "<html>Case 3<br/>15 / 06<br/>22 : 15</html>");
        setLabel(case4, 30, Color.white, true, "<html>Case 4<br/>15 / 06<br/>22 : 15</html>");
        setLabel(case5, 30, Color.white, true, "<html>Case 5<br/>15 / 06<br/>22 : 15</html>");
        setLabel(case6, 30, Color.white, true, "<html>Case 6<br/>15 / 06<br/>22 : 15</html>");
        setLabel(case7, 30, Color.white, true, "<html>Case 7<br/>15 / 06<br/>22 : 15</html>");
        setLabel(case8, 30, Color.white, true, "<html>Case 8<br/>15 / 06<br/>22 : 15</html>");
        
        //comboBox remplissage
        setComboBox(boxMois);
        setComboBox(boxJour);
        setComboBox(boxHeure);
        setComboBox(boxMinute);
        
        //label retard accepté
        setLabel(retardAccepte, 20, Color.white, true, "Retard accepté");
        
        pano.setBackground(vertFond);
        //placement heure
        heureAffiche(cont, pano);
        //placement prochain traitement + nb cases restantes
        infosMenuAffiche(cont, pano);
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
        //placement boutons valider infos
        boutonsValiderInfosAffiche(cont, pano);
        //placement labels infos
        infosLabelsAffiche(cont, pano);
        //placement cases menu calendrier
        casesCalendrierAffiche(cont, pano);
        //placement numéro case remplissage
        numCaseAffiche(cont, pano);
        //placement comboBox remplissage
        boxCalendrierAffiche(cont, pano);
        //placement checkBox retard remplissage
        checkRetardAffiche(cont, pano);
        
        this.setContentPane(pano);
        this.pack();
        
        //rend les éléments invisibles au lancement
        numCaseVisible(false);
        checkRetardVisible(false);
        boxCalendrierVisible(false);
        casesCalendrierVisible(false);
        infosLabelsVisible(false);
        boutonsValiderInfosVisible(false);
        infosEcritureVisible(false, false);
        flechesVisible(false);
        boutonMenuSUVisible(false);
        boutonRetourVisible(false);
        boutonAlerte.setVisible(false);
        
        etat=EnumEtat.MENU;
    }
    
    //mise à jour de l'heure
    public void setHeureAffiche(){
        Date heure=new Date();
        if (heure.getMinutes() < 10)
            heureAffiche.setText((heure.getHours()+": 0"+heure.getMinutes()));
        else
            heureAffiche.setText((heure.getHours()+":"+heure.getMinutes()));
    }

    //action listener
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==panicButton){
            infosMenuVisible(false);
            boutonAlerteAffiche(cont, pano, "Heure du traitement");
            boutonAlerteVisible(true);
            System.out.println("panic button pressed");
        }
        
        else if(e.getSource()==informations){
            etat=EnumEtat.INFOLECTURE;
            ledMarcheVisible(false);
            infosMenuVisible(false);
            boutonsMenuVisible(false);
            flechesVisible(true);
            boutonRetourVisible(true);
            infosEcritureVisible(true, false);
            infosLabelsVisible(true);
            boutonRetourVisible(true);
        }
        else if(e.getSource()==calendrier){
            System.out.println("bouton calendrier pressed");
            etat=EnumEtat.CALENDRIERLECTURE;
            //fonction qui set toutes les cases
            ledMarcheVisible(false);
            infosMenuVisible(false);
            boutonsMenuVisible(false);
            boutonRetourVisible(true);
            casesCalendrierVisible(true);
            
        }
        else if(e.getSource()==menuSU){
            tmp=true;
            etat=EnumEtat.MENUSU;
            ledMarcheVisible(false);
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
            switch(etat){
                case MENUSU:
                    boutonRetourVisible(false);
                    boutonMenuSUVisible(false);
                    break;
                case BADGE:
                    System.out.println("gg");
                    break;
                case INFOLECTURE:
                    flechesVisible(false);
                    infosEcritureVisible(false, false);
                    boutonsValiderInfosVisible(false);
                    infosLabelsVisible(false);
                    break;
                case INFOECRITURE:
                    flechesVisible(false);
                    infosEcritureVisible(false, true);
                    boutonsValiderInfosVisible(false);
                    infosLabelsVisible(false);
                    break;
                case CALENDRIERLECTURE:
                    casesCalendrierVisible(false);
                    break;
                case CALENDRIERECRITURE:
                    boxCalendrierVisible(false);
                    flechesVisible(false);
                    numCaseVisible(false);
                    checkRetardVisible(false);
                    break;
                case HISTORIQUE:
                    infosEcritureVisible(false, false);
                    flechesVisible(false);
                    break;
                    
                    
            }
            if(tmp==true){
                ledMarcheVisible(true);
                boutonRetourVisible(false);
                boutonMenuSUVisible(false);
                boutonsMenuVisible(true);
                infosMenuVisible(true);
                etat=EnumEtat.MENU;
            }
            else{
                boutonMenuSUVisible(true);
            }
            tmp=true;
        }
        else if(e.getSource()==boutonMenuSU0){
            etat=EnumEtat.INFOECRITURE;
            tmp=false;
            ledMarcheVisible(false);
            boutonMenuSUVisible(false);
            flechesVisible(true);
            boutonRetourVisible(true);
            infosEcritureVisible(true, true);
            boutonsValiderInfosVisible(true);
            infosLabelsVisible(true);
        }
        else if(e.getSource()==boutonMenuSU1){
            etat=EnumEtat.CALENDRIERECRITURE;
            tmp=false;
            boutonMenuSUVisible(false);
            boxCalendrierVisible(true);
            flechesVisible(true);
            numCaseVisible(true);
            checkRetardVisible(true);
            
        }
        else if(e.getSource()==boutonMenuSU2){
            tmp=false;
            System.out.println("bouton menu SU2 pressed");
            etat=EnumEtat.HISTORIQUE;
            boutonMenuSUVisible(false);
            flechesVisible(true);
            infosEcritureVisible(true, false);
        }            
        else if(e.getSource()==validerPrenom){
            pilulier.getPatient().setNom(nomEcriture.getText());
            System.out.println(pilulier.getPatient().getNom());
        }
        else if(e.getSource()==validerFonction)
            System.out.println("valider fonction pressed");
        else if(e.getSource()==validerAdresse)
            System.out.println("valider adresse pressed");
        else if(e.getSource()==validerTel)
            System.out.println("valider tel pressed");
        else if(e.getSource()==validerMail)
            System.out.println("valider mail pressed");
        else if(e.getSource()==validerNom)
            System.out.println("valider nom pressed");
    }
    
    //placement des éléments
    
    public void numCaseAffiche(GridBagConstraints cont, JPanel pano){
        cont.gridx=1; 
        cont.gridy=1;
        cont.gridwidth=3;
        pano.add(caseRemplissage, cont);
        cont.gridwidth=1;
    }
    
    public void checkRetardAffiche(GridBagConstraints cont, JPanel pano){
        cont.gridx=3;
        cont.gridy=3;
        cont.gridheight=2;
        pano.add(checkRetard, cont);
        cont.gridheight=1;
        cont.gridy=2;
        pano.add(retardAccepte, cont);
    }
    
    public void boxCalendrierAffiche(GridBagConstraints cont, JPanel pano){
        cont.gridx=1;
        cont.gridy=2;
        pano.add(caseMois, cont);
        cont.gridx=2;
        pano.add(caseJour, cont);
        cont.gridx=1;
        cont.gridy=3;
        pano.add(boxMois, cont);
        cont.gridx=2;
        pano.add(boxJour, cont);
        cont.gridy=4;
        cont.gridx=1;
        pano.add(caseHeure, cont);
        cont.gridx=2;
        pano.add(caseMinute, cont);
        cont.gridx=1;
        cont.gridy=5;
        pano.add(boxHeure, cont);
        cont.gridx=2;
        pano.add(boxMinute, cont);
    } 
    
    public void casesCalendrierAffiche(GridBagConstraints cont, JPanel pano){
        cont.insets=new Insets(10, 10, 10, 10);
        cont.gridx=0;
        cont.gridy=1;
        pano.add(case1, cont);
        cont.gridx=1;
        pano.add(case2, cont);
        cont.gridx=2;
        pano.add(case3, cont);
        cont.gridx=3;
        pano.add(case4, cont);
        cont.gridy=2;
        cont.gridx=0;
        pano.add(case5, cont);
        cont.gridx=1;
        pano.add(case6, cont);
        cont.gridx=2;
        pano.add(case7, cont);
        cont.gridx=3;
        pano.add(case8, cont);
    }
    
    public void infosLabelsAffiche(GridBagConstraints cont, JPanel pano){
        cont.weightx=1/2;
        cont.gridx=1;
        cont.gridy=1;
        pano.add(infoFonction, cont);
        cont.gridy=2;
        pano.add(infoPrenom, cont);
        cont.gridy=3;
        pano.add(infoNom, cont);
        cont.gridy=4;
        pano.add(infoAdresse, cont);
        cont.gridy=5;
        pano.add(infoTel, cont);
        cont.gridy=6;
        pano.add(infoMail, cont);
        cont.gridwidth=1;
        cont.weightx=1;
    }
    public void infosEcritureAffiche(GridBagConstraints cont, JPanel pano){
        cont.gridwidth=4;
        cont.weighty=2/1;
        cont.gridx=2;
        cont.gridy=1;
        pano.add(fonctionEcriture, cont);
        cont.gridy=2;
        pano.add(prenomEcriture, cont);
        cont.gridy=3;
        pano.add(nomEcriture, cont);
        cont.gridy=4;
        pano.add(adresseEcriture, cont);
        cont.gridy=5;
        pano.add(telEcriture, cont);
        cont.gridy=6;
        pano.add(mailEcriture, cont);
        cont.gridwidth=1;
        cont.weighty=1;
    }
    
    public void boutonsValiderInfosAffiche(GridBagConstraints cont, JPanel pano){
        cont.weightx=1/10;
        cont.gridheight=1;
        cont.gridx=6;
        cont.gridy=1;
        pano.add(validerFonction, cont);
        cont.gridy=2;
        pano.add(validerPrenom, cont);
        cont.gridy=3;
        pano.add(validerNom, cont);
        cont.gridy=4;
        pano.add(validerAdresse, cont);
        cont.gridy=5;
        pano.add(validerTel, cont);
        cont.gridy=6;
        pano.add(validerMail, cont);
        cont.weightx=1;
    }
    
    
    public void flechesAffiche(GridBagConstraints cont, JPanel pano){
        cont.gridwidth=1;
        cont.weightx=1/100;
        cont.gridheight=6;
        cont.gridx=0;
        cont.gridy=1;
        pano.add(flecheGauche, cont);
        cont.gridx=7;
        pano.add(flecheDroite, cont);
        cont.gridheight=1;
        cont.weightx=1;
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
        pano.add(boutonMenuSU0, cont);
        cont.insets=new Insets(5, 5, 5, 5);
        cont.gridy=2;
        pano.add(boutonMenuSU1, cont);
        cont.gridy=3;
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
    
    //rendre visible/invisible les éléments
    
    public void numCaseVisible(boolean b){
        caseRemplissage.setVisible(b);
    }
    
    public void boxCalendrierVisible(boolean b){
        boxMois.setVisible(b);
        boxJour.setVisible(b);
        boxHeure.setVisible(b);
        caseMinute.setVisible(b);
        caseMois.setVisible(b);
        caseJour.setVisible(b);
        caseHeure.setVisible(b);
        caseMinute.setVisible(b);
    }
    
    public void checkRetardVisible(boolean b){
        retardAccepte.setVisible(b);
        checkRetard.setVisible(b);
    }
    
    public void casesCalendrierVisible(boolean b){
        case1.setVisible(b);
        case2.setVisible(b);
        case3.setVisible(b);
        case4.setVisible(b);
        case5.setVisible(b);
        case6.setVisible(b);
        case7.setVisible(b);
        case8.setVisible(b);
    }
    
    public void infosLabelsVisible(boolean b){
        infoNom.setVisible(b);
        infoPrenom.setVisible(b);
        infoMail.setVisible(b);
        infoFonction.setVisible(b);
        infoTel.setVisible(b);
        infoAdresse.setVisible(b);
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
    
    public void infosEcritureVisible(boolean b, boolean c){
        nomEcriture.setVisible(b);
        prenomEcriture.setVisible(b);
        fonctionEcriture.setVisible(b);
        mailEcriture.setVisible(b);
        telEcriture.setVisible(b);
        adresseEcriture.setVisible(b);
        nomEcriture.setEditable(c);
        prenomEcriture.setEditable(c);
        fonctionEcriture.setEditable(c);
        telEcriture.setEditable(c);
        mailEcriture.setEditable(c);
        adresseEcriture.setEditable(c);
    }
    
    public void boutonsValiderInfosVisible(boolean b){
        validerNom.setVisible(b);
        validerPrenom.setVisible(b);
        validerFonction.setVisible(b);
        validerAdresse.setVisible(b);
        validerTel.setVisible(b);
        validerMail.setVisible(b);
    }

    
    //setters des éléments
    
    public void setCheckBox(JCheckBox bx){
        Border bordure = BorderFactory.createLineBorder(Color.white);
        bx.setBackground(vertFond);
    }
    
    public void setComboBox(JComboBox bx){
        Border bordure = BorderFactory.createLineBorder(Color.white);
        bx.setBackground(vertFond);
        bx.setBorder(bordure);
        bx.setForeground(Color.white);
        bx.setFont(new Font("Arial", Font.BOLD, 20));
    }
    
    public void setBoutonIcon(JButton bt, ImageIcon img){
        Border bordure = BorderFactory.createLineBorder(Color.white);
        bt.setBackground(vertFond);
        bt.setBorder(bordure);
        bt.setForeground(Color.white);
        bt.setIcon(img);
    }
    
    public void setBoutonMenu(JButton bt, ImageIcon img){
        bt.setIcon(img);
        bt.setOpaque(false);
        bt.setBorderPainted(false);
        bt.setBackground(vertFond);
    }
    
    public void setFleche(JButton bt, ImageIcon img){
        Border bordure = BorderFactory.createLineBorder(Color.white);
        bt.setIcon(img);
        bt.setBorder(bordure);
        bt.setBackground(vertFond);
        bt.setForeground(Color.white);
    }
    
    public void setBoutonTexte(JButton bt, String txt, int sze, Color clr){
        Border bordure = BorderFactory.createLineBorder(clr);
        bt.setText(txt);
        bt.setBackground(vertFond);
        bt.setBorder(bordure);
        bt.setForeground(clr);
        bt.setFont(new Font("Arial", Font.BOLD, sze));
    }
    
    public void setLabel(JLabel lbl, int sze,Color clr,boolean b, String txt){
        Border bordure = BorderFactory.createLineBorder(clr);
        if(b)
            lbl.setHorizontalAlignment(SwingConstants.CENTER);
        lbl.setBorder(bordure);
        lbl.setText(txt);
        lbl.setFont(new Font("Arial", Font.BOLD, sze));
        lbl.setForeground(Color.white);
    }
    
    public void setTextFieldInfo(JTextField txtf, String txt){
        Border bordure = BorderFactory.createLineBorder(Color.white);
        txtf.setBackground(vertFond);
        txtf.setForeground(Color.white);
        txtf.setBorder(bordure);
        txtf.setFont(new Font("Arial", Font.BOLD, 30));
        txtf.setText(txt);
    }
    
    //focus listeners
    @Override
    public void focusGained(FocusEvent e) {
        if(etat==EnumEtat.INFOECRITURE){
            if(e.getSource()==nomEcriture)
                nomEcriture.setText("");
            else if(e.getSource()==telEcriture)
            telEcriture.setText("");
            else if(e.getSource()==mailEcriture)
            mailEcriture.setText("");
            else if(e.getSource()==prenomEcriture)
            prenomEcriture.setText("");
            else if(e.getSource()==fonctionEcriture)
            fonctionEcriture.setText("");
            else if(e.getSource()==adresseEcriture)
            adresseEcriture.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        ;
    }
}
