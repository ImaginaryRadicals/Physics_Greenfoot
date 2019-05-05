import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Vector ballStart = new Vector(getWidth()/2,getHeight()/2);
    Cannon cannon;
    Human human;
    Vector humanStart = new Vector(5,5);
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        //prepare();
        prepare();
    }

    public void act() {
        if(Greenfoot.mouseClicked(null) ) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
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
        this.cannon = new Cannon();
        addObject(this.cannon,(int)ballStart.getX(),(int)ballStart.getY());
        this.human = new Human();
        addObject(this.human, (int)humanStart.getX(),(int)humanStart.getY());
    }
    
    private void aimCannon() {
        
    }
}
