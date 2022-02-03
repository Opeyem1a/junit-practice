package q7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CountArTest {
    @Test
    public void methodAll0s(){
        int[] expected = {10, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] actual = CountAr.countThisPlease(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        assertArrayEquals(expected, actual, "Your program does not count all the 0s");
    }
    @Test
    public void methodTestRandomNums(){
        int[] expected = new int[10];
        int[] passed = new int[10];
        for(int x = 0; x <10; x++){
            int n = (int)(Math.random()*10);
            passed[x] = n;
            expected[n]++;
        }
        int[] actual = CountAr.countThisPlease(passed);

        assertArrayEquals(expected, actual, "A randomly generated set of numbers between 0-9 failed your test");
    }
    @Test
    //if this is the only test passed probably hard coded, but don't know how to work with test results in code
    public void testExample(){
        int[] expected = {0, 1, 0, 2, 3, 1, 0, 2, 0, 3};
        int[] actual = CountAr.countThisPlease(new int[]{ 1, 3, 4, 5, 4, 9, 4, 9, 9, 7, 7, 3 });
        assertArrayEquals(expected, actual, "The example code did not come back right");
    }
    @Test
    public void methodOutOfBoundsException(){

        try{
            //noinspection ResultOfMethodCallIgnored
            CountAr.countThisPlease(new int[]{10, 10, 10, 9, 2,3,4,5,1,7, 5});
            fail("Returning array is larger than it should be");
        }
        catch (IndexOutOfBoundsException e){
            assertTrue(true);
        }
    }
    @Test
    public void methodPassingAnArrayLargerThan10(){
        int[] expected = {1, 2, 3, 0, 1, 1, 1, 1, 0, 1};
        int[] actual = CountAr.countThisPlease(new int[]{2, 2, 4, 2, 1, 9, 5, 1, 6, 0, 7});
        assertArrayEquals(expected, actual, "Your program did not count all the passed numbers");
    }

}
