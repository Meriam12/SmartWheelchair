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
public class CheckBrake {
    private final boolean brakeState;
    private final int speed;

    public CheckBrake(boolean brakeState, int speed) {
        this.brakeState = brakeState;
        this.speed = speed;
    }

    public boolean isBrakeState() {
        return brakeState;
    }

    public int getSpeed() {
        return speed;
    }
    
    
    
    
}
