import java.util.Random;

/*
Question:
Make a program that will generate a random <strong>8 digit</strong> number and encrypt it by dividing it by a second
 random <strong>1-digit</strong> number. At the end of the program, print out these numbers.
*/


public class DeCryptic {
    public static void main(String[] args) {
        Random gen = new Random();
        int crypt = gen.nextInt(90000000) + 10000000;
        int key = 1 + gen.nextInt(9);
        int encrypt = crypt / key;
        System.out.println(crypt + " has been encrypted using " + key + " into " + encrypt);
    }
}

