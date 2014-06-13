package com.epam.am.aircraft;

public class FuelTank {
    private final double maxVolume;
    private double currentFuelVolume;

    public FuelTank(double maxVolume, double currentFuelVolume) {
        this.maxVolume = maxVolume;
        this.currentFuelVolume = fuelVolumeCheck(currentFuelVolume) ? currentFuelVolume : maxVolume;
    }

    public double getMaxVolume() {
        return maxVolume;
    }

    public void setCurrentFuelVolume(double currentFuelVolume) {
        this.currentFuelVolume = currentFuelVolume;
    }

    public double getCurrentFuelVolume() {
        return currentFuelVolume;
    }

    private boolean fuelVolumeCheck(double volume) {
        return volume <= maxVolume - currentFuelVolume;
    }

    @Override
    public String toString() {
        return "FuelTank{" +
                "maxVolume=" + maxVolume +
                ", currentFuelVolume=" + currentFuelVolume +
                '}';
    }
}
