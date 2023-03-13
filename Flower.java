import ecs100.*;
import java.awt.Color;
/**
 * Flower support class
 * Creates a flower of a size and colour
 * It can grow
 * It can tell the driver class where it is on the screen
 *
 * @author Gabrielle 
 * @version 14/3/23
 */
public class Flower
{
    // instance variables
    private double flowerX;        // xpos of flower
    private double flowerY;        // ypos of flower
    
    private int flowerSize;        // flower size
    private int flowerHeight;      // flower height
    
    private double left;           // left of flower
    private double top;            // top of flower
    private double bottom;         // bottom of flower
    
    private Color color;           // color of flower
    
    /**
     * Constructor for objects of class Flower
     */
    public Flower(double x, double y, int size, int stem, Color col)
    {
        // initialise instance variables
        flowerX = x;
        flowerY = y;
        flowerSize = size;
        flowerHeight = stem;
        color = col;
        
        // set the top, left and bottom
        setTop();
        setLeft();
        setBottom();
    }
    
    /**
     * Getter left
     */
    public double getLeft() {
        return this.left;
    }
    
    /**
     * Getter right
     */
    public double getRight() {
        return this.left + this.flowerSize;
    }
    
    /**
     * Getter top
     */
    public double getTop() {
        return this.top;
    }
    
    /**
     * Getter bottom
     */
    public double getBottom() {
        return this.bottom;
    }
    
    /**
     * Set top
     */
    public void setTop() {
        this.top = this.flowerY - this.flowerSize/2.0;
    }
    
    /**
     * Set left
     */
    public void setLeft() {
        this.left = this.flowerX - this.flowerSize/2.0;
    }
    
    /**
     * Set bottom
     */
    public void setBottom() {
        this.bottom = this.flowerY + this.flowerHeight;
    }
    
    /**
     * Draw the flower in the canvas
     */
    public void draw() {
        final int STEMWIDTH = 2;
        final int WAITMS = 500;
        
        // Stem
        UI.setColor(Color.green);                       // set the stem colour
        UI.setLineWidth(STEMWIDTH);                     // set stem width
        UI.drawLine(flowerX, flowerY, flowerX, bottom); // draw stem
        
        // Flower
        UI.setColor(this.color);                       // set the flower colour
        UI.fillOval(left,top, flowerSize, flowerSize); // draw flower
        UI.sleep(WAITMS);                              // wait
        
    }
    
    /**
     * Erase a rectangle around the current instance
     */
    public void erase() {
        final int BUFFFER = 1;
        UI.eraseRect(left, top, flowerSize+BUFFFER, bottom+BUFFFER);
    }
    
    /**
     * Make the flower grow
     */
    public void grow() {
        final int GROWSIZE = 10;
        this.erase();           // erase flower
        this.flowerY -= GROWSIZE;     // increase height
        this.flowerSize += GROWSIZE;  // increase size for the bulb
        
        //set the new position
        this.setTop();
        this.setLeft();
        this.draw();            // redraw the flower
    }
}
