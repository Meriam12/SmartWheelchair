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
public class Brake {
    
    private double speed;

    
    
    public Brake ()
    {
    
    }
    
    public Brake(double speed) {
        this.speed = speed;
    }


    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
   
    public double getSpeed() {
        return speed;
    }
    
    
    public String stop()
    {
        String m = "";
        
        return m;
    }
    
    
        public String slowDown()
    {
        String m = "";
        
        return m;
    }
    
        
        public String accelerate()
    {
        String m = "";
        
        return m;
    }
    
}
