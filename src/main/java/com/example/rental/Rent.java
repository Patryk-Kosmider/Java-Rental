package com.example.rental;

import java.time.LocalDate;

public class Rent {

    // private static int nextId = 1;
    // private int id;
    private String name;
    private LocalDate fromWhen;
    private LocalDate toWhen;
    private Car car;

    public Rent(String name, LocalDate fromWhen, LocalDate toWhen, Car car) {
        this.name = name;
        this.fromWhen = fromWhen;
        this.toWhen = toWhen;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFromWhen() {
        return fromWhen;
    }

    public LocalDate getToWhen() {
        return toWhen;
    }

    public Car getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFromWhen(LocalDate fromWhen) {
        this.fromWhen = fromWhen;
    }

    public void setToWhen(LocalDate toWhen) {
        this.toWhen = toWhen;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
