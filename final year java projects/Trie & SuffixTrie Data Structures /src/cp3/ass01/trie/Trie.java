package cp3.ass01.trie;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Trie {

    private TrieNode root = new TrieNode();


    /**
     * Inserts a string into the trie and returns the last node that was
     * inserted.
     *
     * @param str  The string to insert into the trie
     * @param data The data associated with the string
     * @return The last node that was inserted into the trie
     */
    public TrieNode insert(String str, TrieData data) {
        // hint you can use str.toCharArray() to get the char[] of characters
        //System.out.println("ADDING: " +str);
        // awlays start inserting at the root node
        TrieNode current = root;

        // iterate over the given word
        for (int i = 0; i < str.length(); i++) {
            // get/check the child with char at position i in str
            char childChar = str.charAt(i);
            TrieNode child = current.getChild(childChar);
            if (child == null) {
                // if the child does not exist then create a new one
                child = new TrieNode();
                // and add it to the current node
                current.addChild(str.charAt(i), child);
            }

            // move down the trie
            current = child;
        }

        // now at the end of a word, so add the data and make terminal
        current.addData(data);
        current.setTerminal(true);

        return current;
    }

    /**
     * Search for a particular prefix in the trie, and return the final node in
     * the path from root to the end of the string, i.e. the node corresponding
     * to the final character. getNode() differs from get() in that getNode()
     * searches for any prefix starting from the root, and returns the node
     * corresponding to the final character of the prefix, whereas get() will
     * search for a whole word only and will return null if it finds the pattern
     * in the trie, but not as a whole word.  A "whole word" is a path in the
     * trie that has an ending node that is a terminal node.
     *
     * @param str The string to search for
     * @return the final node in the path from root to the end of the prefix, or
     * null if prefix is not found
     */
    public TrieNode getNode(String str) {
        // hint you can use str.toCharArray() to get the char[] of characters

        // always start at the root node
        TrieNode current = root;

        // iterate over the given word
        for (int i = 0; i < str.length(); i++) {
            //System.out.println("getNode: " +current + ", " + str.charAt(i));
            // descend down the Trie
            current = current.getChild(str.charAt(i));
            //System.out.println("getNode child: " +current + ", " + str.charAt(i));
            if (current == null) {
                // if the child/current is null then it is not a word in the Trie
                return null;
            }
        }

        return current;
    }

    /**
     * Searches for a word in the trie, and returns the final node in the search
     * sequence from the root, i.e. the node corresponding to the final
     * character in the word.
     * <p>
     * getNode() differs from get() in that getNode() searches for any prefix
     * starting from the root, and returns the node corresponding to the final
     * character of the prefix, whereas get() will search for a whole word only
     * and will return null if it finds the pattern in the trie, but not as a
     * whole word. A "whole word" is a path in the
     * trie that has an ending node that is a terminal node.
     *
     * @param str The word to search for
     * @return The node corresponding to the final character in the word, or
     * null if word is not found
     */
    public TrieNode get(String str) {
        // hint you can use str.toCharArray() to get the char[] of characters

        // hint use getNode to find the end node and then check to see if it is
        // not null and a terminal

        TrieNode current = getNode(str);

        if (current != null) {
            // check if current is terminal => an actual word
            if (current.isTerminal()) {
                return current;
            }

            // not a terminal so return null to indicate not a word
            return null;

        }

        return null;
    }

    /**
     * Retrieve from the trie an alphabetically sorted list of all words
     * beginning with a particular prefix.
     *
     * @param prefix The prefix with which all words start.
     * @return The list of words beginning with the prefix, or an empty list if
     * the prefix was not found.
     */
    public List<String> getAlphabeticalListWithPrefix(String prefix) {
        //static list to hold the words
        List<String> words = new LinkedList<>();

        getPrefixWords(prefix, words); //recursive call

        return words; //return in alphabetical order
    }

    //below is the recursive fun to iterate thru the list
    public List<String> getPrefixWords(String currentWord, List<String> words) {
        //System.out.println("getPrefixWords: " + currentWord);
        //set currentNode to the currentWord with prefix
        TrieNode currentNode = getNode(currentWord);
        // System.out.println("currentNode: " + currentNode);
        if (currentNode == null)
            return words; //when node is empty, just return words

        if (currentNode.isTerminal()) { //add currentword to the list of words if is terminal
            words.add(currentWord);
            // System.out.println("adding words: " + currentWord);
        }

        //calls itself on the child node and gradually moves down thru all the branches of the tree checking for terminal nodes

        for (Map.Entry<Character, TrieNode> child : currentNode.getChildren().entrySet()) {

            currentWord += child.getKey(); //attach child onto the word and keep going
            getPrefixWords(currentWord, words);

            currentWord = currentWord.substring(0, currentWord.length() - 1); //after all search has been completed, remove the node from the list and set currentnode to the root
        }

        // return the current list
        return words;
    }


    /**
     * NOTE: TO BE IMPLEMENTED IN ASSIGNMENT 1 Finds the most frequently
     * occurring word represented in the trie (according to the dictionary file)
     * that begins with the provided prefix.
     *
     * @param prefix The prefix to search for
     * @return The most frequent word that starts with prefix
     */
    public String getMostFrequentWordWithPrefix(String prefix) {
        // create a static list to hold all the words that we find recursively
        List<String> words = new ArrayList<>();

        // call the recursive prefix list builder
        words = getAlphabeticalListWithPrefix(prefix);
        //System.out.println(words);

        int max = -1;
        String maxWord = null;

        //traverse thru the size of the word list
        for (int i = 0; i < words.size(); i++) {

            String word = words.get(i);
            TrieNode n = this.get(word); //gives back the trie node
            TrieData d = n.getData();
            int freq = d.getFrequency();

            int val = freq; //assign freq to var val
            if (val > max) {
                max = val;
                maxWord = word;
            }
        }
        return maxWord;
    }


    // TWL: very inefficient!!
    // we have the list of 'words' so loop through the words and
    // examine the frequency of each one, finding the maximum


    /**
     * NOTE: TO BE IMPLEMENTED IN ASSIGNMENT 1 Reads in a dictionary from file
     * and places all words into the trie.
     *
     * @param fileName the file to read from
     * @return the trie containing all the words
     */
    public static Trie readInDictionary(String fileName) {

        String word;
        int frequency;

        Trie dt = new Trie();
        Scanner fileScanner;

        try {
            // use a FileInputStream to ensure correct reading end-of-file
            fileScanner = new Scanner(new FileInputStream(fileName));

            while (fileScanner.hasNextLine()) {
                String next = fileScanner.nextLine();
                String[] parts = next.split(" ");
                word = parts[1];
                frequency = Integer.parseInt(parts[2]);
                // TODO: call insert() here to insert the data object into the dictionary!
                dt.insert(word.toLowerCase(), new TrieData(frequency));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("could not find the file " + fileName + "in the data directory!");
            return null;

        }
        return dt;
    }
}
