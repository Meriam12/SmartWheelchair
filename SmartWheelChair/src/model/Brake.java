/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.CheckBrake;
import events.ScanBeltSensor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meriam
 */
public class Brake extends Thread{
    
    private int speed;
    private boolean brakeState;
    private Wheelchair wheelchair;

    public Brake(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    
    
    public Brake ()
    {
    
    }
    
    public Brake(int speed) {
        this.speed = speed;
    }


    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
   
    public int getSpeed() {
        return speed;
    }
    
    
    public String Stop()
    {
        String m = "";
        
        return m;
       
    }
    
    
        public String slowDown()
    {
        String m = "";
        
        return m;
    }
    
        
        public String accelerate()
    {
        String m = "";
        
        return m;
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
            config.sendEvent(new CheckBrake(brakeState,speed));
        }
    }
}
