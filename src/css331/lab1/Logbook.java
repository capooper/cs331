//--------------------------------------------------------------------
//

//  Laboratory 1                                        Logbook.j
//
//  Definitions for the Logbook ADT
//
//  Implements a Logbook ADT, representing a set of integer entries for a chosen month
//  Edited by Conor Nee
//--------------------------------------------------------------------
package css331.lab1;

import java.io.*;       // For reading (keyboard) & writing (screen)
import java.util.*;                 // For GregorianCalendar class

class Logbook
{
    // Data members
    private int logMonth,                   // Logbook month
                logYear;                    // Logbook year
    private int[] entry = new int[31];      // Array of Logbook entries
    private GregorianCalendar logCalendar;  // Java's built-in Calendar

    // Constructor
    public Logbook ( int month, int year )
    // Creates an empty logbook for the specified month and year.
    // If the month is invalid, the calendar defaults to today's date.
    {
    	//If month is valid, uses given information
    	if ( month <= 12 && month >= 1)
    		logCalendar = new GregorianCalendar(year, month-1, 1);
    	//Defaults to today's date if not
    	else
    		logCalendar = new GregorianCalendar();
    	
    	//Correct by 1
    	logMonth = logCalendar.get(Calendar.MONTH) + 1;
    	logYear = logCalendar.get(Calendar.YEAR);
    	
    	//Initializes the array for the monthly logbook with integer values 0.
    	for (int i = 0; i < daysInMonth(); i++)
    		entry[i] = 0;
    }

    // Methods
    public void putEntry ( int day, int value )
    // Stores entry for the specified day.
    {
    	//Note that array index starts at 0
    	entry[day-1] = value;
    }

    public int getEntry ( int day )
    // Returns entry for the specified day.
    {
    	//Same correction by -1
    	return entry[day-1];

    }

    public int month ( )
    // Returns the logbook month.
    {
    	return logMonth;
    }

    public int year ( )
    // Returns the logbook year.
    {
    	return logYear;
    }

    public int daysInMonth ( )
    // Returns the number of days in the logbook month.
    {
    	//Uses monthly pattern to assign days in the month, odds before 7 have 31 days, evens after have 31 days
    	if ((logMonth % 2 == 1 && logMonth <= 7) || (logMonth >= 8 && (logMonth % 2 == 0)))
    		return 31;
    	else if (!(logMonth == 2))
    		return 30;
    	else if (leapYear())
    		return 29;
    	else
    		return 28;
    	
    }

    // Facilitator (helper) method  
    private boolean leapYear ( )
    // If the logbook month occurs during a leap year, then returns true.
    // Otherwise, returns false.
    {
    	//Inherits gregorian calendar's isLeapYear
    	return logCalendar.isLeapYear(logYear);
    }

    //--------------------------------------------------------------------
    //
    //                        In-lab operations
    //
    //--------------------------------------------------------------------

     private int dayOfWeek ( int day )
    // Returns the day of the week corresponding to the specified day.
    {
    	 //Uses set and inheritance to find the day of the week
    	 logCalendar.set(logYear, logMonth - 1, day);
    	 return logCalendar.get(Calendar.DAY_OF_WEEK)%7;
    }
    public void displayCalendar ()
    // Displays a logbook using the traditional calendar format.
    {
    	// First, determines the dayOfWeek for the 1st to arrange calendar.
    	int count = dayOfWeek(0);
    	//Sets up a temporary variable that calculates how many days remain before the end of the week
    	int rem = count % 7;
    	
         
    		//Quick calendar heading
            System.out.println(logMonth + " / " + logYear);
            System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
            for ( int day = 1; day <= this.daysInMonth(); day++, count++ )
            {
            	//Internal loop for initial alignment of calendar
                while (rem >= 1)
                {
                	System.out.print("\t");
                	rem--;
                }
                
                //Uses count to align calendar instead, as it is initialized to the first day
                if ( count % 7 == 0 )
                    System.out.println( );
                
                System.out.print(day + " " + getEntry(day) + "\t");
              
            }
            System.out.println( );
     
    }

  

    public void putEntry ( int value )
    // Store entry for today.
    {

    }

    public Logbook ( )
    // Default constructor. Creates a logbook for the current month/year.
    {

    }

    public void plus ( Logbook rightLogbook )
    // Combine logbooks.
    {

    }
    
} // class Logbook