/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raymond Chu
 */
import java.util.Arrays;
public class MergeIntersect {
    
    public static void main(String args[]) {
        //Test Methods
        int[] arr1 = {20, 19, 19, 18, 17, 15, 39, 45, 22};
        int[] arr2 = {1, 2, 3, 0, 0, 17, 19, 19, 45, 69, 20};
        System.out.println(Arrays.toString(intersect(arr1, arr2)));
    }
    
    // Finds the common integers between the two arrays.
    public static int[] intersect(int[] array1, int[] array2) {
        int x, y, index;
        x = y = index = 0;
        // Finds the minimum length array and creates a newArray to hold duplicates
        int min = Math.min(array1.length, array2.length);
        int[] intDuplicates = new int[min];
        // Sorts both arrays using bubbleSort
        bubbleSort(array1); 
        bubbleSort(array2);
        // Function to determine duplicates
        while (x < array1.length && y < array2.length) {
            if (array1[x] < array2[y]) {
                x++;
            } else if (array1[x] > array2[y]) {
                y++;
            } else {
                intDuplicates[index] = array1[x];
                x++;
                y++;
                index++;
            }
        }
        return intDuplicates;
    }
    
    /** bubbleSort Algorithm */
    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }
    
    //Helper method for bubbleSortto swap elements
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
}
