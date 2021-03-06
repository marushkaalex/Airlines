package com.epam.am.aircraft;

import com.epam.am.exception.AircraftBuildingException;
import com.epam.am.exception.NotEnoughFuel;
import com.epam.am.exception.RangeException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.epam.am.aircraft.Aircraft.Part.*;

public class Aircraft implements Flyable {
    private static final Logger log = Logger.getLogger(Aircraft.class);

    static {
        BasicConfigurator.configure();
    }
    private final long id;
    private final String manufacturer;
    private final String model;
    private final double weight;
    private final double maxCarryingCapacity;
    private final double maxSpeed;
    private final double maxRange;
    private Point currentLocation;

    public Aircraft(AircraftBuilder builder) throws AircraftBuildingException {
        builder.isCompleted();
        this.id = checkSign(builder.id);
        this.manufacturer = builder.manufacturer;
        this.model = builder.model;
        this.weight = builder.weight;
        this.maxCarryingCapacity = checkSign(builder.maxCarryingCapacity);
        this.maxSpeed = checkSign(builder.maxSpeed);
        this.maxRange = checkSign(builder.maxRange);
        this.currentLocation = builder.currentLocation;
        log.info("Aircraft \"" + manufacturer + model + "\", id=" + id + " has been created");
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

    public String getModelInfo() {
        return getManufacturer() + " " + getModel() + " id=" + getId();
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
            isSet = new HashMap<>();
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

        private void isCompleted() throws AircraftBuildingException {
            StringBuilder message = new StringBuilder();
            for (String s : allAircraftParts()) {
                if (isSet.get(s) == false) {
                    message.append("\n" + s);
                }
            }
            if (!message.toString().equals(""))
                throw new AircraftBuildingException("You haven't set: " + message.toString()
                        + "\n\nAll fields must be set");
        }
    }

    public static class Part {

        public static final String ID = "id";
        public static final String MANUFACTURER = "manufacturer";
        public static final String MODEL = "model";
        public static final String WEIGHT = "weight";
        public static final String MAX_CARRYING_CAPACITY = "maxCarryingCapacity";
        public static final String MAX_SPEED = "maxSpeed";
        public static final String MAX_RANGE = "maxRange";
        public static final String CURRENT_LOCATION = "currentLocation";

        public static String[] allAircraftParts() {
            return new String[]{ID, MANUFACTURER, MODEL, WEIGHT, MAX_CARRYING_CAPACITY, MAX_SPEED,
                    MAX_RANGE, CURRENT_LOCATION};
        }
    }
}

