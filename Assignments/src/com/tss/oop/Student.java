package com.tss.oop;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private Course [] courses;
    private double feesPaid;
    private double totalFees;

    public Student(){
        id=0;
        name="";
        courses=new Course[3];
        feesPaid=0;
        totalFees=50000;
    }
    public Student(int id, String name,Course[] courses,double feesPaid, double totalFees){
        this.id=id;
        this.name=name;
        this.courses=courses;
        this.feesPaid=feesPaid;
        this.totalFees=totalFees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(double feesPaid) {
        this.feesPaid = feesPaid;
    }

    public double getTotalFees() {
        return totalFees;
    }

    public void setTotalFees(double totalFees) {
        this.totalFees = totalFees;
    }

    public Course[] getCourse() {
        return courses;
    }

    public void setCourse(Course course,int index) {
        this.courses[index] = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void payFees(double amount){
        this.feesPaid+=amount;
    }

    public double getPendingFees(){
        return (this.totalFees-this.feesPaid);
    }

    public void displayProfile(){
        System.out.println("Student ID: "+this.id);
        System.out.println("Student Name: "+this.name);
        System.out.println("Courses Name: "+ Arrays.toString(this.courses));
        System.out.println("Fees Paid: Rs. "+this.feesPaid);
        System.out.println("Total Fees: Rs. "+this.totalFees);
    }

    public boolean canTakeCourse(Course courseObj){
        int courseId=courseObj.getId();
        for(Course course: this.courses){
            if(course==null){
                break;
            }
            if(courseId==course.getId()){
                return false;
            }
        }
        return true;
    }
}