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

public class OneToThreeTest {
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

    @Test
    public void lengthStringOneInput() {
        String input = "Hello";
        int actual = OneToThree.lengthString(input);
        int expected = input.length();

        assertEquals(expected, actual, "Your lengthString method does not work with one input");
    }

    @Test
    public void lengthStringTwoInputs() {
        String input = "Hello", input2 = "World";
        int actual = OneToThree.lengthString(input, input2);
        int expected = (input + input2).length();

        assertEquals(expected, actual, "Your lengthString method does not work with two inputs");
    }

    @Test
    public void lengthStringThreeInputs() {
        String input = "Hello", input2 = "World", input3 = "Again";
        int actual = OneToThree.lengthString(input, input2, input3);
        int expected = (input + input2 + input3).length();

        assertEquals(expected, actual, "Your lengthString method does not work with three inputs");
    }

    @Test
    public void lengthStringEmptyInput() {
        String input = "";
        int actual = OneToThree.lengthString(input);
        int expected = input.length();

        assertEquals(expected, actual, "Your lengthString method does not work with empty strings");
    }
}
