/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package PlanningSoftware.control;

import DroneController.control.DroneController;
import DroneController.model.Position;
import DroneController.resources.Constants;
import PlanningSoftware.model.Autopilot;
import PlanningSoftware.resources.ViewConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * This class is a controller that handles the autopilot of the drone.
 * This class is a singleton.
 */
public class AutopilotController {

    /** holds all existing autopilots */
    private List <Autopilot> autopilots = new ArrayList<>();

    /** id of the current chosen autopilot */
    private int chosenAutopilot;

    // ----------------------------- singleton ---------------
    // private instructor
    private AutopilotController() {
    }

    //private and only instance
    private static final AutopilotController AutopilotControllerInstance = new AutopilotController();

    /**
     * @return singleton-instance of AutopilotController
     */
    public static AutopilotController getInstance() {
        return AutopilotControllerInstance;
    }

    // -------------------------------------------------------

    /**
     * Returns previous autopilot. Needed to display previous route.
     */
    public void getPreviousAutopilot() {
        if (this.chosenAutopilot > 0) {
            this.chosenAutopilot -= 1;
        }
    }

    /**
     * Returns next autopilot. Needed to display next route.
     */
    public void getNextAutopilot() {
        if (this.chosenAutopilot < this.autopilots.size()) {
            this.chosenAutopilot += 1;
        }
    }

    /**
     * Adds the given flightPoint (Position) to route.
     * @param xCoordinate (String)
     * @param yCoordinate (String)
     * @param zCoordinate (String)
     * @return (String) Message, if adding was NOT succesfull. Empty string if it was successfull.
     */
    public String addFlightPoint(String xCoordinate, String yCoordinate, String zCoordinate) {
        int x;
        int y;
        int z;

        // parse String to Integer
        try {
            x = Integer.parseInt(xCoordinate);
            y = Integer.parseInt(yCoordinate);
            z = Integer.parseInt(zCoordinate);
        } catch (NumberFormatException e) {
            // return message when entry was not valid
            return ViewConstants.CHECK_ENTRIES;
        }

        if (this.autopilots.size() == 0) {
            createNewAutopilot();
        }

        // create new Position and add to route
        Position position = new Position(new float[]{x, y, z});
        this.autopilots.get(this.chosenAutopilot).addPosition(position);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        return Constants.EMPTY_STRING;
    }

    /**
     * Returns all flightPoints from route as String.
     * @return (String)
     */
    public String getFlightPointsText() {
        if (this.autopilots.size() > 0) {
            return this.autopilots.get(this.chosenAutopilot).routePointsTostring();
        }
        return ViewConstants.EMPTY;
    }

    /**
     * Deletes all flightPoints from route.
     */
    public void deleteFlightPoints() {
        if (this.autopilots.size() > 0) {
            this.autopilots.get(this.chosenAutopilot).deleteRoutePoints();
        }
    }

    /**
     * Starts to fly the saved route.
     * @throws InterruptedException
     */
    public void startAutopilot() throws InterruptedException {

        if (this.autopilots.size() > 0) {

            float[] currentPosition = DroneController.getInstance().getDrone().getCurrentPosition().getWorldPosition();
            float[] wantedPosition = this.autopilots.get(this.chosenAutopilot).getRoute().get(this.chosenAutopilot).getWorldPosition();

            for (int i = 0; i < wantedPosition.length; i++)
                if (currentPosition[i] != wantedPosition[i]) {
                    if (currentPosition[i] < wantedPosition[i]) {
                        currentPosition[i] += Constants.STANDARD_HEIGHT_MOVEMENT;
                    } else {
                        currentPosition[i] -= Constants.STANDARD_HEIGHT_MOVEMENT;
                    }
                }
            TimeUnit.MILLISECONDS.sleep(500);
            DroneController.getInstance().getDrone().getCurrentPosition().setWorldPosition(currentPosition);
        }

    }

    /**
     * Creates a new autopilot, so that a new route can be edited.
     */
    public void createNewAutopilot() {
        Autopilot autopilot = new Autopilot();
        this.autopilots.add(autopilot);
        this.chosenAutopilot = this.autopilots.size()-1;
    }

}
