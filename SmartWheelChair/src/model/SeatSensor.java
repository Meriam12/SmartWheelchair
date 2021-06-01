/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.ObjectDetectionReading;
import events.ScanSeatSensor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toumie
 */
public class SeatSensor extends Thread {
   
private boolean seatState;
private Wheelchair wheelchair;

    public SeatSensor() {
    }

    public SeatSensor(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    
    public SeatSensor(boolean seatState) {
        this.seatState = seatState;
    }

    public void setSeatState(boolean seatState) {
        this.seatState = seatState;
    }

    public boolean isSeatState() {
        return seatState;
    }

public boolean detectBody()
{
    return true;
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
            config.sendEvent(new ScanSeatSensor(seatState));
        }
    }
  


}
