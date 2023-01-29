package ie.atu.dip;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void generateRandomCar() {
        Car car = Car.randomCar("TEST1");

        assertNotNull(car);
        assertEquals("TEST1", car.getPlateNumber());

        assertFalse(car.getColor().isBlank());
        assertFalse(car.getType().isBlank());
    }
}