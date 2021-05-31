/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author a_h_s
 */
public class Wheelchair implements Movement {
    private BeltSensor beltSensor;
    private  FingerprintSensor fingerprintSensor;
    private SeatSensor seatSensor;
    private Screen screen;

    public Wheelchair(BeltSensor beltSensor, FingerprintSensor fingerprintSensor, SeatSensor seatSensor, Screen screen) {
        this.beltSensor = beltSensor;
        this.fingerprintSensor = fingerprintSensor;
        this.seatSensor = seatSensor;
        this.screen = screen;
    }

    public Wheelchair() {
    }

    public BeltSensor getBeltSensor() {
        return beltSensor;
    }

    public void setBeltSensor(BeltSensor beltSensor) {
        this.beltSensor = beltSensor;
    }

    public FingerprintSensor getFingerprintSensor() {
        return fingerprintSensor;
    }

    public void setFingerprintSensor(FingerprintSensor fingerprintSensor) {
        this.fingerprintSensor = fingerprintSensor;
    }

    public SeatSensor getSeatSensor() {
        return seatSensor;
    }

    public void setSeatSensor(SeatSensor seatSensor) {
        this.seatSensor = seatSensor;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
    
    
    
    
    
    
    
    
    public void startMoving(){
    
    System.out.print("Ayyy 7aga");
    
    }
    
    
}
