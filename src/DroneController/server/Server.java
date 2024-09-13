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

import java.io.*;
import java.net.*;

/**
 * This class implements a server, that can connect to the client located in the planning software.
 */
public class Server {

    /**
     * Starts the Server.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(1013);                // create new connection on port 1013
        Socket socket = serverSocket.accept();                                  // accept connection from client
        System.out.println("connected");

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());  // to send data
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());      // to receive data
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String receivedData = dataInputStream.readUTF();                       // received data from simulator
            ServerDataController.getInstance().handleReceivedData(receivedData);    // handle received data
            System.out.println("received Data from simulator: " + receivedData);

            String dataToSend = ServerDataController.getInstance().getMessage();    // get data to send back to simulator
            dataOutputStream.writeUTF(dataToSend);                                 // send data to simulator (client)

            if (receivedData.equalsIgnoreCase("exit")){                 // stop connection
                break;
            }

        }

        socket.close();     // close connection

    }


}
