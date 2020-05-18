package com.algorithm;

public class ReverseInteger {

    public void reverseInteger(int param){

        while(param > 0){

            int res = param%10;
            param = param/10;

            System.out.println(res);
        }
    }
    public static void reverseIntegerTest(){
        ReverseInteger reverseTest = new ReverseInteger();
        reverseTest.reverseInteger(123456789);
    }

}
