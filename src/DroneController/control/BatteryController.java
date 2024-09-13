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
import DroneController.resources.BatteryState;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * This class is a controller that handles the battery of the drone.
 * This class is a singleton.
 */
public class BatteryController {


    // ----------------------------- singleton ---------------
    // private instructor
    private BatteryController() {
    }

    //private and only instance
    private static final BatteryController BatteryControllerInstance = new BatteryController();

    /**
     * @return singleton-instance of BatteryController
     */
    public static BatteryController getInstance() {
        return BatteryControllerInstance;
    }

    // -------------------------------------------------------


    /**
     * Updates capacity of Battery and returns its value.
     * @return (int) capacity
     */
    public int getBatteryCapacity() {
        updateCapacity();
        return DroneController.getInstance().getDrone().getBattery().getCapacity();
    }

    /**
     * Checks wether batteryStatus should be critical or non-critical.
     * In case of critical a warning message will be returned. Otherwise, an empty string will be returned.
     * @return (String)
     */
    public String checkBatteryStatus() {
        float distance = DroneController.getInstance().getDrone().getMovement().getDistance();

        // calculates batteryStatus depending on distance
        DroneController.getInstance().getDrone().getBattery().calculateState(distance);

        if (DroneController.getInstance().getDrone().getBattery().getState() == BatteryState.CRITICAL) {
            return Constants.WARNING_BATTERY;
        }
        return Constants.EMPTY_STRING;
    }

    /**
     * Returns the value of battery capacity as a String.
     * @return (String)
     */
    public String getBatteryPercentage() {
        int percentage = DroneController.getInstance().getDrone().getBattery().getCapacity();
        return percentage + "%";
    }

    /**
     * Updates value of capacity.
     * Capacity will be decreased by one percent, if drone has been actively flying at some point in the last ten seconds.
     */
    private void updateCapacity() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime lastChecked = DroneController.getInstance().getDrone().getBattery().getCapacityCheckedTime();

        long timeDifference = ChronoUnit.SECONDS.between(lastChecked, now);

        if (timeDifference > Constants.TEN_SECONDS) {
            DroneController.getInstance().getDrone().getBattery().setCapacityCheckedTime(now);
            DroneController.getInstance().getDrone().getBattery().updateCapacity();
        }
    }


}
