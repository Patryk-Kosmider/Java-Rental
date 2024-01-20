package com.example.rental;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.*;

public class RentStorageUnitTest {


    @Mock
    private Rent rent;

    @InjectMocks
    private RentStorage rentStorage;


    @Test
    void AddRent() {
        rentStorage = new RentStorage(new ArrayList<>());
        rentStorage.addRent(rent);

        List<Rent> rentList = rentStorage.getRentList();
        Assertions.assertEquals(1, rentList.size());
        Assertions.assertTrue(rentList.contains(rent));
    }
}
