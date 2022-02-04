package UsabilityTestingQuestions;

import java.util.Random;

public class Cryptic {
    public static void main(String[] args) {
        Random gen = new Random();
        int crypt = gen.nextInt(90000000) + 10000000;
        int second = gen.nextInt(9) + 1;
        int encrypt = crypt * second;
        System.out.println(crypt + " has been encrypted into " + encrypt);
    }
}
