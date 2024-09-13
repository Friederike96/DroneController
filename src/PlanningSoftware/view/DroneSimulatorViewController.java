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

import PlanningSoftware.client.ClientDataController;
import PlanningSoftware.control.AutopilotController;
import DroneController.control.BatteryController;
import DroneController.control.MovementController;
import DroneController.control.CameraController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import PlanningSoftware.resources.ViewConstants;

/**
 * Controller for the drone-simulator-view, where the drone can be flown manually and routes can be planned.
 */
public class DroneSimulatorViewController {

    // ProgressBar -----------------------------------------------------
    @FXML
    private ProgressBar barBatteryCapacity;

    // Button -----------------------------------------------------------
    @FXML
    private Button buttonCinema;

    @FXML
    private Button buttonPhoto;

    @FXML
    private Button buttonSlow;

    @FXML
    private Button buttonStandard;

    @FXML
    private Button buttonStartCamera;

    @FXML
    private Button buttonVideo;


    // Label --------------------------------------------------------------
    @FXML
    private Label labelDistance;

    @FXML
    private Label labelHeight;

    @FXML
    private Label labelWarningAltitude;

    @FXML
    private Label labelBatteryPercentage;

    @FXML
    private Label labelBatteryWarning;

    @FXML
    private Label labelFlightPlanWarning;


    // Text Area -----------------------------------------------------------
    @FXML
    private TextArea textAreaPlannedFlightPoints;

    //Text Field -----------------------------------------------------------
    @FXML
    private TextField textFieldXCoordinate;

    @FXML
    private TextField textFieldYCoordinate;

    @FXML
    private TextField textFieldZCoordinate;


    /**
     * Increases height when button up ("Hoch") got clicked.
     */
    @FXML
    public void handleButtonUpClicked() throws Exception {
        MovementController.getInstance().moveUp();
        updateLabelHeight();

        ClientDataController.getInstance().setMessage(ViewConstants.UP);
        ClientDataController.getInstance().setNewData(true);
    }

    /**
     * Decreases height when button down ("Runter") got clicked.
     */
    @FXML
    public void handleButtonDownClicked() {
        MovementController.getInstance().moveDown();
        updateLabelHeight();

        ClientDataController.getInstance().setMessage(ViewConstants.DOWN);
        ClientDataController.getInstance().setNewData(true);
    }

    /**
     * Moves forwards when button forwards ("vorwärts") got clicked.
     */
    @FXML
    public void handleButtonForwardsClicked() {
        MovementController.getInstance().moveForward();
        updateLabelDistance();

        ClientDataController.getInstance().setMessage(ViewConstants.FORWARDS);
        ClientDataController.getInstance().setNewData(true);
    }

    /**
     * Moves backwards when button backwards ("rückwärts") got clicked.
     */
    @FXML
    public void handleButtonBackwardsClicked() {
        MovementController.getInstance().moveBackward();
        updateLabelDistance();

        ClientDataController.getInstance().setMessage(ViewConstants.BACKWARDS);
        ClientDataController.getInstance().setNewData(true);
    }

    /**
     * Moves leftwards when button left ("links") got clicked.
     */
    @FXML
    public void handleButtonLeftClicked() {
        MovementController.getInstance().moveLeft();
        updateLabelDistance();

        ClientDataController.getInstance().setMessage(ViewConstants.LEFT);
        ClientDataController.getInstance().setNewData(true);
    }

    /**
     * Moves rightwards when button right ("rechts") got clicked.
     */
    @FXML
    public void handleButtonRightClicked() {
        MovementController.getInstance().moveRight();
        updateLabelDistance();

        ClientDataController.getInstance().setMessage(ViewConstants.RIGHT);
        ClientDataController.getInstance().setNewData(true);
    }


    /**
     * Sets flight mode to SLOW when button slow got clicked.
     * Will change slow-button to black and the other two flight-mode-buttons back to regular color.
     */
    @FXML
    public void handleButtonSlowClicked() {
        MovementController.getInstance().setFlightModeSlow();
        this.buttonSlow.setBlendMode(BlendMode.DIFFERENCE);

        this.buttonStandard.setBlendMode(BlendMode.SRC_OVER);
        this.buttonCinema.setBlendMode(BlendMode.SRC_OVER);
    }

    /**
     * Sets flight mode to STANDARD when button standard got clicked.
     * Will change standard-button to black and the other two flight-mode-buttons back to regular color.
     */
    @FXML
    public void handleButtonStandardClicked() {
        MovementController.getInstance().setFlightModeStandard();
        this.buttonStandard.setBlendMode(BlendMode.DIFFERENCE);

        this.buttonSlow.setBlendMode(BlendMode.SRC_OVER);
        this.buttonCinema.setBlendMode(BlendMode.SRC_OVER);
    }

    /**
     * Sets flight mode to CINEMA when button cinema got clicked.
     * Will change cinema-button to black and the other two flight-mode-buttons back to regular color.
     */
    @FXML
    public void handleButtonCinemaClicked() {
        MovementController.getInstance().setFlightModeCinema();
        this.buttonCinema.setBlendMode(BlendMode.DIFFERENCE);

        this.buttonSlow.setBlendMode(BlendMode.SRC_OVER);
        this.buttonStandard.setBlendMode(BlendMode.SRC_OVER);
    }

    /**
     * Sets camera mode to taking photos when button got clicked.
     * Will change photo-button to black and video-button back to regular color.
     */
    @FXML
    public void handleButtonPhotoModeClicked() {
        CameraController.getInstance().setCameraToPhotoMode();
        this.buttonPhoto.setBlendMode(BlendMode.DIFFERENCE);
        this.buttonVideo.setBlendMode(BlendMode.SRC_OVER);
    }

