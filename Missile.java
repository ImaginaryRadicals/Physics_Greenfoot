import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends GameObject
{
    Graphic graphic;
    
    public Missile() {
        graphic = new Graphic("Missile_1_Flying_00","png",10, .3);
    }
    /**
     * Act - do whatever the Missile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(graphic.getImage());
    }    
}
