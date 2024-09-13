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
import DroneController.resources.BatteryState;

import java.time.LocalDateTime;

/**
 * This class represents the battery of the DroneController.
 */
public class Battery {

    /**
     * Enumeration.
     * State has one of two values: critical or non-critical.
     * Critical indicates that the battery will last only enough for a straight flight back to the start-position.
     */
    private BatteryState state;

    /**
     * Capacity of the Battery. The integer-value represents the percentage.
     * Only values between 0 and 100 are valid.
     */
    private int capacity;

    /**
     * Date and Time of when the capacity of the Battery was last checked.
     * Needed for calculating the capacity.
     */
    private LocalDateTime capacityCheckedTime;

    /**
     * Constructor without parameters.
     * Battery-Object with full capacity (100%), noncritical-state and timestamp of instantiated time will be generated.
     */
    public Battery() {
        this.state = BatteryState.NONCRITICAL;
        this.capacity = Constants.FULL_BATTERY;
        this.capacityCheckedTime = LocalDateTime.now();
    }

    /**
     * Returns the state of the Battery.
     * @return value of state
     */
    public BatteryState getState() {
        return this.state;
    }

    /**
     * @return value of capacity (int)
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Decreases the capacity by one percent.
     */
    public void updateCapacity() {
        if (this.capacity > 0) {
            this.capacity -= 1;
        }
    }

    /**
     * @return value of capacityCheckedTime (LocalDateTime)
     */
    public LocalDateTime getCapacityCheckedTime() {
        return this.capacityCheckedTime;
    }

    /**
     * Updates the value of capacityCheckedTime.
     * @param capacityCheckedTime new Date and Time, when capacity was last checked
     */
    public void setCapacityCheckedTime(LocalDateTime capacityCheckedTime) {
        this.capacityCheckedTime = capacityCheckedTime;
    }

    /**
     * Calculates, if the state of the Battery is critical or noncritical.
     * @param distance distance of drone (@see Movement)
     */
    public void calculateState(float distance) {
        // 5% battery are needed for 200m distance
        int distanceCoreValue = ((int) distance)/Constants.METERS_PER_5_PERCENT_CAPACITY;
        int capacityCoreValue = this.capacity/Constants.FIVE_PERCENT;

        if (distanceCoreValue >= capacityCoreValue) {
            this.state = BatteryState.CRITICAL;
        }
        else {
            this.state = BatteryState.NONCRITICAL;
        }

    }

    /**
     * Resets values to start settings in case of a new start.
     */
    public void setToStartSettings() {
        this.state = BatteryState.NONCRITICAL;
        this.capacity = Constants.FULL_BATTERY;
        this.capacityCheckedTime = LocalDateTime.now();
    }

}
