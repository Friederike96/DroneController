/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package DroneController.model;

import DroneController.resources.Constants;

/**
 * This class represents the Rotors of the drone.
 */
public class Rotors {

    /** Number of Rotors the drone has */
    private final int numberOfRotors;

    /** Boolean, if Rotors are currently on ore not */
    private boolean rotorsOn;

    /**
     * Constructor without parameter.
     * Rotors-Object will be instantiated by default with 4 rotors and rotors not on.
     */
    public Rotors() {
        this.numberOfRotors = Constants.NUMBER_OF_ROTORS;
        this.rotorsOn = false;
    }

    /**
     * Turns rotors either on or off, depending on the given value.
     * If rotors are turned on, an info about that will be given in the console.
     * @param rotorsOn (boolean) if rotors should be turned on (true) or not (false)
     */
    public void setRotorsOn(boolean rotorsOn) {
        this.rotorsOn = rotorsOn;
        if (rotorsOn) {
            System.out.println("Rotoren angeschaltet");
        }
    }

    /**
     * Resets setting to start-settings.
     * Rotors will be turned off.
     */
    public void setToStartSettings() {
        this.rotorsOn = false;
    }
}
