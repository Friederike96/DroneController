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

import java.io.*;
import java.net.*;

/**
 * This class implements a client that can connect to the server located in the drone controller.
 */
public class Client {


    /**
     * Starts the Client.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 1013);                  // create new connection on port 1013

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream()); // to send data
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());     // to receive data


        while (true) {
            String dataToSend = "";

            //check if there is new data that needs to be sent
            if (ClientDataController.getInstance().isNewData()) {
                dataToSend = ClientDataController.getInstance().getMessage();    // get data to send to drone
                dataOutputStream.writeUTF(dataToSend);                              // send data to drone (server)
                ClientDataController.getInstance().setNewData(false);                   // inform dataController that data has been send
            }

            if (dataToSend.equalsIgnoreCase("exit")){
                break;
            }

            String receivedData = dataInputStream.readUTF();                        // received data from drone
            ClientDataController.getInstance().handleReceivedData(receivedData); // handle received data
            System.out.println("received Data from drone: " + receivedData);

        }

        socket.close();     // close connection
    }

}
