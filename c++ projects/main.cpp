#include <iostream>
#include <string>
using namespace std;

//int x = 3;
//int foo(int *p)
//{
//    *p += 1;
//    return x + *p;
//}
int main() {
//
//    cout << foo(&x) << endl;


//int a1[5] = {0,1,2,3,4};
//int a2[5] = {10,11,12,13,14};
//
//a2 = a1[];
//cout << a2[3] <<endl;


//int a[4] = { 1, 2, 3, 4 };
//int *p = a;
//int n = (*(p+1))++;
//cout << n << endl;

class X
{
public:
    X(int i)
    {
        this->i = i + 1;
        cout << i << endl;
    }
    int i ;
};

class Y : public X{
public:
    Y():X(10)
    {
        cout << i << endl;
    }
};

//int a[] = { 1, 2, 3, 4 };
//cout << 2[a] << endl;
//    class Parent
//    {
//    public:
//        virtual void m(bool again) {
//            cout << "p";
//            if (again)
//                m(false);
//        }
//    };
//
//    class Child : public Parent {
//        virtual void m(bool again){
//            cout << "c";
//            if (again)
//                Parent::m(true);
//        }
//    };
//
//
//    Parent *x1 = new Child();
//    Parent *x2 = new Parent();
//
//    x1->m(true);
//    cout << ":"; //make m public for -> to work
//    x2->m(true);
//    cout << ":";

//    class A
//    {
//    public:
//        virtual string m() { return "A"; }
//    };
//
//    class B : public A
//    {
//        virtual string m() { return "B"; }
//    };
//
//    class C : public A
//    {
//        virtual string m() { return "C"; }
//    };
//
//    class D : public C
//    {
//        virtual string m() { return "D"; }
//    };
//
//    A *a = new B();
//    C *c = new D();
//    a = c;
//    cout << a->m() << endl; //make m public for -> to work

//    string name;
//    cout << "Hello, " << name << endl;
//    getline(cin,name);
//
//    if (!cin) {
//        cout << "Hello, CP2" << endl;
//    }
//    return 0;


}
