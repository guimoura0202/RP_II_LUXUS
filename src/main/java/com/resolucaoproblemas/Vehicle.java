package com.resolucaoproblemas;

/**
 * It creates a class called Vehicle.
 */
public class Vehicle {
    private Location location;
    private luxCompany company;

    // A constructor.
    public Vehicle(luxCompany company, Location location) {
        this.location = location;
        this.company = company;
    }

    /**
     * This function returns the location of the player
     * 
     * @return The location of the object.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * This function returns the company of the current object
     * 
     * @return The company object.
     */
    public luxCompany getCompany() {
        return company;
    }

    /**
     * This function sets the location of the user
     * 
     * @param location The location of the user.
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * This function sets the company of the current object to the company passed in
     * as a parameter
     * 
     * @param company the company that the user is currently logged in as
     */
    public void setCompany(luxCompany company) {
        this.company = company;
    }

// A method that is not doing anything.
    public void pickup(Passenger passenger) {
    }

// Returning false.
	public boolean isFree() {
		return false;
	}
}