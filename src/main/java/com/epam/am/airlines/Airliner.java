package com.epam.am.airlines;

/**
 * Created by Alexander on 11.06.14.
 */
public class Airliner extends Plane{

    public static final double AVERAGE_PASSENGER_WEIGHT = 80;

    private final int seatingCapacity;
    private final int passengersNumber;

    protected Airliner(long id, String model, String manufacturer, int pilotsNumber,
                       double emptyWeight, double maxTakeoffWeight, double maxRange,
                       double maxSpeed, double cruiseSpeed, double fuelConsumption,
                       double fuelTankVolume, double currentFuelAmount, Fuel fuel,
                       int seatingCapacity, int passengersNumber) {

        super(id, model, manufacturer, pilotsNumber, emptyWeight, maxTakeoffWeight,
                maxRange, maxSpeed, cruiseSpeed, fuelConsumption, fuelTankVolume,
                currentFuelAmount, fuel);

        this.seatingCapacity = seatingCapacity;
        this.passengersNumber = passengersNumber;
        this.carryingCapacity = maxTakeoffWeight - emptyWeight - (fuel.getDensity() * currentFuelAmount)
                - passengersNumber * AVERAGE_PASSENGER_WEIGHT;
    }

    @Override
    public boolean fly() {
        return false;
    }

    public static class PlaneBuilder {
        private long id;
        private String model;
        private String manufacturer;
        private int pilotsNumber;
        private double emptyWeight;
        private double maxTakeoffWeight;
        protected double carryingCapacity; // = maxTakeoffWeight - emptyWeight - fuelWeight
        protected double maxRange;
        private double maxSpeed;
        private double cruiseSpeed;
        protected double fuelConsumption; //http://newsruss.ru/doc/index.php/Расход_топлива_у_самолётов
        private double fuelTankVolume;
        private double currentFuelAmount;
        private Fuel fuel;
        private int seatingCapacity;
        private int passengersNumber;

        public PlaneBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public PlaneBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public PlaneBuilder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public PlaneBuilder setPilotsNumber(int pilotsNumber) {
            this.pilotsNumber = pilotsNumber;
            return this;
        }

        public PlaneBuilder setEmptyWeight(double emptyWeight) {
            this.emptyWeight = emptyWeight;
            return this;
        }

        public PlaneBuilder setMaxTakeoffWeight(double maxTakeoffWeight) {
            this.maxTakeoffWeight = maxTakeoffWeight;
            return this;
        }

        public PlaneBuilder setCarryingCapacity(double carryingCapacity) {
            this.carryingCapacity = carryingCapacity;
            return this;
        }

        public PlaneBuilder setMaxRange(double maxRange) {
            this.maxRange = maxRange;
            return this;
        }

        public PlaneBuilder setMaxSpeed(double maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public PlaneBuilder setCruiseSpeed(double cruiseSpeed) {
            this.cruiseSpeed = cruiseSpeed;
            return this;
        }

        public PlaneBuilder setFuelConsumption(double fuelConsumption) {
            this.fuelConsumption = fuelConsumption;
            return this;
        }

        public PlaneBuilder setFuelTankVolume(double fuelTankVolume) {
            this.fuelTankVolume = fuelTankVolume;
            return this;
        }

        public PlaneBuilder setCurrentFuelAmount(double currentFuelAmount) {
            this.currentFuelAmount = currentFuelAmount;
            return this;
        }

        public PlaneBuilder setFuel(Fuel fuel) {
            this.fuel = fuel;
            return this;
        }

        public PlaneBuilder setSeatingCapacity(int seatingCapacity) {
            this.seatingCapacity = seatingCapacity;
            return this;
        }

        public PlaneBuilder setPassengersNumber(int passengersNumber) {
            this.passengersNumber = passengersNumber;
            return this;
        }

        public Airliner createPlane() {
            return new Airliner(id, model, manufacturer, pilotsNumber, emptyWeight, maxTakeoffWeight,
                    maxRange, maxSpeed, cruiseSpeed, fuelConsumption, fuelTankVolume, currentFuelAmount,
                    fuel, seatingCapacity, passengersNumber);
        }
    }
}
