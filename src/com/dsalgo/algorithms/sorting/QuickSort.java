package com.dsalgo.algorithms.sorting;

import java.util.Arrays;

/**
 * @author Nikhil Kumar
 * Quick sort algorithm
 */
public class QuickSort {

    public static void main(String[] args){
        int[] inputArray1 = new int[]{1,45,334,2,2,1,45,23,231,1,343,212,56,78,45,23};
        int[] sortedInputArray1 = new int[]{1,1,1,2,2,23,23,45,45,45,56,78,212,231,334,343};
        int[] sortedArray1 = quickSort(inputArray1);
        System.out.println("Test 1 "+ (Arrays.equals(sortedInputArray1, sortedArray1) ? " PASSED": " FAILED"));

        int[] inputArray2 = new int[]{};
        int[] sortedArray2 = quickSort(inputArray2);
        System.out.println("Test 2 "+ (Arrays.equals(new int[]{}, sortedArray2) ? " PASSED": " FAILED"));

        int[] inputArray3 = new int[]{101,2,393};
        int[] sortedInputArray3 = new int[]{2,101,393};
        int[] sortedArray3 = quickSort(inputArray3);
        System.out.println("Test 3 "+ (Arrays.equals(sortedInputArray3, sortedArray3) ? " PASSED": " FAILED"));

        int[] inputArray4 = new int[]{38, 27, 43, 3, 9, 82, 10};
        int[] sortedInputArray4 = new int[]{3,9,10,27,38,43,82};
        int[] sortedArray4 = quickSort(inputArray4);
        System.out.println("Test 4 "+ (Arrays.equals(sortedInputArray4, sortedArray4) ? " PASSED": " FAILED"));

    }

    /**
     * @param arr input array to sort
     * @return sorted array sequence
     */
    public static int[] quickSort(int[] arr){
        sort(0, arr.length-1, arr);
        return arr;
    }

    /**
     * @param start start index
     * @param end end index
     * @param arr input array subsequence to sort
     */
    public static void sort(int start, int end, int[] arr){
        if(start < end) {
            int pivotPos = partition(start, end, arr);
            sort(start, pivotPos - 1, arr);
            sort(pivotPos + 1, end, arr);
        }
    }

    /**
     * @param start start index
     * @param end end index
     * @param arr input array subsequence to partition
     * @return return the correct index of pivot
     */
    public static int partition(int start, int end, int[] arr){
        int pivot = arr[end];
        end--;
        int i = start;
        while (start <= end){
           if(arr[start] < pivot){
               int temp = arr[i];
               arr[i] = arr[start];
               arr[start] = temp;
               i++;
           }
           start++;
        }
        int temp = arr[i];
        arr[i] = pivot;
        arr[end+1] = temp;
        return i;
    }
}
