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

public class RevUpTest {
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

    public static String revString(String sentence) {
        String result = "";
        for (int i = sentence.length() - 1; i >= 0; i--)
            result += sentence.charAt(i);
        return (result);
    }

    @Test
    public void outputFollowsFormat() {
        String input = "Hello World";
        provideInput(input);
        RevUp.main(new String[0]);
        String actual = getOutput();
        String format = "Your sentence in reverse is: " + revString(input) + System.lineSeparator();
        assertTrue(actual.contains(format), "Your program does not match the output format. Try to ensure your output matches the sample.");

    }

    @Test
    public void revStringEmptyString() {
        String input = "";
        String actual = RevUp.revString(input);
        String expected = revString(input);

        assertEquals(expected, actual, "Your revString method does not work with an empty string.");
    }
}
