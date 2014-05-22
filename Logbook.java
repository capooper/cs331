//--------------------------------------------------------------------
//
//  Laboratory 1                                        Logbook.jshl
//
//  Definitions for the Logbook ADT
//
//  The student is to complete all missing or incomplete method 
//     implementations for this class
//
//--------------------------------------------------------------------

import java.io.*;       // For reading (keyboard) & writing (screen)
import java.util.*;                 // For GregorianCalendar class

class Logbook
{
    // Data members
    private int logMonth,                   // Logbook month
                logYear;                    // Logbook year
    private int[]
                entry = new int[31];        // Array of Logbook entries
    private GregorianCalendar logCalendar;  // Java's built-in Calendar

    // Constructor
    public Logbook ( int month, int year )
    // Creates an empty logbook for the specified month and year.
    {

    }

    // Methods
    public void putEntry ( int day, int value )
    // Stores entry for the specified day.
    {

    }

    public int getEntry ( int day )
    // Returns entry for the specified day.
    {

    }

    public int month ( )
    // Returns the logbook month.
    {

    }

    public int year ( )
    // Returns the logbook year.
    {

    }

    public int daysInMonth ( )
    // Returns the number of days in the logbook month.
    {

    }

    // Facilitator (helper) method  
    private boolean leapYear ( )
    // If the logbook month occurs during a leap year, then returns true.
    // Otherwise, returns false.
    {

    }

    //--------------------------------------------------------------------
    //
    //                        In-lab operations
    //
    //--------------------------------------------------------------------

    private int dayOfWeek ( int day )
    // Returns the day of the week corresponding to the specified day.
    {

    }

    public void displayCalendar ()
    // Displays a logbook using the traditional calendar format.
    {

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