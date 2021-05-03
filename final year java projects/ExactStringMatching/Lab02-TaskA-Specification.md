# Lab02, Task A: Online String Matching 

**Note:** Each checkpoint in this Lab (including Checkpoint 7) is probably more substantial than any of the checkpoints in Lab01, so don’t be discouraged if it takes you longer than you expect to complete them! Feel free to ask for help or discuss implementation ideas with the demonstrator. 

## The Task
The task in the lab is to implement online string matching algorithms and compare the running time and number of comparisons.  

The repository contains an IntelliJ Project that contains code to load a file with the target string, [`ExactStringMatchingDriver`](src/cp3/lab02/ExactStringMatchingDriver.java), and an intended class structure for the online algorithms via an abstract class [`StringMatcher`](src/cp3/lab02/StringMatcher.java), which has the abstract methods
- `void setTarget(String target)` – sets the target to search within
- `void setPattern(String pattern)` – sets the pattern to search for  
- `int match()` – searches for the pattern in target, returns the index of the first match or -1 if there is no match
- `int getNumberOfSteps()` – returns the number of steps performed during a match

Your task is to extend the abstract `StringMatcher` class and override these methods to implement the online string matching algorithms.  `StringMatcher` contains other methods that times the execution of the setTarget, setPattern and match methods (`*timed()`).  These timing methods are called from `ExactStringMatchingDriver` class to perform the searching.

You are also provided with a sample implementation of `StringMatcher` called [`StringMatcherBuiltin`](src/cp3/lab02/StringMatcherBuiltin.java) that uses the `String` class method `indexOf`.  Examine its contents to see how the above methods should be implemented.

The first line of standard input specifies a command. The first command argument specifies the name of the file that contains the text to search, the target string. The [`repaper.txt`](data/repaper.txt) file contains the target from the tutorials and you can attempt to search for **REPAPER**.  

The second command argument specifies the algorithm to use, by default this is "builtin" and uses the `StringMatcherBuiltin` class.  The switch statement takes this parameter and instantiates the corresponding class that represents an implementation of an algorithm: builtin, bruteforce, bm, or kmp.  It is your job to implement bruteforce (ch7), bm (ch8), and kmp (ch9).

For example, run the `ExactStringMatchingDriver` class to use the builtin string matching and enter `REPAPER` as the pattern (user input indicated with `<-- user input`):

```
java –jar ExactStringMatchingDriver 
Enter command: repaper.txt, builtin, verbose <-- user input
Enter search term: REPAPER <-- user input
index: 34, comp: -1, Target: 0.004346ms, Pattern: 0.004345ms, Match: 0.010271ms, 
Total: 0.018962ms
Enter search term: REPAPER
index: 34, comp: -1, Target: 0.004346ms, Pattern: 3.95E-4ms, Match: 0.002766ms, 
Total: 0.007507ms
Enter search term: <-- user input


```

The program terminates when an empty line is entered.

**Note** that the runtime will be different on your own machine and that the first search time maybe inaccurate (or at least longer).  

**Note** that the number of comparisons is -1 as the builtin implementation is a blackbox.  **For your implementation you should provide the number of character comparisons made by the algorithm.**

There are a number of other target text files in the data directory that should be familiar from the lectures and  you can evaluate the runtime and number of comparisons on those files as well. There are a number of other target text files on FLO that you can could download and evaluate the runtime and number of comparisons.  But try not to commit to the repository as some of the files large.

## Checkpoints

### Checkpoint 7 - Brute Force
The task for Checkpoint 7 is to implement your own version of the brute force algorithm and compare it to the builtin `indexOf` of the Java `String` class. Create a new class that extends the `StringMatcher` and overrides the required methods to implement the brute force algorithm.  

You should instantiate your new class for the `"bruteforce"` case of the algorithm switch statement, for example, you should change
```java
case "bruteforce": 
    matcher = null; // TODO: Checkpoint 7
    break;
```
to
```java
case "bruteforce": 
    matcher = StringMatcherBruteForce(); // Checkpoint 7
    break;
```
For reference, the brute force text search algorithm:
```
T = target search string
P = pattern to search for
n = length of T
m = length of P

for ( int  i = 0;  i <=  n – m ;  i++ ) {
      int  j = 0 ;
      while ( ( j < m ) && ( T[ i + j ]  ==  P[ j ] ) ) {
             j++;
      }
      if ( j == m ) {
            return  i;
      }
}
return -1;
```
Show your demonstrator the implementation of the brute force algorithm and your comparison between it and the `StringMatcherBuiltin`.  Your comparison should include it finding **REPAPER** in the `repaper.txt` file (which should have 55 steps) and comparison to a larger target text (e.g. `dickens.txt` or `chromosome4.txt`).  It should compare both short and long patterns and also patterns that do not exist.  

**Can you beat the Java builtin string comparison!!!??**

***
*Commit your changes to the repository and take note of the revision number.  Go to the Lab02 Quiz on FLO and submit your revision number for Checkpoint 7.*
***

### Checkpoint 8 – Better String Matching with Boyer-Moore

Implement the **Boyer-Moore** algorithm as discussed in lectures.  You should attempt to implement the algorithm yourself, but you are allowed use the wonders of the Internet as a resource (and the lecture slides, there is pseudo code there).  However, please do include the reference to the source of your implementation and it must conform to the implementation above and include the number of character comparisons.

Show your demonstrator the implementation of your chosen algorithm and your comparison between it and the `StringMatcherBuiltin` and your implementation of the brute force algorithm. Your comparison should include it finding **REPAPER** in the `repaper.txt` file and comparison to a larger target text (e.g. `dickens.txt` or `chromosome4.txt`, see FLO).  It should compare both short and long patterns and also patterns that do not exist.  Can you *construct* a pattern that ensures the BM algorithm is faster?

**Can you beat the Java builtin string comparison!!!??**

***
*Commit your changes to the repository and take note of the revision number.  Go to the Lab02 Quiz on FLO and submit your revision number for Checkpoint 8.*
***

### Checkpoint 9 – Better String Matching with KMP
Implement the **Knuth-Morris-Pratt** algorithm as discussed in lectures.  You should attempt to implement the algorithm yourself, but you are allowed use the wonders of the Internet as a resource (and the lecture slides).  However, please do include the reference to the source of your implementation and it must conform to the implementation above and include the number of comparisons.  

**There are variants of the KMP algorithm so be sure to implement the lookup table as described in the lectures to get the correct number of comparisons.**

Show your demonstrator the implementation of your KMP algorithm and your comparison between it and the StringMatcherBuiltin and your implementation of the brute force algorithm. Your comparison should include it finding **REPAPER** in the `repaper.txt` file and comparison to a larger target text (e.g. `dickens.txt` or `chromosome4.txt`, see FLO).  It should compare both short and long patterns and also patterns that do not exist.

**Can you beat the Java builtin string comparison!!!??**

***
*Commit your changes to the repository and take note of the revision number.  Go to the Lab02 Quiz on FLO and submit your revision number for Checkpoint 9.*
***