package cp3.lab02;

public class kmp extends StringMatcher{


    private String target_search_string;
    private String pattern_to_search_for;
    private int compreturn;
    private int [] fail_table;

    public void setTarget(String target)
    {

        target_search_string = target;
    }

    public void setPattern(String pattern)
    {
        pattern_to_search_for = pattern;
        fail_table = new int [pattern.length()];

        //create a fail table and initialise to 0
        fail_table[0] = 0;

        int i = 1;
        int j = 0;

        while(i < pattern_to_search_for.length())
        {
            if(pattern.charAt(i) == pattern.charAt(j))
            {
                fail_table[i] = j + 1;
                i++;
                j++;
            }
            else if(j > 0)
            {
                j = fail_table[j-1];
            }
            else
            {
                fail_table[i] = 0;
                i++;
            }
        }
    }

    public int match()
    {
        int n = target_search_string.length();
        int m = pattern_to_search_for.length();

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

        int i = 0;
        int j = 0;

        while(i < n)
        {
            if(c.compare(pattern_to_search_for.charAt(j), target_search_string.charAt(i)))
            {
                if(j == m - 1)
                {
                    compreturn = c.get();
                    return i - m + 1;
                }
                i++; j ++;
            }
            else if( j > 0)
            {
                j = fail_table[j-1];
            }
            else
            {
                i++;
            }
        }
        compreturn = c.get();
        return -1;
    }

    public int getNumberOfComparisons()
    {

        return compreturn;
    }
}
