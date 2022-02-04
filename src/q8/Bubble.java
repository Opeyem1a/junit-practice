package q8;

//You are working on a software animation for an object that grows and pops.
// Write a Java class called Bubble that has attributes called size of type double whose initial value is set by the input parameter of the constructor and isPopped whose initial value is false.
// The class should also have an accessor and mutator method for each attribute, as well as a toString() method that summarizes the attribute values.
// The program should also have a test class called TestPopping that creates an object of Bubble, grow it to twice its original size, pop it, and display the object's details.

public class Bubble {
    private double size;
    private boolean isPopped;
    public Bubble(double a)
    {
        size = a;
        isPopped = false;
    }
    public String toString()
    {
        String out = "size: " + size;
        out = out + " isPopped: "  + isPopped;
        return out;
    }
    public void setSize(double a)
    {
        size = a;
    }
    public double getSize()
    {
        return size;
    }
    public void setIsPopped(boolean a)
    {
        isPopped = a;
    }
    public boolean getIsPopped()
    {
        return isPopped;
    }

}
