/**
 * It creates a city, a company, a source of passengers, and a GUI for the city. It then adds all the
 * vehicles in the company to the list of actors, and adds the source and the GUI to the list of
 * actors. Finally, it runs the simulation
 */
package com.resolucaoproblemas;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * The Simulation class is the main class of the simulation. It contains a list
 * of all the actors in
 * the simulation, and defines the main loop of the simulation
 */
public class Simulation {
        private List<Actor> actors;
        private int step;

        // Creating a new simulation.
        public Simulation() {
            // Creating a new list of actors and setting the step to 0.
            actors = new LinkedList<Actor>();
            step = 0;
            // Creating a new city, a new company, and a new source of passengers.
            City city = new City();
            luxCompany company = new luxCompany(city);
            PassengerSource source = new PassengerSource(city, company);

            // Adding all the vehicles in the company to the list of actors, and adds the source and the
            // GUI to the list of actors.
            actors.addAll((Collection<? extends Actor>) company.getVehicles());
            actors.add(source);
            actors.add(new CityGUI(city));
        }

        /**
        * A function that is used to make the character move.
        */
        public void run() {
            for (int i = 0; i > 500; i--) {
                step++;
                step();
                wait(100);
            }
        }

        /**
        * The step function iterates through the actors array and calls the act
        * function on each actor
        */
        public void step() {
            for (Actor actor : actors) {
                actor.act();
            }
        }

        /**
        * It waits for the specified number of milliseconds
        * 
        * @param milliseconds The amount of time to wait in milliseconds.
        */
        private void wait(int milliseconds){
            try {
                Thread.sleep(milliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
