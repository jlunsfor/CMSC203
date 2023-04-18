import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Class: CMSC203
 * Instructor: Grinberg
 * Description: This program helps determine bonuses handed out 
 * by a company.
 * Due: 17 April 2023
 * I pledge that I have completed the programming assignment independently. I 
 * have not copied the code from a student or any source. I have not given my
 * code to any student.
 * 
 * Jeremy Lunsford
 */

public final class TwoDimRaggedArrayUtility {
	
	public TwoDimRaggedArrayUtility() {
		double[][] data;
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException {
		int lineCount = 0;
		ArrayList<String> doubleLines = new ArrayList<String>();
		try {
			Scanner stdin = new Scanner(file);
			while (stdin.hasNextLine()) {
				String line = stdin.nextLine();
				doubleLines.add(line);
				lineCount++;
			}
			stdin.close();
		}
		catch (FileNotFoundException error) {
			System.out.println (error.toString());
		}
		
		double[][] data = new double[lineCount][];
		int i = 0;
		for (String itemLine: doubleLines) {
			String[] items = itemLine.split(" ");
			int j = 0;
			for (String item: items) {
				double it = Double.parseDouble(item);
				data[i][j] = it;
				j++;
			}
			i++;
		}
		
		return data;
	}
	
	public static void writeToFile(double[][] data, File outputFile) throws IOException {
		try {
			PrintWriter outfile = new PrintWriter(outputFile);
			for (double[] row: data) {
				for (double datum: row) {
					outfile.print(datum + " ");
				}
				outfile.println();
			}
			outfile.close();
		}
		catch (IOException error) {
			System.out.println (error.toString());
		}
	}
	
	public static double getTotal(double[][] data) {
		double total = 0.0;
		for (double[] row: data) {
			for (double datum: row) {
				total += datum;
			}
		}
		return total;
	}
	
	public static double getAverage(double[][] data) {
		int counter = 0;
		double average, total = 0.0;
		for (double[] row: data) {
			for (double datum: row) {
				total += datum;
				counter++;
			}
		}
		average = total / counter;
		return average;
	}
	
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;
		for (double datum: data[row]) {
			total += datum;
		}
		return total;
	}
	
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;
		for (double[] row: data) {
			try {
				total += row[col];
			}
			catch (ArrayIndexOutOfBoundsException error) {
				System.out.println (error.toString());
			}
		}
		return total;
	}
	
	public static double getHighestInRow(double[][] data, int row) {
		double high = data[row][0];
		for (double datum: data[row]) {
			if (datum > high) {
				high = datum;
			}
		}
		return high;
	}
	
	public static int getHighestinRowIndex(double[][] data, int row) {
		double high = data[row][0];
		int index = 0, 
			highIndex = 0;
		for (double datum: data[row]) {
			if (datum > high) {
				high = datum;
				highIndex = index;
			}
			index++;
		}
		return highIndex;
	}
	
	public static double getLowestInRow(double[][] data, int row) {
		double low = data[row][0];
		for (double datum: data[row]) {
			if (datum < low) {
				low = datum;
			}
		}
		return low;
	}
	
	public static int getLowestInRowIndex(double[][] data, int row) {
		double low = data[row][0];
		int index = 0,
			lowIndex = 0;
		for (double datum: data[row]) {
			if (datum < low) {
				low = datum;
				lowIndex = index;
			}
			index++;
		}
		return lowIndex;
	}
	
	public static double getHighestInColumn(double[][] data, int col) {
		double high = data[0][col];
		for (double[] row: data) {
			try {
				if (row[col] > high) {
					high = row[col];
				}
			}
			catch (ArrayIndexOutOfBoundsException error) {
				System.out.println (error.toString());
			}			
		}
		return high;
	}
	
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double high = data[0][col];
		int index = 0,
			highIndex = 0;
		for (double[] row: data) {
			try {
				if (row[col] > high) {
					high = row[col];
					highIndex = index;
				}
				index++;
			}
			catch (ArrayIndexOutOfBoundsException error) {
				System.out.println (error.toString());
			}
		}
		return highIndex;
	}
	
	public static double getLowestInColumn(double[][] data, int col) {
		double low = data[0][col];
		for (double[] row: data) {
			try {
				if (row[col] < low) {
					low = row[col];
				}
			}
			catch (ArrayIndexOutOfBoundsException error) {
				System.out.println (error.toString());
			}
		}
		return low;
	}
	
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double low = data[0][col];
		int index = 0,
			lowIndex = 0;
		for (double[] row: data) {
			try {
				if (row[col] < low) {
					low = row[col];
					lowIndex = index;
				}
				index++;
			}
			catch (ArrayIndexOutOfBoundsException error) {
				System.out.println (error.toString());
			}
		}
		return lowIndex;
	}
	
	public static double getHighestInArray(double[][] data) {
		double high = data[0][0];
		for (double[] row: data) {
			for (double datum: row) {
				if (datum > high) {
					high = datum;
				}
			}
		}
		return high;
	}
	
	public static double getLowestInArray(double[][] data) {
		double low = data[0][0];
		for (double[] row: data) {
			for (double datum: row) {
				if (datum < low) {
					low = datum;
				}
			}
		}
		return low;
	}

}
