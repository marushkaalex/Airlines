package com.epam.am.aircraft;

import com.epam.am.exception.AircraftBuildingException;

import java.util.List;

public class Plane extends PoweredAircraft {

    private final int seatingCapacity;
    private int currentPassengersNumber;

    protected Plane(AircraftBuilder builder, List<Engine> engines, FuelTank fuelTank, int seatingCapacity, int currentPassengersNumber) throws AircraftBuildingException {
        super(builder, engines, fuelTank);
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

