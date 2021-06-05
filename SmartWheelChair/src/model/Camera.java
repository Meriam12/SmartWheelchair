/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.config;
import events.CheckBrake;
import events.ScanObject;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.GUI;
/**
 *
 * @author meriam
 */
public class Camera extends Thread{
    
   private String scannedOject;
   //private boolean scannedObject;
   private String[] listOfObject = {"tree","wall", "door", "smoke"} ;
   private Wheelchair wheelchair;
  private GUI gui1;

    public Camera() {
        
    // listOfObject = {"tree","wall", "door", "smoke"};
    }

    public Camera(String scannedOject) {
        this.scannedOject = scannedOject;
    }

    public Camera(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    
        public void setScannedOject(String scannedOject) {
        this.scannedOject = scannedOject;
    }
    
    public String getScannedOject() {
        return scannedOject;
    }

    public String[] getListOfObject() {
        return listOfObject;
    }


    public String recognizeObject()
   
    {
    int idx = new Random().nextInt(getListOfObject().length);
        String random = (getListOfObject() [idx]);
        System.out.println(random);
        setScannedOject(random);
        return getScannedOject();
    }
    
//     public void identifyObject(String s){
//    
//     s= this.recognizeObject();
//     gui1.getObjectLable().setText(s);
//     if(s.equals("wall"))
//     {
////         ImageIcon icon = new ImageIcon("wall.jpg");
////         gui1.getPhoto().setIcon(icon);
//         //gui1.getObjectImage().setVisible(true);
//         gui1.getWallPhoto().setVisible(true);
//         System.out.println("walaaaaaaaaaaaaaaaaaaaal");
//         
//        gui1.getDoorPhoto().setVisible(false);
//        gui1.getSmokePhoto().setVisible(false);
//        gui1.getTreePhoto().setVisible(false);
//         
//     }
//     else if (s.equals("tree"))
//    
//     {
////         ImageIcon icon = new ImageIcon("tree.jpg");
////         gui1.getPhoto().setIcon(icon);
//          // gui1.getObjectImage().setVisible(true);
//         gui1.getTreePhoto().setVisible(true);
//          System.out.println("treeeeeeeeeeeeeeeeeeee");
//                  gui1.getWallPhoto().setVisible(false);
//        gui1.getDoorPhoto().setVisible(false);
//        gui1.getSmokePhoto().setVisible(false);
//         
//     }
//     else if (s.equals("smoke"))
//    
//     {
////         ImageIcon icon = new ImageIcon("smoke.jpg");
////         gui1.getPhoto().setIcon(icon);
//          // gui1.getObjectImage().setVisible(true);
//         gui1.getSmokePhoto().setVisible(true);
//         System.out.println("SMOOOOKE");
//                 gui1.getWallPhoto().setVisible(false);
//        gui1.getDoorPhoto().setVisible(false);
//        gui1.getTreePhoto().setVisible(false);
//     }
//     else if (s.equals("door"))
//    
//     {
////         ImageIcon icon = new ImageIcon("door.jpg");
////         gui1.getPhoto().setIcon(icon);
//       //    gui1.getObjectImage().setVisible(true);
//          gui1.getDoorPhoto().setVisible(true);
//         System.out.println("DOOOOOOOOOOOOOOOOOOOOOOR");
//                 gui1.getWallPhoto().setVisible(false);
//        gui1.getSmokePhoto().setVisible(false);
//        gui1.getTreePhoto().setVisible(false);
//     }
//    
//    }
   @Override
    public void run() {
        while (true) {
            recognizeObject();
            wheelchair.identifyObject(getScannedOject());
            try {
                this.sleep(3500);
            } catch (InterruptedException ex) {
                Logger.getLogger(FingerprintSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //config.sendEvent(new ScanFingerPrint(fingerPrint);
            config.sendEvent(new ScanObject(scannedOject));
        }
    }
}
