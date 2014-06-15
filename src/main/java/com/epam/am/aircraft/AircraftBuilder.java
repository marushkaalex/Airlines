package com.epam.am.aircraft;

import com.epam.am.exception.AircraftBuildingException;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.epam.am.aircraft.AircraftPart.*;

public class AircraftBuilder {
    protected long id;
    protected String manufacturer;
    protected String model;
    protected double weight;
    protected double maxCarryingCapacity;
    protected double maxSpeed;
    protected double maxRange;
    protected Point currentLocation;
    protected Map<String, Boolean> isSet;

    public AircraftBuilder() {
        isSet = new HashMap<String, Boolean>();
        for (String part : allAircraftParts()) {
            isSet.put(part, false);
        }
    }

    public Aircraft build() throws AircraftBuildingException {
        StringBuilder message = new StringBuilder();
        for (String s : allAircraftParts()) {
            if (isSet.get(s) == false) {
                message.append("\n" + s);
            }
        }
        if (!message.toString().equals("")) throw new AircraftBuildingException("You haven't set: " + message.toString()
                + "\n\nAll fields must be set");
        return new Aircraft(id, manufacturer, model, weight, maxCarryingCapacity, maxSpeed, maxRange, currentLocation);
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
}
