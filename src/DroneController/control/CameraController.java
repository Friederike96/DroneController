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

import DroneController.resources.CameraSetting;

/**
 * This class is a controller that handles the camera of the drone.
 * This class is a singleton.
 */
public class CameraController {



    // ----------------------------- singleton ---------------
    // private instructor
    private CameraController() {
    }

    //private and only instance
    private static final CameraController CameraControllerInstance = new CameraController();

    /**
     * @return singleton-instance of CameraController
     */
    public static CameraController getInstance() {
        return CameraControllerInstance;
    }
    // -------------------------------------------------------


    /**
     * Sets the camera-mode to photo (taking pictures).
     */
    public void setCameraToPhotoMode() {
        DroneController.getInstance().getDrone().getCamera().setSetting(CameraSetting.PHOTO);
    }

    /**
     * Sets the camera-mode to filming (taking videos).
     */
    public void setCameraToVdeoMode() {
        DroneController.getInstance().getDrone().getCamera().setSetting(CameraSetting.FILMING);
    }

    /**
     * Starts or stops filming, depending on if the camera is already filming.
     * Only possible, if camera mode is set to filming-mode.
     */
    public void startOrStopFilming() {
        boolean cameraOn = DroneController.getInstance().getDrone().getCamera().getCameraOn();

        if (DroneController.getInstance().getDrone().getCamera().getSetting() == CameraSetting.FILMING) {
            DroneController.getInstance().getDrone().getCamera().setCameraOn(!cameraOn);
        }
    }

    /**
     * Returns if camera is currently filming or not.
     * @return (boolean)
     */
    public boolean isCameraOn() {
        return DroneController.getInstance().getDrone().getCamera().getCameraOn();
    }


}