    /**
     * Sets camera mode to taking videos when button got clicked.
     * Will change video-button to black and photo-button back to regular color.
     */
    @FXML
    public void handleButtonVideoModeClicked() {
        CameraController.getInstance().setCameraToVdeoMode();
        this.buttonVideo.setBlendMode(BlendMode.DIFFERENCE);
        this.buttonPhoto.setBlendMode(BlendMode.SRC_OVER);
    }

    /**
     * Will start or stop filming, depending on if the camera is already filming.
     * For that the camera mode has to be set to filming.
     * When camera starts filming, the button will turn black.
     * When camera stops filming, the button will be set back to regular color.
     *
     */
    @FXML
    public void handleButtonStartCameraClicked() {
        CameraController.getInstance().startOrStopFilming();
        if (CameraController.getInstance().isCameraOn()) {
            this.buttonStartCamera.setBlendMode(BlendMode.DIFFERENCE);
        }
        else {
            this.buttonStartCamera.setBlendMode(BlendMode.SRC_OVER);
        }
    }


    /**
     * Will add the given coordinates [x y z] as a new flight point to the current route.
     * If given input from the textfields is invalid (it has to be an integer) an error message
     * will be displayed.
     * Once the error message is displayed, it will only be vanished when a valid point got added to the route.
     */
    @FXML
    public void handleAddFlightPointClicked() {
        String xCoordinate = this.textFieldXCoordinate.getText();
        String yCoordinate = this.textFieldYCoordinate.getText();
        String zCoordinate = this.textFieldZCoordinate.getText();

        String errorMessage = AutopilotController.getInstance().addFlightPoint(xCoordinate, yCoordinate, zCoordinate);
        this.labelFlightPlanWarning.setText(errorMessage);

        updateTextAreaFlightPoints();
    }

    /**
     * Autopilot will be started.
     * The autopilot will be flying the drone along the given route points and stop at the last given point.
     * @throws InterruptedException
     */
    @FXML
    public void handleButtonStartRouteClicked() throws InterruptedException {
        AutopilotController.getInstance().startAutopilot();
        updateLabelHeight();
        updateLabelDistance();
    }

    /**
     * Will delete all points from the current route.
     */
    @FXML
    public void handleButtonDeleteRouteClicked() {
        AutopilotController.getInstance().deleteFlightPoints();
        updateTextAreaFlightPoints();
    }

    /**
     * Will create a new, empty route.
     */
    @FXML
    public void handleButtonRouteNewClicked() {
        AutopilotController.getInstance().createNewAutopilot();
        updateTextAreaFlightPoints();
    }

    /**
     * Will switch back to the previous route and display it.
     * If there is no previous route, nothing will happen.
     */
    @FXML
    public void handleButtonRouteBeforeClicked() {
        AutopilotController.getInstance().getPreviousAutopilot();
        updateTextAreaFlightPoints();
    }

    /**
     * Will switch to the next route and display it.
     * If there is no next route, nothing will happen.
     */
    @FXML
    public void handleButtonRouteNextClicked() {
        AutopilotController.getInstance().getNextAutopilot();
        updateTextAreaFlightPoints();
    }



    /*
    functions that are private, since they will not be referred to from fxml-file
     */

    /**
     * Updates the Text Area that shows all flight points from the current route.
     */
    private void updateTextAreaFlightPoints() {
        String flightPointsText = AutopilotController.getInstance().getFlightPointsText();
        this.textAreaPlannedFlightPoints.setText(flightPointsText);
    }

    /**
     * Updates the label that shows the height-information.
     */
    @FXML
    private void updateLabelHeight() {
        String heightText = MovementController.getInstance().getDroneHeight();
        this.labelHeight.setText(heightText);
        updateLabelWarningAltitude();
        updateLabelDistance();
    }

    /**
     * Updates the label that shows the altitude warning.
     * The warning message will only be shown when the height reached 120m.
     */
    private void updateLabelWarningAltitude() {
        String warning = MovementController.getInstance().checkWarningAltitude();
        this.labelWarningAltitude.setText(warning);
    }

    /**
     * Updates the label that shows the distance-information.
     */
    private void updateLabelDistance() {
        String distanceText = MovementController.getInstance().calculateDistance();
        this.labelDistance.setText(distanceText);
        checkBatteryInfo();
    }


    /**
     * Calls three methods that will check status and capacity of battery and display it.
     */
    private void checkBatteryInfo() {
        updateLabelBatteryStatus();
        updateProgressBarBatteryCapacity();
        updateLabelBatteryPercentage();
    }

    /**
     * Updates the progressbar, that displays the battery capacity.
     */
    private void updateProgressBarBatteryCapacity() {
        double progress = BatteryController.getInstance().getBatteryCapacity();
        double percentage = progress/100;  //change 2-digit-number to decimal number
        this.barBatteryCapacity.setProgress(percentage);
    }

    /**
     * Checks, if the battery-status is critical.
     * As soon as the critical status is reached, a warning message will be displayed.
     */
    private void updateLabelBatteryStatus() {
        String warning = BatteryController.getInstance().checkBatteryStatus();
        this.labelBatteryWarning.setText(warning);
    }

    /**
     * Updates the value of the battery percentage (number).
     */
    private void updateLabelBatteryPercentage() {
        String batteryPercentageText = BatteryController.getInstance().getBatteryPercentage();
        this.labelBatteryPercentage.setText(batteryPercentageText);
    }

}
