package com.tssTesting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator=new Calculator();

    @Test
    void multiply() {

        double []a={10,20,30,40};
        double []b={2,2,2,2};
        double[]actual=new double[a.length];

        for(int i=0;i<a.length;i++){
            actual[i]= calculator.multiply(a[i],b[i]);
        }

        double []ans={20,40,60,80};

//        assertEquals(20,actual);

        assertArrayEquals(ans,actual);
    }


    @Test
    void divide() {
        double actual=calculator.divide(10,2);
//        assertEquals(5,actual);

        assertThrows(ArithmeticException.class,()->{calculator.divide(10,0);});

    }
}