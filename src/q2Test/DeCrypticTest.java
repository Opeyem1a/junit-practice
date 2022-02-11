import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

public class DeCrypticTest {
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

    public int getNextLetterIndex(String text, int startIndex) {
        while (Character.isDigit(text.charAt(startIndex)))
            startIndex++;
        return startIndex;
    }

    public int getNextNumberIndex(String text, int startIndex) {
        while (Character.isLetter(text.charAt(startIndex)) || text.charAt(startIndex) == ' ')
            startIndex++;
        return startIndex;
    }

    @RepeatedTest(5)
    public void OutputTesting() {
        //run main & get output
        DeCryptic.main(new String[0]);
        String output = getOutput();
        int i = getNextLetterIndex(output, 0);
        String outputCrypt = output.substring(0, i).trim();
        //Test to make sure crypt is an 8-digit number
        assertEquals(outputCrypt.length(), 8, "Crypt was not 8 digits");
        //Get value of key
        int j = getNextNumberIndex(output, i);
        i = getNextLetterIndex(output, j);
        int outputKey = 0;
        try {
            outputKey = Integer.parseInt(output.substring(j, i).trim());
        } catch (NumberFormatException e) {
            fail("Program was unable to detect an encryption key in output");
        }
        assertEquals(outputKey / 10, 0, "Encryption key was not 1 digit");
        //Get Value of Encrypt
        j = getNextNumberIndex(output, i);
        try {
            int outputEncrypt = Integer.parseInt(output.substring(j).trim());
            int expectedEncrypt = Integer.parseInt(outputCrypt) / outputKey;
            //test if the expected encrypt = actual encrypt
            assertEquals(expectedEncrypt, outputEncrypt, String.format("The output of Encrypt is incorrect: Expected output was %d with key %d, but actual output was %d (Note that your key should be 1 digit)", expectedEncrypt, outputKey, outputEncrypt));
            assertTrue(output.contains(outputCrypt + " has been encrypted using " + outputKey + " into " + expectedEncrypt));
        } catch (NumberFormatException e) {
            fail("Could not detect an encrypt value in your output string");
        }
    }
}

