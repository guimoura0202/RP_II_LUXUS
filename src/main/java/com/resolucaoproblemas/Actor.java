// A Java interface.
package com.resolucaoproblemas;

public interface Actor {
    /**
     * // do something
     */
    public void act();

    /**
     * @return A boolean value.
     */
    public boolean isActive();

    /**
     * @param active true if the user is active, false if not
     */
    public void setActive(boolean active);

    /**
     * // do something
     */
    public void reset();

}
