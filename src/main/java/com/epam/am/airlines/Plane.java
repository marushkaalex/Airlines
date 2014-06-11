package com.epam.am.airlines;

/**
 * Created by Alexander on 11.06.14.
 */
public abstract class Plane extends Aircraft{


    private long id;
    private String model;
    private String manufacturer;
    private final int pilotsNumber;
    private final double emptyWeight;
    private final double maxTakeoffWeight;
    protected double carryingCapacity; // = maxTakeoffWeight - emptyWeight - fuelWeight
    protected final double maxRange;
    private final double maxSpeed;
    private final double cruiseSpeed;
    protected final double fuelConsumption; //http://newsruss.ru/doc/index.php/Расход_топлива_у_самолётов
    private final double fuelTankVolume;
    private double currentFuelAmount;
    private Fuel fuel;

    protected Plane(long id, String model, String manufacturer, int pilotsNumber,
                    double emptyWeight, double maxTakeoffWeight, double maxRange,
                    double maxSpeed, double cruiseSpeed, double fuelConsumption,
                    double fuelTankVolume, double currentFuelAmount, Fuel fuel) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.pilotsNumber = pilotsNumber;
        this.emptyWeight = emptyWeight;
        this.maxTakeoffWeight = maxTakeoffWeight;
        this.maxRange = maxRange;
        this.maxSpeed = maxSpeed;
        this.cruiseSpeed = cruiseSpeed;
        this.fuelConsumption = fuelConsumption;
        this.fuelTankVolume = fuelTankVolume;
        this.currentFuelAmount = currentFuelAmount;
        this.fuel = fuel;

        this.carryingCapacity = maxTakeoffWeight - emptyWeight - (fuel.getDensity() * currentFuelAmount);
    }

}
