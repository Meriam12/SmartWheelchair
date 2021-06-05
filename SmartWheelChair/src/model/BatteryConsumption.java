/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.CheckBatteryLevel;
import events.ScanFingerPrint;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.GUI;


/**
 *
 * @author Mariam
 */
public class BatteryConsumption extends Thread{
    private int batteryLevel;
    private Wheelchair wheelchair;
     private GUI gui1;
    
    public BatteryConsumption() {
    }

    public BatteryConsumption(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

      public BatteryConsumption(Wheelchair wheelchair) {
       this.wheelchair = wheelchair;
       this.batteryLevel = 100;
    }

        
    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    
    public String monitorBatteryLevel (int batteryLevel) {
        
        return "h";
    }
    

    public  int chargeBattery()
    {
        batteryLevel =100;
        
        return batteryLevel;
    }
    
//       public void BatteruConsumption(int batteryLevel)
//             
//     {
//
//            gui1.getBatteryField().setText(batteryLevel + "");
//            this.batteryCons.setBatteryLevel(batteryLevel);
//
//            
//            // Forward Button
//           boolean f=  gui1.getForwardRadio().isSelected();
//           
//                   if(f == true)
//           {
//              batteryLevel -= 10;
//              this.batteryCons.setBatteryLevel(batteryLevel);
//              gui1.getBatteryField().setText(batteryLevel + "");
//                       if (batteryLevel > 20)
//            {
//                System.out.println("The battery don't want to be charged.");
//            }
//            
//            else if (batteryLevel <= 10 && batteryLevel >= 5 )
//            {
//            
//                JOptionPane.showMessageDialog(null, "You must charge the battery now.",
//                 "Battery Low !!", JOptionPane.ERROR_MESSAGE);
//               // System.err.println("You must charge the battery now.");
//            
//            }
//            
//            
//            else if (batteryLevel < 0)
//            {
//                 batteryLevel= batteryCons.chargeBattery();
//              this.batteryCons.setBatteryLevel(batteryLevel);
//              gui1.getBatteryField().setText(batteryLevel + "");
//            
//            }
//             
//      
//            
//           }
//           
//                   
//              // Back button      
//              boolean b=  gui1.getBackRadio().isSelected();
//           
//                   if(b == true)
//           {
//              batteryLevel -= 10;
//              this.batteryCons.setBatteryLevel(batteryLevel);
//              gui1.getBatteryField().setText(batteryLevel + "");
//                       if (batteryLevel > 20)
//            {
//                System.out.println("The battery don't want to be charged.");
//            }
//            
//            else if (batteryLevel <= 10 && batteryLevel >= 5 )
//            {
//                         JOptionPane.showMessageDialog(null, "You must charge the battery now.",
//                 "Battery Low !!", JOptionPane.ERROR_MESSAGE);
//               // System.err.println("You must charge the battery now.");
//            
//               
//            
//            }
//            
//            
//            else if (batteryLevel < 0)
//            {
//                 batteryLevel= batteryCons.chargeBattery();
//              this.batteryCons.setBatteryLevel(batteryLevel);
//              gui1.getBatteryField().setText(batteryLevel + "");
//            
//            }
//            
//           }
//               
//                   
//             // Left button      
//                  
//                boolean l=  gui1.getLeftRadio().isSelected();
//           
//                   if(l == true)
//           {
//              batteryLevel -= 5;
//              this.batteryCons.setBatteryLevel(batteryLevel);
//              gui1.getBatteryField().setText(batteryLevel + "");
//                       if (batteryLevel > 20)
//            {
//                System.out.println("The battery don't want to be charged.");
//            }
//            
//            else if (batteryLevel <= 10 && batteryLevel >= 5 )
//            {
//            
//                 JOptionPane.showMessageDialog(null, "You must charge the battery now.",
//                 "Battery Low !!", JOptionPane.ERROR_MESSAGE);
//               // System.err.println("You must charge the battery now.");            
//            }
//            
//            
//            else if (batteryLevel < 0)
//            {
//                 batteryLevel= batteryCons.chargeBattery();
//              this.batteryCons.setBatteryLevel(batteryLevel);
//              gui1.getBatteryField().setText(batteryLevel + "");
//            
//            }
//
//            
//           }
//                   
//                   
//                // Right button   
//                boolean r=  gui1.getRightRadio().isSelected();
//           
//                   if(r == true)
//           {
//              batteryLevel -= 5;
//              this.batteryCons.setBatteryLevel(batteryLevel);
//              gui1.getBatteryField().setText(batteryLevel + "");
//                       if (batteryLevel > 20)
//            {
//                System.out.println("The battery don't want to be charged.");
//            }
//            
//            else if (batteryLevel <= 10 && batteryLevel >= 5 )
//            {
//            
//                 JOptionPane.showMessageDialog(null, "You must charge the battery now.",
//                 "Battery Low !!", JOptionPane.ERROR_MESSAGE);
//               // System.err.println("You must charge the battery now.");
//            
//            }
//            
//            
//            else if (batteryLevel < 0)
//            {
//                 batteryLevel= batteryCons.chargeBattery();
//              this.batteryCons.setBatteryLevel(batteryLevel);
//              gui1.getBatteryField().setText(batteryLevel + "");
//            
//            }
//             
//      
//            
//           }
//           
//           
//     }
    
   //extends Thread
 @Override
    public void run() {
        while (true) {
            //wheelchair.getFingerprintSensor().raiseTemp();
            try {
                this.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FingerprintSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //config.sendEvent(new ScanFingerPrint(fingerPrint);
            config.sendEvent(new CheckBatteryLevel(batteryLevel));
        }
    }

    
}
