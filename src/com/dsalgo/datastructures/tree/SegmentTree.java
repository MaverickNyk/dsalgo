package com.dsalgo.datastructures.tree;

/**
 * @author  Nikhil Kumar
 * Segment trees, efficient for range queries on array
 * with worst time complexity of O(logN)
 */
public class SegmentTree {

    /**
     * array to store segment tree elements
     */
    int[] segmentTree;

    /**
     * @param arr input Array
     * Constructor to initialize segment tree from input tree
     */
    SegmentTree(int[] arr){
        int n = arr.length;

        segmentTree = new int[getSegmentTreeSize(n)];
        buildSGTree(arr, 0 , n-1, 0);
    }

    /**
     * @param arrayLength length of input array
     * @return return the memory/length required for segment tree
     * he size of the segment tree is 2n-1 (n leaf nodes and n-1 internal nodes).
     * If n is not a power of 2, then the size of the tree will be 2*x – 1
     * where x is the smallest power of 2 greater than n.
     */
    private static int getSegmentTreeSize(int arrayLength){
        int nextPowOf2 = arrayLength != Integer.highestOneBit(arrayLength) ?
                2 * Integer.highestOneBit(arrayLength) : arrayLength;
        return  2 * nextPowOf2 - 1;
    }


    /**
     * @param arr input array
     * @param start start index of segment
     * @param end end index of segment
     * @param stPos index of segment
     * @return returns the sum of that particular range in segment tree
     */
    private int buildSGTree(int[] arr, int start, int end, int stPos){
        if(start == end){
            segmentTree[stPos] = arr[start];
            return segmentTree[stPos];
        }

        int mid = (start + end) / 2;
        segmentTree[stPos] = buildSGTree(arr, start, mid, stPos * 2 + 1)
                + buildSGTree(arr, mid+1, end, stPos * 2 + 2);
        return segmentTree[stPos];
    }

    /**
     * @param arr input array
     * @param start start index of range
     * @param end end index of range
     * @return returns the sum of that specific range
     * @throws IllegalArgumentException when invalid range is specified
     */
    public int getSum(int[] arr, int start, int end) throws IllegalArgumentException{
        if(start < 0 || end > arr.length-1){
            throw  new IllegalArgumentException("Are you serious !!!, Please provide valid Range");
        }
        return getPartitionSum(0, arr.length-1, start, end, 0);
    }

    /**
     * @param ss segment start index
     * @param se segment end index
     * @param rs range start index
     * @param re range end index
     * @param si current segment index, initially its on root i.e. 0 index
     * @return return the sum of segment range from segment tree
     */
    private int getPartitionSum(int ss, int se, int rs, int re, int si){
        if (rs <= ss && re >= se){
            return segmentTree[si];
        }
        if(se < rs || ss > re){
            return  0;
        }
        int mid = (ss + se)/2;
        return getPartitionSum(ss, mid, rs, re, 2 * si + 1) +
                getPartitionSum(mid+1, se, rs, re, 2 * si + 2);
    }

    /**
     * @param inputArr input array
     * @param index index which needs to be updated
     * @param newValue new value to be updated on index
     */
    public void updateValue(int[] inputArr, int index, int newValue){
        if(index < 0 || index > inputArr.length-1){
            throw new IllegalArgumentException("Are you really serious, Stop irritating me");
        }
        int diff = newValue - inputArr[index];
        inputArr[index] = newValue;
        updatedElement(0, inputArr.length-1, 0, index, diff);
    }

    /**
     * @param ss segment start index
     * @param se segment end index
     * @param si segment current index
     * @param index index of element in input array to udpate
     * @param diff diff between old value and new Value
     */
    private void updatedElement(int ss, int se, int si, int index, int diff){

        if(index < ss || index > se){
            return;
        }
        segmentTree[si] = segmentTree[si] + diff;

        if(se != ss){
            int mid = (ss + se)/2;
            updatedElement(ss, mid, 2 * si + 1, index, diff);
            updatedElement(mid+1, se, 2 * si + 2, index, diff);
        }
    }

    public static void main(String[] args){
        int[] inputArr = new int[]{2,3,1,3,78,34,232,45,121,343,121,343,23,454,121,343,232,2,4};
        SegmentTree segmentTree = new SegmentTree(inputArr);
        System.out.println("Segment tree initialized");

        System.out.println("Test 1 :"
                + (segmentTree.getSum(inputArr,0, inputArr.length-1) == 2505 ? "PASSED" : "FAILED"));
        System.out.println("Test 2 :"
                + (segmentTree.getSum(inputArr,2, 12) == 1344 ? "PASSED" : "FAILED"));
        System.out.println("Test 3 :"
                + (segmentTree.getSum(inputArr,3, 7) == 392 ? "PASSED" : "FAILED"));
        System.out.println("Test 4 :"
                + (segmentTree.getSum(inputArr,5, 5) == 34 ? "PASSED" : "FAILED"));
        System.out.println("Test 5 :"
                + (segmentTree.getSum(inputArr,0, 5) == 121 ? "PASSED" : "FAILED"));
        System.out.println("Test 6 :"
                + (segmentTree.getSum(inputArr,8, inputArr.length-1) == 2107 ? "PASSED" : "FAILED"));

        segmentTree.updateValue(inputArr, 5, 4);
        System.out.println("Value at Index 5 is updated Old Value: 34, New Value: 4");

        System.out.println("Test 7 :"
                + (segmentTree.getSum(inputArr,5, 5) == 4 ? "PASSED" : "FAILED"));
        System.out.println("Test 8 :"
                + (segmentTree.getSum(inputArr,0, 5) == 91 ? "PASSED" : "FAILED"));
        System.out.println("Test 9 :"
                + (segmentTree.getSum(inputArr,3, 7) == 362 ? "PASSED" : "FAILED"));
        System.out.println("Test 10 :"
                + (segmentTree.getSum(inputArr,2, 12) == 1314 ? "PASSED" : "FAILED"));
        System.out.println("Test 11 :"
                + (segmentTree.getSum(inputArr,0, inputArr.length-1) == 2475 ? "PASSED" : "FAILED"));

        System.out.println("Program Ends");
    }
}
