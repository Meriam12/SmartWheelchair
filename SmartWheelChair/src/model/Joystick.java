/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.ScanJoyStickMovement;
import events.ScanObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GUI;

    

/**
 *
 * @author Shrouk
 */
public class Joystick extends Thread {
    private String currentSelection;
        private Brake brake;
        private GUI gui1;
        private Wheelchair wheelchair;
        
    public Joystick() {
    }

    public Joystick(String currentSelection, Brake brake) {
        this.currentSelection = currentSelection;
        this.brake = brake;
    }

    public Joystick(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
     //   brake.setSpeed(0);
    }

    public void setCurrentSelection(String currentSelection) {
        this.currentSelection = currentSelection;
    }

    public void setBrake(Brake brake) {
        this.brake = brake;
    }

    public String getCurrentSelection() {
        return currentSelection;
    }

    public Brake getBrake() {
        return brake;
    }
    public String setDirection(String direction) {
       return direction;
    }
    
    public int getBrakeSpeed(){
      int s = brake.getSpeed();
      return s;
    }
    
 @Override
    public void run() {
        while (true) {
            //wheelchair.getFingerprintSensor().raiseTemp();
        // wheelchair.StartMoving(brake.getSpeed());
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FingerprintSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //config.sendEvent(new ScanFingerPrint(fingerPrint);
            config.sendEvent(new ScanJoyStickMovement());
        }
    }
}