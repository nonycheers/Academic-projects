package cp3.lab02;

public abstract class StringMatcher {

    private double timeToSetTarget;
    private double timeToSetPattern;
    private double timeToMatch;

    /**
     * Sets the target (calls <code>setTarget</code>) and times how long this operations takes.
     *
     * @param target the target text
     */
    public void setTargetTimed(String target)
    {
        long tic = System.nanoTime();
        this.setTarget(target);
        long toc = System.nanoTime();
        timeToSetTarget = (toc-tic)/1000000.0;
    }

    /**
     * Sets the pattern (calls <code>setPattern</code>) and times how long this operations takes.
     * @param target the target text
     */
    public void setPatternTimed(String target)
    {
        long tic = System.nanoTime();
        this.setPattern(target);
        long toc = System.nanoTime();
        timeToSetPattern = (toc-tic)/1000000.0;
    }

    /**
     * Calls <code>match</code> and times how long this operations takes.
     *
     * @return the index of the first occurrence of pattern in target, -1 otherwise
     */
    public int matchTimed()
    {
        long tic = System.nanoTime();
        int m = this.match();
        long toc = System.nanoTime();
        timeToMatch = (toc-tic)/1000000.0;

        return m;
    }

    public String toTimingString()
    {
        return "Target: " + this.timeToSetTarget + "ms, " +
                "Pattern: " + this.timeToSetPattern + "ms, " +
                "Match: " + this.timeToMatch +"ms, " + "\n" +
                "Total: " + (this.timeToSetTarget+this.timeToSetPattern+this.timeToMatch) + "ms";
    }

    /**
     * Set the target text (the longer one) to be search.
     *
     * @param target the target text
     */
    public abstract void setTarget(String target);

    /**
     * Set the pattern text (the smaller one) to search for in the target text (the longer one).
     *
     * @param pattern the pattern text
     */
    public abstract void setPattern(String pattern);

    /**
     * Match the pattern in the target text.
     *
     * @return the first position of the pattern in text, -1 otherwise
     */
    public abstract int match();

    /**
     * The number of character comparisons (or tests) performed in finding the pattern in the
     * target text.
     *
     * @return the number of comparisons
     */
    public abstract int getNumberOfComparisons();

}

