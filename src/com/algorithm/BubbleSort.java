package com.algorithm;

import java.util.Arrays;

public class BubbleSort {

    public int[] bublleSort(int[] arr){
        System.out.println("size : " + arr.length);
        for(int i=0; i < arr.length-1; i++){
            for(int j = 0; j<arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    public static void bubbleSortTest(){
        BubbleSort sortTest = new BubbleSort();

        int[] param = {5,2,1,8,6,7,10,9};
        System.out.println("sorted array : " + Arrays.toString(sortTest.bublleSort(param)));
    }
}
