package com.epam.am.aircraft;

import com.epam.am.exception.NotEnoughFuel;
import com.epam.am.exception.RangeException;

import java.awt.*;
import java.util.List;

public class Plane extends Aircraft {

    private final List<Engine> engines;
    private final FuelTank fuelTank;
    private final int seatingCapacity;
    private int currentPassengersNumber;

    protected Plane(long id, String manufacturer, String model, double weight, double maxCarryingCapacity,
                    double maxHeight, double maxSpeed, double maxRange, List<Engine> engines,
                    FuelTank fuelTank, int seatingCapacity, int currentPassengersNumber, Point currentLocation) {
        super(id, manufacturer, model, weight, maxCarryingCapacity, maxHeight, maxSpeed, maxRange, currentLocation);
        this.engines = engines;
        this.fuelTank = fuelTank;
        this.seatingCapacity = seatingCapacity;
        this.currentPassengersNumber = passengersNumberCheck(currentPassengersNumber) ? currentPassengersNumber : seatingCapacity;
    }

    private boolean passengersNumberCheck(int passengers) {
        return passengers <= seatingCapacity;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public int getCurrentPassengersNumber() {
        return currentPassengersNumber;
    }

    @Override
    public void flyTo(Point pointB) throws RangeException, NotEnoughFuel {
        if (getCurrentLocation().distance(pointB) > getMaxRange())
            throw new RangeException("It's too far");

        if ((totalConsumption() * flightHours(pointB)) > fuelTank.getCurrentFuelVolume()) {
            throw new NotEnoughFuel("Not enough fuel");
        }

        fuelTank.setCurrentFuelVolume(fuelTank.getCurrentFuelVolume() - totalConsumption() * flightHours(pointB));
        getCurrentLocation().setLocation(pointB);
    }


    private double flightHours(Point pointB) {
        return getCurrentLocation().distance(pointB) / getMaxSpeed();
    }

    private double totalConsumption() {
        double consumption = 0;
        for (Engine engine : engines) {
            consumption += engine.getAverageFuelConsumption();
        }
        return consumption;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPlane{" +
                "\nengines=" + engines +
                ", \nfuelTank=" + fuelTank +
                ", \nseatingCapacity=" + seatingCapacity +
                ", \ncurrentPassengersNumber=" + currentPassengersNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (seatingCapacity != plane.seatingCapacity) return false;
        if (!engines.equals(plane.engines)) return false;
        if (!fuelTank.equals(plane.fuelTank)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = engines.hashCode();
        result = 31 * result + fuelTank.hashCode();
        result = 31 * result + seatingCapacity;
        return result;
    }
}

