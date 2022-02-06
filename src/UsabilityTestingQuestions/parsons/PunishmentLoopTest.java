package UsabilityTestingQuestions.parsons;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PunishmentLoopTest {
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
        String sentence = "Hello World";
        int n = 4;
        provideInput(String.join(System.lineSeparator(), sentence, n + ""));
        PunishmentLoop.main(new String[0]);
        String actual = getOutput();
        StringBuilder format = new StringBuilder();
        for (int i = 0; i < n; i++) {
            format.append(sentence).append(System.lineSeparator());
        }
        assertTrue(actual.contains(format.toString()), "Your program does not match the expected output. Check the limits of your for loops.");
    }
}