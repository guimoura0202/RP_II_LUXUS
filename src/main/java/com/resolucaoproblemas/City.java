package com.resolucaoproblemas;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * It creates a class called City.
 */
public class City {
    private int width;
    private int height;
    private LinkedList<Object> items;

    // A constructor.
    public City(int width, int height) {
        // Checking if the width and height are positive. If they are not, it throws an
        // exception.
        if (width < 1) {
            throw new IllegalArgumentException(
                    "Width must be positive: " +
                            width);
        }
        if (height < 1) {
            throw new IllegalArgumentException(
                    "Height must be positive: " +
                            height);
        }
        this.width = width;
        this.height = height;
        items = new LinkedList<Object>();
    }

    // A constructor that calls another constructor.
    public City() {
        this(0, 0);
    }

    /**
     * Return an iterator over the items in the list.
     * 
     * @return An iterator object.
     */
    public Iterator getItems() {
        return items.iterator();
    }

    /**
     * This function adds an item to the city
     * 
     * @param item The item to be added to the city.
     */
    public void addItem(Object item) {
        if (items.contains(item)) {
            throw new IllegalArgumentException(
                    item + " already recorded in the city.");
        }
        items.add(item);
    }

    /**
     * If the item is not in the city, throw an exception
     * 
     * @param item The item to remove from the city.
     */
    public void removeItem(Object item) {
        if (!items.remove(item)) {
            throw new IllegalArgumentException(
                    item + " is not in the city.");
        }
    }

    /**
     * The toString() method returns a string representation of the object
     * 
     * @return The width and height of the city.
     */
    public String toString() {
        return "City size " + width + " by " + height;
    }

    /**
     * This function returns the width of the rectangle
     * 
     * @return The width of the rectangle.
     */
    public int getWidth() {
        return width;
    }

    // Returning the height of the rectangle.
    public int getHeight() {
        return height;
    }
}
