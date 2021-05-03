# Lab 01 English Dictionary (Java Refresher)

## Task
Your task is to write a Java program that reads in words from a file (`word-freq.txt`) and uses the information in that file to create a simple English **dictionary** containing information about spelling and frequency of use of each word. The dictionary will then be used to spell-check any text file that the user specifies, and will provide output in the form of a list of words that are not in the dictionary. 

## Background
Computerized dictionaries of natural languages such as English or Japanese are a key component in software programs that perform word-based functions such as spell-checking or text prediction. These programs are found in mobile phones, word processing software, and even software development IDEs like NetBeans, Eclipse and IntelliJ. These dictionaries may also be consulted on-line, and can provide a wealth of information about words, including their spelling, meanings, and common usage. The dictionary in this practical task will be small in its scope, containing only information about spelling and frequency of use (in a specific database of text). However, your implementation should be designed so that it would be simple to extend the dictionary to incorporate additional kinds of information. 

## Details
Your task is to build upon a data structure called `Dictionary` that will hold dictionary information about a set of 7000 different English words, and which can be queried for that information by a user of your program – the user will specify a particular word, and your program should return the dictionary information (the dictionary *entry*) for that word. In this practical, the only word information we will deal with is how *frequently* the word occurs in English (or at least in one sample of English).

You have been provided with the skeleton of a Java IntelliJ project for this lab, in the form of the files `Dictionary.java`,  `DictionaryData.java` and `DictionaryDriver.java`. In this lab, you will complete the solution by implementing the dictionary data structure.  
  
You have also been provided with a text file `data/word-freq.txt`, which contains the most frequent 7000 words occurring in a collection of (mostly American) TV and movie scripts (such a collection of text is called a corpus). Details on the collection process can be found at:
  
<http://en.wiktionary.org/wiki/Wiktionary:Frequency_lists/TV/2006/explanation>
  
If you open the file with a text editor, you will see that (for the most part) the format of the data is pretty straightforward and uniform. Each line consists of three parts or fields separated by spaces, e.g. 
  
  ```
862 buddy 2743 
```
where the first field is a number representing the **rank** of the word in the list of 7000, the second field is the **word** itself, and the third field is the count of the number of times that the word has occurred in the corpus, or its **frequency**. 

Your task will involve reading data from this text file, and for each line, adding an entry to the dictionary containing the word’s **spelling** and **frequency** only (rank is not required but could be stored as well).  
  
  If you scroll through the file manually, you may notice instances where the format is not strictly adhered to. You may want to examine these cases and decide what to do about them (both in terms of writing code and in terms of what implications they have for how to treat some specific words). 
  
  You may use any standard classes available in the Java 8 JDK (although code will be tested against JDK 13), including the Collections Framework, and you may write as many of your own classes as needed. **However, do not modify or change the location of the `DictionaryDriver` class as this is used for testing your checkpoint submission.**
  
  The following are some functions that we might expect of a computerized dictionary: 
  * `lookup` looking up the dictionary entry for a particular word (i.e. finding the pronunciation, meaning, usage frequency, etc.) 
  * `insert` extending the dictionary by adding new words 
  * `remove` delete dictionary entries 
  * `contains` check to see whether a word is in the dictionary or not (returns true/false) 
  * `alphabeticalList` listing the words in the dictionary by alphabetical order 
  * `frequencyOrderedList` listing the words in the dictionary by ascending order of frequency (those of the same frequency should be then ordered in reverse alphabetical order)
  * `spellcheck` read in a file and list all the words not found in the dictionary 

Your aim should be to write a dictionary that can easily be extended to contain extra information about each word, in addition to its frequency of occurrence. For this reason, you need to separate away the class that contains the dictionary entry data from the class that represents the dictionary itself. This is the reason why the skeleton code contains two classes: `DictionaryData` for the entry data, and `Dictionary` for the dictionary. 

Inside `Dictionary.java`, there is a data structure named `dictionaryMap`, which is the main data structure that you should use to implement the dictionary manipulation functions listed in the bullet points above. The skeleton code already provides you with the information that the data structure implements the `Map` interface, but does not provide an instantiation (this is done in the `Dictionary()` constructor, which has been left for you to choose an appropriate  implementation, a `HashMap` or a `TreeMap`). 

The idea is that we map a key (in the form of an English word) onto the data object that represents the dictionary entry for that word. In this way, all the information about the specific dictionary entry is encapsulated in the `DictionaryData` object, which can later be extended to store new kinds of information about a word such as its meaning or pronunciation without affecting the way that `Dictionary` works. 
 
There are many ways to solve the same problem. The important thing is to think through your solution before coding, selecting data structures in terms of what they can do. For instance, you need to consider which implementation for the dictionaryMap data structure you will choose. You should choose one of the classes in the Java Collections Framework, and you can simply complete the line in the constructor by replacing the ``null`` by an appropriate instance of a class from the Collections Framework. However, you do need to justify your choice of class by comparing the good and bad points of the different ``Map`` implementations. In particular, you need to pay attention to how complex the basic operations listed above would be (for a developer, as well as in terms of efficiency) if you made use of each of the different ``Map`` implementations that Java provides.

