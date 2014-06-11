package com.epam.am.airlines;

import com.sun.org.apache.xml.internal.security.keys.content.KeyValue;

/**
 * Created by Alexander on 11.06.14.
 */
public abstract class Plane extends Aircraft{

//    private double keroseneDensity; //0.78-0.85 g/cm^3
//    private final int pilotsNumber;
//    private final int passengersNumber;
//    private final double maxSpeed;
//    private final double fuelTankVolume;
//    private final double cruiseSpeed;
//    private double currentFuelAmount;

    protected final double maxRange;
    protected final int seatingCapacity;
    protected final double fuelConsumption; //http://newsruss.ru/doc/index.php/Расход_топлива_у_самолётов
    private String manufacturer;
    private String model;
    private long id;
    
    protected Plane(long id, String manufacturer, String model,
                    double maxRange, int seatingCapacity, double fuelConsumption) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxRange = maxRange;
        this.seatingCapacity = seatingCapacity;
        this.fuelConsumption = fuelConsumption;
    }
}
