/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import model.Wheelchair;

/**
 *
 * @author a_h_s
 */
public class ScanSeatSensor {
    private  boolean seatState;

    public ScanSeatSensor(boolean seatState) {
        this.seatState = seatState;
    }

    public boolean isSeatState() {
        return seatState;
    }
    

    
}
