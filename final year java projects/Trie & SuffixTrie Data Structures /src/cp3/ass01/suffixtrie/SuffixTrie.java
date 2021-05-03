package cp3.ass01.suffixtrie;

import cp3.ass01.trie.Trie;
import cp3.ass01.trie.TrieData;
import cp3.ass01.trie.TrieNode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class SuffixTrie {

    private SuffixTrieNode root = new SuffixTrieNode();

    /**
     * Insert a String into the suffix trie.  For the assignment the string str
     * is a sentence from the given text file.
     *
     * @param str           the sentence to insert
     * @param startPosition the starting index/position of the sentence
     * @return the final node inserted
     */
    public SuffixTrieNode insert(String str, int startPosition) {
        for (int j = 0; j < str.length(); j++) {
            // awlays start inserting at the root node
            SuffixTrieNode current = root;
            // iterate over the given word

            for (int i = 0; i < str.length(); i++) {
                // get/check the child with char at position i in str
                char childChar = str.charAt(i);
                SuffixTrieNode child = current.getChild(childChar);
                if (child == null) {
                    // if the child does not exist then create a new one
                    child = new SuffixTrieNode();
                    // and add it to the current node
                    current.addChild(str.charAt(i), child);
                }
                current.addData(startPosition, i);
                // move down the trie
                current = child;
            }
            current.setTerminal(true);

            return current;
        }
        // now at the end of a word, so add the data and make terminal
        //suffixindex: char, sen?
        return null;
    }


    public SuffixTrieNode getNode(String str) {
        // hint you can use str.toCharArray() to get the char[] of characters

        // always start at the root node
        for (int j = 0; j < str.length(); j++) {
            SuffixTrieNode current = root;

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
        SuffixTrieNode currentNode = getNode(currentWord);
        // System.out.println("currentNode: " + currentNode);
        if (currentNode == null)
            return words; //when node is empty, just return words

        if (currentNode.isTerminal()) { //add currentword to the list of words if is terminal
            words.add(currentWord);
            // System.out.println("adding words: " + currentWord);
        }

        //calls itself on the child node and gradually moves down thru all the branches of the tree checking for terminal nodes

        for (Map.Entry<Character, SuffixTrieNode> child : currentNode.getChildren().entrySet()) {

            currentWord += child.getKey(); //attach child onto the word and keep going
            getPrefixWords(currentWord, words);

            currentWord = currentWord.substring(0, currentWord.length() - 1); //after all search has been completed, remove the node from the list and set currentnode to the root
        }

        // return the current list
        return words;
    }

    /**
     * Helper/Factory method to build a SuffixTrie object from the text in the
     * given file.  The text file is broken up into sentences and each sentence
     * is inserted into the suffix trie.
     * <p>
     * It is called in the following way
     * <code>SuffixTrie st = SuffixTrie.readInFromFile("Frank01e.txt");</code>
     *
     * @param fileName
     * @return
     */
    public static SuffixTrie readInFromFile(String fileName) {

        String sentence;


        SuffixTrie t = new SuffixTrie();
        Scanner fileScanner;

        try {
            // use a FileInputStream to ensure correct reading end-of-file
            fileScanner = new Scanner(new FileInputStream(fileName));

            while (fileScanner.hasNextLine()) {

                String next = fileScanner.nextLine();

                String[] parts = next.split("[.!?]");

//                for (int i = 0; i < parts.length; i ++) {
                    int i = 0;
                    for (String part : parts) {
                        sentence = part;
                        i++;
//                        i = Integer.parseInt(parts[2]);
                        // TODO: call insert() here to insert the data object into the dictionary!
                        t.insert(sentence.toLowerCase(), i);
                    }

            }

        } catch (FileNotFoundException ex) {
            System.out.println("could not find the file " + fileName + "in the data directory!");
            return null;

        }
        return t;
    }
}