/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package PlanningSoftware.main;

import javafx.application.Application;
import javafx.stage.Stage;
import PlanningSoftware.view.StartViewController;

import java.io.IOException;

/**
 * Main-Class.
 * Will start the GUI of the Planning-Software.
 */
public class FXMain extends Application {

    /**
     * Opens the first Stage
     * @param primaryStage first Stage
     * @throws IOException
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        StartViewController startView = new StartViewController();
        startView.start(primaryStage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }






}
