package UsabilityTestingQuestions.parsons;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PerfektKyoobTest {
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

    public static String getPerfectCube(int n) {
        int nn = n;
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n = n / 10;
        }
        if (result == (int) Math.pow(nn, 1 / 3.0))
            return nn + " is a Perfect Cube!";
        else
            return nn + " is NOT a Perfect Cube!";
    }

    @Test
    public void OutputFollowsFormat() {
        int n = 512;
        provideInput(String.valueOf(n));
        PerfektKyoob.main(new String[0]);
        String actual = getOutput();
        StringBuilder format = new StringBuilder();
        format.append(getPerfectCube(n)).append(System.lineSeparator());
        assertTrue(actual.contains(format.toString()), "Your program does not match the expected output. Check the limits of your while loop.");
    }
}