package UsabilityTestingQuestions;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class BMITest {
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
    public void OutputFollowsFormat() {
        provideInput(String.join(System.lineSeparator(), "1.6", "80"));
        BMIMethodTime.main(new String[0]);
        String actual = getOutput();
        String format = "Your BMI is:";

        assertTrue(actual.contains(format), "Your program does not match the output format. Try to check whether your output matches the sample.");
    }

    @Test
    public void BMIMethodWorks() {
        double height = 2.0;
        int weight = 100;
        double actual = BMIMethodTime.bmiCalc(height, weight);
        double expected = weight / Math.pow(height, 2);

        assertEquals(expected, actual, "Your BMI method does not calculate the correct BMI.");
    }

    @Test
    public void BMIMethodNegativeValues() {
        double height = -1.9;
        int weight = -70;
        double actual = BMIMethodTime.bmiCalc(height, weight);
        double expected = 0;

        assertEquals(expected, actual, "Your BMI method does not account for all cases");
    }
}