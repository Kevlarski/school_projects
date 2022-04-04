//Name:Kevin Mclaughlin
//Class: CIS1500
//Purpose: To create a Java based MadLibs game
package project1;

import javax.swing.JOptionPane;

public class Project1 {

    public static void main(String[] args) {

        String name;
        name = JOptionPane.showInputDialog(
                "Enter your name.");
        String city;
        city = JOptionPane.showInputDialog(
                "Where are you from?");
        String age;
        age = JOptionPane.showInputDialog(
                "When did you start college?");
        String college;
        college = JOptionPane.showInputDialog(
                "At which college did you study?");
        String profession;
        profession = JOptionPane.showInputDialog(
                "Enter a profession you hope to achieve");
        String animal;
        animal = JOptionPane.showInputDialog(
                "What is your favorite animal?");
        String petName;
        petName = JOptionPane.showInputDialog(
                "Enter a great pet name");
        System.out.println("There once was a person named " + name
                + " who lived in " + city + "/n. At the age of "
                + age + ", " + name + " went to college at"
                + college + "./n " + name + " graduated and went to work as a "
                + profession + "./n Then, " + name + " adopted an "
                + animal + " named " + petName + "They both lived "
                + "happily ever after!"); 

    }

}
