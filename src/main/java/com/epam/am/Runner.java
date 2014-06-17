package com.epam.am;

import com.epam.am.aircraft.Aircraft;
import com.epam.am.aircraft.Airlines;
import com.epam.am.aircraft.ExistingAircraft;
import com.epam.am.aircraft.Plane;
import com.epam.am.exception.AircraftBuildingException;
import com.epam.am.exception.NotEnoughFuel;
import com.epam.am.exception.RangeException;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws ParseException, AircraftBuildingException, IOException {
        Plane a = ExistingAircraft.getExistingPlane(ExistingAircraft.Planes.TU_154, 1, 100, 100, new Point(1, 1));
        Plane b = ExistingAircraft.getExistingPlane(ExistingAircraft.Planes.BOEING_777_200, 2, 500, 200, new Point(25, 25));
        Plane c = ExistingAircraft.getExistingPlane(ExistingAircraft.Planes.AIRBUS_A320, 3, 100000, 1000, new Point(500, 500));
        Plane d = ExistingAircraft.getExistingPlane(ExistingAircraft.Planes.AN_124_100, 4, 500000, 7, new Point(200, 156));
        Aircraft pPlane = new Aircraft(new Aircraft.AircraftBuilder().id(5)
                .manufacturer("Handmade")
                .model("Paper Plane")
                .maxCarryingCapacity(10)
                .maxRange(30)
                .maxSpeed(20)
                .weight(0.05)
                .currentLocation(new Point(1, 1)));

        Airlines airlines = new Airlines(1, "Ololo Airlines");
        airlines.addPlane(a);
        airlines.addPlane(b);
        airlines.addPlane(c);
        airlines.addPlane(d);
        System.out.println(airlines.getPlanesInfo());

        airlines.sortPlanesBySeatingCapacity();
        System.out.println(airlines.getPlanesInfo());

        airlines.sortPlanesByWeight();
        System.out.println(airlines.getPlanesInfo());

        for (Plane plane : airlines.findPlanesByRange(100, 6000)) {
            System.out.println(plane.getModelInfo());
        }

        try {
            airlines.getPlaneById(4).flyTo(new Point(500, 500));
        } catch (RangeException e) {
            e.printStackTrace();
        } catch (NotEnoughFuel notEnoughFuel) {
            notEnoughFuel.printStackTrace();
        }
        System.out.println(d.getCurrentLocation());
        System.out.println();
        System.out.println(pPlane.getModelInfo());
    }
}
