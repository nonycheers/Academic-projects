//
// Created by Aishwarya on 27/4/20.
//

#include "HPStack.h"
//def of method ,methods partsof class,


void HPStack::push(double value)
{
    //for( int i = 0; i < 3; i++) //insitale
    regs[3] = regs[2]; //put Z into T
    regs[2] = regs[1]; //put Y into Z
    regs[1] = regs[0]; //put X into Y
    regs[0] = value; //put value into X
}

double HPStack::pop()
{
    double tempvalue = regs[0]; //temp val = X[0]
    regs[0] = regs[1]; //put Y[1] into X[0] //assign
    regs[1] = regs[2]; //put Z[2] into Y[1] //change
    regs[2] = regs[3]; //put assign vale of T[3] and change it into Z[2]

    return tempvalue;
}

double HPStack::peek() //const //wont change any other values
{
    return regs[0];
}

double HPStack::swap()
{
    //swap values in X and Y
    //              1  and 2 swap 2 and 1

    double temp = regs[0]; // put X into temp
    regs[0] = regs[1]; //put Y into X
    regs[1] = temp; // put temp into Y

}
//each value moves down the stack X moves to T
//    regs[2] = regs[3]; //put T[3] into Z[2] copinig val of t and changin z  //X
//    regs[1] = regs[2]; //put Z into Y    //Y
//    regs[0] = regs[1]; //put Y into X    //Z
//    regs[3] = regs[0]; //put  X into T   //T
double HPStack::roll()
{
        double x, y, z, t;

        //copying
        x = regs[0]; //1  y 2
        y = regs[1]; //2  z 3
        z = regs[2]; //3  t 4
        t = regs[3]; //4  x 1

        //changing down
        regs[0] = y; // put value of x into t
        regs[1] = z; //
        regs[2] = t;
        regs[3] = x;

}

double HPStack::enter()
{
    double x, y, z, t;

    //copying
    x = regs[0]; //1  4
    y = regs[1]; //2  3
    z = regs[2]; //3  2
    t = regs[3]; //4  1

    //changing
    regs[0] = x;
    regs[3] = z;
    regs[2] = y;
    regs[1] = x;

}
    /*
     T | 2 | 3 | 4
     Z | 3 | 4 | 2 | 2
     Y | 4 | 2 | 2 | 2
     X | 2 | 2 | 2 | 2

     */



//5 4 + 3 2 - /