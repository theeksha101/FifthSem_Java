package com.DAA;


import java.util.Scanner;

class LCS {
    static void lcs(String string1, String string2, int str1Len, int str2Len) {
        int[][] LCS_table = new int[str1Len + 1][str2Len + 1];

        for (int i = 0; i <= str1Len; i++) {
            for (int j = 0; j <= str2Len; j++) {
                if (i == 0 || j == 0)
                    LCS_table[i][j] = 0;
                else if (string1.charAt(i - 1) == string2.charAt(j - 1))
                    LCS_table[i][j] = LCS_table[i - 1][j - 1] + 1;
                else
                    LCS_table[i][j] = Math.max(LCS_table[i - 1][j], LCS_table[i][j - 1]);
            }
        }

        int index = LCS_table[str1Len][str2Len];
        int temp = index;

        char[] lcs = new char[index + 1];
        lcs[index] = '\0';

        int i = str1Len, j = str2Len;
        while (i > 0 && j > 0) {
            if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                lcs[index - 1] = string1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (LCS_table[i - 1][j] > LCS_table[i][j - 1])
                i--;
            else
                j--;
        }

        System.out.print("S1 : " + string1 + "\nS2 : " + string2 + "\nLCS: ");
        for (int k = 0; k <= temp; k++)
            System.out.print(lcs[k]);
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first string: ");
        String firstString = scanner.next();
        System.out.println("Enter second string: ");
        String secondString = scanner.next();

        int lenFirstStr = firstString.length();
        int lenSecStr = secondString.length();
        lcs(firstString, secondString, lenFirstStr, lenSecStr);
    }
}
