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
public class ScanObject {
    private final boolean scannedObject;

    public ScanObject(boolean scannedObject) {
        this.scannedObject = scannedObject;
    }

    public boolean getScannedObject() {
        return scannedObject;
    }
    
}