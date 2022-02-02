import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JavademicTest {
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
    public void OutputCheck(){
        int expectedCases = 13100;
        //Call the main method here
        Javademic.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        actualOutput = actualOutput.replaceAll("[^0-9.]", "");
        String timeOutput = actualOutput.substring(0,2);
        String timeExpected = "30";
        actualOutput = actualOutput.substring(2);
        int actualCases = (int) Math.round(Double.parseDouble(actualOutput));
        //Compare
        assertEquals(expectedCases, actualCases, "The number of cases is different");
        assertEquals(timeExpected, timeOutput, "The number of days is different then expected");
    }
}
