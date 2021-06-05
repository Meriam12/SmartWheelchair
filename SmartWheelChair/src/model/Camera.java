/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.CheckBrake;
import events.ScanObject;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meriam
 */
public class Camera extends Thread{
    
   private String scannedOject;
   //private boolean scannedObject;
   private String[] listOfObject = {"tree","wall", "door", "smoke"} ;
   private Wheelchair wheelchair;
   

    public Camera() {
        
    // listOfObject = {"tree","wall", "door", "smoke"};
    }

    public Camera(String scannedOject) {
        this.scannedOject = scannedOject;
    }

    public Camera(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    
        public void setScannedOject(String scannedOject) {
        this.scannedOject = scannedOject;
    }
    
    public String getScannedOject() {
        return scannedOject;
    }

    public String[] getListOfObject() {
        return listOfObject;
    }


    public String recognizeObject()
   
    {
    int idx = new Random().nextInt(getListOfObject().length);
        String random = (getListOfObject() [idx]);
        System.out.println(random);
        setScannedOject(random);
        return random;
    }
   @Override
    public void run() {
        while (true) {
            recognizeObject();
            wheelchair.identifyObject(getScannedOject());
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FingerprintSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //config.sendEvent(new ScanFingerPrint(fingerPrint);
            config.sendEvent(new ScanObject(scannedOject));
        }
    }
}
