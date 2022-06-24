
package proj1;

/**
 *
 * @author Kevin McLaughlin
 */

public class Employee{
    public enum DegreeType{NONE, ASSOCIATE, BACHELORS, MASTERS, DOCTORATE};//end enum
    DegreeType degree;
    String firstName;
    String lastName;
    int experience;
    int degreeValue;
    int valuePoints;
    
    /**Parameterless ctor, default values are {NONE, "Stan", "Dupp", 0}
     *
     */
    public Employee(){
        degree = DegreeType.NONE;
        firstName = "Stan";
        lastName = "Dupp";
        experience= 0;
    }//end no-param ctor
    
    /**Ctor for employee object with parameters. Calls degreeValueCalc to obtain number value for enum degree.
     *
     * @param degree enum DegreeType{NONE, ASSOCIATE, BACHELORS, MASTERS, DOCTORATE}
     * @param firstName string 
     * @param lastName string
     * @param experience int number of years worked at company
     */
    public Employee(DegreeType degree,String firstName,String lastName,int experience){
        this.degree=degree;
        this.firstName=firstName;
        this.lastName=lastName;
        this.experience=experience;
        degreeValueCalc();
    }//end ctor

    /**
     *
     * @return degree enum DegreeType {NONE, ASSOCIATE, BACHELORS, MASTERS, DOCTORATE}
     */
    public DegreeType getDegree() {
        return degree;
    }//end getDegree

    /**Sets the degree type, calls degreeValueCalc() to change enum type to int value.
     *
     * @param degree enum DegreeType{NONE, ASSOCIATE, BACHELORS, MASTERS, DOCTORATE}
     */
    public void setDegree(DegreeType degree) {
        this.degree = degree;
        degreeValueCalc();
    }//end setDegree

    /**
     *
     * @return firstName String
     */
    public String getFirstName() {
        return firstName;
    }//end getFirstName

    /**
     *
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }//end setFirstName

    /**
     *
     * @return lastName String
     */
    public String getLastName() {
        return lastName;
    }//end getLastName

    /**
     *
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }//end setLastName

    /**
     *
     * @return experience int Years worked for company.
     */
    public int getExperience() {
        return experience;
    }//end getExp

    /**
     *
     * @param experience int Years worked for company. 
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }//end setExp
    
    /**Takes the current value of 'degree' and uses a switch to equate it to a number, stored as degreeValue.
     * Then calculates total valuePoint total with degreeValue.
     * Default returns the message "The entered degree does not match stored values."
     */
    private void degreeValueCalc(){
        switch(degree){
            case NONE:
                degreeValue=1;
                valuePoints = experience*degreeValue;
                break;
            case ASSOCIATE:
                degreeValue=2;
                valuePoints = experience*degreeValue;
                break;
            case BACHELORS:
                degreeValue=3;
                valuePoints = experience*degreeValue;
                break;
            case MASTERS:
                degreeValue=4;
                valuePoints = experience*degreeValue;
                break;
            case DOCTORATE:
                degreeValue=5;
                valuePoints = experience*degreeValue;
                break;
            default:
                System.out.println("The entered degree does not match stored values.");
        }//end switch
    }//end degreeValueCalc
    
    
    /**Takes all stored fields and returns them as a string.
     *
     * @return a concatenated string containing the firstName, lastName,
     * experience, and degree fields.
     */
    @Override
    public String toString(){
        return firstName+" "+lastName +" has been with the company for "
            + experience+ " years and holds a degree level of "+degree+".";
    }//end toString
    
    /** Compares the valuePoints of 2 Employee objects.
     * @param toMatch Employee object being compared to the current Employee object. 
     * @return true if the values match, false if not.
     */
    public boolean equals(Employee toMatch) {
        return (toMatch.valuePoints==this.valuePoints);
    }//end equals
    
    /**Compares the valuePoints of 2 Employee objects. Returns a value reflecting the relation between them.
     *
     * @param otherEmployee Employee object being compared to the current Employee obj.
     * @return int (-1) if current Employee object has less valuePoints than otherEmployee,
     * (1) if the current Employee has more valuePoints, and 0 if the values are equal.
     * 
     */
    public int compareTo(Employee otherEmployee){
        if (this.valuePoints<otherEmployee.valuePoints)
            return -1;
        else if(this.valuePoints>otherEmployee.valuePoints)
            return 1;
        else 
            return 0;
    }//end compareTo
}//end class