## Checkpoints
Note: these checkpoints are shown in a *recommended* order, but you may find it easier to do them in a more haphazard order, going back and forth between checkpoints and modifying your code whenever things do not work out, until you finally have all the checkpoints completed at once. The order of completion is up to you. 

**Checkpoints are automatically assessed using a FLO Quiz and a version control system.  Please refer FLO for more details on how to submit your solutions using the FLO Quiz system.**

### Checkpoint 1
The starting project should have the following files of interest
* [Dictionary/src/cp3/lab01/Dictionary.java](src/cp3/lab01/Dictionary.java)
* [Dictionary/src/cp3/lab01/DictionaryData.java](src/cp3/lab01/DictionaryData.java)
* [Dictionary/src/cp3/lab01/DictionaryDriver.java](src/cp3/lab01/DictionaryDriver.java)
* [Dictionary/data/word-freq.txt](data/word-freq.txt)

Once the project is open, check to make sure that it has been compiled and that there are no compilation errors. Compilation errors will be indicated by red underline against the offending projects, packages and classes in Project window.

Open up the files `Dictionary.java` and `DictionaryData.java` from the Project Explorer, and examine the code (you may need to expand the `src` folder). Notice that all the methods of Dictionary mentioned above have been provided in the code, but without sensible implementations (instead they are *stubs* that merely print to the screen that they have not yet been implemented). Locate the main method in `DictionaryDriver.java`, and try to work out what it does. 

Run `DictionaryDriver` class by, for example, right-clicking on the source code pane and selecting either  `Run: 'DictionaryDriver'` `Run: 'DictionaryDriver.main()'`.  The Run Window should appear in the IntelliJ window and wait for user input.  Enter the following:
```
1, word-freq.txt, thisisadummyword
```
and it should display an exception message reporting a `NullPointerException`. For example,

```
1, word-freq.txt, thisisadummyword
Performing Test: 1
Exception in thread "main" java.lang.NullPointerException
	at cp3.lab01.DictionaryDriver.testcp1(DictionaryDriver.java:58)
	at cp3.lab01.DictionaryDriver.main(DictionaryDriver.java:31)

Process finished with exit code 1
```

Locate the source of the exception using the information that IntelliJ gives you (hint: you can click on any blue underlined text that refers to a line number in a particular source file). The exception was thrown because the main method was attempting to make use of a `Dictionary` object which had been assigned to `null`.  

This is an excellent example of where the reported error and the actual line of code that caused the error are not co-located!  The source of the error is located in the method `readInDictionary()`. Change the implementation of the static method `readInDictionary()` to make the exception go away. In the first line of this method, we are creating a new `Dictionary` reference `d` and initializing it to `null`, and in the last line of this method, we are returning `d`.  Simply change the first line so that we return a proper instance of the `Dictionary` class, by replacing the line with:
```jshelllanguage
Dictionary d = new Dictionary(); 
```
Run the program again, and check that the exception is no longer being thrown. See the examples at the end of this document for expected out.

**Commit your changes to the repository and take note of the revision number.  Go to the Lab01 Quiz on FLO and submit your revision number for Checkpoint 1.**

### Checkpoint 2

Begin the implementation of `DictionaryData` by deciding which fields from the `word-freq.txt` to store in the class, and coding the appropriate setter and getter methods for these fields.  

*Hint: Instead of typing too much, see if you can find a labour-saving way of creating setters and getters in IntelliJ.* 

Create a constructor that takes a single `String` and parses it to construct a `DictionaryData` object with fields set correctly.  Ensure that the word that you store is in the same case as contained in the line that has been parsed (e.g. do not convert the word "I" to a lower case "i").

Implement the `toString()` method so that it returns a `String` that describes the contents of the dictionary entry – the string should contain the word as well as any data stored in the `DictionaryData` object. (There is a format, commented out in the `toString()` method).

**Commit your changes to the repository and take note of the revision number.  Go to the Lab01 Quiz on FLO and submit your revision number for Checkpoint 2.**

### Checkpoint 3

In the `Dictionary` class Make the implementation of `dictionaryMap` concrete by choosing a particular class from the Java Collections Framework to use in the `Dictionary()` constructor, and calling its constructor appropriately. 

Implement the `insert()`, `lookup()`, `contains()` and `remove()` methods of the `Dictionary` class. These methods should work regardless of whether the search word contains lower or upper case letters, i.e. calls to `d.lookup("Frank")` and `d.lookup("frank")` should return the same entry. 

Complete the functionality of the static method `readInDictionary()` which reads in the dictionary from the supplied file name (e.g. `word-freq.txt`). This method creates a new instance of `Dictionary` (you already did this in Checkpoint 1), opens the file, and reads through it line by line. As it reads each line, `readInDictionary()` it creates a new instance of `DictionaryData`, that stores the information from the current line into the `DictionaryData`.

