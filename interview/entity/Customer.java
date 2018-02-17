package interview.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private String name;
    private double rating;
    private Set<Driver> blackListed;
    private int totalTrips;
        
    public Customer(String name){
        this.name = name;
        this.rating = 5;
        this.totalTrips = 10;
        blackListed = new HashSet<Driver>();    
    }

    public void updateRating(double rating) {
        this.rating = ((this.rating * totalTrips) + rating)/ (totalTrips+1.0);
        this.totalTrips += 1;
    }

    public double getRating() {
        return rating;
    }
    
    public void blackList(Driver driver){
        boolean add = blackListed.add(driver);
    }
    public boolean isBlackListed(Driver driver){
        return blackListed.contains(driver);
    }
    public boolean equals(Object o){
        return ((Customer)o).name.equals(name);
    }
}
