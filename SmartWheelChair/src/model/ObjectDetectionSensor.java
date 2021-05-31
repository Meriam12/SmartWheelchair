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
public class ObjectDetectionSensor {
    
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
    
  
}
