
package salestax;

/**
 * A Program to ask a User about their income
 * and how much is taxable, then calculate the
 * tax they pay currently and would pay with 
 * an increase in tax rate.
 * Kevin McLaughlin
 * 2/15/2022
 * CIS 1500  */

//Imports for user input with JOptionPane
import javax.swing.JOptionPane;
import java.text.*;

public class SalesTax {
    
    public static void main(String[] args) {
        System.out.println("Proposed Sales Tax Increase Program\n");
        
            //User inputs 
            String inc= JOptionPane.showInputDialog(null,
                    "What is your current income:");
                double income;
                income = Double.parseDouble(inc);
                
            String per= JOptionPane.showInputDialog(null,
                    "What percent of your income is taxable (0-100):");
                int percentTaxable;
                percentTaxable = Integer.parseInt(per);    
         
            //Declaring variables and referencing Tax related methods      
            double taxableIncome = income*(percentTaxable*.01);
            
            double currentTaxable = taxableIncome*CURRENT_TAX();
            
            double raisedTaxable = taxableIncome*RAISED_TAX();
            
            double difference = raisedTaxable-currentTaxable;            
    
    //Formating variables using dm 
    DecimalFormat dm = new DecimalFormat("##,###,###.00");
        String formatTaxable = dm.format(taxableIncome);
            String formatCurrent = dm.format(currentTaxable);
            String formatRaised = dm.format(raisedTaxable);
                String formatDiff = dm.format(difference);
        
        //Formated output, based on user input and referential methods        
        System.out.println("Taxable income: $" + formatTaxable);
                
            System.out.println("At current 6% tax: $" 
                + formatCurrent);
        
            System.out.println("At proposed 7% tax: $" 
                + formatRaised);
        
                System.out.println("Difference: $" + formatDiff);
        
    }
    
   
  //Current Michigan Sales Tax//
    public static final double CURRENT_TAX() {
       double curTax=0.06;
       return curTax;
    }
        
    
  //Proposed New Tax Rate//
    public static double RAISED_TAX() {
        double newTax=0.07;
        return newTax;
    }
}
        


