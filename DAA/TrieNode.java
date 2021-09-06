package DAA;

import java.util.Arrays;

public class TrieNode {
    TrieNode[] characters = new TrieNode[26];
    boolean isEndOfWord ;

    TrieNode(){
        this.isEndOfWord = false;
        for (int i = 0; i < 26; i++){
            characters[i] = null;
    }
    }

}
