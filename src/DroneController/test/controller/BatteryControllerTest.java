/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package DroneController.test.controller;

import static org.junit.Assert.*;

import DroneController.control.BatteryController;
import org.junit.*;
import java.util.concurrent.TimeUnit;


/**
 * JUnit-Test for BatteryController
 * Methods that will be tested: getBatteryCapacity(), updateCapacity()
 */
public class BatteryControllerTest {

    private BatteryController batteryController;

    @Before
    public void initBatteryController() {
        batteryController = BatteryController.getInstance();
    }

    // updateCapacity() is located in getBatteryCapacity and thus gets tested
    @Test
    public void testUpdateAndGetCapacity() throws InterruptedException {
        assertEquals(100, batteryController.getBatteryCapacity());
        TimeUnit.SECONDS.sleep(15);
        assertEquals(99, batteryController.getBatteryCapacity());
    }


}
