package UsabilityTestingQuestions.parsons;

/*
 Nested Loops - Hard Q2
 Print: the following pattern, using nested loops.
        1 2 3 4
        1 2 3 4
        1 2 3 4
        1 2 3 4

 */

public class RepeatTheRepeat {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 4; j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }
}
