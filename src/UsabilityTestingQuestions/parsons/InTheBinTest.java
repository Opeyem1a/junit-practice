package UsabilityTestingQuestions.parsons;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InTheBinTest {
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

    public static String getBinary(int n) {
        String binary = "";
        int rem = 0;
        while (n > 0) {
            rem = n % 2;
            binary = rem + binary;
            n = n / 2;
        }
        return binary;
    }

    @Test
    public void OutputFollowsFormat() {
        int n = 5;
        provideInput(String.valueOf(n));
        InTheBin.main(new String[0]);
        String actual = getOutput();
        StringBuilder format = new StringBuilder();
        format.append(n).append(" in binary is ").append(getBinary(n));
        assertTrue(actual.contains(format.toString()), "Your program does not match the expected output. Check the limits of your while loop.");
    }
}