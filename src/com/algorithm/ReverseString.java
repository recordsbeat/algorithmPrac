package com.algorithm;

import java.util.Arrays;

public class ReverseString {

    public String reverseString(String str){
        char[] arr = str.toCharArray();
        int size = arr.length;
        char[] res  = new char[size];
        for(int i=0; i < size ; i ++) {
            res[size-1-i] = arr[i];
        }
        return Arrays.toString(res);
    }

    public static void reverseStringTest(){
        ReverseString reverseTest = new ReverseString();
        String str = "123456789";
        System.out.println("Reversed String  : "  + reverseTest.reverseString(str));
    }
}
