package com.epam.am;

import com.epam.am.aircraft.AircraftException;
import com.epam.am.aircraft.Plane;
import com.epam.am.aircraft.PlaneBuilder;

public class Runner {
    public static void main(String[] args) {
        try {
            Plane customPlane = new PlaneBuilder().buildPlane();
        } catch (AircraftException e) {
            e.printStackTrace();
        }
    }
}
