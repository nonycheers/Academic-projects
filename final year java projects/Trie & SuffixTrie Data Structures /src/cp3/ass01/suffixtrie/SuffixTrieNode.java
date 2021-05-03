package cp3.ass01.suffixtrie;

import cp3.ass01.trie.TrieData;
import cp3.ass01.trie.TrieNode;

import java.util.Map;
import java.util.TreeMap;

public class SuffixTrieNode {

    SuffixTrieData data = new SuffixTrieData();
    private boolean terminal = false;
    int numChildren = 0;
    private Map<Character, SuffixTrieNode> children = new TreeMap<>();

    public SuffixTrieNode getChild(char label) {
        return children.get(label);
    }

    public Map<Character, SuffixTrieNode> getChildren() {
        return children;
    }

    public SuffixTrieData getData() {
        return data;
    }


    public void addChild(char label, SuffixTrieNode node) {
        children.put(label, node);
    }

    public void addData(int sentencePos, int characterPos) {
        this.data.addStartIndex(new SuffixIndex(sentencePos, characterPos));
    }

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    public String toString() {
        return data.toString();
    }
}
