import ecs100.*;
import java.awt.Color;
/**
 * Flower support class
 * Creates a flower of a size and colour
 * It can grow
 *
 * @author Gabrielle 
 * @version 13/3/23
 */
public class Flower
{
    // instance variables - replace the example below with your own
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
        
        // Stem
        UI.setColor(Color.green);                       // set the stem colour
        UI.setLineWidth(STEMWIDTH);                     // set stem width
        UI.drawLine(flowerX, flowerY, flowerX, bottom); // draw stem
        
        // Flower
        UI.setColor(this.color);                       // set the flower colour
        UI.fillOval(left,top, flowerSize, flowerSize); // draw flower
        UI.sleep(500);                                 // wait
        
    }
    
    /**
     * Erase a rectangle around the current instance
     */
    public void erase() {
        UI.eraseRect(left, top, flowerSize+1, bottom);
    }
    
    /**
     * Make the flower grow
     */
    public void grow() {
        this.erase();           // erase flower
        this.flowerY -= 10;     // increase height
        this.flowerSize += 10;  // increase size for the bulb
        
        //set the new position
        this.setTop();
        this.setLeft();
        this.draw();            // redraw the flower
    }
}
