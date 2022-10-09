/**
 * A PassengerSource is a source of passengers for a luxCompany
 */
package com.resolucaoproblemas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * A PassengerSource is an Actor that creates Passengers and sends them to a
 * City.
 */
public class PassengerSource implements Actor {
    private City city;
    private luxCompany company;
    private Random rand;
    private static final double CREATION_PROBABILITY = 0.06;
    private int missedPickups;

    // A constructor.

    public PassengerSource(City city, luxCompany company) {
        if (city == null) {
            throw new NullPointerException("city");
        }
        if (company == null) {
            throw new NullPointerException("company");
        }
        this.city = city;
        this.company = company;

        // Creating a new random number generator with a seed of 12345.
        rand = new Random(12345);
        missedPickups = 0;
    }

    /**
     * If a random number is greater than or equal to 0.1, then create a passenger
     * and add it to the
     * city
     */
    public void act() {
        if (rand.nextDouble() >= CREATION_PROBABILITY) {
            Passenger passenger = createPassenger();
            if (company.requestPickup(passenger)) {
                city.addItem(passenger);
            }
        }
    }

    /**
     * This function returns the number of missed pickups.
     * 
     * @return The number of missed pickups.
     */
    public int getMissedPickups() {
        return missedPickups;
    }

    // Creating a passenger.
    private Passenger createPassenger() {
        int cityWidth = city.getWidth();
        int cityHeight = city.getHeight();

        // Creating a new passenger with a random pickup location and a random
        // destination.
        Location pickupLocation = new Location(rand.nextInt(cityWidth),
                rand.nextInt(cityHeight));
        Location destination;
        do {
            destination = new Location(rand.nextInt(cityWidth),
                    rand.nextInt(cityHeight));
        } while (pickupLocation.equals(destination));
        return new Passenger(pickupLocation, destination);
    }

    public boolean isActive() {
        // TODO Auto-generated method stub
        return false;
    }

    public void setActive(boolean active) {
        // TODO Auto-generated method stub
        
    }

    public void reset() {
        // TODO Auto-generated method stub
        
    }
}
