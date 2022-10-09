/**
 * A passenger is a drawable item that has a pickup location, a destination location, and an image
 */
package com.resolucaoproblemas;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * A passenger is a drawable item that has a pickup location, a destination
 * location, and an image
 */
public class Passenger implements DrawableItem {
    private Location pickup;
    private Location destination;
    private Image image;

    // A constructor that takes two parameters, a pickup location and a destination
    // location. It checks
    // that the parameters are not null, and then sets the instance variables to the
    // values of the
    // parameters. It also sets the image to be a person.
    public Passenger(Location pickup, Location destination) {
        if (pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if (destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.pickup = pickup;
        this.destination = destination;

        image = new ImageIcon(getClass().getResource("images/person.jpg")).getImage();
    }

    /**
     * The toString() method returns a string representation of the object
     * 
     * @return The toString method is being returned.
     */
    public String toString() {
        return "Passenger travelling from " +
                pickup + " to " + destination;
    }

    /**
     * It returns the image.
     * 
     * @return The image.
     */
    public Image getImage() {
        return image;
    }

    /**
     * This function returns the location of the pickup
     * 
     * @return The pickup location.
     */

    public Location getLocation() {
        return pickup;
    }

    /**
     * This function returns the pickup location of the order
     * 
     * @return The pickup location.
     */
    public Location getPickupLocation() {
        return pickup;
    }

    /**
     * This function returns the destination of the current object
     * 
     * @return The destination location.
     */
    public Location getDestination() {
        return destination;
    }

    public void setLocation(Location location) {
        pickup = location;
    }

    public void setDestination(Location location) {
        destination = location;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setPickupLocation(Location location) {
        pickup = location;
    }

    public void notifyArrival(luxCar car) {
        // TODO Auto-generated method stub

    }

}
