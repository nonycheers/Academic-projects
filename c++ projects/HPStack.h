//
// Created by Aishwarya on 27/4/20.
//

#ifndef HP35_HPSTACK_H
#define HP35_HPSTACK_H

//define methods/fun

class HPStack { //class

public: //access specifer when is public main() can use it /public: methods can be used outside the class
    HPStack(){
    regs[0] = 0; // X
    regs[1] = 0; // Y
    regs[2] = 0; // Z
    regs[3] = 0; // T
} //default construtor with no parameters
    void push(double value); //storing val, thats val - function push void that doesn't return val
    double pop(); //x gets popped down level
    double peek(); //val of x
    double swap();
    double roll();
    double enter();

private:
    double regs[4];

};

#endif //HP35_HPSTACK_H











//an obj is how u access the stuff inside of your class
//written in main()
//creating an obj, same as var, name of the class obj name; ex: HPStack stackobj;
//                                                              stackobj.push();
// in oder to use the fun in class , we need to make an obj in main to use that fun in class :)



