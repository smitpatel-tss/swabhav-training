package com.tssTesting;

public class EmployeeOperations {

    public boolean validAge(int age){
        return age>=18;
    }

    public String getEmployeeSurname(String name){
        return name.split(" ")[0];
    }

    public Double calculateSalary(double salary,double tax){
        return salary-(salary*(tax/100));
    }
}
