package com.tss.GruhKarya;

import static com.tss.utils.GlobalConstants.*;
import static com.tss.utils.Validate.*;
import static com.tss.GruhKarya.PolicyConstants.*;

public class PolicyApp {

    public static void main(String[] args) {
        while(true){
            displayMenu();
            int choice= validatePositiveInt();
            switch (choice){
                case 1:{
                    createPolicy();
                    break;
                }
                case 2:{
                    calculatePremium();
                    break;
                }
                case 3:{
                    applyForClaim();
                    break;
                }
                case 4:{
                    displayDetailOfPolicy();
                    break;
                }
                case 5:{
                    System.out.println("Have a Good Day!!");
                    return;
                }
                default:{
                    System.out.println("Enter a valid choice !!");
                }
            }
        }
    }

    private static void displayDetailOfPolicy() {
        if(!checkForPolicyExistence())return;

        displayPolicyNumbers();
        System.out.print("Enter the Policy Number to Apply for claim: ");
        long policyNumber= validatePositiveLong();
        InsurancePolicy p=getPolicyFromNumber(policyNumber);
        if(p==null){
            System.out.println("No such policy found !!");
            return;
        }
        System.out.println("Policy Details: ");
        System.out.println(p);
        System.out.println();
    }

    private static boolean checkForPolicyExistence(){
        if(index==0){
            System.out.println("No Policies Found !!");
            return false;
        }
        return true;
    }

    private static void applyForClaim() {
        if(!checkForPolicyExistence())return;

        displayPolicyNumbers();
        System.out.print("Enter the Policy Number to Apply for claim: ");
        long policyNumber= validatePositiveLong();
        InsurancePolicy p=getPolicyFromNumber(policyNumber);
        if(p==null){
            System.out.println("No such policy found !!");
            return;
        }
        p.applyForClaim();
    }

    private static void calculatePremium() {
        if(!checkForPolicyExistence())return;

        displayPolicyNumbers();
        System.out.print("Enter the Policy Number to Calculate Premium: ");
        long policyNumber= validatePositiveLong();
        InsurancePolicy p=getPolicyFromNumber(policyNumber);
        if(p==null){
            System.out.println("No such policy found !!");
            return;
        }
        System.out.println("Calculated Premium: "+p.calculatePremium());
        System.out.println();
    }

    private static InsurancePolicy getPolicyFromNumber(long policyNumber) {
        for(InsurancePolicy p:policies){
            if(p==null)return null;
            if(p.getPolicyNumber()==policyNumber){
                return p;
            }
        }
        return null;
    }

    private static void displayPolicyNumbers() {
        System.out.println("Available Policies Number: ");
        for(InsurancePolicy p:policies){
            if(p==null)break;
            System.out.println(p.getPolicyNumber());
        }
    }

    private static void createPolicy() {
        if(index==MAX_POLICIES){
            System.out.println("Maximum Policies Reached, Can't create more !!");
            return;
        }
        System.out.println("Enter which type of policy you want to opt: ");
        System.out.println("1. Life Insurance Policy");
        System.out.println("2. Health Insurance Policy");
        System.out.println("3. Vehicle Insurance Policy");
        System.out.print("Enter your Choice: ");
        int choice= validatePositiveInt();
        while(!((choice==1) || (choice==2) || (choice==3))){
            System.out.print("Enter a valid choice(1/2/3) :");
            choice= validatePositiveInt();
        }
        scanner.nextLine();
        inputDetails(choice);

    }

    private static void inputDetails(int choice) {
        System.out.print("Enter Policy Holder Name: ");
        String name= scanner.nextLine();
        System.out.print("Enter Sum Assured: ");
        double sumAssured= validatePositiveDouble();
        System.out.print("Enter Policy Duration in years: ");
        int policyDuration= validatePositiveInt();

        InsurancePolicy p=null;

        switch (choice){
            case 1:{
                p=new LifeInsurancePolicy(name,sumAssured,policyDuration);
                break;
            }
            case 2:{
                p=new HealthInsurancePolicy(name,sumAssured,policyDuration);
                break;
            }
            case 3:{
                p=new VehicleInsurancePolicy(name,sumAssured,policyDuration);
                break;
            }
        }
        policies[index++]=p;
        System.out.println();
        System.out.println(p);

    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("Welcome to Insurance Application !! ");
        System.out.println("1. Create Policy");
        System.out.println("2. Calculate and Display premium");
        System.out.println("3. Apply for claim");
        System.out.println("4. Display details of a policy");
        System.out.println("5. Exit");
        System.out.print("Enter your Choice: ");
    }

}