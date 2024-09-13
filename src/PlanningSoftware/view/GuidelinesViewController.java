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

import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Controller for the guidelines-view.
 */
public class GuidelinesViewController {

    /**
     * Opens a link to a website about guidelines for flying a drone.
     * @throws URISyntaxException
     * @throws IOException
     */
    @FXML
    public void openLink() throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://www.drohnen.de/vorschriften-genehigungen-fuer-die-nutzung-von-drohnen-und-multicoptern/"));
    }

}
