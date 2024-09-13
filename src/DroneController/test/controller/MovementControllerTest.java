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
import DroneController.control.MovementController;
import DroneController.resources.Constants;
import org.junit.*;


/**
 * JUnit-Test for MovementConrtoller
 * Methods that will be tested: checkWarningAltitude()
 */
public class MovementControllerTest {

    private MovementController movementController;

    @Before
    public void initMovementController() {
        movementController = MovementController.getInstance();
    }

    @Test
    public void testCheckWarningAltitude() {
        assertEquals(Constants.EMPTY_STRING, movementController.checkWarningAltitude());

        DroneController.getInstance().getDrone().getMovement().increaseHeight(150F);
        assertEquals(Constants.WARNING_ALTITUDE_REACHED, movementController.checkWarningAltitude());
    }



}
