package com.newTss;

//import com.tss.test.Temp2;



public class Temp3 {
    static int x = 5;

    static {
        x = x * 2;
    }

    static int y = x + 3;

    public static void main(String[] args) {
        System.out.println(x + " " + y);
    }
}

