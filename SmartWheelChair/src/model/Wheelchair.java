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
import javax.swing.JOptionPane;
import view.BatteryConsumptionView;
import view.GUI;
import events.PowerON;
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

    private GPSTracker gps;

    private Camera c;
    private Brake brake;
    private PowerOffOn p;

    private Joystick joyStick;

    

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
       
       p = new PowerOffOn(this);
        fingerprintSensor = new FingerprintSensor(this);
        beltSensor = new BeltSensor(this);
        seatSensor = new SeatSensor(this);
        batteryCons = new BatteryConsumption(this);

        gps = new GPSTracker(this);


        c = new Camera(this);
        brake = new Brake(this);

        joyStick =  new Joystick(this);


        fingerprintSensor.start();
        beltSensor.start();
        seatSensor.start();
        batteryCons.start();
        gps.start();

        c.start();
        brake.start();
        
        //gui1.getObjectImage().setVisible(true);

        joyStick.start();
<<<<<<< Updated upstream


        
=======
        p.start();
>>>>>>> Stashed changes

        gui1.getjRadioButton3().setEnabled(false);
        gui1.getjRadioButton1().setEnabled(false);
        gui1.getjRadioButton2().setEnabled(false);

        // gui1.getgps().setVisible(false);
//      gui1.getgps1().setVisible(false);

        gui1.getjTabbedPane1().setVisible(false);
        gui1.getjLabel9().setVisible(false);
        gui1.getjLabel10().setVisible(false);
        gui1.getjLabel26().setVisible(false);
        gui1.getjLabel27().setVisible(false);
        gui1.getjLabel28().setVisible(false);
        gui1.getjLabel29().setVisible(false);
//      

       
        gui1.getEmptySeat().setVisible(false);
        gui1.getSeated().setVisible(false);
        
        
        gui1.getWallPhoto().setVisible(false);
        gui1.getDoorPhoto().setVisible(false);
        gui1.getSmokePhoto().setVisible(false);
        gui1.getTreePhoto().setVisible(false);
        


    }
