/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.ScanFingerPrint;
import view.SeatSensorView;
import view.wheelchairView;

/**
 *
 * @author a_h_s
 */




//----------------------------------------------------CONTROLLER------------------------------------///
public class Wheelchair implements Movement {
    
    private BeltSensor beltSensor;
    private FingerprintSensor fingerprintSensor;
    private SeatSensor seatSensor;
    private Screen screen;
    
    private wheelchairView gui;
    private SeatSensorView seatSensorView;
              
     private boolean seatStatus = false;

    // This acts as our ON/OFF switch
    private boolean state = false;

    public Wheelchair() {
        gui = new wheelchairView();
        seatSensorView = new    SeatSensorView();
        gui.setLocationRelativeTo(null);
       // gui.setVisible(true);
       seatSensorView.setVisible(true);
        fingerprintSensor = new FingerprintSensor(this);
        beltSensor = new BeltSensor(this);
        seatSensor = new SeatSensor(this);
        fingerprintSensor.start();
        beltSensor.start();
        seatSensor.start();
        
        
    }
    


    public Wheelchair(BeltSensor beltSensor, FingerprintSensor fingerprintSensor, SeatSensor seatSensor, Screen screen) {
        this.beltSensor = beltSensor;
        this.fingerprintSensor = fingerprintSensor;
        this.seatSensor = seatSensor;
        this.screen = screen;
        
    }


     public void tempSignal(int fingerPrint) throws InterruptedException {
        //System.out.println("The temp is now " + temp);
        //gui.getCurrentTempTxt().setText(temp + "");
        gui.getcurrentFINGERPRINTTxt().setText(fingerPrint +"");
        
        if (fingerPrint <= 100) {
           // beeper.beep();
            config.sendEvent(new ScanFingerPrint(0));
        }
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

    public wheelchairView getGui() {
        return gui;
    }
    
    public SeatSensorView getGuiSeatSensor(){
        return seatSensorView;
    }
    
    
    @Override
    public void startMoving(){
    
    System.out.print("Ayyy 7aga");
    
    }

        
        public void setSeatStatusInGUI(boolean status){
            seatStatus = status;
            this.seatSensor.setSeatStatusInGUI(status);
        }
  

    
}
