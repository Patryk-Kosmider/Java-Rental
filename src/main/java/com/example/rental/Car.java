package com.example.rental;

public class Car {

    private String VIN;
    private CarClass carClass;
    private String marka;
    private String model;

    public Car(String VIN, CarClass carClass, String marka, String model) {
        this.VIN = VIN;
        this.carClass = carClass;
        this.marka = marka;
        this.model = model;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public CarClass getCarClass() {
        return carClass;
    }

    public void setCarClass(CarClass carClass) {
        this.carClass = carClass;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
