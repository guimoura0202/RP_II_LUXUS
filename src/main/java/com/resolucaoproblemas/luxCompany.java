package com.resolucaoproblemas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class luxCompany {
    // The above code is creating a new class called VehiclePool.
    private List<Vehicle> vehicles;
    private City city;
    private Map<Vehicle, Passenger> assignments;

    private static final int TOTAL_LUXCARS = 0;

    // Creating a new instance of the class luxCompany.
    public luxCompany(City city) {
        this.city = city;
        vehicles = new LinkedList<Vehicle>();
        assignments = new HashMap<Vehicle, Passenger>();
        setupVehicles();
    }

    /**
     * If there is a vehicle available, assign it to the passenger and set the
     * vehicle's pickup location
     * to the passenger's pickup location. Otherwise, return false.
     * 
     * @param passenger The passenger requesting a pickup
     * @return A boolean value.
     */
    public boolean requestPickup(Passenger passenger) {
        Vehicle vehicle = scheduleVehicle();
        if (vehicle != null) {
            assignments.put(vehicle, passenger);
            vehicle.setLocation(passenger.getPickupLocation());
            return true;
        } else {
            return false;
        }
    }

    /**
     * "If the vehicle is assigned to a passenger, remove the passenger from the
     * city and assign the
     * passenger to the vehicle."
     * 
     * The first line of the function is a call to the `remove` method of the
     * `assignments` map.
     * 
     * The `remove` method returns the value associated with the key, which is the
     * passenger.
     * 
     * If the key is not in the map, the `remove` method returns `null`.
     * 
     * The second line of the function checks if the passenger is `null`.
     * 
     * If the passenger is `null`, the function throws an exception.
     * 
     * If the passenger is not `null`, the function removes the passenger from the
     * city and assigns the
     * passenger to the vehicle
     * 
     * @param vehicle The vehicle that has arrived at the pickup location.
     */
    public void arrivedAtPickup(Vehicle vehicle) {
        Passenger passenger = assignments.remove(vehicle);
        if (passenger == null) {
            throw new MissingPassengerException(vehicle);
        }
        city.removeItem(passenger);
        vehicle.pickup(passenger);
    }

    /**
     * A function that is called when a passenger arrives at their destination.
     * 
     * @param vehicle   The vehicle that has arrived at the destination.
     * @param passenger The passenger that has arrived at their destination.
     */

    public void arrivedAtDestination(Vehicle vehicle,
            Passenger passenger) {
    }

    /**
     * This function returns a list of vehicles
     * 
     * @return A list of vehicles.
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * It returns the first free vehicle in the list of vehicles
     * 
     * @return A vehicle object.
     */
    private Vehicle scheduleVehicle() {
        Iterator<Vehicle> it = vehicles.iterator();
        while (it.hasNext()) {
            Vehicle vehicle = it.next();
            if (vehicle.isFree()) {
                return vehicle;
            }
        }
        return null;
    }

    // Getting the width and height of the city.
    private void setupVehicles() {
        int cityWidth = city.getWidth();
        int cityHeight = city.getHeight();

        Random rand = new Random(12345);

        // Creating a new instance of the class luxCar.
        for (int i = 0; i < TOTAL_LUXCARS; i++) {
            luxCar luxcar = new luxCar(this,
                    new Location(rand.nextInt(cityWidth),
                            rand.nextInt(cityHeight)));
            // Adding the luxCar to the list of vehicles and adding the luxCar to the city.
            vehicles.addAll((Collection<? extends Vehicle>) luxcar);
            city.addItem(luxcar);
        }
    }

// A function that is called when a passenger arrives at their destination.
    public void notifyPickupArrival(luxCar luxCar) {
    }

// Incrementing the idle count.
    public void incrementIdleCount() {
    }
}
