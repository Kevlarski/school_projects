/*==========================================================

 Title:       Assignment 1 - Dragon Years
 Course:      CIS 2252
 Author:      Kevin McLaughlin
 Date:        08/29/22
 Description: A program to calculate a dragon's age in wizard years

 ==========================================================
*/
#include <iostream>
using namespace std;

int main() {
  string name;
  double age;
  cin>>name;
  cin>>age;
  if(age>2){
      age=((age-2)*4)+21;
  }
  if(age<=2){
      age=(age*10.5);
  }
  cout<<"The dragon named "<<name<<" is "<<age<<" years old in wizard years.";
  return 0;
}

