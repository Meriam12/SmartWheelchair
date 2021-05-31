/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author TOUMIE
 */
public class FingerprintSensor {
    
private boolean fingerprintState;

    public FingerprintSensor() {
    }

    public FingerprintSensor(boolean fingerprintState) {
        this.fingerprintState = fingerprintState;
    }

    public void setFingerprintState(boolean fingerprintState) {
        this.fingerprintState = fingerprintState;
    }

    public boolean isFingerprintState() {
        return fingerprintState;
    }

public boolean IdentifyFingerprint(int temp)
{
   return true; 
}   
}
