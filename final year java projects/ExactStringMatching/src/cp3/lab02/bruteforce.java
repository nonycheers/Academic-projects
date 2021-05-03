package cp3.lab02;

public class bruteforce extends StringMatcher {


    private String target_search_string;
    private String pattern_to_search;
    private int compreturn;

    //Set the search for in the target text (the longer one).
    public void setTarget(String target){
    target_search_string = target;
    }

    //Sets the string pattern in the target text we are searching for.
    public void setPattern(String pattern){
        pattern_to_search = pattern;
    }

    //if match return i or else return -1
    //The number of character comparisons (or tests) performed in finding the pattern in the
     // target text.
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


       for (int i = 0; i<= n - m; i++){
            int j = 0;
            while ((j < m) && c.compare(target_search_string.charAt(i + j), pattern_to_search.charAt(j)))
            {
                j++;
            }
            if (j == m) {
                compreturn = c.get();
                return i;
            }
        }
        compreturn = c.get();
        return -1;

    }
    public int getNumberOfComparisons(){
    return compreturn;
    }

}