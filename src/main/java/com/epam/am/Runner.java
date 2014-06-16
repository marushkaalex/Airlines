package com.epam.am;

import com.epam.am.aircraft.ExistingAircraft;
import com.epam.am.aircraft.Plane;
import com.epam.am.exception.AircraftBuildingException;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws ParseException, AircraftBuildingException, IOException {
//        Plane a = ExistingAircraft.getExistingPlane(ExistingAircraft.Planes.TU_154, 1, 100, 100, new Point(1, 1));
//        Plane b = ExistingAircraft.getExistingPlane(ExistingAircraft.Planes.BOEING_777_200, 2, 500, 200, new Point(25, 25));
//        Plane c = ExistingAircraft.getExistingPlane(ExistingAircraft.Planes.AIRBUS_A320, 3, 100000, 1000, new Point(500, 500));
//        Airlines airlines = new Airlines(1, "Ololo Airlines");
//        airlines.addPlane(a);
//        airlines.addPlane(b);
//        airlines.addPlane(c);
//        System.out.println(airlines.getPlanesInfo());
        Plane a = ExistingAircraft.getExistingPlane(ExistingAircraft.Planes.AIRBUS_A320, 1, 50, 50, new Point(1, 1));
        System.out.println(a);
    }
}
