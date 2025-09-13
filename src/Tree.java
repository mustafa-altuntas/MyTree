import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Tree {


    private final TrieNode root;

    public Tree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null || word.trim().isEmpty()) {
            return;
        }

        TrieNode current = root;
        word = word.toUpperCase().trim();


        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }

        current.isEndOfWord = true;
    }


    public List<String> findWordsWithPrefix(String prefix) {
        List<String> result = new ArrayList<>();

        if (prefix == null || prefix.trim().isEmpty()) {
            return result;
        }

        prefix = prefix.toUpperCase().trim();
        TrieNode prefixNode = findPrefixNode(prefix);

        if (prefixNode != null) {
            collectAllWords(prefixNode, prefix, result);
        }

        Collections.sort(result);
        return result;
    }

    private TrieNode findPrefixNode(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return null;
            }
            current = current.children.get(ch);
        }

        return current;
    }

    private void collectAllWords(TrieNode node, String currentWord, List<String> result) {
        if (node.isEndOfWord) {
            result.add(currentWord);
        }

        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            char ch = entry.getKey();
            TrieNode childNode = entry.getValue();
            collectAllWords(childNode, currentWord + ch, result);
        }
    }


}
