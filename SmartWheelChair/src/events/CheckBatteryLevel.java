/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author a_h_s
 */
public class CheckBatteryLevel {
      private final int batterylevel;

    public CheckBatteryLevel(int batterylevel) {
        this.batterylevel = batterylevel;
    }

    public int getBatterylevel() {
        return batterylevel;
    }
      
    
}
