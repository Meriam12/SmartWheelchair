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

/**
 *
 * @author Shrouk
 */
public class Joystick extends Thread {
    private String currentSelection;
        private Brake brake;

    public Joystick() {
    }

    public Joystick(String currentSelection, Brake brake) {
        this.currentSelection = currentSelection;
        this.brake = brake;
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
    //@Override
    public void StartMoving(){
        
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
            config.sendEvent(new ScanJoyStickMovement(currentSelection));
        }
    }
}
