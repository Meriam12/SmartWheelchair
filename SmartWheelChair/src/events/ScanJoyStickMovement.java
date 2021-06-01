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
public class ScanJoyStickMovement {
    
    private final char joystickpostion;
    //final because the value cant be modified from outside the class or anywhere else

    public ScanJoyStickMovement(char joystickpostion) {
        this.joystickpostion = joystickpostion;
    }

    public char getJoystickpostion() {
        return joystickpostion;
    }
    
    
    
}
