/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Toumie
 */
public class SeatSensor {
   
private boolean seatState;

    public SeatSensor() {
    }

    public SeatSensor(boolean seatState) {
        this.seatState = seatState;
    }

    public void setSeatState(boolean seatState) {
        this.seatState = seatState;
    }

    public boolean isSeatState() {
        return seatState;
    }

public boolean detectBody()
{
    return true;
}
}
