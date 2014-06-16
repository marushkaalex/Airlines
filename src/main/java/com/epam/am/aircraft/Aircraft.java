package com.epam.am.aircraft;

import com.epam.am.exception.AircraftBuildingException;
import com.epam.am.exception.NotEnoughFuel;
import com.epam.am.exception.RangeException;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.epam.am.aircraft.AircraftPart.*;

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

    protected Aircraft(AircraftBuilder builder) {
        this.id = checkSign(builder.id);
        this.manufacturer = builder.manufacturer;
        this.model = builder.model;
        this.weight = builder.weight;
        this.maxCarryingCapacity = checkSign(builder.maxCarryingCapacity);
        this.maxSpeed = checkSign(builder.maxSpeed);
        this.maxRange = checkSign(builder.maxRange);
        this.currentLocation = builder.currentLocation;
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
        return "ololo.Aircraft{" +
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

    public static class AircraftBuilder {
        private long id;
        private String manufacturer;
        private String model;
        private double weight;
        private double maxCarryingCapacity;
        private double maxSpeed;
        private double maxRange;
        private Point currentLocation;
        private Map<String, Boolean> isSet;

        public AircraftBuilder() {
            isSet = new HashMap<String, Boolean>();
            for (String part : allAircraftParts()) {
                isSet.put(part, false);
            }
        }

        public AircraftBuilder id(long id) {
            this.id = id;
            isSet.replace(ID, true);
            return this;
        }

        public AircraftBuilder manufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            isSet.replace(MANUFACTURER, true);
            return this;
        }

        public AircraftBuilder model(String model) {
            this.model = model;
            isSet.replace(MODEL, true);
            return this;
        }

        public AircraftBuilder weight(double weight) {
            this.weight = weight;
            isSet.replace(WEIGHT, true);
            return this;
        }

        public AircraftBuilder maxCarryingCapacity(double maxCarryingCapacity) {
            this.maxCarryingCapacity = maxCarryingCapacity;
            isSet.replace(MAX_CARRYING_CAPACITY, true);
            return this;
        }

        public AircraftBuilder maxSpeed(double maxSpeed) {
            this.maxSpeed = maxSpeed;
            isSet.replace(MAX_SPEED, true);
            return this;
        }

        public AircraftBuilder maxRange(double maxRange) {
            this.maxRange = maxRange;
            isSet.replace(MAX_RANGE, true);
            return this;
        }

        public AircraftBuilder currentLocation(Point currentLocation) {
            this.currentLocation = currentLocation;
            isSet.replace(CURRENT_LOCATION, true);
            return this;
        }

        public Aircraft build() throws AircraftBuildingException {
            StringBuilder message = new StringBuilder();
            for (String s : allAircraftParts()) {
                if (isSet.get(s) == false) {
                    message.append("\n" + s);
                }
            }
            if (!message.toString().equals(""))
                throw new AircraftBuildingException("You haven't set: " + message.toString()
                        + "\n\nAll fields must be set");
            return new Aircraft(this);
        }
    }
}

