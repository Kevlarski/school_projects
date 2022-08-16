
package proj4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Kevin McLaughlin
 */
public class TriageSimulator{
    
    public Queue<Patient> high;
    private Queue<Patient> med;
    private Queue<Patient> low;
    private Scanner reader;
    private Scanner lineRdr;
    
    public TriageSimulator() {
        this.high = new LinkedList();
        this.med = new LinkedList();
        this.low = new LinkedList();
    }
    
    
    public void init(){
        try {
            reader = new Scanner(new File("patients.txt"));
            while(reader.hasNext()){
                add(reader.nextLine());
            }//end while
            reader.close();
        } //end init
        catch (FileNotFoundException ex) {
            System.out.println("The file cannot be found.");
        }//end catch
    }//end init
    
    
    private void add(String nextLine){
        lineRdr= new Scanner(nextLine);
        String name = lineRdr.next().concat(" "+lineRdr.next());
        int code =codeConvert(lineRdr.next());
        Patient newPatient = new Patient(name,code);
        
        switch(newPatient.getCode()){
            case(1):
                high.add(newPatient);
                break;
            case(2):
                med.add(newPatient);
                break;
            case(3):
                low.add(newPatient);
                break;
        }//end switch
        
        lineRdr.close();
    }//end add
    
    
    public String remove(){
        String nextPatient=null;
        if(isEmpty()){
            nextPatient="the waiting room is empty.";
        }
        else if(!high.isEmpty()){
            nextPatient=high.remove().getName()+" is next.";
        }
        else if(!med.isEmpty()){
            nextPatient=med.remove().getName()+" is next.";
        }
        else if(!low.isEmpty()){
            nextPatient=low.remove().getName()+" is next.";
        }
        return nextPatient;
    }//end remove
    
    
    private boolean isEmpty(){
        return (high.isEmpty()&&med.isEmpty()&&low.isEmpty());
    }//end isEmpty
    
    private int codeConvert(String code){
        int codeInt=0;
        if(code.equalsIgnoreCase("al")||code.equalsIgnoreCase("ha")||code.equalsIgnoreCase("st")){
            codeInt=1;
        }//end if
        else if(code.equalsIgnoreCase("hn")){
            codeInt=3;
        }//end elseif
        else{
            codeInt=2;
        }//end else
        return codeInt;
    }//end codeConvert
    
}//end
