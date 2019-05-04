import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    public void act() {
        if(Greenfoot.mouseClicked(null) ) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            Vector ballStart = new Vector(getWidth()/2,getHeight()/2);
            double mouseSpeedScale = .1;
            double xVel = mouseSpeedScale * (mouse.getX() - ballStart.getX());
            double yVel = mouseSpeedScale * (mouse.getY() - ballStart.getY());
            Vector startingVelocity = new Vector (xVel,yVel);
            Ball ball = new Ball(startingVelocity);
            addObject(ball,(int)ballStart.getX(),(int)ballStart.getY());
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Ball ball = new Ball(new Vector(10,-20));
        addObject(ball,10,385);
    }
}
