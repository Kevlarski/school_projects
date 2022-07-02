
package enemy;

import java.util.Random;

/**
 *
 * @author Kevin McLaughlin
 */
public class Goblin extends Enemy {
    int height;
    int weight;
    
    /**Uses Random to set height and weight within 
     * indicated range. 
     */
    public void sizeCalc(){
        Random heightRandom = new Random();
        Random weightRandom = new Random();
        height= 70 + heightRandom.nextInt((100 - 70) + 1);
        weight=5 + weightRandom.nextInt((10-5)+1);
        this.Enemy(height, weight);
    }//end sizeCalc
    
      
    
    @Override
    public void attack() {
        System.out.println("Gurgle!");
    }//end attack
    
}//end class
