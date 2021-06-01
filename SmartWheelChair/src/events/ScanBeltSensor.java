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
public class ScanBeltSensor extends Thread {
    private final boolean beltState;
  
    
    
    public ScanBeltSensor(boolean beltState) {
        this.beltState = true;
       
    }

    public boolean isBeltState() {
        return beltState;
    }

    

  
    
}
