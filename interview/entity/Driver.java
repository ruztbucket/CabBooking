package interview.entity;

import java.util.HashSet;
import java.util.Set;

public class Driver {
    private String name;
    private double rating;
    private Set<Customer> blackListed;
    private int totalTrips = 0;
    
    public Driver(String name){
        this.name = name;
        this.rating = 5;
        blackListed = new HashSet<Customer>();
    }
    
    public void updateRating(double rating) {
        this.rating = ((this.rating * totalTrips) + rating)/ (totalTrips+1.0);
        this.totalTrips += 1;        
    }

    public double getRating() {
        return rating;
    }
    public void blackList(Customer customer){
        boolean add = blackListed.add(customer);
    }
    public boolean isBlackListed(Customer customer){
        return blackListed.contains(customer);
    }

    public String getName() {
        return name;
    }

    public void setTotalTrips(int totalTrips) {
        this.totalTrips = totalTrips;
    }

    public int getTotalTrips() {
        return totalTrips;
    }
}
