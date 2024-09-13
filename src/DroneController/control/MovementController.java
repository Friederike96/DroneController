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

import DroneController.resources.Constants;
import DroneController.resources.FlightMode;

import java.text.DecimalFormat;

/**
 * This class is a controller that handles the movement of the drone.
 * This class is a singleton.
 */
public class MovementController {


    // ----------------------------- singleton ---------------
    // private instructor
    private MovementController() {
    }

    //private and only instance
    private static final MovementController MovementControllerInstance = new MovementController();

    /**
     * @return singleton-instance of MovementController
     */
    public static MovementController getInstance() {
        return MovementControllerInstance;
    }
    // -------------------------------------------------------


    /**
     * Moves the drone up.
     * Movement depends on flight-mode.
     */
    public void moveUp() {
        float meters = determineMovementInMeters();

        DroneController.getInstance().getDrone().getMovement().increaseHeight(meters);
        PositionController.getInstance().updateCurrentWorldPositionZ(meters);
    }

    /**
     * Moves the drone down.
     * Movement depends on flight-mode.
     */
    public void moveDown() {
        float meters = determineMovementInMeters();

        DroneController.getInstance().getDrone().getMovement().decreaseHeight(meters);
        PositionController.getInstance().updateCurrentWorldPositionZ(-meters);
    }

    /**
     * Moves the drone leftwards.
     * Movement depends on flight-mode.
     */
    public void moveLeft() {
        float meters = determineMovementInMeters();
        PositionController.getInstance().updateCurrentWorldPositionY(-meters);
    }

    /**
     * Moves the drone righwards.
     * Movement depends on flight-mode.
     */
    public void moveRight() {
        float meters = determineMovementInMeters();
        PositionController.getInstance().updateCurrentWorldPositionY(meters);
    }

    /**
     * Moves the drone forwards.
     * Movement depends on flight-mode.
     */
    public void moveForward() {
        float meters = determineMovementInMeters();
        PositionController.getInstance().updateCurrentWorldPositionX(meters);
    }

    /**
     * Moves the drone backwards.
     * Movement depends on flight-mode.
     */
    public void moveBackward() {
        float meters = determineMovementInMeters();
        PositionController.getInstance().updateCurrentWorldPositionX(-meters);
    }

    /**
     * Returns the current height as a String.
     * @return (String) height
     */
    public String getDroneHeight() {
        float updatedHeight = DroneController.getInstance().getDrone().getCurrentPosition().getWorldPosition()[2];

        DecimalFormat df = new DecimalFormat("##.#");
        return "Höhe: " + df.format(updatedHeight) + "m";
    }

    /**
     * Checks if legally allowed height is reached.
     * The threshold is currently 120m. (2023(
     * @return (String) Warning, if threshold is reached. Otherwise, an empty String will be returned.
     */
    public String checkWarningAltitude() {
        float currentHeight = DroneController.getInstance().getDrone().getMovement().getHeight();

        if (currentHeight > Constants.WARNING_ALTITUDE) {
            return Constants.WARNING_ALTITUDE_REACHED;
        }
        return Constants.EMPTY_STRING;
    }

    /**
     * Calculates the distance between current position of drone and starting position.
     * Returns the value as a String.
     * @return (String) distance
     */
    public String calculateDistance() {
        // calculate distance
        double distance = PositionController.getInstance().calculateDistance();

        // update value in movement-model
        DroneController.getInstance().getDrone().getMovement().setDistance((float) distance);

        DecimalFormat df = new DecimalFormat("##.#");
        return "Distanz: " + df.format(distance) + "m";
    }

    /**
     * Sets flight mode to SLOW.
     */
    public void setFlightModeSlow() {
        DroneController.getInstance().getDrone().getMovement().setFlightMode(FlightMode.SLOW);
    }

    /**
     * Sets flight mode to STANDARD.
     */
    public void setFlightModeStandard() {
        DroneController.getInstance().getDrone().getMovement().setFlightMode(FlightMode.STANDARD);
    }

    /**
     * Sets flight mode to CINEMA.
     */
    public void setFlightModeCinema() {
        DroneController.getInstance().getDrone().getMovement().setFlightMode(FlightMode.CINEMA);
    }

    /**
     * Returns how fast (n meters) the drone will be moving.
     * This depends on the flight mode.
     * @return (float) meters the drone will be moving
     */
    private float determineMovementInMeters() {
        FlightMode flightMode = DroneController.getInstance().getDrone().getMovement().getFlightMode();

        if (flightMode == FlightMode.SLOW) {
            return Constants.SLOW_HEIGHT_MOVEMENT;
        }
        else if (flightMode == FlightMode.STANDARD) {
            return Constants.STANDARD_HEIGHT_MOVEMENT;
        }
        else if (flightMode == FlightMode.CINEMA) {
            return Constants.CINEMA_HEIGHT_MOVEMENT;
        }
        else {
            return Constants.STANDARD_HEIGHT_MOVEMENT;
        }
    }

}
