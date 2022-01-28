package q4;

import java.io.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class Question4Test {

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
    public void OutputCheckAD() {

        int[] input1 = { -123, 0, 1, 2, 144, 1236 }; // hoursworked

        for (int i = 0; i < input1.length; i++) {
            provideInput(input1[i] + System.lineSeparator() + "True" + System.lineSeparator());
            Question4.main(new String[0]);
            String actualOutput = getOutput();
            actualOutput = actualOutput.split(System.lineSeparator())[2 + i * 3].trim() + System.lineSeparator();

            int year = input1[i];
            String expectedOut = year + " AD - 1 = " + (year - 1) + " AD" + System.lineSeparator();

            assertEquals(expectedOut, actualOutput, "The output is different for AD");
        }

    }

    @Test
    public void OutputCheckBC() {

        int[] input1 = { -123, 0, 1, 2, 144, 1236 }; // hoursworked

        for (int i = 0; i < input1.length; i++) {
            provideInput(input1[i] + System.lineSeparator() + "False" + System.lineSeparator());
            Question4.main(new String[0]);
            String actualOutput = getOutput();
            actualOutput = actualOutput.split(System.lineSeparator())[2 + i * 3].trim() + System.lineSeparator();

            int year = input1[i];
            String expectedOut = year + " BC - 1 = " + (year + 1) + " BC" + System.lineSeparator();

            assertEquals(expectedOut, actualOutput, "The output is different for BC");
        }
    }

}
