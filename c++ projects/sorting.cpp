#include <cstdlib>
#include <getopt.h>
#include <iostream>
#include <string>

using namespace std;

static long comparisons = 0;
static long swaps = 0;

void swap(int* a, int* b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
    swaps++;
}

void selectionSort(int* first, int* last) //item 0; last end of arr, 10 last ->9
{
    for (int* i = first; i < last -1; ++i ){
        int* min = i;
        for (int* j = i + 1; j <= last; ++j){
            if (*j < *min)  //items is not given, swap()?
                min = j;                //comparison
            comparisons++;
        }
        swap (min, i);   //swap

    }
}

void insertionSort(int* first, int* last)
{
    for (int* i = first + 1; i < last; ++i){ //int* i: creating a pointer i for type int
        int* j;
        for (j = i; j > first; --j){ //def j - 1, pos before j
            if(*j < *(j-1)){
                swap(j,j-1);
            }
             //shifting j to right
            comparisons++;
        }
    }
//    2 graphs comp
//
//    ia for 1000, 200 , 1000, 50000, 1000,
//    ir "
//    1000elemtne divded by 10,000
//    2 for swaps
//multiples lines on one graph
}

int* partition(int* first, int* last){
    //rand() % (last - first);
//    int* rand_pivot = first + (rand() % (last - first)); //first ele in start of the arr and add to that
//    swap(rand_pivot, (last-1)); //somewhere in the middle


    int* pivot = last -1; //pivot in middle in good if sorted
    int* i = first;
    int* j = last -1;
    for(;;)
    {
        while (*i < *pivot && i < last){
            ++i;
            comparisons++;
        }
        while (*j >= *pivot && j > first){
            --j;
            comparisons++;
        }
        comparisons++;
        if (i >= j) {
            comparisons++;
            break;
        }

        swap (i,j);
    }
    swap(last-1,i);
    return i;

}

void quickSort(int* first, int* last)
{
    if (last - first <=1)
        return;
    int* pivot = partition(first,last); //shld return pointer
    quickSort(first,pivot);
    quickSort(pivot+1,last);
}



//remember for int* A:
//A - The pointer itself
//        *A - The value at position A, int * t= mem add,
//        &A - The address that A is pointing to


//1. count no of compansions and swaps
int main(int argc, char** argv)
{
    string algorithm = "selection";
    string dataset = "random";

    for (int c; (c = getopt(argc, argv, "ravqsin")) != -1;) {
        switch (c) {
        case 'r':
            dataset = "random";
            break;
        case 'a':
            dataset = "sorted";
            break;
        case 'v':
            dataset = "reverse";
            break;
        case 'q':
            algorithm = "quicksort";
            break;
        case 's':
            algorithm = "selection";
            break;
        case 'i':
            algorithm = "insertion";
            break;
        case 'n':
            algorithm = "none";
            break;
        }
    }
    argc -= optind;
    argv += optind;

    const int size = argc > 0 ? atoi(argv[0]) : 10000;
    int* data = new int[size];

    if (dataset == "sorted") {
        for (int i = 0; i < size; ++i) {
            data[i] = i;
        }
    }
    else if (dataset == "reverse") {
        for (int i = 0; i < size; ++i) {
            data[i] = size - i - 1;
        }
    }
    else if (dataset == "random") {
        for (int i = 0; i < size; ++i) {
            data[i] = rand() % size;
        }
    }

    if (algorithm == "quicksort") {
        quickSort(data, data + size);
    }
    else if (algorithm == "selection") {
        selectionSort(data, data + size);
    }
    else if (algorithm == "insertion") {
        insertionSort(data, data + size);
    }

    for (int i = 1; i < size; i++) {
        if (data[i] < data[i - 1]) {
            cout << "Oops!" << '\n';
            exit(1);
        }
    }

    cout << "OK" << '\n';
    cout << "Algorithm:   " << algorithm << '\n';
    cout << "Data set:    " << dataset << '\n';
    cout << "Size:        " << size << '\n';
     //Uncomment for level 3 and 4
     cout << "Comparisons: " << comparisons << '\n';
     cout << "Swaps:       " << swaps << '\n';
    return 0;
}
