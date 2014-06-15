package com.epam.am.aircraft;

import java.awt.*;
import java.util.List;

public class Plane extends PoweredAircraft {

    private final int seatingCapacity;
    private int currentPassengersNumber;

    protected Plane(long id, String manufacturer, String model, double weight, double maxCarryingCapacity,
                    double maxSpeed, double maxRange, List<Engine> engines,
                    FuelTank fuelTank, int seatingCapacity, int currentPassengersNumber, Point currentLocation) {
        super(id, manufacturer, model, weight, maxCarryingCapacity, maxSpeed, maxRange, currentLocation, engines, fuelTank);
        this.seatingCapacity = checkSign(seatingCapacity);
        this.currentPassengersNumber = passengersNumberCheck(currentPassengersNumber) ? currentPassengersNumber : seatingCapacity;
    }

    private boolean passengersNumberCheck(int passengers) {
        return checkSign(passengers) <= seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public int getCurrentPassengersNumber() {
        return currentPassengersNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPlane{" +
                "\nseatingCapacity=" + seatingCapacity +
                ", \ncurrentPassengersNumber=" + currentPassengersNumber +
                '}';
    }
}

