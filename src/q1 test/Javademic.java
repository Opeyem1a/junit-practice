
public class Javademic
{
    public static void main( String[] args )
    {
        double r = 0.3;
        int t = 30;
        int x0 = 5;
        double quantity = Math.pow( 1+r, t );
        double xt = quantity * x0;
        System.out.println( "Num cases of infections in " + t + " days is " + xt + " people" );
    }
}

