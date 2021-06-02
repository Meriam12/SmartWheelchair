/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import events.ScanFingerPrint;
import esper.config;
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
                        wheelchair.tempSignal(fingerPrint);
                    }
                });
         
                  config.createStatement("select weight from ScanSeatSensor")
                .setSubscriber(new Object() {
                    public void update(int seatState) throws InterruptedException {
                        wheelchair.seatSignal(seatState);
                    }
                });
                  
    }
    
}
