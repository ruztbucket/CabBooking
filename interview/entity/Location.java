package interview.entity;

public class Location {
    private double x,y;
    public Location(double x, double y){
        this.x = x;
        this.y = y;
    }
    double getDifference(Location loc){
        return Math.sqrt(Math.pow(this.getX()-loc.getX(),2)+Math.pow(this.getY()-loc.getY(),2));
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }
}
