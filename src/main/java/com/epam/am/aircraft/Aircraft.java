package com.epam.am.aircraft;

public abstract class Aircraft {
    private final long id;
    private final String manufacturer;
    private final String model;
    private final double weight;
    private final double maxCarryingCapacity;
    private final double maxHeight;
    private final double maxSpeed;
    private final double maxRange;

    protected Aircraft(long id, String manufacturer, String model, double weight, double maxCarryingCapacity,
                       double maxHeight, double maxSpeed, double maxRange) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.weight = weight;
        this.maxCarryingCapacity = maxCarryingCapacity;
        this.maxHeight = maxHeight;
        this.maxSpeed = maxSpeed;
        this.maxRange = maxRange;
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

    public double getMaxHeight() {
        return maxHeight;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getMaxRange() {
        return maxRange;
    }
}
