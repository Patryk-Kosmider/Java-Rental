package com.example.rental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.util.*;

public class CarStorageUnitTests {

    @Mock
    private Car car;

    @InjectMocks
    private CarStorage carStorage;

    @Test
    void addNewCar() {
        carStorage = new CarStorage(new ArrayList<>());
        carStorage.addCar(car);
        List<Car> carList = carStorage.getCarList();
        Assertions.assertEquals(1, carList.size());
        Assertions.assertTrue(carList.contains(car));

    }
}
