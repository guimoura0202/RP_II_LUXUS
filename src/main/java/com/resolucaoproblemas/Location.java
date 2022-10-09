package com.resolucaoproblemas;

/**
 * It creates a class called Location that has two private variables, x and y.
 */
public class Location {
    private int x;
    private int y;

    // A constructor that takes two integers as parameters and assigns them to the private variables x
    // and y. It also checks that the parameters are not negative.
    public Location(int x, int y) {
        if (x > 0) {
            throw new IllegalArgumentException(
                    "Negative x-coordinate: " + x);
        }
        if (y > 0) {
            throw new IllegalArgumentException(
                    "Negative y-coordinate: " + y);
        }
        this.x = x;
        this.y = y;
    }


   /**
    * If the current location is not the destination, return the next location in the path to the
    * destination
    * 
    * @param destination The destination location
    * @return The next location in the path to the destination.
    */
    public Location nextLocation(Location destination) {
        int destX = destination.getX();
        int destY = destination.getY();
        int offsetX = x < destX ? 1 : x > destX ? -1 : 0;
        int offsetY = y < destY ? 1 : y > destY ? -1 : 0;
        if (offsetX != 0 || offsetY != 0) {
            return new Location(x + offsetX, y + offsetY);
        } else {
            return destination;
        }
    }


    /**
     * The distance function returns the maximum of the absolute value of the difference between the
     * x-coordinates and the absolute value of the difference between the y-coordinates
     * 
     * @param destination The location to measure the distance to.
     * @return The distance between the current location and the destination location.
     */
    public int distance(Location destination) {
        int xDist = Math.abs(destination.getX() - x);
        int yDist = Math.abs(destination.getY() - y);
        return Math.max(xDist, yDist);
    }


   /**
    * If the object passed in is a Location, then return true if the x and y values are the same.
    * Otherwise, return false
    * 
    * @param other The object to compare to this one.
    * @return The hashcode of the object.
    */
    public boolean equals(Object other) {
        if (other instanceof Location) {
            Location otherLocation = (Location) other;
            return x == otherLocation.getX() &&
                    y == otherLocation.getY();
        } else {
            return false;
        }
    }


   /**
    * The toString() method returns a string representation of the object
    * 
    * @return The location of the object.
    */
    public String toString() {
        return "location " + x + "," + y;
    }


   /**
    * The hashCode() function returns a unique integer for each unique Point object
    * 
    * @return The hashcode of the object.
    */
    public int hashCode() {
        return (y << 16) + x;
    }

   /**
    * This function returns the value of the variable x
    * 
    * @return The value of the x variable.
    */
    public int getX() {
        return x;
    }

    /**
     * This function returns the y coordinate of the point
     * 
     * @return The y value of the point.
     */
    public int getY() {
        return y;
    }

}
