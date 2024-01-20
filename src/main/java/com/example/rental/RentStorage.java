package com.example.rental;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class RentStorage {

    private List<Rent> rentList;

    public RentStorage(List<Rent> rentList) {
        this.rentList = new ArrayList<>();
    }

    public void addRent(Rent rent){
        rentList.add(rent);
    }

    public List<Rent> getRentList() {
        return rentList;
    }
}
