/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package PlanningSoftware.client;

/**
 * Holds and controls the Data that will be sent to DroneController (Server).
 * Determines reaction based on received Data from DroneController.
 */
public class ClientDataController {

    /** data that will be sent to server */
    private String message = "default";

    /** indicates wether message and thus the data to send is new */
    private boolean newData = true;

    // ----------------------------- singleton ---------------
    // private constructor
    private ClientDataController() {

    }

    // private and only instance
    private static final ClientDataController ClientDataControllerInstance = new ClientDataController();

    /**
     * @return singleton-instance of ClientDataController
     */
    public static ClientDataController getInstance() {
        return ClientDataControllerInstance;
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
    public void setMessage(String message) {this.message = message;}

    /**
     * Returns if there is new data to send or not.
     * @return (boolean)
     */
    public boolean isNewData() {
        return newData;
    }

    /**
     * Updates if there is new data to send or not.
     * @param newData
     */
    public void setNewData(boolean newData) {
        this.newData = newData;
    }

    /**
     * Handles the received Data, determines what to do depending on received data.
     * Received data has to look like this: action/data(/data/...) eg. altitudeWarning/120m erreicht
     * @param receivedData (String) data received from server
     */
    public void handleReceivedData(String receivedData) {
        String[] data = receivedData.split("/");

        if (data[0].equalsIgnoreCase("altitudeWarning")) {
            // TODO
        }
    }
}
