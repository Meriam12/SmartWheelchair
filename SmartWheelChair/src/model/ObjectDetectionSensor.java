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
import view.GUI;

/**
 *
 * @author meriam
 */
public class ObjectDetectionSensor extends Thread{
    
  private  Camera camera;
  
  private Brake brake;
 
  private GUI gui1;
  
  
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
    
//     public void DetectObject(String c){ //DetectObject
//    
//    
//      //String s= c.recognizeObject();
//    
//    
//    if (c.equals("wall") || c.equals("door") || c.equals("tree"))
//    {
//         
//         brake.Stop();
//         gui1.getSpeed().setText("0 Km/H");
//         
//
//    } else if(c.equals("smoke")) {
//        System.err.println("keep moving");
//        gui1.getSpeed().setText(Integer.toString((int) brake.getSpeed())+ " Km/H");
//    }
    //}
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
