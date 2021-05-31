/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Mariam
 */
public class Screen {
        private GPSTracker tracker;
        private ArrayList<String> destination;
        private BatteryConsumption batteryConsumption;
        private Brake brake;
        private HealthSensor healthSensor;

    public Screen() {
    }

    public Screen(GPSTracker tracker, ArrayList<String> destination, BatteryConsumption batteryConsumption, Brake brake, HealthSensor healthSensor) {
        this.tracker = tracker;
        this.destination = destination;
        this.batteryConsumption = batteryConsumption;
        this.brake = brake;
        this.healthSensor = healthSensor;
    }

    public void setTracker(GPSTracker tracker) {
        this.tracker = tracker;
    }

    public void setDestination(ArrayList<String> destination) {
        this.destination = destination;
    }

    public void setBatteryConsumption(BatteryConsumption batteryConsumption) {
        this.batteryConsumption = batteryConsumption;
    }

    public void setBrake(Brake brake) {
        this.brake = brake;
    }

    public void setHealthSensor(HealthSensor healthSensor) {
        this.healthSensor = healthSensor;
    }

    public GPSTracker getTracker() {
        return tracker;
    }

    public ArrayList<String> getDestination() {
        return destination;
    }

    public BatteryConsumption getBatteryConsumption() {
        return batteryConsumption;
    }

    public Brake getBrake() {
        return brake;
    }

    public HealthSensor getHealthSensor() {
        return healthSensor;
    }
        
        public float getSpeed(){
            
            return 1;
        }
        
        public String readDestnation(){
            return "m";
        }
        
        public String showDirections(){
            return "m";
        }
        
        public int showBatteryLevel(){
            return 1; 
        }
        
        public String selectSpeed(Brake brake){
            return "m";
        }
        
        public void showHealth(HealthSensor HealthSensor){
            
        }
        
        public int showSpeed(Brake brake){
            return 1;
        }
        
        public String NotifyForBeltSeat(){
            
            return "m";
        }
        
        public String NotifyForBattaryLow(){
            return "m";
        }
        
        public String NotifyForBatteryFull(){
            return "m";
        }
}
