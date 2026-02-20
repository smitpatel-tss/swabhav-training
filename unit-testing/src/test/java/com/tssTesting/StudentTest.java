package com.tssTesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;
    private StudentService service;
    @BeforeEach
    void init(){
        service= Mockito.mock(StudentService.class);
        student=new Student(service);
    }
    @Test
    void getAvgMarks() {
        Mockito.when(service.getTotalMarks()).thenReturn(100.0);
        Mockito.when(service.getTotalStudent()).thenReturn(10.0);

        assertEquals(10,student.getAvgMarks());
    }
}