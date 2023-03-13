import ecs100.*;
import java.awt.Color;
/**
 * Create a garden with each flower obj in an array
 * Click on the flower and make it grow
 *
 * @author Gabrielle
 * @version 14/3/23
 */
public class clickGarden
{
    // class constants
    private static final int STARTX = 75;
    private static final int YPOS = 100;
    private static final int MAXFLOWERS = 5;
    
    // make and array of flowers
    private Flower[] flowerBed = new Flower[MAXFLOWERS];    // initialise array
    
    /**
     * Constructor for objects of class clickGarden
     */
    public clickGarden()
    {
        // initialise instance variables
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        
        // Setup the flowers
        for (int i = 0; i < MAXFLOWERS; i++) {
            // set every flower to a random colour 
            Color col = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            flowerBed[i] = new Flower(STARTX*(i+1), YPOS, 10, 50, col); // create flower obj in the array
        }
        
        // Draw flower
        for (Flower flower : flowerBed) {
            flower.draw();
        }
    }
}
