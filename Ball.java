import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Physics
{
    double restitution = .9;  // Overwrite Physics default.
    
    Ball() {        
    }
    
    Ball(Vector velocity) {
        this.velocity = velocity;
    }
    
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addGravity();
        bounce();
        friction();
        super.act();
        removeIfStationary();
        kill();
    }    
    
    public void bounce() {
        if ( isAtEdge() ) {
            World myWorld = getWorld();  // To get world size
            int padding = 2; // Detect wall when this close
            // Horizontal Bounce
            if( (getX() <= 0+padding) || (getX() >= myWorld.getWidth()-padding)) {
                velocity.setX(-velocity.getX() * this.restitution);    
            }
            // Vertical Bounce
            if( (getY() <= 0+padding) || (getY() >= myWorld.getHeight()-padding)) {
                velocity.setY(-velocity.getY() * this.restitution);    
            }            
        }
        
    }
    
    public void friction() {
        if( isAtEdge() ) {
            velocity.setX( velocity.getX() * 0.95);
        }
    }
    
    public void removeIfStationary() {
        if (velocity.getMagnitude() <= 1.0) {
            removeThis();
        }
        
    }
    
    public void kill() {
        // Ensure this object hasn't been removed from the world yet.
        if (getWorld() != null && isTouching(Linus.class)) {
            removeTouching(Linus.class);
            removeThis();
        }
    }
    
}
