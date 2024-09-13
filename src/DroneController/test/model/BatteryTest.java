/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package DroneController.test.model;

import static org.junit.Assert.*;

import DroneController.model.Battery;
import DroneController.resources.BatteryState;
import org.junit.*;

/**
 * JUnit-Test for Battery
 * Methods that will be tested: calculateState()
 */
public class BatteryTest {

    private Battery battery;


    @Before
    public void initBattery() {
        this.battery = new Battery();
    }

    @Test
    public void testCalculateState() {
        battery.calculateState(100F);
        assertEquals(BatteryState.NONCRITICAL, battery.getState());

        battery.calculateState(10000F);
        assertEquals(BatteryState.CRITICAL, battery.getState());

    }

}
