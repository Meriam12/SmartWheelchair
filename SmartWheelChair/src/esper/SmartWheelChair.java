/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import events.ScanFingerPrint;
import esper.config;
import javax.print.attribute.standard.Destination;
import model.Wheelchair;

/**
 *
 * @author meriam
 */
public class SmartWheelChair {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("hello");
        config.registerEvents();
        
        final Wheelchair wheelchair = new Wheelchair();
        
         config.createStatement("select fingerPrint from ScanFingerPrint")
                .setSubscriber(new Object() {
                    public void update(int fingerPrint) throws InterruptedException {
                        wheelchair.fingerprintScan();
                    }
                });
         
                  config.createStatement("select weight from ScanSeatSensor")
                .setSubscriber(new Object() {
                    public void update(int weight) throws InterruptedException {
                        wheelchair.seatSignal(weight);
                    }
                    
                     });
                    
                    config.createStatement("select batterylevel from CheckBatteryLevel")
                .setSubscriber(new Object() {
                    public void update(int batteryLevel) throws InterruptedException {
                        wheelchair.BatteruConsumption(batteryLevel);
                    }
                    
                });
                    
                    
                      config.createStatement("select scanLocation from TakeDistination")
                .setSubscriber(new Object() {
                    public void update( String Destination) throws InterruptedException {
                        wheelchair.calculateDistance();
                    }
                    
                });
                    

                  
    }
    
}
