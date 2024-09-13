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

import DroneController.control.CameraController;
import DroneController.control.DroneController;
import DroneController.resources.CameraSetting;
import org.junit.*;


/**
 * JUnit-Test for CameraController
 * Methods that will be tested: startOrStopFilming()
 */
public class CameraControllerTest {

    private CameraController cameraController;

    @Before
    public void initCameraController() {
        cameraController = CameraController.getInstance();
    }

    @Test
    public void testStartOrStopFilming() {
        cameraController.startOrStopFilming();
        assertFalse(DroneController.getInstance().getDrone().getCamera().getCameraOn());

        DroneController.getInstance().getDrone().getCamera().setSetting(CameraSetting.FILMING);
        cameraController.startOrStopFilming();
        assertTrue(DroneController.getInstance().getDrone().getCamera().getCameraOn());

    }


}
