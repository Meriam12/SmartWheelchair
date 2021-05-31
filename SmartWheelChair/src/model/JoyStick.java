/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Shrouk
 */
public class Joystick {
    private String currentSelection;
        private Brake brake;

    public Joystick() {
    }

    public Joystick(String currentSelection, Brake brake) {
        this.currentSelection = currentSelection;
        this.brake = brake;
    }

    public void setCurrentSelection(String currentSelection) {
        this.currentSelection = currentSelection;
    }

    public void setBrake(Brake brake) {
        this.brake = brake;
    }

    public String getCurrentSelection() {
        return currentSelection;
    }

    public Brake getBrake() {
        return brake;
    }
    public String setDirection(String direction) {
       return direction;
    }
    //@Override
    public void StartMoving(){
        
    }

}
