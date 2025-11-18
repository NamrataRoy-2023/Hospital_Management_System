package org.controller;

import org.model.InsufficientFundsException;
import org.model.Patient;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Hospital {

    static Scanner sc = new Scanner(System.in);

    static ArrayList <Patient> al = new ArrayList<Patient>();

    //ADMISSION METHOD TO ADMIT PATIENTS
    public static void admission(){
        System.out.println("Provide your Bank Balance : ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.println("Provide your Name : ");
        String name = sc.nextLine();

        System.out.println("Provide your Age : ");
        byte age = sc.nextByte();

        System.out.println("Provide your Phone Number : ");
        double phone = sc.nextDouble();
        sc.nextLine();

        System.out.println("Provide your Address : ");
        String address = sc.nextLine();

        System.out.println("Provide your Gender : ");
        char gender = sc.next().charAt(0);

        boolean added = al.add(new Patient(amount,name,age,phone,address,gender));
        System.out.println(added? "Patient Admitted" : "Not Admitted");
    }

    public static Patient checkPhone(long phone){
        for(Patient p : al ){
            if(p.getPhone()==phone){
                return p;
            }
        }
        return  null;
    }

    //FOR EMERGENCY CASES OF PATIENTS
    public static void emergency(){
        System.out.println("Provide your registered Mobile Number : ");
        long phone = sc.nextLong();
        Patient p = checkPhone(phone);
        if(p!=null) {
            System.out.println("What emergency do you have?");
            System.out.println("Press 1 for Orthopedic");
            System.out.println("Press 2 for Cardiologist");

            int emergencyChoice = sc.nextInt();

            switch (emergencyChoice) {
                case 1: {
                    emergencyOrtho(p);
                    break;
                }
                case 2: {
                    emergencyCardio(p);
                    break;
                }
                default: {
                    System.out.println("Invalid Choice");
                }
            }
        }
        else {
            System.out.println("Invalid Mobile Number !");
            emergency();
        }
    }

    //EMERGENCY TREATMENT FOR ORTHO PATIENTS
    public static void emergencyOrtho(Patient p){
        System.out.println("Please bring your Patient" + p.getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("Operation Successful");
    }

    //EMERGENCY TREATMENT FOR CARDIO PATIENTS
    public static void emergencyCardio (Patient p){
        System.out.println("Please bring your Patient"+p.getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("Operation Successful");
    }

    //OPD TREATMENT FOR CARDIO PATIENTS
    public static void opd(){
        System.out.println("Provide your registered Mobile Number : ");
        long phone = sc.nextLong();
        Patient p = checkPhone(phone);
        if(p!=null) {
            System.out.println("Which doctor you want to visit?");
            System.out.println("Press 1 for Medicine Specialist");
            System.out.println("Press 2 for Orthopedic");
            System.out.println("Press 3 for Cardiologist");
            System.out.println("Press 4 for Neurologist");

            int opdChoice = sc.nextInt();

            switch (opdChoice) {
                case 1: {
                    medicine_Specialist(p);
                    break;
                }
                case 2: {
                    orthopedic(p);
                    break;
                }
                case 3: {
                    cardiologist(p);
                    break;
                }
                case 4: {
                    neurologist(p);
                    break;
                }
                default: {
                    System.out.println("Invalid Choice");
                }
            }
        }
        else {
            System.out.println("Invalid Mobile Number !");
            opd();
        }
    }

    //Medicine_Specialist
    public static void medicine_Specialist(Patient p){
        System.out.println("Bring the Patient" + p.getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("Treatment done have medicines regularly");
    }

    //ORTHOPEDIC
    public static void orthopedic(Patient p){
        System.out.println("Bring the Patient" + p.getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("Treatment done have medicines regularly");
    }

    //CARDIOLOGIST
    public static void cardiologist(Patient p){
        System.out.println("Bring the Patient" + p.getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("Treatment done have medicines regularly");
    }

    //NEUROLOGIST
    public static void neurologist(Patient p){
        System.out.println("Bring the Patient" + p.getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("Treatment done have medicines regularly");
    }

    //BILLING DESK METHODS
    public static void  billingCounter(){
        System.out.println("Provide your registered Mobile Number : ");
        long phone = sc.nextLong();
        Patient p = checkPhone(phone);
        if(p!=null) {
            System.out.println("Welcome to the billing desk.Please choose your mode of payment");
            System.out.println("Press 1 for Cash");
            System.out.println("Press 2 for UPI");
            System.out.println("Press 3 for Credit Card / Debit Card");
            System.out.println("Press 4 for Cheque");

            int paymentOption = sc.nextInt();

            switch (paymentOption) {
                case 1: {
                    cash(p);
                    break;
                }
                case 2: {
                    upi(p);
                    break;
                }
                case 3: {
                    card(p);
                    break;
                }
                case 4: {
                    cheque(p);
                    break;
                }
                default: {
                    System.out.println("Invalid Choice");
                }
            }
        }
        else {
            System.out.println("Invalid Mobile Number !");
            billingCounter();
        }

    }

    //CASH PAYMENT METHOD
    public static void cash(Patient p){
        double billAmount = sc.nextDouble();
        System.out.println("Please provide the Amount : ");
        if (p.getAmount() < billAmount){
            try {
                throw new InsufficientFundsException("The Amount in your Account is Insufficient");
            }catch (InsufficientFundsException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Payment done Successfully");
        }
    }

    //UPI PAYMENT METHOD
    public static void upi(Patient p){
        double billAmount = sc.nextDouble();
        System.out.println("Please provide the Amount : ");
        if (p.getAmount() < billAmount){
            try {
                throw new InsufficientFundsException("The Amount in your Account is Insufficient");
            }catch (InsufficientFundsException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Payment done Successfully");
        }
    }

    //CARD PAYMENT METHOD
    public static void card(Patient p){
        double billAmount = sc.nextDouble();
        System.out.println("Please provide the Amount : ");
        if (p.getAmount() < billAmount){
            try {
                throw new InsufficientFundsException("The Amount in your Account is Insufficient");
            }catch (InsufficientFundsException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Payment done Successfully");
        }
    }

    //CHEQUE PAYMENT METHOD
    public static void cheque(Patient p){
        double billAmount = sc.nextDouble();
        System.out.println("Please provide the Amount : ");
        System.out.print("Payment Processing");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

        }
        if (p.getAmount() < billAmount){
            try {
                throw new InsufficientFundsException("The Amount in your Account is Insufficient");
            }catch (InsufficientFundsException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Payment done Successfully");
        }
    }


    //METHOD TO PERFORM TEST
    public static void test(){
        System.out.println("Provide your registered Mobile Number : ");
        long phone = sc.nextLong();
        Patient p = checkPhone(phone);

        if (p!=null){
            System.out.println("Please provide the Sample");
            String sample = sc.next();
            if (sample.equalsIgnoreCase("urine")){
                System.out.println("Urine Sample Received.");
            }
            else if (sample.equalsIgnoreCase("blood")){
                System.out.println("Blood Sample Received.");
            }
            else if (sample.equalsIgnoreCase("stool")){
                System.out.println("Stool Sample Received.");
            }
            else if (sample.equalsIgnoreCase("hair")){
                System.out.println("Hair Sample Received.");
            }
        }
        else {
            System.out.println("Invalid Mobile Number !");
            test();
        }
    }

    //METHOD TO TAKE MEDICINES
    public static void medicines(){
        System.out.println("Provide your registered Mobile Number : ");
        long phone = sc.nextLong();
        Patient p = checkPhone(phone);

        if (p!=null){
            System.out.println("Specify your Disease.");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
            System.out.println("Medicines Provided.");

        }else {
            System.out.println("Invalid Mobile Number !");
            medicines();
        }
    }



}
