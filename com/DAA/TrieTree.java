package com.DAA;

// LCP using Trie

import java.util.Objects;
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
            }
            temp = temp.characters[index];
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

    int countChildren(TrieNode node){
        int count = 0;

        for (int i = 0; i < 26; i++){
            if (node.characters[i] != null){
                count ++;
            }
            //TODO:

        }
        return count;
    }

    StringBuilder findLCP(String[] array){
        TrieNode crawl = root;
        StringBuilder prefix = new StringBuilder();
        for (String str : array){
            int wordLength = str.length();
            for (int i = 0; i < wordLength; i++){
                int index = str.charAt(i) - 'a';
                if (countChildren(crawl) == 1 && !crawl.isEndOfWord){
                    crawl= crawl.characters[index];
                    prefix.append((char) ('a' + index));
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {

        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";

        Scanner takeInput = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println(ANSI_YELLOW + "Keep giving strings as inputs to find the Longest Common Prefix among them");
        System.out.println(ANSI_YELLOW + "Enter" + ANSI_RED+" 'exit' " + ANSI_YELLOW +" to stop giving strings");
        String userGivenString = takeInput.nextLine();

        while (!Objects.equals(userGivenString, "exit")){
            TrieTree tree = new TrieTree();

            String[] spacedString = userGivenString.split("\\s+");
            for (String s : spacedString) {
                tree.insert(s);
            }

            StringBuilder producedPrefix = tree.findLCP(spacedString);
            if (producedPrefix.length() != 0){
                System.out.println(ANSI_BLUE + "'" +producedPrefix + "'" + ANSI_RESET + " is the prefix");
            }
            else {
                System.out.println(ANSI_BLUE + "-1"+ ANSI_RESET);
            }

            System.out.println("-------------------------------------------------------------------------------------");
            userGivenString = takeInput.nextLine();
        }
    }
}
