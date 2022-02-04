package UsabilityTestingQuestions;
// Methods - Defining Methods - Hard Q1

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

