package DAA;

import java.util.Arrays;
import java.util.Scanner;

public class TrieTree {
    TrieNode root;

    TrieTree(){
        root = new TrieNode();
    }

    int getIndex (char character){
        char a = 'a';
        int _a = a;
        int _char = character;
        int index = _char - _a;
        return index;
    }

    void insert(String data) {
        TrieNode temp = root;
        for (int i = 0; i < data.length(); i++) {
            char character = data.charAt(i);
            int index = getIndex(character);
            if (temp.characters[index] == null){
                temp.characters[index] = new TrieNode();
            temp = temp.characters[index];
            }
        }
        temp.isEndOfWord = true;
    }

    boolean search(String key)
    {
        int length = key.length();
        int index;
        TrieNode crawl = root;

        for (int j = 0; j < length; j++) {
            index = key.charAt(j) - 'a';
            if (crawl.characters[index] == null)
                return false;
            crawl = crawl.characters[index];
        }
        return (crawl.isEndOfWord);
    }

    void findLCP(){
        
    }

    public static void main(String[] args) {
        TrieTree tree = new TrieTree();

        Scanner takeInput = new Scanner(System.in);
        System.out.println("Enter Some Strings: ");
        String userGivenString = takeInput.nextLine();
        System.out.println(userGivenString);
        String[] spacedString = userGivenString.split("\\s+");
        System.out.println(Arrays.toString(spacedString));

        for (String s : spacedString) {
            tree.insert(s);
        }



    }
}
