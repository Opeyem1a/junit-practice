package q4;

import java.util.Scanner;
public class Question4
{
   public static void main( String [] args )
   {
      Scanner input = new Scanner( System.in );
      System.out.println("Enter a year: ");
      int year = input.nextInt();
      System.out.println("Is it AD or BC? (Enter true for AD and false for BC) ");
      boolean ad = input.nextBoolean();
      if( ad )
         System.out.println(year + " AD - 1 = " + ( year - 1 ) + " AD ");
      else
         System.out.println(year + " BC - 1 = " + ( year + 1 ) + " BC ");
   }
}

