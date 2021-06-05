/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.PowerON;
import events.ScanSeatSensor;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GUI;

/**
 *
 * @author a_h_s
 */
public class PowerOffOn  extends Thread {
    private GUI gui1;
    boolean state;
Wheelchair wheelchair;
    public PowerOffOn(boolean state) {
        this.state = state;
    }

    public PowerOffOn(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
        state = false;
    }
    
//    public void Power(){
//    
//    if (gui1.getjRadioButton4().isSelected() == false){
//    
//    
//    System.out.println("henaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        gui1.getjRadioButton3().setEnabled(false);
//        gui1.getjRadioButton1().setEnabled(false);
//        gui1.getjRadioButton2().setEnabled(false);
//       
//        gui1.getEmptySeat().setVisible(false);
//        gui1.getSeated().setVisible(false);
//        
//        
//        gui1.getWallPhoto().setVisible(false);
//        gui1.getDoorPhoto().setVisible(false);
//        gui1.getSmokePhoto().setVisible(false);
//        gui1.getTreePhoto().setVisible(false);
//    
//    
//         gui1.getBackRadio().setEnabled(false);
//         gui1.getForwardRadio().setEnabled(false);
//         gui1.getRightRadio().setEnabled(false);
//         gui1.getLeftRadio().setEnabled(false);
//       //  gui1.getjButton11().setEnabled(false);
//         gui1.getjRadioButton50().setEnabled(false);
//         gui1.getSpeed().setVisible(false);
//         gui1.getjPanel8().setVisible(false);
//         gui1.getObjectLable().setVisible(false);
//         gui1.getChangeLoction().setEnabled(false);
//         gui1.getBatteryField().setEnabled(false);
//         
//         //config.sendEvent(new PowerON(false));
//    }  
//    else {
//              gui1.getBackRadio().setEnabled(true);
//         gui1.getForwardRadio().setEnabled(true);
//         gui1.getRightRadio().setEnabled(true);
//         gui1.getLeftRadio().setEnabled(true);
//       //  gui1.getjButton11().setEnabled(true);
//         gui1.getjRadioButton50().setEnabled(true);
//         gui1.getSpeed().setVisible(true);
//         gui1.getjPanel8().setVisible(true);
//          gui1.getObjectLable().setVisible(true);
//          //gui1.getChangeLoction().setVisible(false);
//          gui1.getChangeLoction().setEnabled(true);
//          gui1.getBatteryField().setEnabled(true);
//         
//         
//     
//    }
//    
//    
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
            config.sendEvent(new PowerON (state));
        }
    }
    
}
