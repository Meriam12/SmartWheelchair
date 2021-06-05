/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.ScanObject;
import events.TakeDistination;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GUI;

/**
 *
 * @author TOUMIE
 */
public class GPSTracker extends Thread {
    private GUI gui1;
    private String currentLocation;
    private String Destination;
private Wheelchair wheelchair;
    public GPSTracker() {
    }
 public GPSTracker(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }
    
    public GPSTracker(String currentLocation, String Destination) {
       
        this.currentLocation = currentLocation;
        this.Destination = Destination;
    }


    public String getCurrentLocation() {
        //this.currentLocation = gui.getjTextField1().getText();
   
        return currentLocation;
    }

//
//    public String getCurrentLocation() {
//        currentLocation = gui.getjTextField1().getText();
//         if (currentLocation=="cairo")
//         {
//             String res= currentLocation= one;
//         } else {
//         String res= currentLocation= two;}
//        return currentLocation;
//    }


    public String getDestination() {
        return Destination;
    }

    public void setCurrentLocation(String currentLocation) {
       
       this.currentLocation = currentLocation;
        
   
       
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }
    
//    public double calculateDistance(String currentLocation, String Destination)
//    {
//         this.currentLocation = gui.getjTextField1().getText();
//          this.currentLocation = gui.getjTextField1().getText();
//    return 0;
//    }
//    
    public String changeDirection()
    {
    return ("");
    }
    
//    public void calculateDistance()
//    
//    {
//    
//        //FIngerprint
//    if (gui1.getjRadioButton4().isSelected() == true)
//    {
//        //SeatSensor
//    
//       if (gui1.getjRadioButton1().isSelected() == true)
//    {
//        //SeatBeltSensor
//        if (gui1.getjRadioButton2().isSelected() == true)
//        {
//    if(gui1.getjRadioButton50().isSelected() == true) 
//    {
//        
//         String cl = gui1.currentloc().getSelectedItem().toString();
//         String dest = gui1.distenation().getSelectedItem().toString();
//          //  System.out.println(cl);
////          int cl = Integer.parseInt(gui1.getlocbtn().getText());
////           int dest = Integer.parseInt(gui1.getdistbtn().getText());
//         if (cl == "Room" && dest =="Kitchen"){
////         if (cl== 1 && dest== 2){
//          
//         gui1.getjTabbedPane1().setVisible(true);
//          gui1.getjTabbedPane1().setSelectedIndex(0);
//         
//         
//           gui1.getdisTXT().setText("2 meters");
//          //  gui1.getgps().setVisible(true); 
////        gui1.getgps1().setVisible(false); 
//        }
//            else if (cl=="Kitchen" && dest=="Room"){
//                gui1.getjTabbedPane1().setVisible(true);
//                gui1.getjTabbedPane1().setSelectedIndex(5);
//                gui1.getdisTXT().setText("2 meters");
//     }
//         else if (cl=="Kitchen" && dest=="Bathroom"){
//                 gui1.getjTabbedPane1().setVisible(true);
//             gui1.getjTabbedPane1().setSelectedIndex(4);
//     gui1.getdisTXT().setText("1 meter");
//    }
//         else if (cl=="Bathroom" && dest=="Kitchen"){
//             gui1.getjTabbedPane1().setVisible(true);
//             gui1.getjTabbedPane1().setSelectedIndex(3);
//     gui1.getdisTXT().setText("1 meter");
//    }
//         
//         else if (cl=="Bathroom" && dest=="Room"){
//             gui1.getjTabbedPane1().setVisible(true);
//             gui1.getjTabbedPane1().setSelectedIndex(2);
//     gui1.getdisTXT().setText("3 meter");
//    }
//         else if (cl=="Room" && dest=="Bathroom"){
//             gui1.getjTabbedPane1().setVisible(true);
//             gui1.getjTabbedPane1().setSelectedIndex(1);
//     gui1.getdisTXT().setText("3 meter");
//    }
//            System.out.println("Distance is calculated");
//    }
//    
//    
//
//
//    else
//    {
//           System.out.println("Distance is not calculated");
//           gui1.getjTabbedPane1().setVisible(false);
//    }
//    
//    
//     
//    if(gui1.getChangeLoction().isSelected() == true) {
//        
//        gui1.getjTabbedPane1().setVisible(false);
//        gui1.getdisTXT().setText("0");
//        gui1.distenation().setSelectedItem("choose..");
//         gui1.currentloc().setSelectedItem("choose..");
//    
//      }
//      
//  
//    }
//    }
//    }
//    }
    
    
    
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
            config.sendEvent(new TakeDistination(Destination));
        }
    }
}
