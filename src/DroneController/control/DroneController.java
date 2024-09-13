/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package DroneController.control;

import DroneController.model.Drone;

/**
 * This class is a controller that holds the drone-model.
 * This class is a singleton.
 */
public class DroneController {

    /** drone-model */
    private final Drone drone = new Drone();


    // ----------------------------- singleton ---------------
    // private instructor
    private DroneController() {
    }

    //private and only instance
    private static final DroneController DroneControllerInstance = new DroneController();

    /**
     * @return singleton-instance of DroneController
     */
    public static DroneController getInstance() {
        return DroneControllerInstance;
    }
    // -------------------------------------------------------


    /**
     * Returns the drone-object.
     * @return (DroneController)
     */
    public Drone getDrone() {
        return drone;
    }

    /**
     * Resets values of drone to start settings.
     */
    public void setToStartSettings() {
        this.drone.setToStartSettings();
    }

}
