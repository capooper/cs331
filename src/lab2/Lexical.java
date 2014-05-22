package lab2;

import java.io.*;
import java.util.*;

public class Lexical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "PROGSAMP.DAT";
		FileInputStream inFile;
		BufferedReader bufFinReader;
		String totality = "";
		String buffer = "";
		int count = 0;

		try {
			// Initialize the FileInputStream
			inFile = new FileInputStream(filename);
			bufFinReader = new BufferedReader(new InputStreamReader(inFile));
		} catch (FileNotFoundException e) {
			System.out.print("Error opening file " + filename);
			return; // Can't continue execution
		}

		try {
			while (buffer != null) {
				totality += (buffer);
				buffer = bufFinReader.readLine();
			}

			StringTokenizer sorter = new StringTokenizer(totality);

			System.out.println("Has tokens? : " + sorter.countTokens());
			while (sorter.hasMoreTokens()) {
				count++;
				System.out.println(count + " : " + sorter.nextToken());
			}

			bufFinReader.close();
			inFile.close();
		}

		catch (IOException ej) {
			System.out.print("IO error.");
			return;
		}

	}
}
