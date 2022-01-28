package q5;

import java.io.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class Question5Test {

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
    public void OutputCheckArmStrongNums() {

        int[] armStrongNums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748};
        
        for(int i = 0; i < armStrongNums.length; i++ ){
            String expectedOut = armStrongNums[i] + " is an Armstrong Number!" + System.lineSeparator();
            provideInput(armStrongNums[i] + System.lineSeparator());
            Question5.main( new String[0] );
            String actualOutput = getOutput();
            actualOutput = actualOutput.split(System.lineSeparator())[1 + i * 2] + System.lineSeparator();
            assertEquals(expectedOut, actualOutput, "The output is different");
        }

    }

    @Test
    public void OutputCheckNotArmStrongNums() {

        int[] notArmStrongNums = {10, 234, 534, 2452};
        for(int i = 0; i < notArmStrongNums.length; i++ ){
            String expectedOut = notArmStrongNums[i] + " is NOT an Armstrong Number!" + System.lineSeparator();
            provideInput(notArmStrongNums[i] + System.lineSeparator());
            Question5.main( new String[0] );
            String actualOutput = getOutput();
            actualOutput = actualOutput.split(System.lineSeparator())[1 + i * 2] + System.lineSeparator();
            assertEquals(expectedOut, actualOutput, "The output is different");
        }

    }
}