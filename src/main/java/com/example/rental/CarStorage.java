package com.example.rental;

import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class CarStorage {

    private List<Car> carList;

    public CarStorage(List<Car> carList) {
        this.carList = new ArrayList<>();
    }

    public void addCar(Car car){
        carList.add(car);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
