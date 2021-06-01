/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.CheckBrake;
import events.ScanObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meriam
 */
public class Camera extends Thread{
    
   private String scannedOject;
   private boolean scannedObject;
   

    public Camera() {
    }

    public Camera(String scannedOject) {
        this.scannedOject = scannedOject;
    }

        public void setScannedOject(String scannedOject) {
        this.scannedOject = scannedOject;
    }
    
    public String getScannedOject() {
        return scannedOject;
    }


    public void recognizeObject()
   
    {
    
    }
   @Override
    public void run() {
        while (true) {
            //wheelchair.getFingerprintSensor().raiseTemp();
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FingerprintSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //config.sendEvent(new ScanFingerPrint(fingerPrint);
            config.sendEvent(new ScanObject(scannedObject));
        }
    }
}
