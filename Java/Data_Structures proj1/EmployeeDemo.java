
package proj1;

import static proj1.Employee.DegreeType.*;


/**
 *
 * @author Kevin McLaughlin
 */
public class EmployeeDemo {
    public static void main(String[] args) {
        Employee firstEmp = new Employee(DOCTORATE, "Clark", "Wayne", 0);
        
        Employee secondEmp= new Employee();
        
        System.out.println("Using equals: "+secondEmp.equals(firstEmp)+"\n");
        
        System.out.println("Using compareTo: "+firstEmp.compareTo(secondEmp)+"\n");
        
        System.out.println("Using getFirstName on parameterized Employee: "+firstEmp.getFirstName()+"\n");
        
        System.out.println("Using getDegree on parameterized Employee: "+firstEmp.getDegree()+"\n");
        
        System.out.println("Using getLastName on \'default\' Employee: "+secondEmp.getLastName()+"\n");
        
        System.out.println("Using getExperience on 'default' Employee: "+secondEmp.getExperience()+"\n");
        
        System.out.println("Using toString on both Employee objects:\n");
        
        System.out.println(firstEmp.toString()+"\n");
        
        System.out.println(secondEmp.toString()+"\n");
        
       
        
    }//end main
    
}//end class
