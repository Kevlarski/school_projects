
package enemy;

import java.util.Random;

/**
 *
 * @author Kevin McLaughlin
 */
public class Ogre extends Enemy{
    int height;
    int weight;
    
    /**Uses Random to set height and weight within 
     * indicated range. 
     */
    public void sizeCalc(){
        Random heightRandom = new Random();
        Random weightRandom = new Random();
        weight= 120 + weightRandom.nextInt((200 - 120) + 1);
        height=200 + heightRandom.nextInt((300-200)+1);
        this.Enemy(height, weight);
    }//end sizeCalc
    
    @Override
    public void attack() {
        System.out.println("Ugh!");
    }//end attack
    
}//end class