//     
//    


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

    
    public void Power(){
    
    if (gui1.getjRadioButton4().isSelected() == false){
    
    
    System.out.println("henaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        gui1.getjRadioButton3().setEnabled(false);
        gui1.getjRadioButton1().setEnabled(false);
        gui1.getjRadioButton2().setEnabled(false);
       
        gui1.getEmptySeat().setVisible(false);
        gui1.getSeated().setVisible(false);
        
        
        gui1.getWallPhoto().setVisible(false);
        gui1.getDoorPhoto().setVisible(false);
        gui1.getSmokePhoto().setVisible(false);
        gui1.getTreePhoto().setVisible(false);
    
    
         gui1.getBackRadio().setEnabled(false);
         gui1.getForwardRadio().setEnabled(false);
         gui1.getRightRadio().setEnabled(false);
         gui1.getLeftRadio().setEnabled(false);
         gui1.getjButton11().setEnabled(false);
         gui1.getjRadioButton50().setEnabled(false);
         gui1.getSpeed().setVisible(false);
    
         //config.sendEvent(new PowerON(false));
    }  
    else {
              gui1.getBackRadio().setEnabled(true);
         gui1.getForwardRadio().setEnabled(true);
         gui1.getRightRadio().setEnabled(true);
         gui1.getLeftRadio().setEnabled(true);
         gui1.getjButton11().setEnabled(true);
         gui1.getjRadioButton50().setEnabled(true);
         gui1.getSpeed().setVisible(true);
         
         
     
    }
    
    
    }
    
    public void DetectObject(String c){ //DetectObject
    
    
      //String s= c.recognizeObject();
    
    
    if (c.equals("wall") || c.equals("door") || c.equals("tree"))
    {
         
         brake.Stop();
         gui1.getSpeed().setText("0 Km/H");

    } else if(c.equals("smoke")) {
        System.err.println("keep moving");
        gui1.getSpeed().setText(Integer.toString((int) brake.getSpeed())+ " Km/H");
    }
    }
    
    
            
//        gui1.getWallPhoto().setVisible(false);
//        gui1.getDoorPhoto().setVisible(false);
//        gui1.getSmokePhoto().setVisible(false);
//        gui1.getTreePhoto().setVisible(false);
    
    public void identifyObject(String s){
    
     s= c.recognizeObject();
     gui1.getObjectLable().setText(s);
     if(s.equals("wall"))
     {
//         ImageIcon icon = new ImageIcon("wall.jpg");
//         gui1.getPhoto().setIcon(icon);
         //gui1.getObjectImage().setVisible(true);
         gui1.getWallPhoto().setVisible(true);
         System.out.println("walaaaaaaaaaaaaaaaaaaaal");
         
        gui1.getDoorPhoto().setVisible(false);
        gui1.getSmokePhoto().setVisible(false);
        gui1.getTreePhoto().setVisible(false);
         
     }
     else if (s.equals("tree"))
    
     {
//         ImageIcon icon = new ImageIcon("tree.jpg");
//         gui1.getPhoto().setIcon(icon);
          // gui1.getObjectImage().setVisible(true);
         gui1.getTreePhoto().setVisible(true);
          System.out.println("treeeeeeeeeeeeeeeeeeee");
                  gui1.getWallPhoto().setVisible(false);
        gui1.getDoorPhoto().setVisible(false);
        gui1.getSmokePhoto().setVisible(false);
         
     }
     else if (s.equals("smoke"))
    
     {
//         ImageIcon icon = new ImageIcon("smoke.jpg");
//         gui1.getPhoto().setIcon(icon);
          // gui1.getObjectImage().setVisible(true);
         gui1.getSmokePhoto().setVisible(true);
         System.out.println("SMOOOOKE");
                 gui1.getWallPhoto().setVisible(false);
        gui1.getDoorPhoto().setVisible(false);
        gui1.getTreePhoto().setVisible(false);
     }
     else if (s.equals("door"))
    
     {
//         ImageIcon icon = new ImageIcon("door.jpg");
//         gui1.getPhoto().setIcon(icon);
       //    gui1.getObjectImage().setVisible(true);
          gui1.getDoorPhoto().setVisible(true);
         System.out.println("DOOOOOOOOOOOOOOOOOOOOOOR");
                 gui1.getWallPhoto().setVisible(false);
        gui1.getSmokePhoto().setVisible(false);
        gui1.getTreePhoto().setVisible(false);
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
                                            gui1.getEmptySeat().setVisible(true);
                                            System.out.println("invalid seat");
                                        }
                                        else{
                                             gui1.getSeated().setVisible(true);
                                            gui1.getjRadioButton2().setEnabled(true);
                                             System.out.println("valid seat");
                                         
                                        }
                        }
                        else{
                           
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
            
                JOptionPane.showMessageDialog(null, "You must charge the battery now.",
                 "Battery Low !!", JOptionPane.ERROR_MESSAGE);
               // System.err.println("You must charge the battery now.");
            
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
                         JOptionPane.showMessageDialog(null, "You must charge the battery now.",
                 "Battery Low !!", JOptionPane.ERROR_MESSAGE);
               // System.err.println("You must charge the battery now.");
            
               
            
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
            
                 JOptionPane.showMessageDialog(null, "You must charge the battery now.",
                 "Battery Low !!", JOptionPane.ERROR_MESSAGE);
               // System.err.println("You must charge the battery now.");            
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
            
                 JOptionPane.showMessageDialog(null, "You must charge the battery now.",
                 "Battery Low !!", JOptionPane.ERROR_MESSAGE);
               // System.err.println("You must charge the battery now.");
            
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

       
    if(gui1.getjRadioButton50().isSelected() == true) {
        
   
        
         String cl = gui1.currentloc().getSelectedItem().toString();
         String dest = gui1.distenation().getSelectedItem().toString();
          //  System.out.println(cl);
//          int cl = Integer.parseInt(gui1.getlocbtn().getText());
//           int dest = Integer.parseInt(gui1.getdistbtn().getText());
         if (cl == "Room" && dest =="Kitchen"){
//         if (cl== 1 && dest== 2){
          
         gui1.getjTabbedPane1().setVisible(true);
          gui1.getjTabbedPane1().setSelectedIndex(0);
         
         
           gui1.getdisTXT().setText("2 meters");
          //  gui1.getgps().setVisible(true); 
//        gui1.getgps1().setVisible(false); 
        }
            else if (cl=="Kitchen" && dest=="Room"){
                gui1.getjTabbedPane1().setVisible(true);
                gui1.getjTabbedPane1().setSelectedIndex(5);
                gui1.getdisTXT().setText("2 meters");
     }
         else if (cl=="Kitchen" && dest=="Bathroom"){
                 gui1.getjTabbedPane1().setVisible(true);
             gui1.getjTabbedPane1().setSelectedIndex(4);
     gui1.getdisTXT().setText("1 meter");
    }
         else if (cl=="Bathroom" && dest=="Kitchen"){
             gui1.getjTabbedPane1().setVisible(true);
             gui1.getjTabbedPane1().setSelectedIndex(3);
     gui1.getdisTXT().setText("1 meter");
    }
         
         else if (cl=="Bathroom" && dest=="Room"){
             gui1.getjTabbedPane1().setVisible(true);
             gui1.getjTabbedPane1().setSelectedIndex(2);
     gui1.getdisTXT().setText("3 meter");
    }
         else if (cl=="Room" && dest=="Bathroom"){
             gui1.getjTabbedPane1().setVisible(true);
             gui1.getjTabbedPane1().setSelectedIndex(1);
     gui1.getdisTXT().setText("3 meter");
    }
            System.out.println("Distance is calculated");
    }
    
    


    else
    {
           System.out.println("Distance is not calculated");
           gui1.getjTabbedPane1().setVisible(false);
    }
    
    
      if(gui1.getChangeLoction().isSelected() == true) {
        
        gui1.getjTabbedPane1().setVisible(false);
        gui1.getdisTXT().setText("0");
         gui1.distenation().setSelectedItem("choose..");
          gui1.currentloc().setSelectedItem("choose..");
    
      }
      
  
     
    }
    
    
            
     /////////////////////////////////////////////// Joystick ///////////////////////////////////////////////////
     


 

  public void StartMoving(){
            
       
        if(gui1.getHandBrake().isSelected()== true) {
         gui1.getSpeed().setText("0 Km/H");
            System.err.println("handBrake IS PRESSED");
        }
        //    gui1.getSpeed().setText(SpeedNumber + "");
          //  this.brake.setSpeed(SpeedNumber);
          
          int gettingSpeed = brake.getSpeed();
            //Moving Forward "UpperButton"
            boolean UpperArrow=  gui1.getForwardRadio().isSelected();
             // Moving Backward "Down Button"      
            boolean DownArrow=  gui1.getBackRadio().isSelected();
              // Turning Left 
              boolean LeftArrow=  gui1.getLeftRadio().isSelected();
               // Turning Right   
              boolean RightArrow=  gui1.getRightRadio().isSelected();
              
            if(UpperArrow == true)
                {
                    
                    gettingSpeed += 2;
                    this.brake.setSpeed(gettingSpeed);
                    gui1.getSpeed().setText(gettingSpeed + " Km/H");
                     System.out.println( gui1.getSpeed().getText());
                    System.out.println("YOU 'RE MOVING FORWARD.");
                
                }
           
             
             else if(DownArrow == true)
           {
              gettingSpeed -= 2;
              this.brake.setSpeed(gettingSpeed);
              gui1.getSpeed().setText(gettingSpeed + " Km/H");
              System.out.println("ALERT! YOU 'RE MOVING BACKWARD.");
           }
              
               
          
               else if(LeftArrow == true)
                {
                    gettingSpeed -= 1;
                    this.brake.setSpeed(gettingSpeed);
                    gui1.getSpeed().setText(gettingSpeed + " Km/H");
                    System.out.println("ALERT! YOU 'RE TURNING LEFT.");
                 }
                

           else if(RightArrow == true)
             {
              gettingSpeed -= 1;
              this.brake.setSpeed(gettingSpeed);
              gui1.getSpeed().setText(gettingSpeed + " Km/H");
              System.out.println("ALERT! YOU 'RE TURNING RIGHT.");
             }
    
  }
  
  
 
     
}
     



