package UsabilityTestingQuestions.java;
// Methods - Defining Methods - Hard Q1
/*
Write a Java Program that asks the user for a double value indicating their height (in metres) and an integer indicating
their weight (in kg) and calculates their BMI. Create a method called bmiCalc that takes the height and weight and
parameters and returns their BMI. Make sure to check whether the parameters passed into the method are positive numbers,
 otherwise return 0. Note: Use printf to ensure the printed BMI value has at most 2 decimals.
        Sample output:
        Enter your height in metres: 1.6
        Enter your weight in kg: 80
        Your BMI is 31.25

*/


import java.util.Scanner;

public class BMIMethodTime {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your height in metres");
        double height = input.nextDouble();
        System.out.println("Enter your weight in kg");
        int weight = input.nextInt();
        System.out.println("Your BMI is: " + bmiCalc(height, weight));
    }

    public static double bmiCalc(double a, int b) {
        if (a < 0 || b < 0) {
            return 0;
        }
        double x = b / Math.pow(a, 2);
        return x;
    }
}

