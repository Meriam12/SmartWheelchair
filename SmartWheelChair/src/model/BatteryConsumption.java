/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.CheckBatteryLevel;
import events.ScanFingerPrint;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mariam
 */
public class BatteryConsumption extends Thread{
    private int batteryLevel;
    private Wheelchair wheelchair;
    
    public BatteryConsumption() {
    }

    public BatteryConsumption(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

      public BatteryConsumption(Wheelchair wheelchair) {
       this.wheelchair = wheelchair;
       this.batteryLevel = 100;
    }

        
    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    
    public String monitorBatteryLevel (int batteryLevel) {
        
        return "h";
    }
    

    public  int chargeBattery()
    {
        batteryLevel =100;
        
        return batteryLevel;
    }
    
   //extends Thread
 @Override
    public void run() {
        while (true) {
            //wheelchair.getFingerprintSensor().raiseTemp();
            try {
                this.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FingerprintSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //config.sendEvent(new ScanFingerPrint(fingerPrint);
            config.sendEvent(new CheckBatteryLevel(batteryLevel));
        }
    }

    
}
