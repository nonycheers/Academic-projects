package cp3.lab01;

import java.io.*;
import java.util.*;

/**
 *
 * @author lewi0146
 */
public class Dictionary {

    private Map<String, DictionaryData> dictionaryMap = null;

    public Dictionary() {

        dictionaryMap = new TreeMap<String, DictionaryData>();
    }

    /**
     * Extends this dictionary by adding the new word
     * identified with <code>word</code> and the data <code>data</code>.
     * @param word the word to add to the <code>Dictionary</code>.
     * @param data the data about the word s
     */
    public void insert(String word, DictionaryData data) {

        dictionaryMap.put(word.toUpperCase(),data);
    }

    /**
     * Removes the word identified by <code>word</code> from this Dictionary.
     * @param word the word to remove to the <code>Dictionary</code>.
     * @return
     */
    public DictionaryData remove(String word) {

        DictionaryData data = dictionaryMap.get(word.toUpperCase());
        dictionaryMap.remove(word.toUpperCase());

        return data;
    }

    /**
     * Look up the dictionary entry for a particular word
     *
     * @param word the particular word to look up.
     * @return the data associated with the word identified by <code>word</code>.
     */
    public DictionaryData lookup(String word) {

        return dictionaryMap.get(word.toUpperCase());
    }

    /**
     * Check to see whether a word is in the dictionary or not (returns true/false)
     * @param word the word to check
     * @return <code>true</code> if in this <code>Dictionary</code>, <code>false</code> otherwise.
     */


    public boolean contains(String word) {

        return dictionaryMap.containsKey(word.toUpperCase());

    }

    /**
     * Builder method for the <code>Dictionary</code> class that builds
     * a dictionary from the given file name.
     * It is expected that each entry is on a seperate line in the form
     * <pre>
     *     862 buddy 2743
     * </pre>
     * where 862 is the rank, buddy is the word, and 2743 is the frequency.
     *
     * @param fileName the file to load the dictionary data from
     * @return the created <code>Dictionary</code> or <code>null</code> on error.
     */
    public static Dictionary readInDictionary(String fileName) {
        Dictionary d = new Dictionary();
        Scanner fileScanner;

        try {
            // use a FileInputStream to ensure correct reading end-of-file
            fileScanner = new Scanner(new FileInputStream("data" + File.separator +fileName));

            while (fileScanner.hasNextLine()) {
                String nextLine = fileScanner.nextLine();
                // System.out.println("nextLine: " + nextLine); uncomment if you want to see what is read in
                DictionaryData data = new DictionaryData(nextLine);

                // TODO: call insert() here to insert the data object into the dictionary!
                d.insert(data.word.toUpperCase(),data);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("could not find the file " +fileName+ "in the data directory!");
            return null;
        }

        return d;
    }

    /**
     * Read in a file and list all the words not found in this dictionary.
     * @param fileName the file to read and check.
     * @return List of words not found in this <code>Dictionary</code>.
     */
    public List<String> spellCheck(String fileName) {
        List<String> list = new LinkedList<String>();

        Scanner fileScanner;

        try {
            // use a FileInputStream to ensure correct reading end-of-file
            fileScanner = new Scanner(new FileInputStream("data" + File.separator +fileName));

            while (fileScanner.hasNextLine()) {
                String nextLine = fileScanner.nextLine();
                // System.out.println("nextLine: " + nextLine); uncomment if you want to see what is read in
                String [] words = nextLine.split(" ");

                for(int i = 0; i < words.length; i++)
                {
                    if(words[i].length() > 0 && !contains(words[i]))
                    {
                        list.add(words[i]);
                    }
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("could not find the file " +fileName+ "in the data directory!");
            return null;
        }

        return list;
    }

    /**
     * Creates a list of the words in this dictionary by alphabetical order.
     * @return the list of alphabetical sorted dictionary words.
     */
    public List<DictionaryData> alphabeticalList() {
        //System.out.println("Checkpoint 5: alphabeticalList() not implemented yet");
        //using the java collection set
        //wordlist here is the collection containing elements to be added to this set values
        Collection<DictionaryData> wordlist = dictionaryMap.values();
        //return list of words as an arrarylist using the same format as above
        return new ArrayList<DictionaryData>(wordlist);

        //return null;
    }

    /**
     * Creates a list of the words in this dictionary by ascending order of
     * frequency (those of the same frequency should be
     * then ordered in reverse alphabetical order).
     * @return the list of frequency sorted dictionary words.
     */
    //we want to compare dictdata words with same freq to dictdata words then reorder them in ascending order
    //using compare method of the boolean class

    public static boolean compare_dictdata(DictionaryData i, DictionaryData j)
    {
        if( i.frequency == j.frequency)
        {
            return j.word.compareTo(i.word) < 0; // i < j
        }
        return i.frequency < j.frequency;

    }
    public List<DictionaryData> frequencyOrderedList() {
        //System.out.println("Checkpoint 6: frequencyOrderedList() not implemented yet");
        List<DictionaryData> wordlist = alphabeticalList();

        //using insertion sort
        int j;
        DictionaryData k;
        for (int i = 1; i < wordlist.size(); i++) {
            j = i;

            while (j > 0 && compare_dictdata(wordlist.get(j), wordlist.get(j - 1))) {
                k = wordlist.get(j);
                wordlist.set(j, wordlist.get(j - 1));
                wordlist.set(j - 1, k);
                j--;

            }
            //i++;
        }
        return wordlist;
    }
}
