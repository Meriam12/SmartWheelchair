/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.ScanJoyStickMovement;
import events.ScanObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GUI;

    

/**
 *
 * @author Shrouk
 */
public class Joystick extends Thread implements Movement{
    private String currentSelection;
        private Brake brake;
        private GUI gui1;
        private Wheelchair wheelchair;
        
    public Joystick() {
    }

    public Joystick(String currentSelection, Brake brake) {
        this.currentSelection = currentSelection;
        this.brake = brake;
    }

    public Joystick(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
     //   brake.setSpeed(0);
    }

    public void setCurrentSelection(String currentSelection) {
        this.currentSelection = currentSelection;
    }

    public void setBrake(Brake brake) {
        this.brake = brake;
    }

    public String getCurrentSelection() {
        return currentSelection;
    }

    public Brake getBrake() {
        return brake;
    }
    public String setDirection(String direction) {
       return direction;
    }
    
    public int getBrakeSpeed(){
      int s = brake.getSpeed();
      return s;
    }
    
    @Override 
    public void startMoving(){
//            
//          if (gui1.getjRadioButton4().isSelected() == true)
//    {
//        //SeatSensor
//    
//       if (gui1.getjRadioButton1().isSelected() == true)
//    {
//        //SeatBeltSensor
//        if (gui1.getjRadioButton2().isSelected() == true)
//        {
//            
//        
//        if(gui1.getHandBrake().isSelected()== true) {
//         gui1.getSpeed().setText("0 Km/H");
//          brake.Stop();
//            System.err.println("handBrake IS PRESSED");
//        }
//        //    gui1.getSpeed().setText(SpeedNumber + "");
//          //  this.brake.setSpeed(SpeedNumber);
//          
//          int gettingSpeed = brake.getSpeed();
//            //Moving Forward "UpperButton"
//            boolean UpperArrow=  gui1.getForwardRadio().isSelected();
//             // Moving Backward "Down Button"      
//            boolean DownArrow=  gui1.getBackRadio().isSelected();
//              // Turning Left 
//              boolean LeftArrow=  gui1.getLeftRadio().isSelected();
//               // Turning Right   
//              boolean RightArrow=  gui1.getRightRadio().isSelected();
//              
//            if(UpperArrow == true)
//                {
//                    
//                    gettingSpeed += 2;
//                    this.brake.setSpeed(gettingSpeed);
//                    gui1.getSpeed().setText(gettingSpeed + " Km/H");
//                     System.out.println( gui1.getSpeed().getText());
//                    System.out.println("YOU 'RE MOVING FORWARD.");
//                
//                }
//           
//             
//             else if(DownArrow == true)
//           {
//              gettingSpeed -= 2;
//              this.brake.setSpeed(gettingSpeed);
//              gui1.getSpeed().setText(gettingSpeed + " Km/H");
//              System.out.println("ALERT! YOU 'RE MOVING BACKWARD.");
//           }
//              
//               
//          
//               else if(LeftArrow == true)
//                {
//                    gettingSpeed -= 1;
//                    this.brake.setSpeed(gettingSpeed);
//                    gui1.getSpeed().setText(gettingSpeed + " Km/H");
//                    System.out.println("ALERT! YOU 'RE TURNING LEFT.");
//                 }
//                
//
//           else if(RightArrow == true)
//             {
//              gettingSpeed -= 1;
//              this.brake.setSpeed(gettingSpeed);
//              gui1.getSpeed().setText(gettingSpeed + " Km/H");
//              System.out.println("ALERT! YOU 'RE TURNING RIGHT.");
//             }
//    
//  }
//  
//    }
//    }
}
    
 @Override
    public void run() {
        while (true) {
            //wheelchair.getFingerprintSensor().raiseTemp();
        // wheelchair.StartMoving(brake.getSpeed());
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FingerprintSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //config.sendEvent(new ScanFingerPrint(fingerPrint);
            config.sendEvent(new ScanJoyStickMovement());
        }
    }
}