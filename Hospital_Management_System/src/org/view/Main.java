package org.view;

import org.controller.Hospital;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void userDecision(int userChoice){
        switch (userChoice){
            case 1 : {
                Hospital.emergency();
                break;
            }
            case 2 : {
                Hospital.opd();
                break;
            }
            case 3 : {
                Hospital.billingCounter();
                break;
            }
            case 4 : {
                Hospital.test();
                break;
            }
            case 5 : {
                Hospital.medicines();
                break;
            }
            default : {
                System.out.println("Invalid Input..");
            }

        }
    }

    public static void main(String[] args) {
        String repeat = null;
        System.err.println("************Welcome to my Hospital*************");
        do {
            System.out.println("Please enter the Patient details : ");
            Hospital.admission();
            System.out.println("Do you want to add more Patients then type \"YES\" or else press any other key ");
            repeat=sc.next();
        }while(repeat.equalsIgnoreCase("yes"));

        String operationChoice = null;

        do {
            System.out.println("How may I help You?");
            System.out.println("Press 1 for Emergency");
            System.out.println("Press 2 for OPD");
            System.out.println("Press 3 for Billing");
            System.out.println("Press 4 for Test");
            System.out.println("Press 5 for Medicines");
            int userChoice = sc.nextInt();
            userDecision(userChoice);
            System.out.println("Do you want to continue then type \"YES\" or else press any other key");
            operationChoice=sc.next();
        }while(operationChoice.equals("yes"));
    }
}