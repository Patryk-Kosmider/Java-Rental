package com.example.rental;


import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class RentalService {
    private final CarStorage carStorage;
    private final RentStorage rentStorage;

    private final double oneDayRent = 100;

    public RentalService(CarStorage carStorage, RentStorage rentStorage) {
        this.carStorage = carStorage;
        this.rentStorage = rentStorage;
    }

    public boolean doesCarExist(String VIN){
        for (Car car : carStorage.getCarList()){
            if (car.getVIN().equals(VIN)){
                return true;
            }
        }
        return false;
    }

    public double estimatePrice(String VIN, LocalDate fromWhen, LocalDate toWhen){
        if(doesCarExist(VIN)) {
            double daysFromTo = ChronoUnit.DAYS.between(fromWhen, toWhen);
            double price = oneDayRent * daysFromTo;
            for (Car carToRent : carStorage.getCarList()) {
                if (carToRent.getVIN().equals(VIN)) {
                    price = price * carToRent.getCarClass().getPriceRatio();
                }
            }
            return price;
        }
        else throw new RuntimeException("There is no such a car");
    }

    public boolean isAvailableToRent(String VIN, LocalDate fromWhen, LocalDate toWhen) {
        if(doesCarExist(VIN)){
            for (Rent rent : rentStorage.getRentList()){
                if(rent.getCar().getVIN().equals(VIN)){
                    if(rent.getToWhen().isBefore(fromWhen) && rent.getFromWhen().isBefore(toWhen)){
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public Rent createRent(String name, Car car, LocalDate fromWhen, LocalDate toWhen){
        if(isAvailableToRent(car.getVIN(), fromWhen, toWhen)){
            return new Rent(name, fromWhen, toWhen, car);
        } else {
            throw new RuntimeException("There error has occured while renting");
        }
    }

    public CarStorage getCarStorage() {
        return carStorage;
    }

    public RentStorage getRentStorage() {
        return rentStorage;
    }
}

