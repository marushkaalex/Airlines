package com.epam.am;

import com.epam.am.aircraft.Plane;
import com.epam.am.aircraft.PlaneJson;
import com.epam.am.exception.AircraftBuildingException;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws ParseException, AircraftBuildingException, IOException {
        Plane a = PlaneJson.getExistingPlane(PlaneJson.Planes.TU_154, 1, 100, 100, new Point(1, 1));
        System.out.println(a.toString());
    }
}
