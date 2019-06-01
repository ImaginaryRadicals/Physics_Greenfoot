import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Physics here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Physics extends GameObject
{
    Vector velocity = new Vector(0,0);
    Vector acceleration = new Vector(0,0);
    Vector gravity = new Vector(0,1);
    double restitution = 1.0;
    
    public void act() 
    {
       applyAcceleration();
       applyVelocity();
       resetAcceleration();
    }    
    
    public void applyAcceleration() {
        velocity.add(acceleration);
    }
    
    public void applyVelocity() {
        setLocation( getX() + (int) velocity.getX(), 
            getY() + (int) velocity.getY());
    }
    
    public void resetAcceleration() {
        acceleration.setXY(0,0);
    }
    
    public void addGravity() {
        acceleration.add(gravity);
    }
    
    public double addGravity(int xLoc, int yLoc, double strength) {
        // Force = G * mass1 * mass2 / range^2
        // Acceleration = strength / distance^2
        Vector gravityPosition = new Vector(xLoc,yLoc);
        Vector myPosition = new Vector(getX(),getY());
        // Distance
        double xDist = gravityPosition.getX() - myPosition.getX();
        double yDist = gravityPosition.getY() - myPosition.getY();
        double distance = Math.sqrt( Math.pow(xDist,2) + Math.pow(yDist,2) );
        double accelerationMagnitude = strength / Math.pow(distance,2);
        Vector gravityAccel = new Vector(xDist,yDist);
        gravityAccel.setMagnitude(accelerationMagnitude);
        acceleration.add(gravityAccel);
        return accelerationMagnitude;
    }
    
    public double getVelocity() {
        return velocity.getMagnitude();
    }
}

