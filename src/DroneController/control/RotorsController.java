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

/**
 * This class is a controller that handles the movement of the drone.
 * This class is a singleton.
 */
public class RotorsController {


    // ----------------------------- singleton ---------------
    // private instructor
    private RotorsController() {
    }

    //private and only instance
    private static final RotorsController RotorsControllerInstance = new RotorsController();

    /**
     * @return singleton-instance of MovementController
     */
    public static RotorsController getInstance() {
        return RotorsControllerInstance;
    }
    // -------------------------------------------------------

    /**
     * Turns the rotors on.
     */
    public void startRotors() {
        DroneController.getInstance().getDrone().getRotors().setRotorsOn(true);
    }



}
