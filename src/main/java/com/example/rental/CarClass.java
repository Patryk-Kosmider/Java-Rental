package com.example.rental;

public enum CarClass {
    STANDARD(1.5), PREMIUM(2.5), ECONOMY(1);

    private final double priceRatio;

    CarClass(double priceRatio) {
        this.priceRatio = priceRatio;
    }

    public double getPriceRatio() {
        return priceRatio;
    }
}
