import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    public Map<Character, TrieNode> children;

    // kelime bitti mi
    public boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}