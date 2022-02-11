import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PayrollTaxTest {
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

    @RepeatedTest(value = 10)
    public void RandomInputTest() {
        //Generate random input for hours, wage, and taxRate
        Random r = new Random();
        int hours = r.nextInt(60);
        int wage = r.nextInt(100);
        double taxRate = Math.random();
        //Calculate expected output
        double pay, tax, netExpected;
        pay = (hours * wage);
        tax = hours * wage * taxRate;
        netExpected = pay - tax;
        //Create input String
        String input = hours + " " + wage + " " + taxRate + " ";
        provideInput(input);
        //Run main
        PayrollTax.main(new String[0]);
        //Get Output
        String output = getOutput();
        //Get the calculated Pay Amount, Tax Amount, and Net Earnings
        String [] splitOutput = output.split(System.lineSeparator());
        String PayOutput = "";
        String TaxOutput = "";
        String NetOutput = "";
        for(int i = 0; i < splitOutput.length; i++) {
            if(splitOutput[i].contains("Pay"))
                PayOutput = output.split(System.lineSeparator())[i];
            else if(splitOutput[i].contains("Tax"))
                TaxOutput = output.split(System.lineSeparator())[i];
            else if(splitOutput[i].contains("Net"))
                NetOutput = output.split(System.lineSeparator())[i];
        }
        //Get Numbers from Output Strings
        double payActual;
        double taxActual;
        double netActual;
        try {
            payActual = Double.parseDouble(PayOutput.replaceAll("[^0-9.]", ""));
            assertEquals(pay, payActual, String.format("Pay amount not correct: Expected Pay = %.2f, Output Pay = %.2f", pay, payActual));
        } catch (NumberFormatException e) {
            fail("Could not detect the pay in output string, please make sure your output matches the format");
        }
        try {
            taxActual = Double.parseDouble(TaxOutput.replaceAll("[^0-9.]", ""));
            assertEquals(tax, taxActual, String.format("Tax amount not correct: Expected Tax = %.2f, Output Tax = %.2f", tax, taxActual));
        } catch (NumberFormatException e) {
            fail("Could not detect the tax amount in output string, please make sure your output matches the format");
        }
        try {
            netActual = Double.parseDouble(NetOutput.replaceAll("[^0-9.]", ""));
            assertEquals(netExpected, netActual, String.format("Net earnings not correct: Expected Earnings: %.2f, Output Earnings: %.2f", netExpected, netActual));
        } catch (NumberFormatException e) {
            fail("Could not detect net earnings in output string, please make sure your output matches the format");
        }
        //Test to make sure output is the correct format
        String s = "Pay Amount: " + pay + System.lineSeparator() + "Tax Amount: " + tax + System.lineSeparator() + "Net Earnings: " + netExpected + System.lineSeparator();
        assertTrue(output.contains(s), "Make sure your output matches the format");
    }
}