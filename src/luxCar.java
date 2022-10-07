import java.awt.Image;
import javax.swing.ImageIcon;


public class luxCar implements DrawableItem
{
    private Passenger passenger;
    private luxCar car;
    private Image emptyImage, passengerImage;
    

    public luxCar(luxCarCompany company, Location location)
    {
        super(company, location);
        emptyImage = new ImageIcon(getClass().getResource("images/luxCar.jpg")).getImage();

        passengerImage = new ImageIcon(getClass().getResource("images/luxCar+person.jpg")).getImage();
    }
    
 
    public void act()
    {
        Location target = getTargetLocation();
        if(target != null) {
            Location next = getLocation().nextLocation(target);
            setLocation(next);
            if(next.equals(target)) {
                if(passenger != null) {
                    notifyPassengerArrival(passenger);
                    offloadPassenger();
                }
                else {
                    notifyPickupArrival();
                }
            }
        }
        else {
            incrementIdleCount();
        }
    }


    public boolean isFree()
    {
        return getTargetLocation() == null && passenger == null;
    }
    
  
    public void setPickupLocation(Location location)
    {
        setTargetLocation(location);
    }
    

    public void pickup(Passenger passenger)
    {
        this.passenger = passenger;
        setTargetLocation(passenger.getDestination());
    }


    public void offloadPassenger()
    {
        passenger = null;
        clearTargetLocation();
    }
    

    public Image getImage()
    {
        if(passenger != null) {
            return passengerImage;
        }
        else {
            return emptyImage;
        }
    }


    public String toString()
    {
        return "luxCar at " + getLocation();
    }
}
