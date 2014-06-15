package com.epam.am.aircraft;

import com.epam.am.exception.NotEnoughFuel;
import com.epam.am.exception.RangeException;

import java.awt.*;

public class Aircraft implements Flyable {
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
        this.id = checkSign(id);
        this.manufacturer = manufacturer;
        this.model = model;
        this.weight = weight;
        this.maxCarryingCapacity = checkSign(maxCarryingCapacity);
        this.maxSpeed = checkSign(maxSpeed);
        this.maxRange = checkSign(maxRange);
        this.currentLocation = currentLocation;
    }

    protected int checkSign(int a) {
        if (a < 0) throw new IllegalArgumentException("Argument must be > 0");
        return a;
    }

    protected double checkSign(double a) {
        if (a < 0) throw new IllegalArgumentException("Argument must be > 0");
        return a;
    }

    protected long checkSign(long a) {
        if (a < 0) throw new IllegalArgumentException("Argument must be > 0");
        return a;
    }

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

    public void flyTo(Point pointB) throws RangeException, NotEnoughFuel {
        currentLocation = pointB;
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
