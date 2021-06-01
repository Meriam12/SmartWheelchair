/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.ObjectDetectionReading;
import events.ScanJoyStickMovement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author meriam
 */
public class ObjectDetectionSensor extends Thread{
    
  private  Camera camera;
  
  private Brake brake;

  
  
  public ObjectDetectionSensor() {
    }
    
    


  public ObjectDetectionSensor(Camera camera, Brake brake) {
        this.camera = camera;
        this.brake = brake;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Brake getBrake() {
        return brake;
    }

    public void setBrake(Brake brake) {
        this.brake = brake;
    }

  
    public void detectObject(Camera camera)
    {
    
    }
    
    public void takeAction(Camera camera)
    
    {
    
    }
    @Override
    public void run() {
        while (true) {
            //wheelchair.getFingerprintSensor().raiseTemp();
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FingerprintSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //config.sendEvent(new ScanFingerPrint(fingerPrint);
            config.sendEvent(new ObjectDetectionReading(camera.getScannedOject()));
        }
    }
  
}
