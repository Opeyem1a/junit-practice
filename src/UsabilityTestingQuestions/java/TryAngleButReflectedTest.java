package UsabilityTestingQuestions.java;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TryAngleButReflectedTest {
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

    public static String printPattern(int n) {
        if (n < 0) {
            return "Number must be positive" + System.lineSeparator();
        }
        StringBuilder pattern = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i + 1); j++)
                pattern.append(j).append(" ");
            pattern.append(System.lineSeparator());
        }
        return pattern.toString();
    }

    @Test
    public void outputFollowsFormat() {
        int input = 5;
        provideInput(String.valueOf(input));
        TryAngleButReflected.main(new String[0]);
        String actual = getOutput();
        String format = printPattern(input);
        assertTrue(actual.contains(format), "Your program does not match the output format. Try to ensure your output matches the sample.");
    }

    @Test
    public void printPatternZeroLines() {
        int input = 0;
        TryAngleButReflected.printPattern(input);
        String actual = getOutput();
        String expected = printPattern(input);

        assertEquals(expected, actual, "Your printPattern method does not work with 0 lines.");
    }

    @Test
    public void printPatternNegativeLines() {
        int input = -1;
        TryAngleButReflected.printPattern(input);
        String actual = getOutput();
        String expected = printPattern(input);

        assertEquals(expected, actual, "Your printPattern method does not work with negative numbers.");
    }
}
