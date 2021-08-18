package com.dsalgo.algorithms.sorting;

import java.util.Arrays;

/**
 * @author Nikhil Kumar
 * Merge Sort algorithm
 */
public class MergeSort {

    public static void main(String[] args){
        int[] inputArray1 = new int[]{1,45,334,2,2,1,45,23,231,1,343,212,56,78,45,23};
        int[] sortedInputArray1 = new int[]{1,1,1,2,2,23,23,45,45,45,56,78,212,231,334,343};
        int[] sortedArray1 = mergeSort(inputArray1);
        System.out.println("Test 1 "+ (Arrays.equals(sortedInputArray1, sortedArray1) ? " PASSED": " FAILED"));

        int[] inputArray2 = new int[]{};
        int[] sortedArray2 = mergeSort(inputArray2);
        System.out.println("Test 2 "+ (Arrays.equals(new int[]{}, sortedArray2) ? " PASSED": " FAILED"));

        int[] inputArray3 = new int[]{101,2,393};
        int[] sortedInputArray3 = new int[]{2,101,393};
        int[] sortedArray3 = mergeSort(inputArray3);
        System.out.println("Test 3 "+ (Arrays.equals(sortedInputArray3, sortedArray3) ? " PASSED": " FAILED"));

        int[] inputArray4 = new int[]{38, 27, 43, 3, 9, 82, 10};
        int[] sortedInputArray4 = new int[]{3,9,10,27,38,43,82};
        int[] sortedArray4 = mergeSort(inputArray4);
        System.out.println("Test 4 "+ (Arrays.equals(sortedInputArray4, sortedArray4) ? " PASSED": " FAILED"));

    }

    /**
     * @param arr input array
     * @return void
     */
    public static int[]  mergeSort(int[] arr){
        sort(0, arr.length-1, arr);
        return arr;
    }

    /**
     * @param start start index of array segment
     * @param end end index of array segment
     * @param arr input array
     */
    public static void sort(int start, int end, int[] arr){
        if(start < end){
            int mid = (start + end) / 2;
            sort(start, mid, arr);
            sort(mid+1, end, arr);
            merge(start, mid, end, arr);
        }

    }

    /**
     * @param start start index of first array block
     * @param mid end index of first array block and mid+1 is start index of second array block
     * @param end end index of second array block
     * @param arr input array
     */
    public static void merge(int start, int mid, int end, int[] arr){
        int leftLength = mid-start+1;
        int rightLength = end-mid;

        int[] leftArr = new int[leftLength];
        int[] rightArr = new int[rightLength];


        if (leftLength >= 0) System.arraycopy(arr, start, leftArr, 0, leftLength);
        if (rightLength >= 0) System.arraycopy(arr, mid+1, rightArr, 0, rightLength);

        int i = 0, j = 0, k = start;
        while (i < leftLength && j < rightLength){
            if(leftArr[i] > rightArr[j]){
                arr[k++] = rightArr[j++];
            }
            else{
                arr[k++] = leftArr[i++];
            }
        }

        while (i < leftLength){
            arr[k++] = leftArr[i++];
        }

        while (j < rightLength){
            arr[k++] = rightArr[j++];
        }
    }
}