package com.epam.am.aircraft;

public class Engine {
    private final double averageFuelConsumption;

    public Engine(double averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public Engine(Long averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption.doubleValue();
    }

    public double getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "averageFuelConsumption=" + averageFuelConsumption +
                '}';
    }
}
