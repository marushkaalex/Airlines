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

public class PlaneJson {

    private static final String MANUFACTURER = "manufacturer";
    private static final String MODEL = "model";
    private static final String WEIGHT = "weight";
    private static final String MAX_CARRYING_CAPACITY = "max_carrying_capacity";
    private static final String MAX_SPEED = "max_speed";
    private static final String MAX_RANGE = "max_range";
    private static final String ENGINES = "engines";
    private static final String FUEL_TANK = "fuel_tank";
    private static final String SEATING_CAPACITY = "seating_capacity";

    private PlaneJson() {
    }

    public static Plane getExistingPlane(String planeName, long id, double fuelVolume,
                                         int currentPassengersNumber, Point currentLocation)
            throws IOException, ParseException, AircraftBuildingException {
        InputStream is = PlaneJson.class.getResourceAsStream("/planes_json.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String buf;
        while ((buf = reader.readLine()) != null) {
            sb.append(buf);
        }
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(sb.toString());
        JSONObject planeObject = (JSONObject) ((JSONObject) obj).get(planeName);
        return new PlaneBuilder().id(id)
                .manufacturer((String) planeObject.get(MANUFACTURER))
                .model((String) planeObject.get(MODEL))
                .weight(((Long) planeObject.get(WEIGHT)).doubleValue())
                .maxCarryingCapacity(((Long) planeObject.get(MAX_CARRYING_CAPACITY)).doubleValue())
                .maxSpeed(((Long) planeObject.get(MAX_SPEED)).doubleValue())
                .maxRange(((Long) planeObject.get(MAX_RANGE)).doubleValue()) //11404
                .engines(getEngines(planeObject))
                .fuelTank(new FuelTank(((Long) planeObject.get(FUEL_TANK)).doubleValue(), fuelVolume))
                .seatingCapacity(((Long) planeObject.get(SEATING_CAPACITY)).intValue())
                .currentPassengersNumber(currentPassengersNumber)
                .currentLocation(currentLocation)
                .buildPlane();
    }

    private static List<Engine> getEngines(JSONObject planeObject) {
        List<Engine> engines = new ArrayList<Engine>();
        JSONArray jsonArray = (JSONArray) planeObject.get(ENGINES);
        for (Object o : jsonArray) {
            Number a = (Number) o;
            engines.add(new Engine(a.doubleValue()));
        }
        return engines;
    }

    public interface Planes {
        public static final String BOEING_777_200 = "BOEING_777_200";
        public static final String AIRBUS_A320 = "AIRBUS_A320";
        public static final String TU_154 = "TU_154";
    }
}
