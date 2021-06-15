/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.modele;

/**
 *
 * @author p2007867
 */
public class Moteur {
    protected int angleRotation;
    
    public Moteur(int angle){
        angleRotation= angle;
        
    }
    private void setAngle(int angle){
        angleRotation= angle;
    }
    private int getAngleRotation(){
        return angleRotation;
    }
   // public boolean rotation(){
  
    //}
}