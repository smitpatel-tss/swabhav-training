package com.tssTesting;

public class Student {
    private StudentService service;

    Student(StudentService service){
        this.service=service;
    }

    double getAvgMarks(){
        return service.getTotalMarks()/service.getTotalStudent();
    }
}
