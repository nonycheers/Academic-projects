package cp3.lab02;

public class bm extends StringMatcher {


    private String target_search_string;
    private String pattern_to_search;
    private int compreturn;
    private int [] lookup_table;

    //Set the search for in the target text (the longer one).
    public void setTarget(String target) {
        target_search_string = target;
    }

    //Sets the string pattern in the target text we are searching for.
    public void setPattern(String pattern) {
        pattern_to_search = pattern;


        //initialise a look up table for ascii chars arr

        lookup_table = new int[127];
        for (int i = 0; i < 127; i++) {
            lookup_table[i] = - 1;
        }

        //define lookup table
        for (int i = 0; i < pattern_to_search.length(); i++){
            lookup_table[(int)pattern_to_search.charAt(i)] = i;
        }
    }


    public int match() {
        int n = target_search_string.length();
        int m = pattern_to_search.length();

            //use to count the comparisons in the string its seaching
            class compcount {
                private int comparisons;

                public compcount() {
                    comparisons = 0;
                }

                public boolean compare(char a, char b) {
                    comparisons++;
                    return a == b;
                }

                public int get() {
                    return comparisons;
                }
            }
            //instance of class, create a new comparsion obj to store&return the num/tests of comparisons
            compcount c = new compcount();

            int i = m -1;
            int j = m -1;

        while(i<=n-1) {
            if (c.compare(target_search_string.charAt(i), pattern_to_search.charAt(j))) {
                if (j == 0) {
                    compreturn = c.get();
                    return i;
                } else {
                    i--; // i = i -1
                    j--;
                }
            } else {
                i = i + m - Math.min(j, 1 + lookup_table[(int) target_search_string.charAt(i)]);
                j = m - 1;
            }
        }
            compreturn = c.get();
            return -1;

        }
        public int getNumberOfComparisons(){
            return compreturn;
        }

    }










