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

import DroneController.model.Movement;
import org.junit.*;
import org.junit.jupiter.api.Order;


/**
 * JUnit-Test for Movement
 * Methods that will be tested: increaseHeight(), decreaseHeight()
 */
public class MovementTest {

    private Movement movement;

    @Before
    public void initMovement() {
        movement = new Movement();
    }

    @Test
    @Order(1)
    public void testIncreaseHeight() {
        assertEquals(0F, movement.getHeight(), 0.001);

        movement.increaseHeight(10F);
        assertEquals(10F, movement.getHeight(), 0.001);
    }

    @Test
    @Order(2)
    public void testDecreaseHeight() {
        movement.increaseHeight(10F);
        movement.decreaseHeight(5);
        assertEquals(5F, movement.getHeight(), 0.001);

        movement.decreaseHeight(10);
        assertEquals(-5F, movement.getHeight(), 0.001);
    }


}
