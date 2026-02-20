package BEHAVIOURAL.Strategy.test;

import BEHAVIOURAL.Strategy.model.Employee;
import BEHAVIOURAL.Strategy.model.SeniorHR;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee1=new Employee(10,"Tanmay",new SeniorHR());

        System.out.println(employee1.getName());
        System.out.println(employee1.getRole().getRoleName());
        employee1.printResponsibilities();
    }
}