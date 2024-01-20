package com.example.rental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.*;

public class RentalServiceUnitTest {


    @Mock
    private CarStorage carStorage;
    @Mock
    private RentStorage rentStorage;

    @InjectMocks
    private RentalService rentalService;

    @Test
    void DoesCarExist() {
        MockitoAnnotations.openMocks(this);
        rentalService = new RentalService(carStorage, rentStorage);
        Mockito.when(carStorage.getCarList()).thenReturn(List.of(new Car("1212", CarClass.STANDARD, "Toyota", "Corrola")));
        Assertions.assertTrue(rentalService.doesCarExist("1212"));
        Assertions.assertFalse(rentalService.doesCarExist("AVCD"));

    }

    @Test
    void EstimatePrice(){
        MockitoAnnotations.openMocks(this);
        rentalService = new RentalService(carStorage, rentStorage);
        Mockito.when(carStorage.getCarList()).thenReturn(List.of(new Car("1212", CarClass.STANDARD, "Toyota", "Corrola")));
        double result = rentalService.estimatePrice("1212", LocalDate.of(2024, 01, 18), LocalDate.of(2024, 01, 20));
        double expected = 100 * 2 * 1.5;

        Assertions.assertEquals(expected, result);

        Assertions.assertThrows(RuntimeException.class, () -> rentalService.estimatePrice("ABC", LocalDate.parse("2024-01-18"), LocalDate.parse("2024-01-20")));

    }

    @Test
    void isAvailableToRent() {
        MockitoAnnotations.openMocks(this);
        rentalService = new RentalService(carStorage, rentStorage);
        Car car = new Car("1212", CarClass.STANDARD, "Toyota", "Corrola");
        Mockito.when(carStorage.getCarList()).thenReturn(List.of(car));
        Mockito.when(rentStorage.getRentList()).thenReturn(List.of(new Rent("Patryk", LocalDate.of(2024, 01, 20), LocalDate.of(2024, 01, 21), car)));

        Assertions.assertTrue(rentalService.isAvailableToRent("1212", LocalDate.of(2024,01,22), LocalDate.of(2024, 01, 23)));
        Assertions.assertFalse(rentalService.isAvailableToRent("1212", LocalDate.of(2024, 01, 19), LocalDate.of(2024,01,21)));
    }

    @Test
    void createRent() {
        MockitoAnnotations.openMocks(this);
        rentalService = new RentalService(carStorage,rentStorage);

        Car car = new Car("1212", CarClass.STANDARD, "Toyota", "Corrola");
        Mockito.when(carStorage.getCarList()).thenReturn(List.of(car));
        Mockito.when(rentStorage.getRentList()).thenReturn(List.of(new Rent("Patryk", LocalDate.of(2024, 01, 20), LocalDate.of(2024, 01, 21), car)));

        Assertions.assertNotNull(rentalService.createRent("Patryk",car, LocalDate.of(2024, 01, 22), LocalDate.of(2024, 01,23)));
        Assertions.assertThrows(RuntimeException.class, () -> rentalService.createRent("Patryk", car ,LocalDate.of(2024, 01, 19), LocalDate.of(2024, 01, 21)));


    }
}
