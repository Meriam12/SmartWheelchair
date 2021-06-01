/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.CheckBatteryLevel;
import events.ScanBeltSensor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toumie
 */
public class BeltSensor extends Thread {
    
private boolean beltState;

    public BeltSensor() {
    }

    public BeltSensor(boolean beltState) {
        this.beltState = beltState;
    }

    public void setBeltState(boolean beltState) {
        this.beltState = beltState;
    }

    public boolean isBeltState() {
        return beltState;
    }

public void checkBelt(boolean beltState)
{

}
    
 //extends Thread
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
            config.sendEvent(new ScanBeltSensor(beltState));
        }
    }
  
    
    
}
