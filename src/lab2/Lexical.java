/* Lab Exercise 3
 * Author: Conor Nee
 * 
 * Purpose: Use BufferedReader and StringTokenizer to perform lexical analysis on a test data file.
 */

package lab2;

import java.io.*;
import java.util.*;

public class Lexical {

	public static void main(String[] args) {

		//Initializes filename to given data file
		String filename = "PROGSAMP.DAT";
		FileInputStream inFile;
		BufferedReader bufFinReader;
		//total and buffer initialized as blank strings.
		String totality = "";
		String buffer = "";
		int count = 0;

		// try-catch for FileNotFound
		try {
			// Initialize the FileInputStream
			inFile = new FileInputStream(filename);
			bufFinReader = new BufferedReader(new InputStreamReader(inFile));
		} catch (FileNotFoundException e) {
			System.out.print("Error opening file " + filename);
			return; // Can't continue execution
		}

		// try-catch for IOException
		try {
			//escape is null because that's the final return value of readLine
			while (buffer != null) {
				//concats the buffer onto the full string, buffer grabs a line at a time from the reader
				totality += (buffer);
				buffer = bufFinReader.readLine();
			}

			//tokenizes full string with normal delimiters 
			StringTokenizer sorter = new StringTokenizer(totality);

			//continues counting and printing until there are no more tokens
			while (sorter.hasMoreTokens()) {
				count++;
				System.out.println(count + " : " + sorter.nextToken());
			}

			//closes both streams
			bufFinReader.close();
			inFile.close();
		}

		catch (IOException ej) {
			System.out.print("IO error.");
			return;
		}

	}
}
