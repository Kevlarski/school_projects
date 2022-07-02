
package enemy;

/**
 *
 * @author Kevin McLaughlin
 */
public abstract class Enemy {
    private int height;
    private int weight;

    /**Gets value of field height 
     *
     * @return field height
     */
    public int getHeight() {
        return height;
    }//end getHeight

    /**Sets field height
     *
     * @param height int
     */
    public void setHeight(int height) {
        this.height = height;
    }//end setHeight

    /**Gets value of field weight
     *
     * @return field weight
     */
    public int getWeight() {
        return weight;
    }//end getWeight

    /**Sets field weight
     *
     * @param weight int
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }//end setWeight

    /**Creates Enemy object
     *
     * @param height int 
     * @param weight int
     */
    public void Enemy(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }//end ctor
    
    /**Abstract method for individual attack sounds.
     * Implementation uses println() to print specific sound.
     *
     */
    public abstract void attack();
    
}//end class
