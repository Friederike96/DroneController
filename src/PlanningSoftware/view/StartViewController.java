/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package PlanningSoftware.view;

import DroneController.control.DroneController;
import DroneController.control.RotorsController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the start-view.
 */
public class StartViewController {

    /**
     * Empty constructor.
     * Needed to start application.
     */
    public StartViewController() {

    }

    /**
     * This method will start the application.
     * The first stage (start-view) will be opened.
     * @param primaryStage (Stage)
     * @throws IOException
     */
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start-view.fxml"));
        Scene startViewScene = new Scene(fxmlLoader.load());

        primaryStage.setScene(startViewScene);
        primaryStage.setTitle("Start");
        primaryStage.show();
    }

    /**
     * Starts a new dialog once the about button ("Anwendungs-Hinweise") was clicked.
     * @throws IOException
     */
    @FXML
    public void handleAboutButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("about-view.fxml"));
        DialogPane dialogPane = fxmlLoader.load();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);

        dialog.setTitle("Anwendungs-Hinweise");
        dialog.show();
    }


    /**
     * Starts a new dialog once the guidelines button ("Vorschriften") was clicked.
     * @throws IOException
     */
    @FXML
    public void handleGuidelinesButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("guidelines-view.fxml"));
        DialogPane dialogPane = fxmlLoader.load();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);

        dialog.setTitle("Gesetzliche Vorschriften");
        dialog.show();
    }

    /**
     * Starts a new dialog once the start button was clicked.
     * This is the main part of the application, where the drone can be flown.
     * @throws IOException
     */
    @FXML
    public void handleStartButtonClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("drone-simulator-view.fxml"));
        DialogPane dialogPane = fxmlLoader.load();

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setDialogPane(dialogPane);

        dialog.setTitle("Flug-Planungs-Software");
        dialog.show();

        RotorsController.getInstance().startRotors();
    }

    /**
     * Will stop and close the application once stop button ("Beenden") was clicked.
     */
    @FXML
    public void handleStopApplication() {
        DroneController.getInstance().setToStartSettings();
        System.exit(1);
    }

}
