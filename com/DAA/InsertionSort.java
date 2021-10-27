package com.DAA;

import java.util.Scanner;

public class InsertionSort {

    Integer[] sort(Integer[] arr){
        int arrayLength = arr.length;

        for (int i = 1; i < arrayLength; i++){
            int k = i;
            int j = i - 1;
            while (arr[k] < arr[j]){
                int temp = arr[k];
                arr[k] = arr[j];
                arr[j] = temp;
                j -= 1;
                k -= 1;
                if(j < 0) {
                    break;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_CYAN = "\u001B[36m";

        InsertionSort insertionSort = new InsertionSort();

        Scanner takeInput = new Scanner(System.in);
        System.out.println(ANSI_PURPLE + "Enter Some" +  ANSI_YELLOW +" Space-Separated" + ANSI_PURPLE +" Unsorted Numbers: " + ANSI_PURPLE);
        String userGivenArray = takeInput.nextLine();

        String[] unsortedString = userGivenArray.split("\\s+");

        Integer[] unsortedIntegers = new Integer[unsortedString.length];

        for (int i = 0; i < unsortedString.length; i++){
            String str = unsortedString[i];
             int digits = Integer.parseInt(str);
             unsortedIntegers[i] = digits;
        }

        for (int element : unsortedIntegers){
            System.out.print(ANSI_RESET+ "---" + ANSI_RESET);
        }
        System.out.println();
        System.out.print(ANSI_CYAN + "Unsorted Array: ");
        for (int element : unsortedIntegers){
            System.out.print(element + " | ");
        }

        Integer[] sortedArray = insertionSort.sort(unsortedIntegers);
        System.out.println();
        for (int element : unsortedIntegers){
            System.out.print(ANSI_RESET+ "---" + ANSI_RESET);
        }
        System.out.println();
        System.out.print(ANSI_BLUE + "Sorted Elements: ");
        for (int element : sortedArray){
            System.out.print(element + " | ");
        }
    }
}