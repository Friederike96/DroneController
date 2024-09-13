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
 * This class is a controller that handles the position of the drone.
 * This class is a singleton.
 */
public class PositionController {


    // ----------------------------- singleton ---------------
    // private instructor
    private PositionController() {
    }

    //private and only instance
    private static final PositionController PositionControllerInstance = new PositionController();

    /**
     * @return singleton-instance of PositionController
     */
    public static PositionController getInstance() {
        return PositionControllerInstance;
    }
    // -------------------------------------------------------


    /**
     * Updates the x-coordinate of the current position.
     * Adds/deducts the coordinate by the given value.
     * @param meters (float) can be negative or positive
     */
    public void updateCurrentWorldPositionX(float meters) {
        DroneController.getInstance().getDrone().getCurrentPosition().setWorldPositionX(meters);
    }

    /**
     * Updates the y-coordinate of the current position.
     * Adds/deducts the coordinate by the given value.
     * @param meters (float) can be negative or positive
     */
    public void updateCurrentWorldPositionY(float meters) {
        DroneController.getInstance().getDrone().getCurrentPosition().setWorldPositionY(meters);
    }

    /**
     * Updates the z-coordinate of the current position.
     * Adds/deducts the coordinate by the given value.
     * @param meters (float) can be negative or positive
     */
    public void updateCurrentWorldPositionZ(float meters) {
        DroneController.getInstance().getDrone().getCurrentPosition().setWorldPositionZ(meters);
    }

    /**
     * Calculates the distance between current position of the drone and starting position.
     * Returns calculated distance as double.
     * Displays current Position in Console, since this will not be shown in the simulator.
     * @return (double) distance
     */
    public float calculateDistance() {
        System.out.println(DroneController.getInstance().getDrone().getCurrentPosition().toString());

        return calculateVectorLength(
                DroneController.getInstance().getDrone().getStartingPosition().getWorldPosition(),
                DroneController.getInstance().getDrone().getCurrentPosition().getWorldPosition()
        );
    }

    /**
     * Calculates vector-length between two points in a three-dimensional coordinate-system.
     * @param pointA float[3]
     * @param pointB float[3]
     * @return (float) vector-length
     */
    private float calculateVectorLength (float[] pointA, float[] pointB) {
        double x0 = pointA[0];
        double y0 = pointA[1];
        double z0 = pointA[2];

        double x1 = pointB[0];
        double y1 = pointB[1];
        double z1 = pointB[2];

        // distance = sqrt( (x1-x0)² + (y1-y0)² + (z1-z0)² )
        double x = (x1 - x0) * (x1 - x0);
        double y = (y1 - y0) * (y1 - y0);
        double z = (z1 - z0) * (z1 - z0);

        double distance = Math.sqrt(x + y + z);

        return (float) distance;
    }

}
