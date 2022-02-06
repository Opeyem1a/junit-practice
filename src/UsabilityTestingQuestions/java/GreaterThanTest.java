package UsabilityTestingQuestions.java;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class GreaterThanTest {
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

    public int greaterNum(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    @Test
    public void OutputFollowsFormat() {
        provideInput(String.join(System.lineSeparator(), "5", "10"));
        GreaterThan.main(new String[0]);
        String actual = getOutput();
        String format = "The greater number is 10" + System.lineSeparator();

        assertTrue(actual.contains(format), "Your program does not match the output format. Try to ensure your output matches the sample.");
    }

    @Test
    public void greaterNumMethodWorks() {
        int a = 500, b = 1;
        int actual = GreaterThan.greaterNum(a, b);
        int expected = greaterNum(a, b);

        assertEquals(expected, actual, "Your greaterNum method does not return the correct value");
    }

    @Test
    public void greaterNumMethodNegativeValues() {
        int a = -50, b = -3734;
        int actual = GreaterThan.greaterNum(a, b);
        int expected = greaterNum(a, b);

        assertEquals(expected, actual, "Your greaterNum method does not work with negative numbers");
    }

    @Test
    public void greaterNumMethodEqualValues() {
        int a = 12, b = a;
        int actual = GreaterThan.greaterNum(a, b);
        int expected = greaterNum(a, b);

        assertEquals(expected, actual, "Check the boundaries on your greaterNum method");
    }
}
