/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Mariam
 */
public class BatteryConsumption {
    private int batteryLevel;

    public BatteryConsumption() {
    }

    public BatteryConsumption(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    
    public String monitorBatteryLevel (batteryLevel) {
        
        return "h";
    }
    
    public void chargeBattery(){
        
    }
}
