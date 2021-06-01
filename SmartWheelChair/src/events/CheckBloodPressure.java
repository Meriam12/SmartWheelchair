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
public class CheckBloodPressure {
      private final int bloodPressure;

    public CheckBloodPressure(int bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getBloodPressure() {
        return bloodPressure;
    }
      
      
}
