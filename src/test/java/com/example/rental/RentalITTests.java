package com.example.rental;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@SpringBootTest
public class RentalITTests {

    private  Car car;
    private  Car car1;

    private Rent rent;
    private Rent rent1;

    @Autowired
    private RentalService rentalService;

    @BeforeEach
    public void setUp() {
        car = new Car("1212", CarClass.STANDARD, "Toyota", "Corrola");
        car1 = new Car("1213", CarClass.PREMIUM, "Mercedes", "AMG");
        rent = new Rent("Patryk", LocalDate.of(2024, 01, 20), LocalDate.of(2024, 01, 22), car);
        rent1 = new Rent("Bartlomiej", LocalDate.of(2024, 01, 26), LocalDate.of(2024, 01, 27), car1);
        rentalService.getCarStorage().addCar(car);
        rentalService.getCarStorage().addCar(car1);
        rentalService.getRentStorage().addRent(rent);
        rentalService.getRentStorage().addRent(rent1);

    }

    @AfterEach
    public void afterTest(){
        rentalService.getCarStorage().getCarList().clear();
        rentalService.getRentStorage().getRentList().clear();
    }

    @Test
    void shouldCarExist() {
        Assertions.assertTrue(rentalService.doesCarExist("1212"));
        Assertions.assertFalse(rentalService.doesCarExist("ABCD"));

    }

    @Test
    void shouldEstimatePrice() {

        double price = 450 ;
        double price1 = 500;

        Assertions.assertEquals(price, rentalService.estimatePrice("1212", LocalDate.of(2024, 01, 20), LocalDate.of(2024, 01, 23)));
        Assertions.assertEquals(price1, rentalService.estimatePrice("1213", LocalDate.of(2024, 01, 20), LocalDate.of(2024, 01, 22)));
        Assertions.assertThrows(RuntimeException.class, () -> rentalService.estimatePrice("ABCD", LocalDate.of(2024, 01, 20), LocalDate.of(2024, 01, 21)));

    }

    @Test
    void shouldAssumeIfCanRent () {
        Assertions.assertTrue(rentalService.isAvailableToRent("1212", LocalDate.of(2024, 01, 23), LocalDate.of(2024, 01, 25)));
        Assertions.assertFalse(rentalService.isAvailableToRent("1213", LocalDate.of(2024, 01, 25), LocalDate.of(2024, 01, 29)));
    }

    @Test
    void shouldCreateRent() {
        Assertions.assertNotNull(rentalService.createRent("Kordian", car, LocalDate.of(2024, 01, 28),LocalDate.of(2024, 01, 30)));
        Assertions.assertThrows(RuntimeException.class, () -> rentalService.createRent("Kordian", car, LocalDate.of(2024,01,19), LocalDate.of(2024, 01, 23)));
    }
}
