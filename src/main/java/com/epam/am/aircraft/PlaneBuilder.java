package com.epam.am.aircraft;

import com.epam.am.exception.AircraftBuildingException;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.am.aircraft.AircraftPart.*;

//TODO try to extend AircraftBuilder
public class PlaneBuilder {
    private Map<String, Boolean> isSet;

    private long id;
    private String manufacturer;
    private String model;
    private double weight;
    private double maxCarryingCapacity;
    private double maxSpeed;
    private double maxRange;
    private List<Engine> engines;
    private FuelTank fuelTank;
    private int seatingCapacity;
    private int currentPassengersNumber;
    private Point currentLocation;

    public PlaneBuilder() {
        isSet = new HashMap<String, Boolean>();
        String[] parts = allAircraftParts();
        for (String part : parts) {
            isSet.put(part, false);
        }
    }

    public Plane buildPlane() throws AircraftBuildingException {
        StringBuilder message = new StringBuilder();
        for (String s : allAircraftParts()) {
            if (isSet.get(s) == false) {
                message.append("\n" + s);
            }
        }
        if (!message.toString().equals("")) throw new AircraftBuildingException("You haven't set: " + message.toString()
                + "\n\nAll fields must be set");
        return new Plane(id, manufacturer, model, weight, maxCarryingCapacity,
                maxSpeed, maxRange, engines, fuelTank,
                seatingCapacity, currentPassengersNumber, currentLocation);
    }

    public PlaneBuilder id(long id) {
        this.id = id;
        isSet.replace(ID, true);
        return this;
    }

    public PlaneBuilder manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        isSet.replace(MANUFACTURER, true);
        return this;
    }

    public PlaneBuilder model(String model) {
        this.model = model;
        isSet.replace(MODEL, true);
        return this;
    }

    public PlaneBuilder weight(double weight) {
        this.weight = weight;
        isSet.replace(WEIGHT, true);
        return this;
    }

    public PlaneBuilder maxCarryingCapacity(double maxCarryingCapacity) {
        this.maxCarryingCapacity = maxCarryingCapacity;
        isSet.replace(MAX_CARRYING_CAPACITY, true);
        return this;
    }

    public PlaneBuilder maxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
        isSet.replace(MAX_SPEED, true);
        return this;
    }

    public PlaneBuilder maxRange(double maxRange) {
        this.maxRange = maxRange;
        isSet.replace(MAX_RANGE, true);
        return this;
    }

    public PlaneBuilder engines(List<Engine> engines) {
        this.engines = engines;
        isSet.replace(ENGINES, true);
        return this;
    }

    public PlaneBuilder fuelTank(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
        isSet.replace(FUEL_TANK, true);
        return this;
    }

    public PlaneBuilder seatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
        isSet.replace(SEATING_CAPACITY, true);
        return this;
    }

    public PlaneBuilder currentPassengersNumber(int currentPassengersNumber) {
        this.currentPassengersNumber = currentPassengersNumber;
        isSet.replace(CURRENT_PASSENGERS_NUMBER, true);
        return this;
    }

    public PlaneBuilder currentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
        isSet.replace(CURRENT_LOCATION, true);
        return this;
    }
}
