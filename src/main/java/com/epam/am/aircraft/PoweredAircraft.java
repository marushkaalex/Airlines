package com.epam.am.aircraft;

import com.epam.am.exception.NotEnoughFuel;
import com.epam.am.exception.RangeException;

import java.awt.*;
import java.util.List;

public class PoweredAircraft extends Aircraft {
    private final List<Engine> engines;
    private final FuelTank fuelTank;

    protected PoweredAircraft(long id, String manufacturer, String model, double weight, double maxCarryingCapacity,
                              double maxSpeed, double maxRange, Point currentLocation, List<Engine> engines,
                              FuelTank fuelTank) {
        super(id, manufacturer, model, weight, maxCarryingCapacity, maxSpeed, maxRange, currentLocation);
        this.engines = engines;
        this.fuelTank = fuelTank;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    protected double totalConsumption() {
        double consumption = 0;
        for (Engine engine : engines) {
            consumption += engine.getAverageFuelConsumption();
        }
        return consumption;
    }

    private double flightHours(Point pointB) {
        return getCurrentLocation().distance(pointB) / getMaxSpeed();
    }

    @Override
    public void flyTo(Point pointB) throws RangeException, NotEnoughFuel {
        if (getCurrentLocation().distance(pointB) > getMaxRange())
            throw new RangeException("It's too far");
        if ((totalConsumption() * flightHours(pointB)) > getFuelTank().getCurrentFuelVolume()) {
            throw new NotEnoughFuel("Not enough fuel");
        }
        getFuelTank().setCurrentFuelVolume(getFuelTank().getCurrentFuelVolume() - totalConsumption() * flightHours(pointB));
        getCurrentLocation().setLocation(pointB);
    }

    @Override
    public String toString() {
        return super.toString() + "\nPoweredAircraft{" +
                "\nengines=" + engines +
                ", \nfuelTank=" + fuelTank +
                '}';
    }
}
