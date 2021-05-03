package cp3.lab02;

public class StringMatcherBuiltin extends StringMatcher {

    String target;
    String pattern;

    @Override
    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public int match() {
        return target.indexOf(pattern);
    }

    @Override
    public int getNumberOfComparisons() {
        return -1;
    }

}
