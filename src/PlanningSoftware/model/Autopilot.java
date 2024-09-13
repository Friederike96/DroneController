/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package PlanningSoftware.model;

import DroneController.model.Position;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an autopilot, that will automatically fly the drone along a given route.
 */
public class Autopilot {

    /**
     * ArrayList of all positions, that the drone shall fly to (= route to fly).
     * The drone will fly to these positions in the given order of the list.
     */
    private final List<Position> route = new ArrayList<>();

    /**
     * Constructor without parameters.
     * Empty ArrayList of Positions will be generated.
     */
    public Autopilot() {
    }

    /**
     * @return route (List)
     */
    public List<Position> getRoute() {
        return route;
    }

    /**
     * Adds the given Position to the end of the route (ArrayList).
     * @param position that will be added to route
     */
    public void addPosition(Position position) {
        this.route.add(position);
    }

    /**
     * Appends all Positions from the route to a String.
     * @return String text
     */
    public String routePointsTostring() {
        StringBuilder text = new StringBuilder();

        for (Position position : this.route) {
            if (((getRoute().indexOf(position)+1) % 4) == 0) {
                text.append(position.toString()).append("\n");
            }
            else {
                text.append(position.toString()).append(", ");
            }
        }

        return text.toString();
    }

    /**
     * Deletes all Positions from route.
     */
    public void deleteRoutePoints() {
        this.route.clear();
    }

}
