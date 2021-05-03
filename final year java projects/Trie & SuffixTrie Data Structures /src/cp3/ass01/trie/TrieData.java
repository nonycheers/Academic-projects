package cp3.ass01.trie;

public class TrieData {

    private int frequency = -1;

    /**
     * Construct a new TrieData with the given frequency
     *
     * @param frequency the frequency of the data associated with the TrieNode
     */
    public TrieData(int frequency) {
        this.frequency = frequency;
    }

    /**
     * Gets the frequency of this TrieData.
     *
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }


    /**
     * Sets the frequency of this TrieData
     *
     * @param frequency the frequency
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }


    @Override
    public String toString() {
        return String.valueOf(frequency);
    }
}
