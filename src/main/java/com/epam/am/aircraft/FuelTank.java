package com.epam.am.aircraft;

public class FuelTank {
    private final double maxVolume;
    private double currentFuelValume;

    public FuelTank(double maxVolume, double currentFuelValume) {
        this.maxVolume = maxVolume;
        this.currentFuelValume = currentFuelValume;
    }
}
