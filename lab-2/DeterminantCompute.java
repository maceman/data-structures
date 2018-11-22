
/**
 * Packages to be used throughout Lab.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * author: Mike Macey
 * 
 * This class reads in matrices line by line from a user provided input file,
 * computes the determinant and writes the result to an output file.
 */
public class DeterminantCompute {

	public static int order = 0;

	public static void main(String[] args) {

		String inputFile;
		String outputFile;

		int n = 0, rowIndex = 0, colIndex = 0, lineIndex = 1, matrixIndex = 0;
		boolean mOrderDef = true;

		Scanner in = new Scanner(System.in);
		System.out.println("Please provide the path to your input file " +
		"including the file name and type:");
		System.out.println("Example: /Users/mmacey1/input_file.txt");
		System.out.print(">>> ");
		inputFile = in.next();

		System.out.println("Please provide the path for your output file " +
		"including the file name and type:");
		System.out.println("Example: /Users/mmacey1/output_file.txt");
		System.out.print(">>> ");
		outputFile = in.next();
		//in.close();
		

		try {
			
			Scanner scan = new Scanner(new File(inputFile));
			FileWriter writer = new FileWriter(outputFile);
			
			int[][] matrix;

			// Read the input file line by line
			while (scan.hasNextLine()) {
				if (mOrderDef) {
					n = scan.nextInt();
					order = n;
					matrixIndex++;
					
					// Configure output line indices
					if (lineIndex < 10) {
						writer.write(lineIndex + ")    ");
					}
					if (lineIndex > 9 && lineIndex < 100) {
						writer.write(lineIndex + ")   ");
					}
					if (lineIndex > 99 && lineIndex < 1000) {
						writer.write(lineIndex + ")  ");
					}
					lineIndex++;

					// Next set of lines are matrix values
					mOrderDef = false;

				}

				else {
					rowIndex = 0;
					colIndex = 0;

					// Read in matrix values
					matrix = new int[n][n];
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							matrix[i][j] = scan.nextInt();
							colIndex++;
						}
						colIndex = 0;
						rowIndex++;
					}
					writer.write("Matrix Number: " + matrixIndex + 
							", Matrix order: " + n + "\n");
					
					// Configure output line indices
					if (lineIndex < 10) {
						writer.write(lineIndex + ")    ");
					}
					if (lineIndex > 9 && lineIndex < 100) {
						writer.write(lineIndex + ")   ");
					}
					if (lineIndex > 99 && lineIndex < 1000) {
						writer.write(lineIndex + ")  ");
					}

					// Write matrix values to output file
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							if (matrix[i][j] < 0) {
								writer.write("" + matrix[i][j] + " ");
							} else {
								writer.write(" " + matrix[i][j] + " ");
							}
						}
						lineIndex++;
						writer.write("\n");
						
						// Configure output line indices
						if (lineIndex < 10) {
							writer.write(lineIndex + ")    ");
						}
						if (lineIndex > 9 && lineIndex < 100) {
							writer.write(lineIndex + ")   ");
						}
						if (lineIndex > 99 && lineIndex < 1000) {
							writer.write(lineIndex + ")  ");
						}
					}
					
					// Write determinant to output file
					writer.write("The determinant for the above matrix is " 
					+ computeDet(matrix, order) + "\n");
					lineIndex++;
					
					// Configure output line indices
					if (lineIndex < 10) {
						writer.write(lineIndex + ")    ");
					}
					if (lineIndex > 9 && lineIndex < 100) {
						writer.write(lineIndex + ")   ");
					}
					if (lineIndex > 99 && lineIndex < 1000) {
						writer.write(lineIndex + ")  ");
					}
					writer.write("----------------------------------" + 
					"------------\n");
					lineIndex++;
					
					// Next integer is a new matrix order
					mOrderDef = true;
				}
			}
			scan.close();
			writer.close();

			
			
		} catch (FileNotFoundException exception) {
			System.out.println("*** File was not found. Please try " + 
		"another file and/or file path. ***");
		} catch (IOException exception) {
			System.out.println("*** I/O error. ***");
			
		} catch (NoSuchElementException exception) {
			System.out.println("*** Matrix number " + matrixIndex + 
					" is invalid!  ***");
			System.out.println("*** The problem appears to be at (" + 
					rowIndex + "," + colIndex + ")  ***");
		} 
		System.out.println("Program Done.");
		

	} // end main

	/**
	 * Computes the determinant of a given matrix by 
	 * recursively making computations on smaller
	 * matrices until the stopping case is reached.
	 * 
	 * @param matrix - a matrix for evaluating
	 * @param order - order of a given matrix
	 * @return - determinant of matrix
	 */
	public static int computeDet(int matrix[][], int order) {

		// Stopping case
		if (order == 1) {
			return matrix[0][0];
		}

		int result = 0;
		int minor[][] = new int[order][order];
		int x = 1;

		for (int k = 0; k < order; k++) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < order; i++) {
				for (int j = 0; j < order; j++) {
					if (i != 0 && j != k) {
						minor[a][b++] = matrix[i][j];
						
						// Reset column and increment to next row
						if (b == order - 1) {
							b = 0;
							a++;
						}
					}
				}
			}
			
			// Recursively call the next matrix of a smaller order
			result = result + x * matrix[0][k] * computeDet(minor, order - 1);
			x = x * -1;
		}
		return result;

	} // end computeDet

} // end DeterminantCompute
