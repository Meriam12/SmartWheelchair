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
    
//    private final String joystickpostion;
//    //final because the value cant be modified from outside the class or anywhere else
//
//    public ScanJoyStickMovement(String joystickpostion) {
//        this.joystickpostion = joystickpostion;
//    }
//
//    public String getJoystickpostion() {
//        return joystickpostion;
//    }
    private final int speed;

    public ScanJoyStickMovement(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
    
    
    
    
}
