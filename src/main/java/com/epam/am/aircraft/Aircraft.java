package com.epam.am.aircraft;

import java.awt.*;

public abstract class Aircraft implements Flyable {
    private final long id;
    private final String manufacturer;
    private final String model;
    private final double weight;
    private final double maxCarryingCapacity;
    private final double maxSpeed;
    private final double maxRange;
    private Point currentLocation;

    protected Aircraft(long id, String manufacturer, String model, double weight, double maxCarryingCapacity,
                       double maxSpeed, double maxRange, Point currentLocation) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.weight = weight;
        this.maxCarryingCapacity = maxCarryingCapacity;
        this.maxSpeed = maxSpeed;
        this.maxRange = maxRange;
        this.currentLocation = currentLocation;
    }

//    public abstract void flyTo(Point pointB) throws RangeException;

    public long getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxCarryingCapacity() {
        return maxCarryingCapacity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getMaxRange() {
        return maxRange;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "\nid=" + id +
                ", \nmanufacturer='" + manufacturer + '\'' +
                ", \nmodel='" + model + '\'' +
                ", \nweight=" + weight +
                ", \nmaxCarryingCapacity=" + maxCarryingCapacity +
                ", \nmaxSpeed=" + maxSpeed +
                ", \nmaxRange=" + maxRange +
                ", \ncurrentLocation=" + currentLocation +
                '}';
    }
}
