/*==========================================================

 Title:       Assignment 2 - Numerical Representation
 Course:      CIS 2252
 Author:      <Kevin McLaughlin>
 Date:        < 09/13 /22 >
 Description: This program takes 2 integers as input and then outputs
 			the range of values as spelled out strings. If the values exceed
 			9, corresponding "even" and "odd" will print instead.

 ==========================================================
*/
#include <iostream>
#include <string>
using namespace std;

int main() {
    int x,y, counter;
    cin>>x;
    cin>>y;
    counter = x;
    if(x<y){
        while(counter<=y){
            
            switch(counter){
                case 1:
                    cout<<"one\n";
                    break;
                case 2:
                    cout<<"two\n";
                    break;
                case 3:
                    cout<<"three\n";
                    break;
                case 4:
                    cout<<"four\n";
                    break;
                case 5:
                    cout<<"five\n";
                    break;
                case 6:
                    cout<<"six\n";
                    break;
                case 7:
                    cout<<"seven\n";
                    break;
                case 8:
                    cout<<"eight\n";
                    break;
                case 9:
                    cout<<"nine\n";
                    break;
                default:
                    if(counter%2>0){
                        cout<<"odd\n";
                    }
                    else{
                        cout<<"even\n";
                    }
            }//end switch
            
            counter++;
        }//end while
    }//end if
    else if(x>y){
        counter=y;
        while(counter<=x){
            switch(counter){
                case 1:
                    cout<<"one\n";
                    break;
                case 2:
                    cout<<"two\n";
                    break;
                case 3:
                    cout<<"three\n";
                    break;
                case 4:
                    cout<<"four\n";
                    break;
                case 5:
                    cout<<"five\n";
                    break;
                case 6:
                    cout<<"six\n";
                    break;
                case 7:
                    cout<<"seven\n";
                    break;
                case 8:
                    cout<<"eight\n";
                    break;
                case 9:
                    cout<<"nine\n";
                    break;
                default:
                    if(counter%2>0){
                        cout<<"odd\n";
                    }
                    else{
                        cout<<"even\n";
                    }
            }//end switch
            
            counter++;
        }//end while
    }//end elseif
    else{
        switch(x){
            case 1:
                cout<<"one";
                break;
            case 2:
                cout<<"two";
                break;
            case 3:
                cout<<"three";
                break;
            case 4:
                cout<<"four";
                break;
            case 5:
                cout<<"five";
                break;
            case 6:
                cout<<"six";
                break;
            case 7:
                cout<<"seven";
                break;
            case 8:
                cout<<"eight";
                break;
            case 9:
                cout<<"nine";
                break;
            default:
                if(counter%2>0){
                    cout<<"odd";
                }
                else{
                    cout<<"even";
                }
        }//end switch
    }//end else
  return 0;
}


