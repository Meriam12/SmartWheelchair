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
public class ObjectDetectionReading {
    
    //dah by2oul eah el object 
     private final String DetctedObject;

    public ObjectDetectionReading(String DetctedObject) {
        this.DetctedObject = DetctedObject;
    }

    public String getDetctedObject() {
        return DetctedObject;
    }
     
}
