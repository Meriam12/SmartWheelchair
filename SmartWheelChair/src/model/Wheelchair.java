/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.ScanBeltSensor;
import events.ScanFingerPrint;
import view.wheelchairView;
import events.ScanSeatSensor;
import java.awt.Color;
import java.util.Random;
import javax.swing.ImageIcon;
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
<<<<<<< Updated upstream
    private Camera c;
    private Brake brake;
=======
    private Brake brake;
    private Joystick joyStick;
>>>>>>> Stashed changes
    
    private wheelchairView gui;
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
<<<<<<< Updated upstream
        c = new Camera(this);
        brake = new Brake(this);
=======
        joyStick =  new Joystick(this);
>>>>>>> Stashed changes
        
        fingerprintSensor.start();
        beltSensor.start();
        seatSensor.start();
        batteryCons.start();
<<<<<<< Updated upstream
        c.start();
        brake.start();
        
        //gui1.getObjectImage().setVisible(true);
=======
        joyStick.start();
        
>>>>>>> Stashed changes
        gui1.getjRadioButton3().setEnabled(false);
        gui1.getjRadioButton1().setEnabled(false);
        gui1.getjRadioButton2().setEnabled(false);
       
        
        
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

    public void DetectObject(String c){ //DetectObject
    
    
      //String s= c.recognizeObject();
    
    
    if (c.equals("wall") || c.equals("door") || c.equals("tree"))
    {
         gui1.getObjectLable().setText(c);
         brake.Stop();
         gui1.getSpeed().setText("0 Km/H");

    } else if(c.equals("smoke")) {
        System.err.println("keep moving");
        gui1.getSpeed().setText(Integer.toString((int) brake.getSpeed()));
    }
    }
    
    public void identifyObject(String s){
    
     s= c.recognizeObject();
     if(s.equals("wall"))
     {
//         ImageIcon icon = new ImageIcon("wall.jpg");
//         gui1.getPhoto().setIcon(icon);
         //gui1.getObjectImage().setVisible(true);
         System.out.println("walaaaaaaaaaaaaaaaaaaaal");
         
         
         
     }
     else if (s.equals("tree"))
    
     {
//         ImageIcon icon = new ImageIcon("tree.jpg");
//         gui1.getPhoto().setIcon(icon);
          // gui1.getObjectImage().setVisible(true);
          System.out.println("treeeeeeeeeeeeeeeeeeee");
         
     }
     else if (s.equals("smoke"))
    
     {
//         ImageIcon icon = new ImageIcon("smoke.jpg");
//         gui1.getPhoto().setIcon(icon);
          // gui1.getObjectImage().setVisible(true);
         System.out.println("SMOOOOKE");
     }
     else if (s.equals("door"))
    
     {
//         ImageIcon icon = new ImageIcon("door.jpg");
//         gui1.getPhoto().setIcon(icon);
       //    gui1.getObjectImage().setVisible(true);
         System.out.println("DOOOOOOOOOOOOOOOOOOOOOOR");
     }
    
    }
 
    
    @Override
    public void startMoving(){
    
    System.out.print("Ayyy 7aga");
    
    }
    ///////////////////////////////////////////Fingerprint Sensor/////////////////////////////////////
    
     public void fingerprintScan() throws InterruptedException {
       
         if(gui1.getjRadioButton4().isSelected() == true){ //power
        
                gui1.getjRadioButton3().setEnabled(true); //fingerprint
//                gui1.getjRadioButton1().setEnabled(false);//seat 
//                gui1.getjRadioButton2().setEnabled(false); //seat belt

                                if(gui1.getjRadioButton3().isSelected()){     //fingerprint
                                    
                                    int f = Integer.parseInt(gui1.getFingerprintField().getText());
                                                if (f == fingerprintSensor.getUserFingerprint()) {
                                                    gui1.getFingerprint_status().setText("Status: Valid fingerprint");
                                                    System.out.println("Status: Valid fingerprint");
                                                     gui1.getjRadioButton1().setEnabled(true); //seat
                                                     
                                                }
                                                else{
                                                    gui1.getFingerprint_status().setText("Status: Invalid fingerprint");
                                                     System.out.println("Status: Invalid fingerprint");
                                                }
                                }
                                
                                else{
                                    
                                }
            }
                 else{ //// else bta3t el power button
                     gui1.getjRadioButton3().setEnabled(false);
                     gui1.getjRadioButton1().setEnabled(false);
                     gui1.getjRadioButton2().setEnabled(false);
                 }
 }
    
    
    
    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////// Seat Sensor /////////////////////////////////////////
        
 public void seatSignal(int weight) throws InterruptedException {
       
         
        System.out.println("The weight is now " + weight);
        gui1.getWeightFromGUI().setText(weight +"");


                        if(gui1.getjRadioButton1().isSelected()){
                             
                              weight = seatSensor.SeatWeight();
                              this.seatSensor.setWeight(weight);
                              gui1.getWeightFromGUI().setText(weight + "");
                              
                                        if (weight < 20) {
                                            gui1.getjSeat_validatonFromGUI().setBackground(Color.red);  
                                            System.out.println("invalid seat");
                                        }
                                        else{
                                             gui1.getjSeat_validatonFromGUI().setBackground(Color.green);
                                            gui1.getjRadioButton2().setEnabled(true);
                                             System.out.println("valid seat");
                                         
                                        }
                        }
                        else{
                            gui1.getjSeat_validatonFromGUI().setBackground(Color.red);
                            gui1.getjRadioButton2().setEnabled(false);
                            
                        }
    }

 
    ////////////////////////////////////////////////////////////////////////////////////////////////
     
          //inclasswheelchair
     /*------------------------------------------------Seat Belt -----------------------------------------*/
     public void seatBeltsignal() {
     boolean check = gui1.getjRadioButton2().isSelected();
     
            if( check == true){
                       config.sendEvent(new ScanBeltSensor(check));
                       this.beltSensor.checkBelt(check);
                       System.out.println("the seat is fasten");
                       gui1.getjLabel25().setVisible(true); 

                //set the icon to true
            } else {
                        config.sendEvent(new ScanBeltSensor(check));
                        this.beltSensor.checkBelt(check);
                        System.out.println("the seat is unfasten");
                        gui1.getjLabel25().setVisible(false);
                //set the icon to false

            }
     
     
     }
     
     
     /*-----------------------------------------end of SeatBelt------------------------------------------*/
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

     public void calculateDistance(){

       
    if(gui1.getjRadioButton50().isSelected()) {
        
             String cl = gui1.currentloc().getSelectedItem().toString();
         String dest = gui1.distenation().getSelectedItem().toString();
         // System.out.println(cl);
//          int cl = Integer.parseInt(gui1.getlocbtn().getText());
//           int dest = Integer.parseInt(gui1.getdistbtn().getText());
         if (cl.equals("Room") && dest.equals("Kitchen")){
//         if (cl== 1 && dest== 2){
         gui1.getdisTXT().setText("2 meters");
//          gui1.getgps().setVisible(true); 
//           gui1.getgps1().setVisible(false); 
        }
            else if (cl=="Kitchen" && dest=="Room"){
     gui1.getdisTXT().setText("2 meters");
//     gui1.getgps().setVisible(false); 
//      gui1.getgps1().setVisible(true); 
    }
         else if (cl=="Kitchen" && dest=="Bathroom"){
     gui1.getdisTXT().setText("1 meter");
    }
         else if (cl=="Bathroom" && dest=="Kitchen"){
     gui1.getdisTXT().setText("1 meter");
    }
         
         else if (cl=="Bathroom" && dest=="Room"){
     gui1.getdisTXT().setText("3 meter");
    }
         else if (cl=="Room" && dest=="Bathroom"){
     gui1.getdisTXT().setText("3 meter");
    }
            System.out.println("Distance is calculated");
    }else
    {
           System.out.println("Distance is not calculated");
         
           
    }
            
     /////////////////////////////////////////////// Joystick ///////////////////////////////////////////////////
     
<<<<<<< Updated upstream

 
=======
  public void StartMoving(int SpeedNumber){
            
        
        System.out.print("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
            gui1.getSpeed().setText(SpeedNumber + "");
            //this.brake.setSpeed(SpeedNumber);

            //Moving Forward "UpperButton"
            boolean UpperArrow=  gui1.getForwardRadio().isSelected();
            if(UpperArrow == true)
                {
                    SpeedNumber += 2;
                    this.brake.setSpeed(SpeedNumber);
                    gui1.getSpeed().setText(SpeedNumber + "");
                    System.out.println("YOU 'RE MOVING FORWARD.");
                
                }
            // Moving Backward "Down Button"      
             boolean DownArrow=  gui1.getBackRadio().isSelected();
              if(DownArrow == true)
           {
              SpeedNumber -= 2;
              this.brake.setSpeed(SpeedNumber);
              gui1.getSpeed().setText(SpeedNumber + "");
              System.out.println("ALERT! YOU 'RE MOVING BACKWARD.");
           }
              
               
            // Turning Left 
              boolean LeftArrow=  gui1.getLeftRadio().isSelected();
                if(LeftArrow == true)
                {
                    SpeedNumber -= 1;
                    this.brake.setSpeed(SpeedNumber);
                    gui1.getSpeed().setText(SpeedNumber + "");
                    System.out.println("ALERT! YOU 'RE TURNING LEFT.");
                 }
                
            // Turning Right   
              boolean RightArrow=  gui1.getRightRadio().isSelected();
            if(RightArrow == true)
             {
              SpeedNumber -= 1;
              this.brake.setSpeed(SpeedNumber);
              gui1.getSpeed().setText(SpeedNumber + "");
              System.out.println("ALERT! YOU 'RE TURNING RIGHT.");
             }
    
    }
     
>>>>>>> Stashed changes
}
}