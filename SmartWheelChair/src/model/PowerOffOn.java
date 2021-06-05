/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.PowerON;
import events.ScanSeatSensor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a_h_s
 */
public class PowerOffOn  extends Thread {
    boolean state;
Wheelchair wheelchair;
    public PowerOffOn(boolean state) {
        this.state = state;
    }

    public PowerOffOn(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
        state = false;
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
            config.sendEvent(new PowerON (state));
        }
    }
    
}
