import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends GameObject
{

    public Cannon() {
    }

    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        aimCannon();
        shootOnClick();
    }    

    private void aimCannon() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if ( mouse != null) {
            turnTowards( mouse.getX(), mouse.getY() );
            turn(-90);
        }
    }

    private void shootOnClick() {
        if( Greenfoot.mouseClicked(null) || Greenfoot.isKeyDown("space")) {
            World world = getWorld();
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if(mouse != null) {
                double mouseSpeedScale = .1;
                double xVel = mouseSpeedScale * (mouse.getX() - getX());
                double yVel = mouseSpeedScale * (mouse.getY() - getY());
                Vector startingVelocity = new Vector(xVel,yVel);
                Ball ball = new Ball(startingVelocity);
                world.addObject(ball,getX(),getY());
            }
        }
    }
}
