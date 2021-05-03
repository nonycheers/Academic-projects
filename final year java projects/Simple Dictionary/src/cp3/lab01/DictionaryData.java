package cp3.lab01;

/**
 *
 * @author lewi0146
 */

public class DictionaryData {

    int rank;
    String word;
    int frequency;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }


    /**
     * Creates a new DictionaryData object based upon the the String line that
     * contains the data about the new data item.
     *
     * @param line the data about the new data item
     */

    public DictionaryData(String line)
    {
        String [] field = line.split(" "); //string field takes the line from the stdin and bifurcates the word with space
        this.rank = Integer.parseInt(field[0]);
        this.word = field[1];
        this.frequency = Integer.parseInt(field[2]);
    }

    /**
     * A string representation of the DataDictionary object. For example
     *
     *     "orange: frequency = 518"
     *
     * @return a string representation of the DataDictionary object
     */
    @Override
    public String toString() {
        return this.word + ": frequency = " + this.frequency;
    }
}
