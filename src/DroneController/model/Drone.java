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

/**
 * This class represents the Drone.
 * This class will hold Objects of Battery, Camera, Position and Movement.
 */
public class Drone {

    /** Rotors of DroneController */
    private final Rotors rotors;

    /** Battery of DroneController */
    private final Battery battery;

    /** Camera of DroneController */
    private final Camera camera;

    /** starting Position of DroneController */
    private final Position startingPosition;

    /** current Position of DroneController */
    private final Position currentPosition;

    /** Movement of DroneController */
    private final Movement movement;

    /**
     * Constructor without parameters.
     * DroneController-Object with Battery, Camera, starting and current Position and Movement will be instantiated.
     */
    public Drone() {
        this.rotors = new Rotors();
        this.battery = new Battery();
        this.camera = new Camera();
        this.startingPosition = new Position();
        this.currentPosition = new Position();
        this.movement = new Movement();
    }

    /**
     * @return Rotors-Object
     */
    public Rotors getRotors() {
        return this.rotors;
    }

    /**
     * @return Battery-Object
     */
    public Battery getBattery() {
        return this.battery;
    }

    /**
     * @return Camera-Object
     */
    public Camera getCamera() {
        return this.camera;
    }

    /**
     * @return startingPosition-Object
     */
    public Position getStartingPosition() {
        return this.startingPosition;
    }

    /**
     * @return currentPosition-Object
     */
    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    /**
     * @return Movement-Object
     */
    public Movement getMovement() {
        return this.movement;
    }

    /**
     * Resets all values back to start settings.
     * Needed when application gets restarted.
     */
    public void setToStartSettings() {
        this.startingPosition.setToStartSettings();
        this.currentPosition.setToStartSettings();
        this.movement.setToStartSettings();
        this.battery.setToStartSettings();
        this.rotors.setToStartSettings();
    }

}
