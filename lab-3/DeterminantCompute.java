
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
		int userInput, userMatrixOrder;
		boolean mOrderDef = true;
		String userMatrix;

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

		System.out.print("Would you like to insert your own matrix "+
		"into the program?  y/n >>> ");
		userMatrix = in.next().toLowerCase();

		try {

			Scanner scan = new Scanner(new File(inputFile));
			FileWriter writer = new FileWriter(outputFile);

// ----------------------------------------------------------------------------------
// Set up user input process
// ----------------------------------------------------------------------------------
			
			// Initiate user matrix
			if (userMatrix.equals("y")) {

				System.out.println("What is the order of your matrix?");
				System.out.print("*** Order should be greater than 1 and less"+
				" than 10 *** >>> ");
				userMatrixOrder = in.nextInt();
				System.out.println("*** Ensure your values are integers (int) ***");

				LinkedMatrix inputMatrix = new LinkedMatrix();
				matrixIndex++;
				rowIndex = 0;
				colIndex = 0;

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

				inputMatrix.setOrder(userMatrixOrder);
				writer.write("Matrix Number: " + matrixIndex + ", Matrix order: " +
				inputMatrix.order + "\n");
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

				// Gather user input and write to output file
				for (int i = 0; i < userMatrixOrder; i++) {
					for (int j = 0; j < userMatrixOrder; j++) {
						
						System.out.print("Input data at (" + i + "," + j + "): ");
						userInput = in.nextInt();
						ListNode node = new ListNode(new NodeFeatures(userInput, i, j));
						inputMatrix.insertNode(node);
						
						if (userInput < 0) {
							writer.write("" + userInput + " ");
						} else {
							writer.write(" " + userInput + " ");
						}
						colIndex++;
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

					colIndex = 0;
					rowIndex++;
				}

				// Write result to output file
				writer.write("The determinant for the above matrix is " + 
						computeDet(inputMatrix, inputMatrix.order) + "\n");

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
			}
			
// ----------------------------------------------------------------------------------
// Run initial input file
// ----------------------------------------------------------------------------------

			while (scan.hasNextLine() && scan.hasNextInt()) {
				if (mOrderDef) {
					n = scan.nextInt();
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

				} else {

					LinkedMatrix matrix = new LinkedMatrix();
					rowIndex = 0;
					colIndex = 0;

					matrix.setOrder(n);
					writer.write("Matrix Number: " + matrixIndex + 
							", Matrix order: " + matrix.order + "\n");

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

					// Read in matrix values
					for (int i = 0; i < matrix.order; i++) {
						for (int j = 0; j < matrix.order; j++) {
							int data = scan.nextInt();
							ListNode node = new ListNode(new NodeFeatures(data, i, j));
							matrix.insertNode(node);
							if (data < 0) {
								writer.write("" + data + " ");
							} else {
								writer.write(" " + data + " ");
							}

							colIndex++;
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

						colIndex = 0;
						rowIndex++;
					}

					writer.write("The determinant for the above matrix is " + 
					computeDet(matrix, matrix.order) + "\n");

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
		System.out.println("Please check the output file for the results.");

	} // end main

	/**
	 * Computes the determinant of a given matrix by recursively making
	 * computations on smaller matrices until a stopping case is reached.
	 * 
	 * @param matrix - a matrix for evaluating
	 * @param order - order of a given matrix
	 * @return - determinant of matrix
	 */
	public static int computeDet(LinkedMatrix matrix, int order) {

		int result = 0;

		// First stopping case
		if (order == 1) {
			return matrix.getHead().getData();
		}

		// Second stopping case
		if (order == 2) {
			ListNode matrixTraversal = matrix.getHead();
			int a = matrixTraversal.getData();
			int b = matrixTraversal.next.getData();
			int c = matrixTraversal.next.next.getData();
			int d = matrixTraversal.next.next.next.getData();

			return (a * d) - (b * c);
		}

		int x = 1;
		ListNode firstRowTraversal = matrix.getHead();

		while (firstRowTraversal.getRow() == 0) {

			LinkedMatrix minor = new LinkedMatrix();
			ListNode matrixTraversal = matrix.getHead();

			int minorRow = 0;
			int minorCol = 0;

			while (matrixTraversal != null) {
				if (matrixTraversal.getRow() != 0 
						&& matrixTraversal.getCol() != firstRowTraversal.getCol()) {
					ListNode insert = new ListNode(new NodeFeatures(matrixTraversal.getData(), minorRow, minorCol));
					minor.insertNode(insert);
					minorCol++;
					if (minorCol == order - 1) {
						minorCol = 0;
						minorRow++;
					}
				}
				matrixTraversal = matrixTraversal.next;
			}

			result = result + x * firstRowTraversal.getData() * computeDet(minor, order - 1);
			x = x * -1;
			
			firstRowTraversal = firstRowTraversal.next;
		}
		
		return result;
		
	} // end computeDet

} // end DeterminantCompute
