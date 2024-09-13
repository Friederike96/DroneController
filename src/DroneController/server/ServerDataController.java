/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package DroneController.server;

import DroneController.control.MovementController;
import DroneController.resources.Constants;

/**
 * Holds and controls the Data that will be sent to PlanningSoftware (Client).
 * Determines reaction based on received Data from PlanningSoftware.
 */
public class ServerDataController {

    /** data that will be sent to client */
    private String message = "default";


    // ----------------------------- singleton ---------------
    // private constructor
    private ServerDataController() {

    }

    // private and only instance
    private static final ServerDataController ServerDataControllerInstance = new ServerDataController();

    /**
     * @return singleton-instance of ServerDataController
     */
    public static ServerDataController getInstance() {
        return ServerDataControllerInstance;
    }
    // -------------------------------------------------------


    /**
     * @return (String) message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Updates value of message with given String.
     * @param message (String)
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Handles the received Data, determines what to do depending on received data.
     * Received data has to look like this: action/data(/data/...) eg. up/1.0
     * @param receivedData (String) data received from client
     */
    public void handleReceivedData(String receivedData) {
        String[] data = receivedData.split("/");

        if (data[0].equalsIgnoreCase(Constants.UP)) {
            MovementController.getInstance().moveUp();  //TODO setmessage in method
        }
        else if (data[0].equalsIgnoreCase(Constants.DOWN)) {
            MovementController.getInstance().moveDown();
        }
        else if (data[0].equalsIgnoreCase(Constants.LEFT)) {
            MovementController.getInstance().moveLeft();
        }
        else if (data[0].equalsIgnoreCase(Constants.RIGHT)) {
            MovementController.getInstance().moveRight();
        }
        else if (data[0].equalsIgnoreCase(Constants.FORWARDS)) {
            MovementController.getInstance().moveForward();
        }
        else if (data[0].equalsIgnoreCase(Constants.BACKWARDS)) {
            MovementController.getInstance().moveBackward();
        }
    }
}
