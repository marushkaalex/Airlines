package com.epam.am.airlines;

import java.util.Random;

public class Fuel {

    private double density;

    public Fuel(double density) {
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

    public static class Kerosene {
        public static final double DENSITY_MIN = 0.78;
        public static final double DENSITY_MAX = 0.85;

        public static double randomDensity() {
            return new Random().nextDouble() * (DENSITY_MAX - DENSITY_MIN + 1) + DENSITY_MIN;
        }
    }
}
