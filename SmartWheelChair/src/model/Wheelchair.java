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
import events.ScanSeatSensor;
import view.BatteryConsumptionView;
import view.GUI;

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
    private BatteryConsumption batteryCons;
    
    private wheelchairView gui;
    private SeatSensorView seatSensorView;
    private GUI gui1;
    
     private boolean seatStatus = false;

    // This acts as our ON/OFF switch
    private boolean state = false;

    public Wheelchair() {
       // gui = new wheelchairView();
       // seatSensorView = new    SeatSensorView();
        gui1 = new GUI();
      //  gui.setLocationRelativeTo(null);
       // gui.setVisible(true);
      // seatSensorView.setVisible(true);
      gui1.setLocationRelativeTo(null);
       gui1.setVisible(true);
       
       
        fingerprintSensor = new FingerprintSensor(this);
        beltSensor = new BeltSensor(this);
        seatSensor = new SeatSensor(this);
        batteryCons = new BatteryConsumption(this);
        
        fingerprintSensor.start();
        beltSensor.start();
        seatSensor.start();
        batteryCons.start();
        
        
    }
    


    public Wheelchair(BeltSensor beltSensor, FingerprintSensor fingerprintSensor, SeatSensor seatSensor, Screen screen, BatteryConsumption batteryCons) {
        this.beltSensor = beltSensor;
        this.fingerprintSensor = fingerprintSensor;
        this.seatSensor = seatSensor;
        this.screen = screen;
        this.batteryCons= batteryCons;
        
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

        ////////////////////////////////////// Seat Sensor /////////////////////////////////////////
        public void setSeatStatusInGUI(boolean status){
            seatStatus = status;
            this.seatSensor.setSeatStatusInGUI(status);
        }
  
     public void seatSignal(int weight) throws InterruptedException {
        //System.out.println("The temp is now " + temp);
        //gui.getCurrentTempTxt().setText(temp + "");
        seatSensorView.getjTextField2().setText(weight +"");
        
        if (weight < 20) {
           // beeper.beep();
            config.sendEvent(new ScanSeatSensor(weight));
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
     
     
   //////////////////////////////////// Battery sensor ////////////////////////////
     
     public void BatteruConsumption(int batteryLevel)
             
     {

            gui1.getBatteryField().setText(batteryLevel + "");
            this.batteryCons.setBatteryLevel(batteryLevel);

            
            // Forward Button
           boolean f=  gui1.getForwardRadio().isSelected();
           
                   if(f == true)
           {
              batteryLevel -= 10;
              this.batteryCons.setBatteryLevel(batteryLevel);
              gui1.getBatteryField().setText(batteryLevel + "");
                       if (batteryLevel > 20)
            {
                System.out.println("The battery don't want to be charged.");
            }
            
            else if (batteryLevel <= 10 && batteryLevel >= 5 )
            {
            
                System.err.println("You must charge the battery now.");
            
            }
            
            
            else if (batteryLevel < 0)
            {
                 batteryLevel= batteryCons.chargeBattery();
              this.batteryCons.setBatteryLevel(batteryLevel);
              gui1.getBatteryField().setText(batteryLevel + "");
            
            }
             
      
            
           }
           
                   
              // Back button      
              boolean b=  gui1.getBackRadio().isSelected();
           
                   if(b == true)
           {
              batteryLevel -= 10;
              this.batteryCons.setBatteryLevel(batteryLevel);
              gui1.getBatteryField().setText(batteryLevel + "");
                       if (batteryLevel > 20)
            {
                System.out.println("The battery don't want to be charged.");
            }
            
            else if (batteryLevel <= 10 && batteryLevel >= 5 )
            {
            
                System.err.println("You must charge the battery now.");
            
            }
            
            
            else if (batteryLevel < 0)
            {
                 batteryLevel= batteryCons.chargeBattery();
              this.batteryCons.setBatteryLevel(batteryLevel);
              gui1.getBatteryField().setText(batteryLevel + "");
            
            }
            
           }
               
                   
             // Left button      
                  
                boolean l=  gui1.getLeftRadio().isSelected();
           
                   if(l == true)
           {
              batteryLevel -= 5;
              this.batteryCons.setBatteryLevel(batteryLevel);
              gui1.getBatteryField().setText(batteryLevel + "");
                       if (batteryLevel > 20)
            {
                System.out.println("The battery don't want to be charged.");
            }
            
            else if (batteryLevel <= 10 && batteryLevel >= 5 )
            {
            
                System.err.println("You must charge the battery now.");
            
            }
            
            
            else if (batteryLevel < 0)
            {
                 batteryLevel= batteryCons.chargeBattery();
              this.batteryCons.setBatteryLevel(batteryLevel);
              gui1.getBatteryField().setText(batteryLevel + "");
            
            }

            
           }
                   
                   
                // Right button   
                boolean r=  gui1.getRightRadio().isSelected();
           
                   if(r == true)
           {
              batteryLevel -= 5;
              this.batteryCons.setBatteryLevel(batteryLevel);
              gui1.getBatteryField().setText(batteryLevel + "");
                       if (batteryLevel > 20)
            {
                System.out.println("The battery don't want to be charged.");
            }
            
            else if (batteryLevel <= 10 && batteryLevel >= 5 )
            {
            
                System.err.println("You must charge the battery now.");
            
            }
            
            
            else if (batteryLevel < 0)
            {
                 batteryLevel= batteryCons.chargeBattery();
              this.batteryCons.setBatteryLevel(batteryLevel);
              gui1.getBatteryField().setText(batteryLevel + "");
            
            }
             
      
            
           }
           
           
     }
}
