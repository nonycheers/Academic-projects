/**
 * Computer Programming 2 (COMP2711, COMP8801)
 * Practical 4: Words
 */

#include <iostream>
#include <string>
#include <unistd.h>
#include <vector>
#include "MyVector.h"
//STL - std tem lib
using namespace std;

struct WordInfo{ //mini class
public:
    string word; //words text
    int count = 1; //no of times word haas been seen

};

int main(int argc, char** argv)
{
    enum {
        total,
        unique,
        individual
    } mode = total;

    for (int c; (c = getopt(argc, argv, "tui")) != -1;) {
        switch (c) {
        case 't':
            mode = total;
            break;
        case 'u':
            mode = unique;
            break;
            case 'i':
                mode = individual;
                break;


        }
    }

    argc -= optind;
    argv += optind;

    MyVector<WordInfo> text;//holds wordinfo objects, //vvector becomes myvetor //text(10) can be initialised here, to store 10 elements/spaces
    string s;
    int count = 0;
    while (cin >> s)
    {
        count += 1;
        bool found = false;

        for (MyVector<WordInfo>::iterator it = text.begin(); it != text.end(); it++) //end before begin
        {
            if (s == it->word) { //*it get access to that elements by deferecing it
                // it = text.end();
                it->count++;
                found = true;
                break;
            }
        }
        if (!found){
            WordInfo w; //we are using wordinfo here, we just defined it by w;
            w.word = s;//word is empty = string in vector
            MyVector<WordInfo>::iterator it = text.begin(); //declare it, after for ended (while loop advaces where word is < s
            while (it != text.end())
            {
                if (s < it->word)
                {
                    break;
                }
                it++;
            }  //end before begin
            text.insert(it,w); //previous (text.push_back(s)); //it points to wordinfo
        }
    }

    switch (mode) {
        case total:
            cout << "Total: " << count << '\n';
            break;
        case unique:
            cout << "Unique: " << text.size() << '\n'; //unqiue: no of elements, no the elements
            break;
        case individual:

            for (MyVector<WordInfo>::iterator it = text.begin(); it != text.end(); it++) //end before begin
            {
                cout << it->word <<": " << it->count << '\n';
                 //it->word gets the text
                it->count++; // it->count gets the count for that word


            }

            break;
    }
    const int countt = argc > 1 ? atoi(argv[1]) : 1000;
    vector<char>store;

    for(int i = 0; i < countt; ++i){
        store.insert (store.begin(),'B');
    }
    for(int i = 0; i < countt; i++){
        store.erase(store.begin());
    }
    return 0;
}


////vector: defualt arr size to 1000
//used: how many of those elements are used


//    1. declare a vector
    //vector of characters

//    2. logic check : arr of string, add words to str, before adding string check to c if the word already existss, if so dont add
//inseting words and vector , cin breaks words by space
//            cout << *it; //dereferring making the var was to originally string
//    boolean found = false;
//
//    14:17
//    if(newValue == *it)

        //havent found = boolean false
    //if(newValue == *it) found to true , *teration to text.end
    //after loop, check, if found is false, inert new value

    //if text already cantins s do noting, otherwise interst and increament count by 1
   // text.insert(text.end(),s);

//    3. iterator : //c++ stl vector class
    //algormiton, methods that you can use on data structures




//reading words, counting words, creating own vector class for
//the second part (simliar operations as the built-in vector class), level1: count no of unique words