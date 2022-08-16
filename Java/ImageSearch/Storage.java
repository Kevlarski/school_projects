//Kevin McLaughlin
//CIS 2353
//Summer 2022
//Prof. John P. Baugh

package prog3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Kevin McLaughlin
 */
public class Storage {
    /*Field Objects for data storage*/
    private ImageInfo imgInfo;
    private final ArrayList<ImageInfo> imgList = new ArrayList();
    
    /*Initializer, reads .txt file to populate 'database'*/ 
    public void Storage(){
        Scanner reader;
        try {
            reader = new Scanner(new File("image_info.txt"));
            
            /*Creating ImageInfo objects to store individual data sets*/
            while(reader.hasNextLine()){
                imgInfo= new ImageInfo();
                imgInfo.setName(reader.next());
                imgInfo.setAttributes(splitter(reader.nextLine()));
                imgList.add(imgInfo);
            }//end while
            
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Cannot find file");
        }//end catch
        
    }//end Storage
    
    /**Takes a string and separates the tokens into an ArrayList attributes
     * 
     * @param input String to be split
     * @return ArrayList attributes composed of all attributes trailing the image
     * name(1+)
     */
    private ArrayList<String> splitter(String input){
        Scanner split = new Scanner(input);
        ArrayList<String> attributes=new ArrayList();
        
        while(split.hasNext()){
            attributes.add(split.next());
        }//end while
        
        split.close();
        return attributes;
    }//end splitter
    
    /**Checks entered string for multiple tokens and enters all found tokens
     * in an ArrayList(String) 'input'. If an 'and' or an 'or'
     *is found, uses if statements to determine output based on input. 
     * Prints the contents of the ArrayList(String) output, or a failure message
     * if output is empty.
     * 
     * @param choice String to be checked against stored values
     */
    public void multiCheck(String choice){
        //Adding objects//
        Scanner checker = new Scanner(choice);
        ArrayList<String> input = new ArrayList();
        ArrayList<String> output = new ArrayList();
        
        /*while loop to add query*/
        int i=0;
        while(checker.hasNext()){
            input.add(checker.next());
            i++;
        }//end while
        
        /*Checks for multiple params. If "and" or "or" is present, iterates through list
        adding to output following query*/
        if(input.size()>1){
            if(input.get(1).equals("or")){
                i =0;
                while(i<imgList.size()){
                    if(imgList.get(i).getAttributes().contains(input.get(0))||
                            imgList.get(i).getAttributes().contains(input.get(2))){
                        output.add(imgList.get(i).getName());
                    }//end if
                    i++; //counter for "or" while
                } //end while
            }//end if "or"
            else if(input.get(1).equals("and")){
                i =0;
                while(i<imgList.size()){
                    if(imgList.get(i).getAttributes().contains(input.get(0))&&
                            imgList.get(i).getAttributes().contains(input.get(2))){
                        output.add(imgList.get(i).getName());
                    }//end if
                    i++; //counter for "and" while
                } //end while
            }//end elseif "and"
        }//end if (>1)
        
        /*if only one search param, else happens*/
        else{
            for(ImageInfo img: imgList){
                if(img.getAttributes().contains(input.get(0))){
                    output.add(img.getName());
                }//end if
            }//end for
        }//end else
        
        /*Checking ArrayList output for values. Prints fail message if not */
        if(output.isEmpty()){
            System.out.println("There don't seem to be any matches");
        }//end if
        else{
            for(String out:output){
                System.out.println(out);
            }//end for
        }//end else
        checker.close();
    }//end check()
    
}//end
