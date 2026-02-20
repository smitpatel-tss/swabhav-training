package com.tssTesting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeOperationsTest {

    EmployeeOperations operations;

    @BeforeEach
    void init(){
        System.out.println("Test------- Started!");

        operations=new EmployeeOperations();
    }

    @AfterEach
    void printAfter(){
        System.out.println("TestCase Executed!");
    }

    @BeforeAll
    static void printBefore(){
        System.out.println("Tests Started!");
    }

    @Test
    void validAge() {
        assertTrue(operations.validAge(20));
        assertFalse(operations.validAge(16));
    }

    @Test
    void getEmployeeSurname() {
        assertEquals("Chhatbar",operations.getEmployeeSurname("Chhatbar Neel"));
        assertInstanceOf(String.class,operations.getEmployeeSurname("ANYTHING Else"));
    }

    @Test
    void calculateSalary() {
        assertEquals(0,operations.calculateSalary(10000,0));
    }
}