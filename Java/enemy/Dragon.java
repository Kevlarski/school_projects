
package enemy;

import java.util.Random;

/**
 *
 * @author Kevin McLaughlin
 */
public class Dragon extends Enemy{
    int height;
    int weight;
    
    /**Uses Random to set height and weight within 
     * indicated range. 
     */
    public void sizeCalc(){
        Random heightRandom = new Random();
        Random weightRandom = new Random();
        weight= 1000 + weightRandom.nextInt((1500 - 1000) + 1);
        height=750 + heightRandom.nextInt((2000-750)+1);
        this.Enemy(height, weight);
    }//end sizeCalc
    
    @Override
    public void attack() {
        System.out.println("Rawr!");
    }//end attack
    
}//end class
