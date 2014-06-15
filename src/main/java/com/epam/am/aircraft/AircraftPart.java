package com.epam.am.aircraft;

public final class AircraftPart {

    public static final String ID = "id";
    public static final String MANUFACTURER = "manufacturer";
    public static final String MODEL = "model";
    public static final String WEIGHT = "weight";
    public static final String MAX_CARRYING_CAPACITY = "maxCarryingCapacity";
    public static final String MAX_SPEED = "maxSpeed";
    public static final String MAX_RANGE = "maxRange";
    public static final String ENGINES = "engines";
    public static final String FUEL_TANK = "fuelTank";
    public static final String SEATING_CAPACITY = "seatingCapacity";
    public static final String CURRENT_PASSENGERS_NUMBER = "currentPassengersNumber";
    public static final String CURRENT_LOCATION = "currentLocation";

    private AircraftPart() {
    }

    public static String[] allPlaneParts() {
        return new String[]{ID, MANUFACTURER, MODEL, WEIGHT, MAX_CARRYING_CAPACITY, MAX_SPEED,
                MAX_RANGE, ENGINES, FUEL_TANK, SEATING_CAPACITY, CURRENT_PASSENGERS_NUMBER, CURRENT_LOCATION};
    }

    public static String[] allAircraftParts() {
        return new String[]{ID, MANUFACTURER, MODEL, WEIGHT, MAX_CARRYING_CAPACITY, MAX_SPEED,
                MAX_RANGE, CURRENT_LOCATION};
    }
}