You should also modify `readInDictionary()` so that it stores the data object in the `dictionaryMap` using the `insert()` method you completed in above. 

**Commit your changes to the repository and take note of the revision number.  Go to the Lab01 Quiz on FLO and submit your revision number for Checkpoint 3.**

### Checkpoint 4

Implement `spellcheck()`. The method should read in a text file specified by its filename (e.g. `data/checkme.txt`) , and go through each of the words in the file, checking to see if the word is in the dictionary. If it is not, the word should be added to a list. This list is returned when the method completes. You can use any standard implementation of List, e.g. `ArrayList` or `LinkedList`. 

*Hint: follow the pattern used in `readInDictionary()` to read from a file.*

**Commit your changes to the repository and take note of the revision number.  Go to the Lab01 Quiz on FLO and submit your revision number for Checkpoint 4.**


### Checkpoint 5

Implement `alphabeticalList().`  Think about your choice of data structure can influence your implementation of this method.  What are the benefits and drawbacks?

**Commit your changes to the repository and take note of the revision number.  Go to the Lab01 Quiz on FLO and submit your revision number for Checkpoint 5.**


### Checkpoint 6

Implement `frequencyOrderedList()`. Did you choices in Checkpoint 5 affect how you accomplished Checkpoint 6?  Try to resist the temptation of changing the implementation of the dictionary between checkpoints 5 and 6.

**Commit your changes to the repository and take note of the revision number.  Go to the Lab01 Quiz on FLO and submit your revision number for Checkpoint 6.**

## Example Input and Output for the Checkpoint Levels 
The phrase `<-- user input` at the end of a line indicates the user input (excluding the phrase `<-- user input`)
### Checkpoint 1

```
java cp3.lab01.DictionaryDriver
1, word-freq.txt, thisisadummyword  <-- user input
Performing Test: 1
null
```

### Checkpoint 2
```
java cp3.lab01.DictionaryDriver 
2, 30 test 23456  <-- user input
Performing Test: 2
test: frequency = 23456
```
### Checkpoint 3
```
java cp3.lab01.DictionaryDriver
3, word-freq.txt, there more appertain orange I i aaaarrrrghh, there, aaaarrrrghh, 0 aaaarrrrghh 1222422  <-- user input
Performing Test: 3
Testing contains...
there: true
more: true
appertain: false
orange: true
I: true
i: true
aaaarrrrghh: false
Testing lookup...
there: frequency = 85662
more: frequency = 40239
appertain: Not found
orange: frequency = 518
I: frequency = 1052546
I: frequency = 1052546
aaaarrrrghh: Not found
Testing remove...
there: Not found
more: frequency = 40239
appertain: Not found
orange: frequency = 518
I: frequency = 1052546
I: frequency = 1052546
aaaarrrrghh: Not found
Testing insert...
there: Not found
more: frequency = 40239
appertain: Not found
orange: frequency = 518
I: frequency = 1052546
I: frequency = 1052546
aaaarrrrghh: frequency = 1222422
```

### Checkpoint 4 
```
java cp3.lab01.DictionaryDriver
4, word-freq.txt, checkme.txt  <-- user input
Performing Test: 4
[Well,, Prince,, Lucca, estates, Buonapartes., you,, war,, infamies, horrors, perpetrated, Antichrist-, Antichrist-, friend,, 'faithful, slave,', yourself!, do?, you-, news., July,, 1805,, well-known, Pavlovna, Scherer,, Empress, Marya, Fedorovna., greeted, Vasili, Kuragin,, importance,, reception., Pavlovna, days., was,, said,, grippe;, grippe, St., Petersburg,, elite.]
```


### Checkpoint 5
```
java cp3.lab01.DictionaryDriver
5, word-freq.txt  <-- user input
Performing Test: 5
a: frequency = 563578
aaah: frequency = 167
aah: frequency = 844
aaron: frequency = 1908
aaron's: frequency = 171
abandon: frequency = 244
abandoned: frequency = 440
abbott: frequency = 610
abby: frequency = 826
abby's: frequency = 147
abe: frequency = 699
abigail: frequency = 1515
abigail's: frequency = 143
ability: frequency = 418
able: frequency = 6289
aboard: frequency = 286
abortion: frequency = 156
about: frequency = 142750
above: frequency = 951
absence: frequency = 181
```
### Checkpoint 6
``` 
java cp3.lab01.DictionaryDriver
6, word-freq.txt   <-- user input
Performing Test: 6
vegetables: frequency = 139
trapper: frequency = 139
swinging: frequency = 139
sum: frequency = 139
spark: frequency = 139
ruled: frequency = 139
trish: frequency = 140
trashed: frequency = 140
tournament: frequency = 140
throne: frequency = 140
teresa: frequency = 140
slick: frequency = 140
sausage: frequency = 140
raining: frequency = 140
prices: frequency = 140
pasta: frequency = 140
paloma: frequency = 140
needles: frequency = 140
leaning: frequency = 140
leaders: frequency = 140
```