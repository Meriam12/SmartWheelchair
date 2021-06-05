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
private Wheelchair wheelchair;

    public BeltSensor() {
    }

    public BeltSensor(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
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


//in class BeltSensor
public void checkBelt(boolean beltState)
{
if (beltState == true )
    this.beltState = true;
else 
    this.beltState = false;
}
    
 //extends Thread
 @Override
    public void run() {
        while (true) {
           wheelchair.seatBeltsignal();
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BeltSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //config.sendEvent(new ScanFingerPrint(fingerPrint);
            config.sendEvent(new ScanBeltSensor(beltState));
        }
    }

  
    
    
}
