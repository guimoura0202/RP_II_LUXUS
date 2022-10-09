package com.resolucaoproblemas;

import java.util.List;
import java.util.LinkedList;

/**
 * A shuttle is a vehicle that can pick up and drop off passengers
 */
public class Shuttle extends Vehicle {
    private List<Location> destinations;
    private List<Passenger> passengers;

    // A constructor.
    public Shuttle(luxCompany company, Location location) {
        // Calling the constructor of the superclass.
        super(company, location);
        destinations = new LinkedList<Location>();
        passengers = new LinkedList<Passenger>();
    }

    /**
     * The act() function is called every time the Greenfoot environment runs a
     * "tick" (i.e. every time the
     * game loop runs)
     */
    public void act() {
    }

    /**
     * This function returns true if the parking spot is free
     * 
     * @return True
     */
    public boolean isFree() {
        return true;
    }

    /**
     * This function adds a location to the destinations list and then chooses a
     * target location.
     * 
     * @param location The location of the pickup
     */
    public void setPickupLocation(Location location) {
        destinations.add(location);
        chooseTargetLocation();
    }

    /**
     * This function adds a passenger to the list of passengers and adds the
     * passenger's destination to
     * the list of destinations. It then chooses a target location
     * 
     * @param passenger The passenger to be picked up.
     */
    public void pickup(Passenger passenger) {
        passengers.add(passenger);
        destinations.add(passenger.getDestination());
        chooseTargetLocation();
    }

    /**
     * This function chooses a target location for the player to move to.
     */
    private void chooseTargetLocation() {
    }

    /**
     * // Java
     * public void offloadPassenger() {}
     */
    public void offloadPassenger() {
    }
}
