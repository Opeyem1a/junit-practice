package q5;

import java.util.Scanner;

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
