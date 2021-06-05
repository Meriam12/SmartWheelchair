/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import java.util.Random;
import events.ScanFingerPrint;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GUI;

/**
 *
 * @author TOUMIE
 */
public class FingerprintSensor extends Thread {
    
private boolean fingerprintState;
private int fingerPrint;   // deh el value ely hangebha mn el GUI
private Wheelchair wheelchair;
private int userFingerprint;
 private GUI gui1;
 
    public FingerprintSensor() {
    }

     public FingerprintSensor(Wheelchair wheelchair) {
         this.wheelchair = wheelchair;
         this.fingerPrint = 10;
          userFingerprint = 3;
    }

    public int getUserFingerprint() {
        return userFingerprint;
    }
     
     

    public FingerprintSensor(int fingerPrint) {
        this.fingerPrint = fingerPrint;
    }
     private int random(int min, int max) {
        
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
     
       public void raiseTemp() {
        fingerPrint += random(5, 10);
    }
    
    public FingerprintSensor(boolean fingerprintState) {
        this.fingerprintState = fingerprintState;
        this.fingerPrint = fingerPrint;
    }

    public void setFingerprintState(boolean fingerprintState) {
        this.fingerprintState = fingerprintState;
    }

    public boolean isFingerprintState() {
        return fingerprintState;
    }

    public int getFingerPrint() {
        return fingerPrint;
    }
    
 
public boolean IdentifyFingerprint(int temp)
{
   return true; 
} 

//   public void fingerprintScan() throws InterruptedException {
//       
//         if(gui1.getjRadioButton4().isSelected() == true){ //power
//        
//                gui1.getjRadioButton3().setEnabled(true); //fingerprint
////                gui1.getjRadioButton1().setEnabled(false);//seat 
////                gui1.getjRadioButton2().setEnabled(false); //seat belt
//
//                                if(gui1.getjRadioButton3().isSelected()){     //fingerprint
//                                    
//                                    int f = Integer.parseInt(gui1.getFingerprintField().getText());
//                                                if (f == this.getUserFingerprint()) {
//                                                    gui1.getFingerprint_status().setText("Status: Valid fingerprint");
//                                                    System.out.println("Status: Valid fingerprint");
//                                                     gui1.getjRadioButton1().setEnabled(true); //seat
//                                                     
//                                                }
//                                                else{
//                                                    gui1.getFingerprint_status().setText("Status: Invalid fingerprint");
//                                                     System.out.println("Status: Invalid fingerprint");
//                                                }
//                                }
//                                
//                                else{
//                                    
//                                }
//            }
//                 else{ //// else bta3t el power button
//                     gui1.getjRadioButton3().setEnabled(false);
//                     gui1.getjRadioButton1().setEnabled(false);
//                     gui1.getjRadioButton2().setEnabled(false);
//                 }
// }
    
    
//extends Thread
 @Override
    public void run() {
        while (true) {
            wheelchair.getFingerprintSensor().raiseTemp();
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FingerprintSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            config.sendEvent(new ScanFingerPrint(fingerPrint));
        }
    }
}
