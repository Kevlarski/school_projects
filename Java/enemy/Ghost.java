
package enemy;

import java.util.Random;

/**
 *
 * @author Kevin McLaughlin
 */
public class Ghost extends Enemy{
    int weight=0;
    int height;
    
    /**Uses Random to set height and weight within 
     * indicated range. Weight will always be 0 for ghost objects.
     */
    public void sizeCalc(){
        Random heightRandom = new Random();
        height= 90 + heightRandom.nextInt((150 - 90) + 1);
        this.Enemy(height, weight);
    }//end sizeCalc
   
    
    @Override
    public void attack() {
        System.out.println("Boo!");
    }//end attack
    
}//end class
