package cp3.lab01;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Class to test the Dictionary class.
 * To test checkpoint 1 enter: 1, word-freq.txt, thisisadummyword
 * To test checkpoint 2 enter: 2, 30 test 23456
 * To test checkpoint 3 enter: 3, word-freq.txt, there more appertain orange I i aaaarrrrghh, there, aaaarrrrghh, 0 aaaarrrrghh 1222422
 * To test checkpoint 4 enter: 4, word-freq.txt, checkme.txt
 * To test checkpoint 5 enter: 5, word-freq.txt
 * To test checkpoint 6 enter: 6, word-freq.txt
 *
 * @author lewi0146
 */
public class DictionaryDriver {

    public static void main(String[] args) {

        Scanner sInput = new Scanner(System.in);
        String line = sInput.nextLine();
        String[] input = line.split(",");
        String testNumber = input[0];
        System.out.println("Performing Test: " + testNumber);


        switch (testNumber) {
            case "1":
                testcp1(input[1].trim(),input[2].trim());
                break;
            case "2":
                testcp2(input[1].trim());
                break;
            case "3":
                // DictionaryTest 3 word-freq.txt "there more appertain orange I i aaaarrrrghh" there aaaarrrrghh "0 aaaarrrrghh 1222422"
                testcp3(input[1].trim(),input[2].trim(),input[3].trim(),input[4].trim(),input[5].trim());
                break;
            case "4":
                testcp4(input[1].trim(), input[2].trim());
                break;
            case "5":
                testcp5(input[1].trim());
                break;
            case "6":
                testcp6(input[1].trim());
                break;
            default:
                System.out.println("invalid test number");
                break;

        }
    }

    private static void testcp1(String fileName, String word) {
        //Dictionary d = Dictionary.readInDictionary(fileName);
        Dictionary d = new Dictionary(); //checkpoint 1
        System.out.println(d.lookup(word));
    }

    private static void testcp2(String input)
    {

        DictionaryData data = new DictionaryData(input);
        System.out.println(data);
    }

    private static void testcp3(String fileName, String words, String removeWord, String newWord, String newWordData) {

        Dictionary d = Dictionary.readInDictionary(fileName);

        String[] keys = words.split(" ");

        // lookup each of the keys and print out what you find
        System.out.println("Testing contains...");
        for (String key : keys) {
            System.out.println(key + ": " +d.contains(key));
        }

        DictionaryData data = null;
        // lookup each of the keys and print out what you find
        System.out.println("Testing lookup...");
        for (String key : keys) {
            data = d.lookup(key);
            if (data != null) {
                System.out.println(data);
            } else {
                System.out.println(key + ": Not found");
            }
        }


        System.out.println("Testing remove...");
        // remove one of them
        d.remove(removeWord);

        // now do it again
        for (String key : keys) {
            data = d.lookup(key);
            if (data != null) {
                System.out.println(data);
            } else {
                System.out.println(key + ": Not found");
            }
        }

        System.out.println("Testing insert...");
        DictionaryData newD = new DictionaryData(newWordData);
        d.insert(newWord, newD);

        // now do it again
        for (String key : keys) {
            data = d.lookup(key);
            if (data != null) {
                System.out.println(data);
            } else {
                System.out.println(key + ": Not found");
            }
        }

    }

    private static void testcp4(String filename, String fileToCheck) {

        Dictionary d = Dictionary.readInDictionary(filename);

        System.out.println(d.spellCheck(fileToCheck));
    }

    private static void testcp5(String fileName) {

        Dictionary d = Dictionary.readInDictionary(fileName);

        // print out the first 20 words in alphabetical order
        DictionaryData data = null;
        List<DictionaryData> lA = d.alphabeticalList();
        if (lA != null) {
            Iterator<DictionaryData> itA = lA.iterator();
            for (int i = 0; i < 20; i++) {
                data = itA.next();
                System.out.println(data);
            }
        }
    }

    private static void testcp6(String fileName) {

        Dictionary d = Dictionary.readInDictionary(fileName);

        DictionaryData data = null;

        // print out the first 20 words in frequency order
        List<DictionaryData> lF = d.frequencyOrderedList();
        if (lF != null) {
            Iterator<DictionaryData> itF = lF.iterator();
            for (int i = 0; i < 20; i++) {
                data = itF.next();
                System.out.println(data);
            }
        }
    }


}
