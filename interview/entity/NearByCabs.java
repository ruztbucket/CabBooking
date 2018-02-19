package interview.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class NearByCabs {
    private SortedSet<Cab> cabs;
    private double threshold = 10;
    public NearByCabs(Cab cab){
        cabs.add(cab);
    }
    public NearByCabs(){
        cabs = new TreeSet<Cab>();
    }
    public void addCab(Cab cab){
        cabs.add(cab);
    }
    public List<Cab> getMatch(Booking booking){
        List<Cab> matches = new ArrayList<Cab>();
        Iterator it = cabs.iterator();
        double customerRating = booking.getCustomer().getRating();
        boolean nothingMatched = true;
        while(it.hasNext()){
            Cab cab = (Cab)it.next();
            double driverRating = cab.getDriver().getRating();
            if(nothingMatched == false && driverRating<customerRating)
                break;            
            if(cab.hasSeats(booking.getSeats()) && withinThreshold(cab.getBookings(),booking) && isCompatible(cab.getDriver(),booking.getCustomer())){
                matches.add(cab);
                nothingMatched = false;
            }
        }
        return matches;
    }
        public boolean withinThreshold(List<Booking> bookings, Booking newBooking){
            if(bookings.isEmpty())
                return true;
            boolean tooFar = true;                        
            Iterator it = bookings.iterator();            
            while(it.hasNext()){
                Booking booking = (Booking)it.next();
                if(booking.getDestination().getDifference(newBooking.getDestination()) < threshold){
                    tooFar = false;
                    break;
                }                    
            }
            return !tooFar;
        }
        
        public boolean isCompatible(Driver driver, Customer customer){
            if(driver.isBlackListed(customer) || customer.isBlackListed(driver))
                return false;
            return true;
        }           
}
