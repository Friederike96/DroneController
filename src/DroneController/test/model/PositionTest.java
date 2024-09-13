/*
 * Project: DroneController-PlanningSoftware
 *
 * Project at Hochschule Bremen, Faculty IV
 * Degree: Technische Informatik
 * Module: PROG2
 *
 * Author:  Friederike Korte
 */

package DroneController.test.model;

import static org.junit.Assert.*;

import DroneController.model.Position;
import org.junit.*;


/**
 * JUnit-Test for Position
 * Methods that will be tested: setWorldPositionY(), setWorldPositionX(), setWorldPositionZ()
 */
public class PositionTest {

    private Position position;

    @Before
    public void initPosition() {
        position = new Position();
    }

    @Test
    public void testSetWorldPositionXYZ() {

        assertEquals(0F, position.getWorldPosition()[2], 0.001);
        position.setWorldPositionZ(2);
        assertEquals(2F, position.getWorldPosition()[2], 0.001);

        position.setWorldPositionX(2);
        assertEquals(2F, position.getWorldPosition()[0], 0.001);

        position.setWorldPositionY(2);
        assertEquals(2F, position.getWorldPosition()[1], 0.001);
    }


}
