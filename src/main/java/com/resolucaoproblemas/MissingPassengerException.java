package com.resolucaoproblemas;

/**
 * This class is a custom exception that is thrown when a passenger is missing at the pickup location.
 */
public class MissingPassengerException extends RuntimeException {
    private Vehicle vehicle;

    // A constructor that calls the superclass constructor.
    public MissingPassengerException(Vehicle vehicle) {
        super("Missing passenger at pickup location.");
    }

    /**
     * This function returns the vehicle object
     * 
     * @return The vehicle object.
     */
    public Vehicle getVehicle() {
        return vehicle;
    }
}
