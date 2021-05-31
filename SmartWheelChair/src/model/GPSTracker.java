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
public class GPSTracker {
    
    private String currentLocation;
    private String Destination;

    public GPSTracker() {
    }

    public GPSTracker(String currentLocation, String Destination) {
        this.currentLocation = currentLocation;
        this.Destination = Destination;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getDestination() {
        return Destination;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }
    
    public double calculateDistance(String currentLocation, String Destination)
    {
    return 0;
    }
    
    public String changeDirection()
    {
    return ("");
    }
}
