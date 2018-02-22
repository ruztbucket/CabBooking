package interview.entity;

public class Booking {
    private Customer customer;
    private Location destination;
    private int seats;
    public Booking(Customer customer, Location destination, int seats){
        this.customer = customer;
        this.destination = destination;
        this.seats = seats;
    }
    public int getSeats(){
        return this.seats;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Location getDestination() {
        return destination;
    }
    
}
