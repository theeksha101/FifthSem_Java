package com.DAA;

import javax.swing.*;
import java.util.Arrays;
import java.util.Scanner;

class BinarySearch
{
    public static Integer divideAndConquerSort(Integer[] array, int left, int right, int target)
    {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (target == array[mid]) {
            return mid;
        }
        else if (target < array[mid]) {
            return divideAndConquerSort(array, left, mid - 1, target);
        }
        else {
            return divideAndConquerSort(array, mid + 1, right, target);
        }
    }

    public static void main(String[] args)
    {
        Scanner takeInput = new Scanner(System.in);
        System.out.println("Enter Some Space-Separated Numbers: ");
        String userGivenArray = takeInput.nextLine();

        String[] arrayOfString = userGivenArray.split("\\s+");
        Integer[] arrayOfIntegers = new Integer[arrayOfString.length];

        for (int i = 0; i < arrayOfString.length; i++){
            String str = arrayOfString[i];
            int digits = Integer.parseInt(str);
            arrayOfIntegers[i] = digits;
        }
        System.out.println(Arrays.toString(arrayOfIntegers));
        System.out.println("Enter key to search: ");
        int keyToSearch = takeInput.nextInt();
        int left = 0;
        int right = arrayOfIntegers.length - 1;

        int index = divideAndConquerSort(arrayOfIntegers, left, right, keyToSearch);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found in the array");
        }
    }
}


