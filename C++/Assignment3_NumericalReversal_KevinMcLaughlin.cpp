/*==========================================================

 Title:       Assignment 3 - Numerical Reversal
 Course:      CIS 2252
 Author:      <Kevin McLaughin>
 Date:        <9/14/22>
 Description: This program takes an int as the size for an array,
                then takes that number of int's (space-delimited)
                into an array and prints that list backwards.

 ==========================================================*/
#include <iostream>
#include <array>
using namespace std;

int main() {
    
    int input;
    cin>>input;
    int array[input];
    for(int i=0;i<input;i++){
        cin>>array[i];
    }
    int x = input;
    for(x;x>0;x--){
        cout<<array[x-1]<<" ";
    }
  return 0;
}


