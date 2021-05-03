/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cp3.ass01.suffixtrie;

import cp3.ass01.trie.Trie;

import java.util.*;

/**
 * This is an example class to driver the Suffix Trie project.  You can use this a starting point
 * to test your Suffix Trie implementation.
 * <p>
 * It expects user input of the file to processes as the first line and then the subsequent lines are
 * the words/phrases/suffixes to search for with an empty line terminating the user input. For example:
 * <p>
 * java cp3.ass01.suffixtrie.SuffixTrieDriver
 * data/Frank02.txt
 * and
 * the
 * , the
 * onster
 * ngeuhhh
 * ing? This
 *
 * @author lewi0146
 */
public class SuffixTrieDriver {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        Queue<String> ss = new ArrayDeque<>();
        String suffix = in.nextLine();

        while (!suffix.equals("")) {
            ss.offer(suffix);
            suffix = in.nextLine();
        }

        SuffixTrie st = SuffixTrie.readInFromFile(fileName);

        while (!ss.isEmpty()) {
            String s = ss.poll();
            SuffixTrieNode sn = st.getNode(s);
            System.out.println("[" + s + "]: " + sn);
        }


        int testLevel = in.nextInt();

        switch (testLevel) {
            case 1:
                test1(in);
                break;
        }

    }


    public static void test1(Scanner in) {

        String fileName = in.next();
        //String fileName = "mississippi.txt";
        SuffixTrie st = SuffixTrie.readInFromFile(fileName);
        String[] ss = in.nextLine().trim().split("[.!?]");
        for (String s : ss) {
            SuffixTrieNode sn = st.getNode(s);
            System.out.println("[" + s + "]: " + sn);

        }

        /**
         * Test out the getMostFrequentWordWithPrefix method. Expects a file name that is the
         * dictionary and then a some of words to search for in the newly created
         * Trie. For example
         *
         * <cdoe>5 data/word-freq.expanded.trim.txt aba the bbb</code>
         *
         * @param in
         */
//    public static void test5(Scanner in) {
//
//        String fileName = in.next();
//
//        System.out.print("Reading in trie...");
//        SuffixTrie dt = SuffixTrie.readInFromFile(fileName);
//        System.out.println("done");
//
//        String[] more = in.nextLine().trim().split(" ");
//        for (String mm : more) {
//            System.out.println("PREFIX = " + mm);
//            String f = dt.getMostFrequentWordWithPrefix(mm);
//            System.out.println("Most Frequent Word is " + f);
//        }
    }
}

