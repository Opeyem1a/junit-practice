package UsabilityTestingQuestions.parsons;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SumAverageProgramTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    public static String[] getTestData(int[] input) {
        String[] testData = new String[input.length];
        for (int i = 0; i < input.length; i++)
            testData[i] = Integer.toString(input[i]);
        return testData;
    }

    @Test
    public void OutputFollowsFormat() {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        provideInput(String.join(System.lineSeparator(), getTestData(input)));
        SumAverageProgram.main(new String[0]);
        String actual = getOutput();

        double sum = 0;
        for (int j : input) sum += j;
        double average = sum / input.length;
        String expected = String.format("Sum = %.2f Average = %.2f", sum, average);

        assertTrue(actual.contains(expected), "Your program does not match the output. Check the limits of your while loop");
    }
}