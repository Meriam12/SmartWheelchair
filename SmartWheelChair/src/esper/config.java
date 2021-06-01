/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import events.ScanFingerPrint;
import events.CheckBatteryLevel;
import events.CheckBloodPressure;
import events.CheckBrake;
import events.CheckHeartRate;
import events.ObjectDetectionReading;
import events.ScanJoyStickMovement;
import events.ScanBeltSensor;
import events.ScanObject;
import events.ScanSeatSensor;
import events.TakeDistination;



/**
 *
 * @author a_h_s
 */
public class config {
    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();
    
    
    public static void registerEvents() {
        engine.getEPAdministrator().getConfiguration().addEventType(ScanFingerPrint.class);
        engine.getEPAdministrator().getConfiguration().addEventType(CheckBatteryLevel.class);
        engine.getEPAdministrator().getConfiguration().addEventType(CheckBloodPressure.class);
        engine.getEPAdministrator().getConfiguration().addEventType(CheckBrake.class);
        engine.getEPAdministrator().getConfiguration().addEventType(CheckHeartRate.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ObjectDetectionReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ScanBeltSensor.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ScanJoyStickMovement.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ScanObject.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ScanSeatSensor.class);
        engine.getEPAdministrator().getConfiguration().addEventType(TakeDistination.class);


        
        System.out.println("Events Successfully Registered.");
    }
    
    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement Successfully Created.");
        return result;
    }
    
      public static void sendEvent(Object o)
    {
        engine.getEPRuntime().sendEvent(o);
    }
    
}
