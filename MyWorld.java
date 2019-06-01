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
        super(600, 700, 1); 
        prepare();
    }

    public void act() {

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Cannon
        addObject(new Cannon(), 0, getHeight() );
        // Linuses
        for(int i=0; i<4; i++) {
            addObject(new Linus(), 
                getWidth() * (50 + Greenfoot.getRandomNumber(50))/100, 
                Greenfoot.getRandomNumber(getHeight()));
        }
        // Missile
        addObject(new Missile(),130,292);
        addObject(new Cursor(),getWidth()/2,getHeight()/2);
    }
    

    

    
}
