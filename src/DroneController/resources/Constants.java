/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package DroneController.resources;

/**
 * This interface holds constants, that are referenced from model- and control-package.
 */
public interface Constants {

    // general
    float ZERO_F = 0.0F;
    int ZERO = 0;
    String EMPTY_STRING = "";

    // Battery
    int FULL_BATTERY = 100;
    double TEN_SECONDS = 10.0;
    String WARNING_BATTERY = "Achtung: Batteriestand kritisch. Bitte zurückkehren.";

    // Movement
    int METERS_PER_5_PERCENT_CAPACITY = 200;
    int FIVE_PERCENT = 5;
    float SLOW_HEIGHT_MOVEMENT = 0.5F;
    float STANDARD_HEIGHT_MOVEMENT = 1F;
    float CINEMA_HEIGHT_MOVEMENT = 1.8F;
    float WARNING_ALTITUDE = 120F;
    String WARNING_ALTITUDE_REACHED = "Achtung! " + Constants.WARNING_ALTITUDE + "m erreicht";

    // Rotors
    int NUMBER_OF_ROTORS = 4;



    // Data Controller
    String UP = "up";
    String DOWN = "down";
    String LEFT = "left";
    String RIGHT = "right";
    String BACKWARDS = "backwards";
    String FORWARDS = "forwards";

}
