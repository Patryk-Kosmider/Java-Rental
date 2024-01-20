package com.example.rental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;

public class RentUnitTest {

    @Mock
    private Car car;

    @InjectMocks
    private Rent rent;

    @Test
    void CreateRent() {

        rent = new Rent("Patryk", LocalDate.of(2024, 01, 18), LocalDate.of(2024, 01, 20), car);

        Assertions.assertEquals("Patryk", rent.getName());
        Assertions.assertEquals(LocalDate.of(2024, 01, 18), rent.getFromWhen());
        Assertions.assertEquals(LocalDate.of(2024, 01, 20), rent.getToWhen());
        Assertions.assertSame(car, rent.getCar());

    }
}
