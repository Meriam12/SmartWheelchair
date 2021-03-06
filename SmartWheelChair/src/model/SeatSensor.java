/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.ObjectDetectionReading;
import events.ScanSeatSensor;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GUI;
/**
 *
 * @author Toumie
 */
public class SeatSensor extends Thread {
    

   private GUI gui1;

private boolean seatState;
private Wheelchair wheelchair;
private int weight;

    public SeatSensor() {
    }

    public SeatSensor(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
        this.weight = 0; 
    }

    
    public SeatSensor(boolean seatState) {
        this.seatState = seatState;
    }

    public void setSeatState(boolean seatState) {
        this.seatState = seatState;
    }

    public boolean isSeatState() {
        return seatState;
    }
    
        public int SeatWeight()
    {
        weight = 50;
    return weight;
    }
    
        public int SeatNoWeight()
    {
        weight = 10;
    return weight;
    }

    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
public boolean detectBody()
{
    return true;
}

    

//    public void setSeatStatusInGUI(boolean status) {
//        seatState = status;
//        if (status) {
//            wheelchair.getGuiSeatSensor().getjTextField1().setText("Valid");
//        } else {
//            wheelchair.getGuiSeatSensor().getjTextField1().setText("Invalid");
//        }
//
//    }
    
//
//    public void checkSeatSensor(){ //this num is in killos
//        if (weight < 20){   //since babies are not allowed to use this wheelchair
//             setSeatState(false);
//             setSeatStatusInGUI(false);
//             
//        }
//        else{
//            setSeatState(true);
//            setSeatStatusInGUI(true);
//        }
//    }
//  
    
//public void seatSignal(int weight) throws InterruptedException {
//       
//         
//        System.out.println("The weight is now " + weight);
//        gui1.getWeightFromGUI().setText(weight +"");
//
//
//                        if(gui1.getjRadioButton1().isSelected()){
//                             
//                              weight = SeatSensor.SeatWeight();
//                              SeatSensor.setWeight(weight);
//                              gui1.getWeightFromGUI().setText(weight + "");
//                              
//                                        if (weight < 20) {
//                                            gui1.getEmptySeat().setVisible(true);
//                                            System.out.println("invalid seat");
//                                        }
//                                        else{
//                                             gui1.getSeated().setVisible(true);
//                                            gui1.getjRadioButton2().setEnabled(true);
//                                             System.out.println("valid seat");
//                                         
//                                        }
//                        }
//                        else{
//                           
//                            gui1.getjRadioButton2().setEnabled(false);
//                            
//                        }
//    }

 


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
            config.sendEvent(new ScanSeatSensor(weight));
        }
    }
    


}
