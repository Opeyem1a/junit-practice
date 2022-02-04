package q4;

import java.util.Scanner;

//Write a program that asks for a year, and whether it is AD or BC, and subtracts one year from the given year and displays the results. ( Hint: 10 AD - 1 year = 9 AD, and 1 BC - 1 year = 2BC ). For simplicity, assume the user will not enter 0 AD.

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

