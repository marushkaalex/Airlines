package com.epam.am.aircraft;

import java.util.List;

public class Plane extends Aircraft {

    private final List<Engine> engines;
    private final FuelTank fuelTank;
    private final int seatingCapacity;
    private int currentPassengersNumber;

    public Plane(long id, String manufacturer, String model, double weight, double maxCarryingCapacity,
                 double maxHeight, double maxSpeed, double maxRange, List<Engine> engines,
                 FuelTank fuelTank, int seatingCapacity, int currentPassengersNumber) {
        super(id, manufacturer, model, weight, maxCarryingCapacity, maxHeight, maxSpeed, maxRange);
        this.engines = engines;
        this.fuelTank = fuelTank;
        this.seatingCapacity = seatingCapacity;
        this.currentPassengersNumber = currentPassengersNumber;
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
}

//public static class PlaneClassification {
//    public static enum Military {
//        FIGHTER, INTERCEPTOR, FIGHTER_BOMBER, BOMBER, ATTACK, REFUELLER, TRANSPORT;
//    }
//
//    public static enum Civil {
//        AIRLINER, CARGO, AGRICULTURAL, SPORT;
//
//        enum l {}
//    }
//}
