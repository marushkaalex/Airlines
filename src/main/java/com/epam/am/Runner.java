package com.epam.am;

import com.epam.am.aircraft.Airlines;
import com.epam.am.aircraft.Plane;
import com.epam.am.aircraft.PlaneJson;
import com.epam.am.exception.AircraftBuildingException;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws ParseException, AircraftBuildingException, IOException {
        Plane a = PlaneJson.getExistingPlane(PlaneJson.Planes.TU_154, 1, 100, 100, new Point(1, 1));
        Plane b = PlaneJson.getExistingPlane(PlaneJson.Planes.BOEING_777_200, 2, 500, 200, new Point(25, 25));
        Plane c = PlaneJson.getExistingPlane(PlaneJson.Planes.AIRBUS_A320, 3, 100000, 1000, new Point(500, 500));
        Airlines airlines = new Airlines(1, "Ololo Airlines");
        airlines.addPlane(a);
        airlines.addPlane(b);
        airlines.addPlane(c);
        System.out.println(airlines.getPlanesInfo());
    }
}
