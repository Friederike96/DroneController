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
 * This class represents the position in a three-dimensional room with a x-, y- and z-axis.
 */
public class Position {

    // [x y z] in meters
    /**
     * Represents a coordinate in three three-dimensional room.
     * [x y z] in meters
     */
    private float[] worldPosition = new float[3];

    /**
     * Constructor without parameters.
     * Will initialize a Position where all values of worldPosition will be 0[zero].
     * because the starting point will always be seen as the nullpoint.
     */
    public Position() {
        this.worldPosition[0] = Constants.ZERO_F;
        this.worldPosition[1] = Constants.ZERO_F;
        this.worldPosition[2] = Constants.ZERO_F;
    }

    /**
     * Constructor with parameter.
     * Will initialize a Position where values of worldPosition [x y z] will be the given values [x y z].
     * @param worldPosition (float[3]) positive and negative values are allowed
     */
    public Position(float[] worldPosition) {
        this.worldPosition = worldPosition;
    }

    /**
     * @return value of worldPosition (float-Array)
     */
    public float[] getWorldPosition() {
        return this.worldPosition;
    }

    /**
     * Updates the world position with the given position.
     * @param worldPosition (float[3]) positive and negative values are allowed
     */
    public void setWorldPosition(float[] worldPosition) {
        this.worldPosition = worldPosition;
    }

    /**
     * Updates x-cooridnate of woldPosition.
     * @param xMovement value in meters to be added/subtracted to x-ccordinate
     */
    public void setWorldPositionX(float xMovement) {
        float xCoordinate = this.worldPosition[0];
        this.worldPosition[0] = xCoordinate + xMovement;
//        if (this.worldPosition[2] != Constants.ZERO_F) {
//            this.worldPosition[0] = xCoordinate + xMovement;
//        }
    }

    /**
     * Updates y-cooridnate of woldPosition.
     * @param yMovement value in meters to be added/subtracted to y-ccordinate
     */
    public void setWorldPositionY(float yMovement) {
        float yCoordinate = this.worldPosition[1];
        this.worldPosition[1] = yCoordinate + yMovement;
//        if (this.worldPosition[2] != Constants.ZERO_F) {
//            this.worldPosition[1] = yCoordinate + yMovement;
//        }
    }

    /**
     * Updates z-cooridnate of woldPosition.
     * @param zMovement value in meters to be added/subtracted to z-ccordinate
     */
    public void setWorldPositionZ(float zMovement) {
        float zCoordinate = this.worldPosition[2];
        this.worldPosition[2] = zCoordinate + zMovement;
//        if (zCoordinate + zMovement < 0F) {
//            this.worldPosition[2] = Constants.ZERO_F;
//        }
//        else {
//            this.worldPosition[2] = zCoordinate + zMovement;
//        }
    }

    /**
     * Resets values to start settings in case of a new start.
     */
    public void setToStartSettings() {
        this.worldPosition[0] = Constants.ZERO_F;
        this.worldPosition[1] = Constants.ZERO_F;
        this.worldPosition[2] = Constants.ZERO_F;
    }

    /**
     * Concatenates x-, y- and z-coordinate to a String.
     * @return string
     */
    public String toString() {
        return "["
                + this.worldPosition[0] + ", "
                + this.worldPosition[1] + ", "
                + this.worldPosition[2] + "]";
    }

}
