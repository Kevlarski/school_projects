
package enemy;

import java.util.ArrayList;
import java.util.Random;

/**Creates 100 Enemy objects, stores them in ArrayList menagerie,
 * and prints the attack() of each Enemy stored
 *
 * @author Kevin McLaughlin
 */
public class EnemyDemo {
    public static void main(String[] args) {
        //creating new ArrayList and Random object
        ArrayList<Enemy> menagerie = new ArrayList();
        Random dFour = new Random();
        //creating variables for while loop, switch statement, and for loop.
        int i=0;
        int next;
        //while loop and Random to determine next Enemy object created
        while (i<101){
            next = 1 + dFour.nextInt((4 - 1) + 1);
            //switch to create appropriate Enemy,set their height/weight, and add to menagerie ArrayList
            switch(next){
                case 1:
                    Goblin gobbo = new Goblin();
                    gobbo.sizeCalc();
                    menagerie.add(gobbo);
                    break;
                case 2:
                    Ghost spooky = new Ghost();
                    spooky.sizeCalc();
                    menagerie.add(spooky);
                    break;
                case 3:
                    Ogre biggun = new Ogre();
                    biggun.sizeCalc();
                    menagerie.add(biggun);
                    break;
                case 4:
                    Dragon scorcher = new Dragon();
                    scorcher.sizeCalc();
                    menagerie.add(scorcher);
                    break;
                default:
                    System.out.println("The creature created is unfathomable!");
                    break;
            }//end switch
            i++;
        }//end while
        for (i=0;i<menagerie.size();i++) { 		      
           menagerie.get(i).attack();
        }//end for
    }//end main
    
}//end class
