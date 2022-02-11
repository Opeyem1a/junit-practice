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
        // Create expected string
        double expectedCases = Math.pow( 1+0.3, 30 ) * 5;
        String expected = "Num cases of infections in 30 days is " + expectedCases + " people" ;
        //Call the main method here
        Javademic.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        String outputDays = actualOutput.split("in")[2].trim();
        outputDays = outputDays.split("days")[0].trim();
        String outputCases = actualOutput.split("is")[1].trim();
        outputCases = outputCases.split("people")[0].trim();
        //Compare
        try {
            assertEquals(expectedCases, Double.parseDouble(outputCases), "The number of cases is different then expected");
        }catch(Exception e){
            fail("Could not find the number of cases in your output string");
        }
        assertEquals("30", outputDays, "The number of days is different then expected");
        assertTrue(actualOutput.contains(expected), "Output format does not match example");
    }
}
