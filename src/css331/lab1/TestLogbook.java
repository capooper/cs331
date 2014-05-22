//--------------------------------------------------------------------
//
//  Laboratory 1                                     TestLogbook.java

//
//  Test program for the operations in the Logbook ADT.
//
//--------------------------------------------------------------------
package css331.lab1;
import java.io.*;       // For reading (keyboard) & writing (screen)

class TestLogbook
{
    public static void main( String args[]) throws IOException 
    {
        int month,              // Input month
            year,               // Input year
            day,                // Input day
            entry,              // Input logbook entry
            dofw,               // Day of the week
            j;                  // Loop counter
        boolean stop = false;   // Signals end of test
        char ans;               // Y/N answer for report of test 1
        Logbook testLog;

        //-----------------------------------------------------------------
        // Initialize reader and tokenizer for the input stream -
        //   for reading 'tokens' (namely the montth & year) 
        //   input from the keyboard.  
        //
        // Initialize reader - To read a character at a time
        InputStreamReader reader = new InputStreamReader(System.in);
        
        // Initialize the tokenizer -
        //   To read tokens (words and numbers separated by whitespace)
        StreamTokenizer tokens = new StreamTokenizer(reader);
        
        // Note: use the nextToken( ) method to step through a stream of tokens. 
        //   Use tokenizer's nval to obtain the number read.
        //   Since nval is of type double, cast it to an int.
        
        // Create a logbook (not used in Test 4).
        System.out.print("\n\nEnter the month and year for the logbook month: ");
        tokens.nextToken(); 
        month = (int)tokens.nval; 
        tokens.nextToken( );
        year = (int)tokens.nval;
        testLog = new Logbook(month,year);

        // Test 1 : Tests the month, year, and daysInMonth operations.
        System.out.println("Month : " + testLog.month());
        System.out.println("Year  : " + testLog.year());
        System.out.println("# days in month : " + testLog.daysInMonth());

        System.out.print("Another Logbook (Y/N)?  ");
        ans = (char)System.in.read();
        if (ans == 'N' || ans == 'n') stop = true;

        while ( !stop )           // repeat if desired
        {
            System.out.print("\n\nEnter the month and year for the logbook month: ");
            tokens.nextToken(); 
            month = (int)tokens.nval; 
            tokens.nextToken( );
            year = (int)tokens.nval;
            testLog = new Logbook(month,year);

            // Test 1 : Tests the month, year, and daysInMonth operations.
            System.out.println("Month : " + testLog.month());
            System.out.println("Year  : " + testLog.year());
            System.out.println("# days in month : " + testLog.daysInMonth());

            System.out.print("Another Logbook (Y/N)?  ");
            ans = (char)System.in.read();
            if (ans == 'N' || ans == 'n') stop = true;
        }

        // Test 2 : Tests the putEntry and getEntry operations.
        stop = false;
        while ( !stop )
        {
            System.out.print("\nEnter day and entry (0 0 to exit Test 2) : ");
            tokens.nextToken(); 
            day = (int)tokens.nval; 
            tokens.nextToken( );
            entry = (int)tokens.nval;

            if ( day != 0 )
            {
                testLog.putEntry(day, entry);
                System.out.println("Logbook:");
                for ( day = 1 ; day <= testLog.daysInMonth() ; day++ )
                {
                    
                    System.out.print(day + " " + testLog.getEntry(day) + "\t");
                    if ( day % 5 == 0 )
                        System.out.println( );
                }
                System.out.println( );
            }
            else stop = true;
        }

        // Test 3 : Tests the calendar operation.
          System.out.println( );
          testLog.displayCalendar();
          System.out.println( );

        // Test 4 : Tests the overloaded constructor and putEntry
        //          operations.
        //4
        //4  Logbook thisMonth = new Logbook( );
        //4  System.out.println("\nLogbook for this month:");
        //4  System.out.println("Month : " + thisMonth.month());
        //4  System.out.println("Year  : " + thisMonth.year());
        //4  System.out.println("# days in month : " + thisMonth.daysInMonth());
        //4  thisMonth.putEntry(100);
        //4  for ( day = 1 ; day <= thisMonth.daysInMonth() ; day++ )
        //4  {
        //4      System.out.print(day + " " + thisMonth.getEntry(day) + "\t");
        //4      if ( day % 5 == 0 )
        //4         System.out.println( );
        //4  }
        //4  System.out.println( );

        //5  // Test 5 : Tests the plus operation.  
        //5
        //5  Logbook logDay100 = new Logbook(month, year),
        //5          logDay200 = new Logbook(month, year);
        //5
        //5  System.out.println("\nLoading logbooks logDay100 and logDay200");
        //5  for ( day = 1 ; day <= logDay100.daysInMonth() ; day++ )
        //5  {
        //5     logDay100.putEntry(day,100*day);
        //5     logDay200.putEntry(day,200*day);
        //5  }
        //5
        //5  System.out.println( );
        //5  System.out.println("Logbook logDay100:");
        //5  logDay100.displayCalendar( );
        //5
        //5  System.out.println( );
        //5  System.out.println("Logbook logDay200:");
        //5  logDay200.displayCalendar( );
        //5  System.out.println( );
        //5  
        //5  logDay100.plus(logDay200);            
        //5
        //5  System.out.println("Combined logbooks:");
        //5  logDay100.displayCalendar( );
        //5  System.out.println( );

    } // main( )
    
} // class TestLogbook