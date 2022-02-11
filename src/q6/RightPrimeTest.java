package q6;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RightPrimeTest {
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
    //actual tests start now

    @Test
    public void notPrimeAfterTruncationsTest(){
        provideInput("1277");
        RightPrime.main(new String[0]);
        String actual = getOutput();
        String expected = "Enter a number"+System.lineSeparator()+"false"+System.lineSeparator();

        assertEquals(expected, actual, "Your program does not check the prime after multiple truncations");
    }

    @Test
    public void largePrimeTest(){
        provideInput("59393");
        RightPrime.main(new String[0]);
        String actual = getOutput();
        String expected = "Enter a number"+System.lineSeparator()+"true"+System.lineSeparator();

        assertEquals(expected, actual, "Your program does not handle large right truncatable primes");
    }
    @Disabled("Assume all inputs are positive")
    @Test
    public void negativePrimeTest(){
        provideInput("31");
        RightPrime.main(new String[0]);
        String actual = getOutput();
        String expected = "Enter a number"+System.lineSeparator()+"false"+System.lineSeparator();

        assertEquals(expected, actual, "Your program should not accept negative primes");
    }
    //now to test the method
    @Test
    public void methodTest(){
        boolean actual = RightPrime.isRightPrime(797);
        assertTrue(actual, "Your isRightPrime method does not correctly identify a right truncatable prime");
        actual = RightPrime.isRightPrime(593);
        assertTrue(actual, "Your isRightPrime method does not correctly identify a non-right truncatable prime");
    }
}
