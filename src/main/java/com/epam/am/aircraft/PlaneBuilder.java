package com.epam.am.aircraft;

import com.epam.am.exception.AircraftBuildingException;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaneBuilder {
    private Map<String, Boolean> isSet;

    private long id;
    private String manufacturer;
    private String model;
    private double weight;
    private double maxCarryingCapacity;
    private double maxHeight;
    private double maxSpeed;
    private double maxRange;
    private List<Engine> engines;
    private FuelTank fuelTank;
    private int seatingCapacity;
    private int currentPassengersNumber;
    private Point currentLocation;

    public PlaneBuilder() {
        isSet = new HashMap<String, Boolean>();
        String[] parts = Parts.allParts();
        for (String part : parts) {
            isSet.put(part, false);
        }
    }

    public Plane buildPlane() throws AircraftBuildingException {
        StringBuilder message = new StringBuilder();
        for (String s : Parts.allParts()) {
            if (isSet.get(s) == false) {
                message.append("\n" + s);
            }
        }
        if (!message.toString().equals("")) throw new AircraftBuildingException("You haven't set: " + message.toString()
                + "\n\nAll fields must be set");
        return new Plane(id, manufacturer, model, weight, maxCarryingCapacity,
                maxHeight, maxSpeed, maxRange, engines, fuelTank,
                seatingCapacity, currentPassengersNumber, currentLocation);
    }

    public PlaneBuilder id(long id) {
        this.id = id;
        isSet.replace(Parts.ID, true);
        return this;
    }

    public PlaneBuilder manufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        isSet.replace(Parts.MANUFACTURER, true);
        return this;
    }

    public PlaneBuilder model(String model) {
        this.model = model;
        isSet.replace(Parts.MODEL, true);
        return this;
    }

    public PlaneBuilder weight(double weight) {
        this.weight = weight;
        isSet.replace(Parts.WEIGHT, true);
        return this;
    }

    public PlaneBuilder maxCarryingCapacity(double maxCarryingCapacity) {
        this.maxCarryingCapacity = maxCarryingCapacity;
        isSet.replace(Parts.MAX_CARRYING_CAPACITY, true);
        return this;
    }

    public PlaneBuilder maxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
        isSet.replace(Parts.MAX_HEIGHT, true);
        return this;
    }

    public PlaneBuilder maxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
        isSet.replace(Parts.MAX_SPEED, true);
        return this;
    }

    public PlaneBuilder maxRange(double maxRange) {
        this.maxRange = maxRange;
        isSet.replace(Parts.MAX_RANGE, true);
        return this;
    }

    public PlaneBuilder engines(List<Engine> engines) {
        this.engines = engines;
        isSet.replace(Parts.ENGINES, true);
        return this;
    }

    public PlaneBuilder fuelTank(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
        isSet.replace(Parts.FUEL_TANK, true);
        return this;
    }

    public PlaneBuilder seatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
        isSet.replace(Parts.SEATING_CAPACITY, true);
        return this;
    }

    public PlaneBuilder currentPassengersNumber(int currentPassengersNumber) {
        this.currentPassengersNumber = currentPassengersNumber;
        isSet.replace(Parts.CURRENT_PASSENGERS_NUMBER, true);
        return this;
    }

    public PlaneBuilder currentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
        isSet.replace(Parts.CURRENT_LOCATION, true);
        return this;
    }

    public static class Parts {
        public static final String ID = "id";
        public static final String MANUFACTURER = "manufacturer";
        public static final String MODEL = "model";
        public static final String WEIGHT = "weight";
        public static final String MAX_CARRYING_CAPACITY = "maxCarryingCapacity";
        public static final String MAX_HEIGHT = "maxHeight";
        public static final String MAX_SPEED = "maxSpeed";
        public static final String MAX_RANGE = "maxRange";
        public static final String ENGINES = "engines";
        public static final String FUEL_TANK = "fuelTank";
        public static final String SEATING_CAPACITY = "seatingCapacity";
        public static final String CURRENT_PASSENGERS_NUMBER = "currentPassengersNumber";
        public static final String CURRENT_LOCATION = "currentLocation";

        public static String[] allParts() {
            return new String[]{ID, MANUFACTURER, MODEL, WEIGHT, MAX_CARRYING_CAPACITY, MAX_HEIGHT, MAX_SPEED,
                    MAX_RANGE, ENGINES, FUEL_TANK, SEATING_CAPACITY, CURRENT_PASSENGERS_NUMBER, CURRENT_LOCATION};
        }
    }
}
