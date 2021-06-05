/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.ScanObject;
import events.TakeDistination;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GUI;

/**
 *
 * @author TOUMIE
 */
public class GPSTracker extends Thread {
     private GUI gui;
    private String currentLocation;
    private String Destination;

    public GPSTracker() {
    }

    public GPSTracker(String currentLocation, String Destination) {
        gui = new GUI();
        this.currentLocation = currentLocation;
        this.Destination = Destination;
    }
//
//    public String getCurrentLocation() {
//        currentLocation = gui.getjTextField1().getText();
//         if (currentLocation=="cairo")
//         {
//             String res= currentLocation= one;
//         } else {
//         String res= currentLocation= two;}
//        return currentLocation;
//    }

    public String getDestination() {
        return Destination;
    }

    public void setCurrentLocation(String currentLocation) {
       
      //  this.currentLocation = currentLocation;
         this.currentLocation = gui.getjTextField1().getText();
         
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }
    
    public double calculateDistance(String currentLocation, String Destination)
    {
    return 0;
    }
    
    public String changeDirection()
    {
    return ("");
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
            config.sendEvent(new TakeDistination(Destination));
        }
    }
}
