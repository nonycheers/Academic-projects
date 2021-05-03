package cp3.lab02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lewi0146
 */
public class ExactStringMatchingDriver {

    /**
     * Example commands:
     *   repaper.txt, builtin, verbose
     *   repaper.txt, bruteforce, verbose
     *   repaper.txt, bm, verbose
     *   repaper.txt, kmp, verbose
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        System.out.print("Enter command: ");
        Scanner in = new Scanner(System.in);
        String[] command = in.nextLine().split(",");

        if (command.length == 0 || command[0].isEmpty()) {
            System.out.println("usage: java cp3.lab02.ExactStringMatchingDriver");
            System.out.println("Enter command: <file>, <algorithm>, <verbose>");
            System.out.println("Enter search term: <searchterm>");
            System.out.println("where, ");
            System.out.println("  <file>: is the file to search (should in the 'data' directory)");
            System.out.println("  <algorithm>: ESM algorithm to use [builtin|bruteforce|bm|kmp|other], default: builtin");
            System.out.println("  <versbose>: is specified and is verbose then timing info outputted, default: not specified");
            System.out.println("  <searchterm>: the term to search");

        } else {

            String file = command[0].trim();

            Scanner s = new Scanner(new FileInputStream("data" + File.separator + file));
            StringBuilder targetBuilder = new StringBuilder();
            while (s.hasNextLine()) {
                targetBuilder.append(s.nextLine());
            }
            String target = targetBuilder.toString();

            StringMatcher matcher = null;

            String algorithm;
            if (command.length > 1) {
                algorithm = command[1].trim();
            } else {
                algorithm = "builtin";
            }

            switch (algorithm) {
                case "builtin":
                    matcher = new StringMatcherBuiltin();
                    break;
                case "bruteforce":
                    matcher = new bruteforce(); // TODO: Checkpoint 7
                    break;
                case "bm":
                    matcher = new bm(); // TODO: Checkpoint 8
                    break;
                case "kmp":
                    matcher = new kmp(); // TODO: Checkpoint 9
                    break;


            }

            matcher.setTargetTimed(target);

            System.out.print("Enter search term: ");
            String pattern = in.nextLine();

            // verbose output
            boolean verbose = false;
            if (command.length > 2) {
                verbose = command[2].trim().equals("verbose");
            }

            while (!pattern.isEmpty()) {
                matcher.setPatternTimed(pattern);
                int index = matcher.matchTimed();
                System.out.print("index: " + index);
                if (!algorithm.equals("other") || verbose) {
                    System.out.print(", comp: " + matcher.getNumberOfComparisons());
                }
                if (verbose) {
                    System.out.print(", " + matcher.toTimingString());
                }
                System.out.println();
                System.out.print("Enter search term: ");
                pattern = in.nextLine();
            }
        }
    }
}
