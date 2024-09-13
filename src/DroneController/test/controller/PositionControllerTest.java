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

import DroneController.control.DroneController;
import DroneController.control.PositionController;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit-Test for Battery
 * Methods that will be tested: calculateDistance()
 */
public class PositionControllerTest {

    private PositionController positionController;

    @Before
    public void initPositionController() {
        positionController = PositionController.getInstance();
    }

    @Test
    public void testCalculateDistance() {
        assertEquals(0.0, positionController.calculateDistance(), 0.001);

        DroneController.getInstance().getDrone().getCurrentPosition().setWorldPosition(new float[]{1F, 1F, 1F});
        assertEquals(1.732, positionController.calculateDistance(), 0.001);
    }


}
