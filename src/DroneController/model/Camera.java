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

import DroneController.resources.CameraSetting;

/**
 * This class represents the camera of the drone.
 */
public class Camera {

    /**
     * Enumeration.
     * Setting has one of two values: filming or photo.
     * Determines wether the camera will take pictures or videos.
     */
    private CameraSetting setting;

    /**
     * Boolean that represents wether the camera is currently filming or not.
     * Will only be used when setting = filming.
     */
    private boolean cameraOn;


    /**
     * Constructor without parameters.
     * Camera-Object with photo-setting and cameraOm = false will be instantiated.
     */
    public Camera() {
        this.setting = CameraSetting.PHOTO;
        this.cameraOn = false;
    }

    /**
     * @return value of setting (Setting)
     */
    public CameraSetting getSetting() {
        return setting;
    }

    /**
     * Updates the setting.
     * @param setting new setting of camera
     */
    public void setSetting(CameraSetting setting) {
        this.setting = setting;
    }

    /**
     * @return value of cameraOn (boolean)
     */
    public boolean getCameraOn() {
        return cameraOn;
    }

    /**
     * Updates value of camera, starts/stops filming.
     * @param cameraOn boolean-value, if filming shall be started/stopped
     */
    public void setCameraOn(boolean cameraOn) {
        this.cameraOn = cameraOn;
    }

}
