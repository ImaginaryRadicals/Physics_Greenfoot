import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Vector ballStart = new Vector(0,getHeight());
    Cannon cannon;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 700, 1); 
        prepare();
    }

    public void act() {
        aimCannon();
        shootOnClick();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        this.cannon = new Cannon();
        addObject(this.cannon, (int) ballStart.getX(), (int) ballStart.getY() );
    }
    
    private void shootOnClick() {
        if( Greenfoot.mouseClicked(null) ) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            double mouseSpeedScale = .1;
            double xVel = mouseSpeedScale * (mouse.getX() - ballStart.getX());
            double yVel = mouseSpeedScale * (mouse.getY() - ballStart.getY());
            Vector startingVelocity = new Vector(xVel,yVel);
            Ball ball = new Ball(startingVelocity);
            addObject(ball,(int)ballStart.getX(),(int)ballStart.getY());
        }
    }
    
    private void aimCannon() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if ( this.cannon != null && mouse != null) {
            this.cannon.turnTowards( mouse.getX(), mouse.getY() );
            this.cannon.turn(-90);
        }
    }
    
}
