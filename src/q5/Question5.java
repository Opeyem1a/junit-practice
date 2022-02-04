package q5;

import java.util.Scanner;

// Write a program that asks the user for a number and determines if it is an "Armstrong Number", i.e the sum of its own digits raised to the power of the number of digits is equal to the number itself. (Eg: 8208 = 84 + 24 + 04 + 84). Hint: You need one loop to check how many digits are in the number, and another to check whether it is an Armstrong number.

public class Question5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = input.nextInt();
        int nn = n;
        int numDigits = 0;
        int result = 0;
        while (nn > 0) {
            numDigits++;
            nn = nn / 10;
        }
        nn = n;
        while (n > 0) {
            result += Math.pow(n % 10, numDigits);
            n = n / 10;
        }
        if (result == nn)
            System.out.println(nn + " is an Armstrong Number!");
        else
            System.out.println(nn + " is NOT an Armstrong Number!");
    }
}
