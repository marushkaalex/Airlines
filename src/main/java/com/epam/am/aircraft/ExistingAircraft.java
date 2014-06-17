package com.epam.am.aircraft;

import com.epam.am.exception.AircraftBuildingException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExistingAircraft {

    private static final String MANUFACTURER = "manufacturer";
    private static final String MODEL = "model";
    private static final String WEIGHT = "weight";
    private static final String MAX_CARRYING_CAPACITY = "max_carrying_capacity";
    private static final String MAX_SPEED = "max_speed";
    private static final String MAX_RANGE = "max_range";
    private static final String ENGINES = "engines";
    private static final String FUEL_TANK = "fuel_tank";
    private static final String SEATING_CAPACITY = "seating_capacity";

    private ExistingAircraft() {
    }

    public static Plane getExistingPlane(String planeName, long id, double fuelVolume,
                                         int currentPassengersNumber, Point currentLocation)
            throws IOException, ParseException, AircraftBuildingException {
        InputStream is = ExistingAircraft.class.getResourceAsStream("/aircrafts_json.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String buf;
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
        }
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(sb.toString());
        JSONObject planeObject = (JSONObject) ((JSONObject) obj).get(planeName);
        return new Plane(new Aircraft.AircraftBuilder().id(id)
                .manufacturer((String) planeObject.get(MANUFACTURER))
                .model((String) planeObject.get(MODEL))
                .weight(((Long) planeObject.get(WEIGHT)).doubleValue())
                .maxCarryingCapacity(((Long) planeObject.get(MAX_CARRYING_CAPACITY)).doubleValue())
                .maxSpeed(((Long) planeObject.get(MAX_SPEED)).doubleValue())
                .maxRange(((Long) planeObject.get(MAX_RANGE)).doubleValue())
                .currentLocation(currentLocation),
                getEngines(planeObject),
                new FuelTank(((Number) planeObject.get(FUEL_TANK)).doubleValue(), fuelVolume),
                ((Number) planeObject.get(SEATING_CAPACITY)).intValue(),
                currentPassengersNumber);
    }

    private static List<Engine> getEngines(JSONObject planeObject) {
        List<Engine> engines = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) planeObject.get(ENGINES);
        for (Object o : jsonArray) {
            Number a = (Number) o;
            engines.add(new Engine(a.doubleValue()));
        }
        return engines;
    }

    public static class Planes {
        public static final String BOEING_777_200 = "BOEING_777_200";
        public static final String AIRBUS_A320 = "AIRBUS_A320";
        public static final String TU_154 = "TU_154";
        public static final String AN_124_100 = "AN_124_100";
    }
}
