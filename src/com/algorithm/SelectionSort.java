package com.algorithm;

import java.util.Arrays;

public class SelectionSort {

    public int[] selectionSort(int[] arr){
        System.out.println("size : " + arr.length);
        for(int i=0; i<arr.length-1; i++){
            int minPos = i;
            for(int j =i+1; j<arr.length; j++){
                if(arr[minPos] > arr[j])
                    minPos = j;
            }
            if(i != minPos){
                int temp = arr[i];
                arr[i] = arr[minPos];
                arr[minPos] = temp;
            }

        }
        return arr;
    }
    public static void selectSortTest(){
        SelectionSort sortTest = new SelectionSort();

        int[] param = {5,2,1,8,6,7,10,9};
        System.out.println("sorted array : " + Arrays.toString(sortTest.selectionSort(param)));
    }
}
