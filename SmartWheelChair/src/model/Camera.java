/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author meriam
 */
public class Camera {
    
   public String scannedOject;

    public Camera() {
    }

    public Camera(String scannedOject) {
        this.scannedOject = scannedOject;
    }

        public void setScannedOject(String scannedOject) {
        this.scannedOject = scannedOject;
    }
    
    public String getScannedOject() {
        return scannedOject;
    }


    public void recognizeObject()
   
    {
    
    }
   
}
