/*==========================================================

 Title:       Assignment 5 - Sum/Difference with Pointer
 Course:      CIS 2252
 Author:      Kevin McLaughlin
 Date:        10/10/22
 Description: This program stores the sum of 2 numbers as x
                and the absolute difference as y

 ==========================================================
*/

#include <iostream>
#include <cmath>
using namespace std;

void Modify(int *x, int *y) {
    int first = *x;
    int second = *y;
    *x=first+second;
    *y=abs(first-second);
}

int main() {
    //DO NOT MODIFY ANYTHING IN THE main() !!!
    
    int x, y;
    
    int *ptr_x = &x;
    int *ptr_y = &y;
    
    cin >> x;
    cin >> y;
    
    Modify(ptr_x, ptr_y);
    
    cout << x << endl;
    cout << y;
                 
    return 0;
}
