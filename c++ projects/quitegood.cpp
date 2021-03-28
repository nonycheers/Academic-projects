/**
 * Computer Programming 2 (COMP2711, COMP8801)
 * Practical 1: Quite Good Numbers
 */

#include <iostream>
#include <cstdlib>

using namespace std;

// start with 2
// if a factor, sum all the factors and return result


int main(int argc, char *argv[]) {
    int const limit = argc > 1 ? atoi(argv[1]) : 10000; //limit = 10000
    int const badness = argc > 2 ? atoi(argv[2]) : 0; // program argument limit=1000000
    int i, sum; // n is any number from 2-10000
    int count = 0;
    for (int n = 2; n < limit; n++) { //loop for the nums below 10000
        sum = 1; // sum starts at index 1 becos at index 0 is n at 1 , but n starts at 2

        //for (i = 2; (i * i <= n || i*i == n); i++) { //loop for n' factors (i to repeat loop for all nums below 10000)


        for (i = 2; i * i <= n; i++) { //i++ to count

            if (n % i == 0){ // if n is divisible by i (any num at index also from 2-10000) its a fac

                if (i == n/i)
                   sum = sum + i;
               else
                sum = sum + i + n/i ; // if n is divisible ==0 , add val at i to sum
            }
        }
        //if (sum == n) {// level 1
            if ((n -sum >=0 && n-sum <=-badness) || (sum - n>=0 && sum-n <=-badness)) {
       count++; // per no increment count
        }
//            cout << sum << " "
//        if (n - sum >= 0 && n - sum <= badness || sum - n >= 0 && sum - n <= badness) { //level 2
//          cout << n << " ";
// diff of 3
        if (badness < 0 ) //badness -1 less than 0 , print count. 0 or higher print iteslf
        {
        }
        else if ((n -sum >=0 && n-sum <=badness) || (sum - n>=0 && sum-n <=badness)) { //level 3
            cout << n << " ";
        }

    } if (badness < 0 )
        cout << count << " ";
}