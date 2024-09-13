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
import DroneController.resources.FlightMode;

/**
 * This class represents all movement-related things of the DroneController:
 * Height, Distance and FlightMode.
 */
public class Movement {

    /**
     * Enumeration.
     * FlightMode has one of three values: slow, standard or cinema.
     * The flightMode determines how fast/slow the drone will fly.
     */
    private FlightMode flightMode;

    /**
     * Distance between the current position and the starting position.
     */
    private float distance;

    /**
     * Height above the starting point.
     */
    private float height;

    /**
     * Constructor without parameters.
     * Movement-object with standard flightmode, zero distance and zero height will be instantiated.
     */
    public Movement() {
        this.flightMode = FlightMode.STANDARD;
        this.distance = Constants.ZERO_F;
        this.height = Constants.ZERO_F;
    }

    /**
     * @return value of flightMode (FlightMode)
     */
    public FlightMode getFlightMode() {
        return this.flightMode;
    }

    /**
     * Updates the value of flightMode.
     * @param flightMode new value of flightMode
     */
    public void setFlightMode(FlightMode flightMode) {
        this.flightMode = flightMode;
    }

    /**
     * @return value of distance (float)
     */
    public float getDistance() {
        return this.distance;
    }

    /**
     * Updates the value of distance.
     * @param distance new distance
     */
    public void setDistance(float distance) {

        this.distance = distance;
    }

    /**
     * @return value of height (float)
     */
    public float getHeight() {
        return this.height;
    }

    /**
     * Increases height by the given value.
     * @param meters to increase height by (float)
     */
    public void increaseHeight(float meters) {
        this.height += meters;
    }

    /**
     * Decreases height by the given value.
     * @param meters to decrease height by (float)
     */
    public void decreaseHeight(float meters) {
        this.height -= meters;
    }

    /**
     * Resets values to start settings in case of a new start.
     */
    public void setToStartSettings() {
        this.flightMode = FlightMode.STANDARD;
        this.distance = Constants.ZERO_F;
        this.height = Constants.ZERO_F;
    }

}
