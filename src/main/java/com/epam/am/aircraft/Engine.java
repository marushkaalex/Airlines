package com.epam.am.aircraft;

public class Engine {
    private final double AverageFuelConsumption;

    public Engine(double averageFuelConsumption) {
        AverageFuelConsumption = averageFuelConsumption;
    }

    public double getAverageFuelConsumption() {
        return AverageFuelConsumption;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "AverageFuelConsumption=" + AverageFuelConsumption +
                '}';
    }
}
