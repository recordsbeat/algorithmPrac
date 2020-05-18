package com.algorithm;

import java.util.Arrays;

public class InsertionSort {

    public int[] insertionSort(int[] arr){
        int size = arr.length;

        for(int i =0; i<size-1; i++){
            for(int j=i+1; j>0; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void insertionSortTest(){
        InsertionSort sortTest = new InsertionSort();

        int[] param = {5,2,1,8,6,7,10,9};
        System.out.println("sorted array : " + Arrays.toString(sortTest.insertionSort(param)));
    }
}
