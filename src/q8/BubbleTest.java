package q8;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleTest {

    boolean alreadyFailed = false;

    @Test
    public void testForConstructor(){
        try{
            Class<?> cls = Class.forName("q8.Bubble");
            Constructor<?>[] constructorList = cls.getConstructors();
            if(constructorList.length!=1) {
                alreadyFailed = true;
                fail("You do not have 1 constructor");
            }

            if(!alreadyFailed) {
                Class<?>[] pl = constructorList[0].getParameterTypes();
                if (pl.length != 1) {
                    alreadyFailed = true;
                    fail("You need 1 parameter in your constructor");
                }
                boolean contains = pl[0].toString().contains("double");
                if (!contains)
                    alreadyFailed = true;
                assertTrue(contains);
            }
        }
        catch(ClassNotFoundException e){
            System.err.println(e.getMessage());
            fail();
        }

    }
    //group this with the above test, so if the constructor isn't the appropraite parameters then it won't crash
    double[] sizes = {23, 14.2, Double.MAX_VALUE};
    @RepeatedTest(3)
    public void repeatedTestConstructorParameters(RepetitionInfo n){
        if(alreadyFailed){
            fail("Cannot test without proper constructor");
        }
        else {
            Bubble b = new Bubble(sizes[n.getCurrentRepetition() - 1]);
            assertEquals(sizes[n.getCurrentRepetition() - 1], b.getSize(), "Bubble size is not what was passed to the constructor");
            assertFalse(b.getIsPopped(), "Constructor should initialize popped to be false");
        }
    }

    Bubble b = new Bubble(5); //made new bubble for rest of the test
    //in here, make a new test repeated method that randomizes a new set of values for a bubble each time and then calls these current tests as helper methods
    @Test
    public void testGetSize(){
        assertEquals(5, b.getSize());
    }

    @Test
    public void testSetSize(){
        b.setSize(7);
        assertEquals(7, b.getSize(), "does not return the correct size");
    }

    @Test
    public void testSetPopped(){
        b.setIsPopped(true);
        assertTrue(b.getIsPopped());
    }

    @Test
    public void testToString(){
        b.setSize(7.2);
        b.setIsPopped(false);
        String s = "size: 7.2 isPopped: false";
        assertEquals(s, b.toString(), "String format is wrong");
    }
}
