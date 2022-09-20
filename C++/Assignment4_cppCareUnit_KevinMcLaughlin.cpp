/*==========================================================

 Title:     Assignment 4 - C++ Care Unit
 Course:  	CIS 2252
 Author:  	Kevin McLaughlin
 Date:    	9/20/22
 Description: This program calculates BMI using 2 weight values 
                and one height value (that will be switched to meters).
                Then the program switches the values and calculates again

 ==========================================================
*/

#include <iostream>
using namespace std;


double conversionMeters(double height){
    double heightMeters = (height/3.281);
    return heightMeters;
}

float BMIcalculator(double weight){
    float BMI =(float) weight/((1.8)*(1.8));
    return BMI;    
}

float BMIcalculator(double weight, double height){
    float BMI =(float) weight/((height)*(height));
    return BMI;
}

void swap(double &x, double &y){
    double z = x;
     x = y;
     y = z;
}

int main() {
    //DO NOT MODIFY MAIN()!!!
    
    double w1, w2, h;
    cin >> w1 >> w2 >> h;

    float index1 = BMIcalculator(w1);
    float index2 = BMIcalculator(w2, conversionMeters(h));

    cout << index1 << " " << index2 << endl;

    swap(w1, w2);

    index1 = BMIcalculator(w1);
    index2 = BMIcalculator(w2, conversionMeters(h));
    cout << index1 << " " << index2 << endl;
}

