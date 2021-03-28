/**
 * Computer Programming 2 (COMP2711, COMP8801)
 * Practical 2: Roman Numbers
 */

#include <iostream>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <cctype>
using namespace std;

int main(int argc, char *argv[]) {
    string input; //roman user, get subsrt
    string roman[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    string ten[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    string hundred[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    string thousand[] = {"", "M", "MM", "MMM"};


    while (cin >> input) {
        int total = 0; //value
        //cout << input;

        if (isdigit(input[0])){
            int num = stoi(input);
            int a = num/1000;
            int b = num/100%10;
            int c = num/10%10;
            int d = num%10;

            cout<<left<<thousand[a]<<hundred[b]<<ten[c]<<roman[d]<<endl;
        }
        else{

        for (int i = 0; i < input.length(); i++) {
            input[i] = toupper(input[i]);
        }
        for (int i = 3; i > 0; i--) {
            if (thousand[i] == input){
           //     cout << i * 1000;
            }
                if (input.substr(0,thousand[i].length()) == thousand[i]){ //smaller string 0,
                    total = total + i * 1000;
                    input = input.substr(thousand[i].length()); // from index 2
                }
            }

        for (int i = 9; i > 0; i--) {
            if (hundred[i] == input){
            //    cout << i * 100;
            }
            if (input.substr(0,hundred[i].length()) == hundred[i]){ //smaller string
                total = total + i * 100;
                input = input.substr(hundred[i].length());
            }
        }

        for (int i = 9; i > 0; i--) {
            if (ten[i] == input){
            //    cout << i * 10;
            }
            if (input.substr(0, ten[i].length()) == ten[i]){ //smaller string
                total = total + i * 10;
                input = input.substr(ten[i].length());
            }
        }

        for (int i = 9; i > 0; i--) {// = to input string, print no from num array at that index
            if (roman[i] == input){
            //    cout << i * 100;
            }
            if (input.substr(0,roman[i].length()) == roman[i]){ //smaller string
                total = total + i ;
                input = input.substr(roman[i].length());
            }
        }

        cout<<left<<total<<endl;
        }

    }
}

