package q6;

import java.util.Scanner;

public class RightPrime {
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a number" );
        int num = input.nextInt();
        System.out.println( isRightPrime(num));
    }
    public static boolean isRightPrime( int num )
    {
        while( num > 0 )
        {
            int factors = 0;
            for( int i = 1; i <= num; i++ )
                if( num % i == 0 )
                    factors++;
            if( factors != 2 )
                return false;
            num /= 10;
        }
        return true;
    }

}