import greenfoot.*;
import java.util.HashMap;

/**
 * Write a description of class Graphic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Graphic  
{
    // Static HashMap, so the Class contains the image data for ALL 
    // instances, preventing redundant file access and storage.
    // Each instance just tracks which index it is on.
    // Once consequence: Two different scales cannot be used for same image files.
    static private HashMap<String,GreenfootImage> imageMap;
    private String filename_base;
    private String filename_extension;
    private int imageIndex = 0;
    public boolean animate = true;
    public int animateDecimate = 5;
    private int animateDecimateIndex = 0;
    private int numberOfImages;
    
    /**
     * Constructor for objects of class Graphic
     */
    public Graphic()
    {
        this.imageMap = new HashMap<String,GreenfootImage>();
    }
    
    public Graphic(String filename_base,String filename_extension,
        int numberOfImages, double imageScale) {
        this.imageMap = new HashMap<String,GreenfootImage>();
        this.filename_base = filename_base;
        this.filename_extension = filename_extension;
        this.numberOfImages = numberOfImages;
        for(int i=0;i<numberOfImages;++i) {
            addImage(filename_base + i + '.' + filename_extension, imageScale);
        }
    }

    public void addImage(String imageName, double imageScale) {
        if (!imageMap.containsValue(imageName)) {
            GreenfootImage image = new GreenfootImage(imageName);
            if (imageScale != 1.0) {
                image.scale((int)(image.getWidth()*imageScale),
                    (int)(image.getHeight()*imageScale));
            }
            imageMap.put(imageName,image);
        }
    }
    
    public void incrementImage() {
        imageIndex++;
        if (imageIndex >= numberOfImages) {
            imageIndex = 0;
        }        
    }
    
    public String getCurrentImageName() {
        return filename_base + imageIndex + '.' + filename_extension;
    }
    
    public GreenfootImage getImage() {
        if (animate) {
            if ( ++animateDecimateIndex >= animateDecimate ) {
                animateDecimateIndex = 0;
                incrementImage();
            }
        }
        GreenfootImage image = imageMap.get( getCurrentImageName() );                    
        return image;
    }
}
