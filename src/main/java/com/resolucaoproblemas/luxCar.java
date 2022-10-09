package com.resolucaoproblemas;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * This class is a subclass of the DrawableItem class. It has three private
 * variables: passenger, car,
 * and emptyImage. It also has two private variables: passengerImage and
 * emptyImage
 */
public class luxCar implements DrawableItem {
    private Passenger passenger;
    private luxCar car;
    private Image emptyImage, passengerImage;

    // A constructor.
    public luxCar(luxCompany company, Location location) {
        super();
        emptyImage = new ImageIcon(getClass().getResource("images/luxCar.jpg")).getImage();

        passengerImage = new ImageIcon(getClass().getResource("images/luxCar+person.jpg")).getImage();
    }

    /**
     * If the taxi has a target location, it moves towards it. If it has a
     * passenger, it notifies the
     * passenger that it has arrived. If it doesn't have a passenger, it notifies
     * the dispatcher that
     * it has arrived
     */
    public void act() {
        Location target = getTargetLocation();
        if (target != null) {
            Location next = getLocation().nextLocation(target);
            setLocation(next);
            if (next.equals(target)) {
                if (passenger != null) {
                    notifyPassengerArrival(passenger);
                    offloadPassenger();
                } else {
                    notifyPickupArrival();
                }
            }
        } else {
            incrementIdleCount();
        }
    }

   /**
    * This function is called when a pickup arrives at a location. It notifies the company that the
    * pickup has arrived.
    */
    private void notifyPickupArrival() {
        luxCompany company = getCompany();
        company.notifyPickupArrival(this);
    }

   /**
    * This function returns a company object
    * 
    * @return Nothing.
    */
    private luxCompany getCompany() {
        return null;
    }

   /**
    * Increment the idle count for the company.
    */
    private void incrementIdleCount() {
        luxCompany company = getCompany();
        company.incrementIdleCount();
    }

   /**
    * Notify the passenger that they have arrived at their destination.
    * 
    * @param passenger The passenger that has arrived at the destination.
    */
    private void notifyPassengerArrival(Passenger passenger) {
        passenger.notifyArrival(car);
    }

    private Location getTargetLocation() {
        return null;
    }

    /**
     * "Returns true if the elevator is free, false otherwise."
     * 
     * 
     * The function isFree() returns true if the elevator is free, false otherwise.
     * 
     * The function isFree() returns true if the
     * 
     * @return The method isFree() returns a boolean value.
     */
    public boolean isFree() {
        return getTargetLocation() == null && passenger == null;
    }

    /**
     * It sets the pickup location.
     * 
     * @param location The location to set as the pickup location.
     */
    public void setPickupLocation(Location location) {
        setTargetLocation(location);
    }

    /**
     * The function pickup() takes a passenger as an argument and sets the target
     * location of the taxi
     * to the passenger's destination
     * 
     * @param passenger The passenger to be picked up
     */
    public void pickup(Passenger passenger) {
        this.passenger = passenger;
        setTargetLocation(passenger.getDestination());
    }

    private void setTargetLocation(Location destination) {
    }

    /**
     * It clears the target location of the passenger.
     */
    public void offloadPassenger() {
        passenger = null;
        clearTargetLocation();
    }

    private void clearTargetLocation() {
    }

    /**
     * If the passenger is not null, return the passengerImage, otherwise return the
     * emptyImage
     * 
     * @return The image of the passenger or the empty image.
     */
    public Image getImage() {
        if (passenger != null) {
            return passengerImage;
        } else {
            return emptyImage;
        }
    }

    /**
     * The function returns a string that says "luxCar at " and then the location of
     * the car
     * 
     * @return The string "luxCar at " + the location of the car.
     */
    public String toString() {
        return "luxCar at " + getLocation();
    }

    /**
     * This function returns a location object.
     * 
     * @return null
     */
    public Location getLocation() {
        // TODO Auto-generated method stub
        return null;
    }

    // Setting the location of the car.
    public void setLocation(Location location) {
        // TODO Auto-generated method stub

    }
}
