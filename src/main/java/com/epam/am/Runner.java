package com.epam.am;

import com.epam.am.aircraft.Engine;
import com.epam.am.aircraft.FuelTank;
import com.epam.am.aircraft.Plane;
import com.epam.am.aircraft.PlaneBuilder;
import com.epam.am.exception.AircraftBuildingException;
import com.epam.am.exception.NotEnoughFuel;
import com.epam.am.exception.RangeException;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Runner {
    public static void main(String[] args) {

        Plane plane;
        try {
            plane = new PlaneBuilder()
                    .id(1)
                    .manufacturer("Boeing")
                    .model("777-200")
                    .weight(139225)
                    .maxCarryingCapacity(14385)
                    .maxHeight(247210)
                    .maxSpeed(945)
                    .maxRange(9695) //11404
                    .engines(new ArrayList<Engine>(Arrays.asList(new Engine(5702), new Engine(5702))))
                    .fuelTank(new FuelTank(117000, 117000))
                    .seatingCapacity(400)
                    .currentPassengersNumber(375)
                    .currentLocation(new Point(0, 0))
                    .buildPlane();
            System.out.println(plane);
            plane.flyTo(new Point(900, 100));
            System.out.println(plane.getFuelTank().getCurrentFuelVolume());
        } catch (AircraftBuildingException e) {
            e.printStackTrace();
        } catch (NotEnoughFuel notEnoughFuel) {
            notEnoughFuel.printStackTrace();
        } catch (RangeException e) {
            e.printStackTrace();
        }

    }
}
