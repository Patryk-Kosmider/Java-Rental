package com.example.rental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarUnitTests {
    @Test
    void createCar() {
        Car car = new Car("1212", CarClass.STANDARD, "Toyota", "Corolla");

        Assertions.assertEquals("1212", car.getVIN());
        Assertions.assertEquals(CarClass.STANDARD, car.getCarClass());
        Assertions.assertEquals("Toyota", car.getMarka());
        Assertions.assertEquals("Corrola", car.getModel());
    }
}
