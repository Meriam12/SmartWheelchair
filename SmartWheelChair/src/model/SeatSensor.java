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

    
    public void checkSeatSensor(int num){ //this num is in killos
        if (num < 20){   //since babies are not allowed to use this wheelchair
             setSeatState(false);
        }
        else{
            setSeatState(true);
        }
    }
  
    
    public void setSeatStatusInGUI(boolean status) {
        seatState = status;
        if (status) {
            wheelchair.getGuiSeatSensor().getjTextField1().setText("Valid");
        } else {
            wheelchair.getGuiSeatSensor().getjTextField1().setText("Invalid");
        }

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
