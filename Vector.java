/**
 * Write a description of class Vector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector  
{
    protected double x;
    protected double y;

    /**
     * Constructor for objects of class Vector
     */
    public Vector() {
        this.x = 0;
        this.y = 0;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void add(double x, double y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public void add(Vector myVector) {
        this.x = this.x + myVector.getX();
        this.y = this.y + myVector.getY();
    }
    
    public double getMagnitude() {
        return Math.sqrt( Math.pow(x,2) + Math.pow(y,2)  );
    }
    
    public void setMagnitude(double newMagnitude) {
        double oldMagnitude = getMagnitude();
        double scaleFactor = newMagnitude/oldMagnitude;
        x = x * scaleFactor;
        y = y * scaleFactor;
    }
    
}
