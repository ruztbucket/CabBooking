package interview.entity;

import java.util.ArrayList;
import java.util.List;

public class Cab implements Comparable{
    private boolean online = false;
    private Driver driver;
    private List<Booking> bookings;
    private int seatsAvailable;
    
    public Cab(Driver driver){
        this.online = true;
        this.driver = driver;
        seatsAvailable = 4;
        bookings = new ArrayList<Booking>();        
    }
    public Driver getDriver(){
        return driver;
    }    
    public void addBooking(Booking booking){
        bookings.add(booking);
        seatsAvailable -= booking.getSeats();
    }
    public void goOffline(){
        this.online = false;
    }
    public void goOnline(){
        this.online = true;
    }
    public int compareTo(Object cab){
        if(this.getDriver().getRating() <= ((Cab)cab).getDriver().getRating())
            return -1;
        else
            return 1;
    }
    public boolean equals(Cab cab){
        return this==cab;
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
