////
//// Created by Aishwarya on 7/5/20.
////

#ifndef WORDS_MYVECTOR_H
#define WORDS_MYVECTOR_H

template <class T>
class MyVector {
public:
    typedef T* iterator; // creates an alias of the T* type called iterator
    MyVector();
    iterator begin(); //method called begin, does take arg, type iterator iterator point to element in items
    iterator end(); //point to 1000 element items
    int size();
    iterator insert(iterator position, const T& item);
    iterator resize();
private:
    T items[1000]; //make pt to items , chnage pt to point to new arr
    int used; // how many spaces used in the items arr
};


template <class T>
MyVector<T>::MyVector()
{
     used = 0;

}
//className::MethodName
template <class T>
T* MyVector<T>::begin()//pointer it to the first elemnt in items arr
//items just by self is the pointeer to the strt of the arr
{
    return items; //very first pointer in arr
}

template <class T>
T* MyVector<T>::end()
{
    return items + used; // used is int, increment by used //point it to the first elemnt + 1 in arr
//iterator + int = move that many along
}

template <class T>
int MyVector<T>::size(){ //whatever is being return by the method
    return used;
}

template <class T>
T* MyVector<T>::insert(iterator position, const T& item) { //const string, pointer to pos
    //items[position] = 0; //incremnt by 1
    iterator it;
    for (it = end();it>position;it--) { //at it = item
        *it = *(it - 1);
    }
    *it = item;
    used++; //size of vect
    return it;


}
template <class T>
T* MyVector<T>::resize(){
    take current return new arr
}

//empty arr
//beign 1st elemtn
//end plus +

#endif //WORDS_MYVECTOR_H
