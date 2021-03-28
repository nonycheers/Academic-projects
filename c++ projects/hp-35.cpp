/**
 * Computer Programming 2 (COMP2711, COMP8801)
 * Practical 3: HP-35
 */

#include <iostream>
#include <sstream>
#include <string>
#include "HPStack.h"
#include <cmath>
# define PI 3.141592
using namespace std;


int main(int argc, char* argv[]) {
    HPStack stack;
    string line; // takes line of stdin from user
    while (getline(cin, line)) {
        stringstream expression(line);
        string token;
        while (expression >> token) { //white spaces
            if (isdigit(token[0])) { //if idgit push in : stop if digit treat all as nums
                stack.push(stod(token)); // pop 2 nums off the stack
            }
            else if (token == "+") { // similar for other arithmetic ops
                double x = stack.pop();
                double y = stack.pop();
                stack.push(y + x); //stack.push(stack.pop() + stack.pop())
            }
            else if (token == "-") {
                double x = stack.pop();
                double y = stack.pop();
                stack.push(y - x);
            }
            else if (token == "/") {
                double x = stack.pop(); // we want to pop on push when there is an artimetic op
                double y = stack.pop();
                stack.push(y / x);
            }
            else if (token == "*") {
                double x = stack.pop();
                double y = stack.pop();
                stack.push(y * x);
            }
            int i = 0;
            while (token[i]) {
                char c = token[i];
                token[i] = toupper(c);
                //cout << token[i];
                i++;
            }

             if (token == "PI") {
                stack.push(PI);
            }
            else if (token == "SIN") {
                double x = stack.pop();
                stack.push(sin(x));
            }
            else if (token == "COS") {
                double x = stack.pop();
                stack.push(cos(x));
            }
            else if (token == "TAN") {
                double x = stack.pop();
                stack.push(tan(x));
            }
            else if (token == "ARCSIN") {
                double x = stack.pop();
                stack.push(asin(x));
            }
            else if (token == "ARCCOS") {
                double x = stack.pop();
                stack.push(acos(x));
            }
            else if (token == "ARCTAN") {
                double x = stack.pop();
                stack.push(atan(x));
            }
            else if (token == "CHS"){
                double x = stack.pop();
                stack.push(x * (-1));
            }
            else if (token == "RECIP"){
                double x = stack.pop();
                stack.push(1 / x);
            }
            else if (token == "LN"){
                double x = stack.pop();
                stack.push(log(x));
            }
            else if (token == "LOG"){
                double x = stack.pop();
                stack.push(log10(x));
            }
            else if (token == "EXP"){
                double x = stack.pop();
                stack.push(exp(x));
            }
            else if (token == "SQRT"){
                double x = stack.pop();
                stack.push(sqrt(x));
            }
            else if (token == "POW"){
                double x = stack.pop();
                double y = stack.pop();
                stack.push(pow(x,y));
            }
            double memoryslot;
            if (token == "STO"){
                memoryslot = stack.peek(); // peek() store current val of X into memoryslot

            }
            if (token == "RCL"){
                stack.push(memoryslot);

            }
            if (token == "CLR"){
                stack.push(0);
                stack.push(0);
                stack.push(0);
                stack.push(0);

            }
            if (token == "CLX"){
                double x = stack.pop();
            }

            if (token == "SWAP"){
                stack.swap(); // calling swap once, the code has the x and y already swaping in it, you only call it once

            }
            if (token == "ROLL"){
                stack.roll();


            }
            if (token == "ENTER"){
                stack.enter();
            }
        }
        cout << stack.peek() << endl;

    }
    return 0;
}