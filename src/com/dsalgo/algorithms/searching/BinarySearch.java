package com.dsalgo.algorithms.searching;


/**
 * @author Nikhil Kumar
 * Binary search algorithm
 * used only on Sorted array with a search complexity of O(logN)
 */
public class BinarySearch {

    public static void main(String[] args){
        System.out.println("Test 1 " +  (binarySearch(new int[]{1,2,4,5,6,7,8,9},7) == 5? "PASSED": "FAILED"));
        System.out.println("Test 2 " +  (binarySearch(new int[]{-11,-2,0,1,2,7,8,900},-2) == 1? "PASSED": "FAILED"));
        System.out.println("Test 3 " +  (binarySearch(new int[]{-11,-2,0,1,2,7,8,900},1) == 3? "PASSED": "FAILED"));
        System.out.println("Test 4 " +  (binarySearch(new int[]{-11,-2,0,1,2,7,8,900},900) == 7? "PASSED": "FAILED"));
        System.out.println("Test 5 " +  (binarySearch(new int[]{1,2,4,5,6,7,8,9},5) == 3? "PASSED": "FAILED"));
        System.out.println("Test 6 " +  (binarySearch(new int[]{1,2,4,5,6,7,8,9},15) == -1? "PASSED": "FAILED"));
        System.out.println("Test 7 " +  (binarySearch(new int[]{-11,-2,0,1,2,7,8,900},-11) == 0? "PASSED": "FAILED"));

    }

    /**
     * @param arr input array
     * @param target value to search in array
     * @return index of target value in the array
     */
    public static int binarySearch(int[] arr, int target){
        return recurseSearch(0, arr.length-1, arr, target);
    }

    /**
     * @param left index of the partition array
     * @param right index of the partition array
     * @param arr input array
     * @param target target to search
     * @return index of the target value in input array
     */
    public static int recurseSearch(int left, int right, int[] arr, int target){
        int index = -1;
        if(left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == target) {
                index = mid;
            } else if (arr[mid] < target) {
                index = recurseSearch(mid + 1, right, arr, target);
            } else {
                index = recurseSearch(left, mid - 1, arr, target);
            }
        }
        return index;
    }
}
