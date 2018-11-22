
/**
 * Packages to be used throughout Lab.
 */
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * author: Mike Macey
 * 
 * This class reads an input file from a user given path line by line,
 * determines of a given string matches a set of predefined languages and
 * writes an output file to a user given path, listing the results of the
 * language checks.
 */
public class LanguageChecker {

	static String results;

	public static void main(String[] args) {

		String inputFile;
		String outputFile;

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

		try {
			Scanner scan = new Scanner(new File(inputFile));
			FileWriter writer = new FileWriter(outputFile);

			// Initialize stacks for language checking
			LinkedList newList_L1 = new LinkedList();
			LinkedList newList_L2 = new LinkedList();
			LinkedList newList_L3 = new LinkedList();
			LinkedList newList_L4 = new LinkedList();
			LinkedList newList_L5 = new LinkedList();

			int lineCount = 1;
			while (scan.hasNextLine()) {

				// Read the input file line by line
				String line = scan.nextLine();
				writer.write(lineCount + ". ");
				for (int i = 0; i < line.length(); i++) {
					char item = line.charAt(i);
					newList_L1.push(Character.toUpperCase(item));
					newList_L2.push(Character.toUpperCase(item));
					newList_L3.push(Character.toUpperCase(item));
					newList_L4.push(Character.toUpperCase(item));
					newList_L5.push(Character.toUpperCase(item));
					writer.write(item);
				}

				// Check if line is empty
				if (newList_L1.isEmpty()) {
					writer.write("{} empty string - no language fits!\n");
					lineCount++;
					writer.write("-----------------------------------------"
						+ "--------------------------------------------\n");
				} else {

					// Run language checks
					results = "";
					L1_Check(newList_L1);
					L2_Check(newList_L2);
					L3_Check(newList_L3);
					L4_Check(newList_L4);
					L5_Check(newList_L5);
					writer.write(" is in " + results);
					lineCount++;
					writer.write("-----------------------------------------"
						+ "--------------------------------------------\n");
				}
			}
			scan.close();
			writer.close();

		} catch (FileNotFoundException exception) {
			System.out.println("*** File was not found. Please try" +
								"another file and/or file path. ***");
		} catch (IOException exception) {
			System.out.println("*** I/O error. ***");
		}
		System.out.println("Done.");

	} // end main

	/**
	 * Determines if a string is constructed in the following language: Equal
	 * number of A's and B's (in any order) and no other characters
	 * 
	 * @param stack
	 *            - a stack that represents the input string
	 */
	public static void L1_Check(LinkedList stack) {

		// Set up primary stacks for language referencing
		LinkedList aStack = new LinkedList();
		LinkedList bStack = new LinkedList();

		while (!stack.isEmpty()) {
			if (stack.peek() == 'A') {
				stack.pop(); // register all A's
				aStack.push('A');
			} else if (stack.peek() == 'B') {
				stack.pop(); // register all B's
				bStack.push('B');
			} else {

				// clear stacks if anything but A or B exist in stack
				aStack.clearStack();
				bStack.clearStack();
				stack.clearStack();
			}
		}

		// Check stack sizes for language adherence
		if (aStack.size() == bStack.size() && aStack.size() != 0) {
			results = results + "L1 ";
		}
	} // end L1_Check

	/**
	 * Determines if a string is constructed in the following
	 * language: A^n B^n where n > 0
	 * 
	 * @param stack - a stack that represents the input string
	 */
	public static void L2_Check(LinkedList stack) {

		// Set up primary stacks for language referencing
		LinkedList aStack = new LinkedList();
		LinkedList bStack = new LinkedList();

		if (!stack.isEmpty()) {
			if (stack.peek() == 'B') { // ensure string ends with 'B'
				while (stack.peek() == 'B') {
					stack.pop(); // pop remaining B's
					bStack.push('B');
				}
				if (stack.peek() == 'A') { // ensure A follows B characters
					while (stack.peek() == 'A') {
						stack.pop(); // pop remaining A's
						aStack.push('A');
					}

					// clear stacks if characters remains
					if (stack.peek() != 'A' && !stack.isEmpty()) {
						aStack.clearStack();
						bStack.clearStack();
						stack.clearStack();
					}
				} else {
					aStack.clearStack();
					bStack.clearStack();
					stack.clearStack();
				}
			} else {
				aStack.clearStack();
				bStack.clearStack();
				stack.clearStack();
			}
		} else {
			aStack.clearStack();
			bStack.clearStack();
		}

		// Check stack sizes for language adherence
		if (aStack.size() == bStack.size() && aStack.size() != 0) {
			results = results + "L2 ";
		}
	} // end L2_Check

	/**
	 * Determines if a string is constructed in the following
	 * language: A^n B^2n where n > 0
	 * 
	 * @param stack - a stack that represents the input string
	 */
	public static void L3_Check(LinkedList stack) {

		// Set up primary stacks for language referencing
		LinkedList aStack = new LinkedList();
		LinkedList bStack = new LinkedList();

		if (!stack.isEmpty()) {
			if (stack.peek() == 'B') { // ensure string ends with 'B'
				while (stack.peek() == 'B') {
					stack.pop(); // pop remaining B's
					bStack.push('B');
				}
				if (stack.peek() == 'A') { // ensure A follows B characters
					while (stack.peek() == 'A') {
						stack.pop(); // pop remaining A's
						aStack.push('A');
					}

					// clear stacks if characters remains
					if (stack.peek() != 'A' && !stack.isEmpty()) {
						aStack.clearStack();
						bStack.clearStack();
						stack.clearStack();
					}
				} else {
					aStack.clearStack();
					bStack.clearStack();
					stack.clearStack();
				}
			} else {
				aStack.clearStack();
				bStack.clearStack();
				stack.clearStack();
			}
		} else {
			aStack.clearStack();
			bStack.clearStack();
		}

		// Check stack sizes for language adherence
		if (2 * aStack.size() == bStack.size() && aStack.size() != 0) {
			results = results + "L3 ";
		}
	} // end L3_Check

	/**
	 * Determines if a string is constructed in the following 
	 * language: (A^n B^m)^p where n, m, p > 0
	 * 
	 * @param stack - a stack that represents the input string
	 */
	public static void L4_Check(LinkedList stack) {

		// Set up primary stacks for language referencing
		LinkedList aStack = new LinkedList();
		LinkedList bStack = new LinkedList();

		// Set up reference stacks to hold A^n B^m pattern
		LinkedList aRefStack = new LinkedList();
		LinkedList bRefStack = new LinkedList();

		// Set status of language adherence
		boolean status = false;

		if (!stack.isEmpty()) {
			if (stack.peek() == 'B') { // ensure string ends with 'B'
				while (stack.peek() == 'B') {
					stack.pop(); // pop remaining B's
					bRefStack.push('B');
				}
				if (stack.peek() == 'A') { // ensure A follows B characters
					while (stack.peek() == 'A') {
						stack.pop(); // pop remaining A's
						aRefStack.push('A');
					} // A^n B^m pattern is set at this point

					// iterate at this point
					while (!stack.isEmpty()) {
						if (stack.peek() == 'B') { // ensure string ends with
													// 'B'
							while (stack.peek() == 'B') {
								stack.pop(); // pop remaining B's
								bStack.push('B');
							}
							if (stack.peek() == 'A') { // ensure A follows B
														// characters
								while (stack.peek() == 'A') {
									stack.pop(); // pop remaining A's
									aStack.push('A');
								}

								// Determine language status
								if (aStack.size() == aRefStack.size() 
										&& bStack.size() == bStack.size()) {
									status = true;
								} else {
									status = false;
									aStack.clearStack();
									bStack.clearStack();
									stack.clearStack();
								}
							} else {
								status = false;
								aStack.clearStack();
								bStack.clearStack();
								stack.clearStack();
							}
						} else {
							status = false;
							aStack.clearStack();
							bStack.clearStack();
							stack.clearStack();
						}
						aStack.clearStack();
						bStack.clearStack();
					}

				} else {
					aStack.clearStack();
					bStack.clearStack();
					aRefStack.clearStack();
					bRefStack.clearStack();
					stack.clearStack();
				}
			} else {
				aStack.clearStack();
				bStack.clearStack();
				aRefStack.clearStack();
				bRefStack.clearStack();
				stack.clearStack();
			}
		} else {
			aStack.clearStack();
			bStack.clearStack();
			aRefStack.clearStack();
			bRefStack.clearStack();
		}

		// Determine the status of the input string's language adherence
		if (status) {
			results = results + "L4 ";
		}
	} // end L4_Check

	/**
	 * Determines if a string is constructed in the following 
	 *  language: A^n B^4n C^3n D^5n where n > 0
	 * 
	 * @param stack - a stack that represents the input string
	 */
	public static void L5_Check(LinkedList stack) {

		// Set up primary stacks for language referencing
		LinkedList aStack = new LinkedList();
		LinkedList bStack = new LinkedList();
		LinkedList cStack = new LinkedList();
		LinkedList dStack = new LinkedList();

		if (!stack.isEmpty()) {
			if (stack.peek() == 'D') { // ensure string ends with 'D'
				while (stack.peek() == 'D') {
					stack.pop(); // pop remaining D's
					dStack.push('D');
				}
				if (stack.peek() == 'C') { // ensure C follows D characters
					while (stack.peek() == 'C') {
						stack.pop(); // pop remaining C's
						cStack.push('c');
					}
					if (stack.peek() == 'B') {//ensure B follows C characters
						while (stack.peek() == 'B') {
							stack.pop(); // pop remaining B's
							bStack.push('B');
						}
						if (stack.peek() == 'A') { // ensure A follows B
													// characters
							while (stack.peek() == 'A') {
								stack.pop(); // pop remaining A's
								aStack.push('A');
							}

							// clear stacks if characters remains
							if (stack.peek() != 'A' && !stack.isEmpty()) {
								aStack.clearStack();
								bStack.clearStack();
								cStack.clearStack();
								dStack.clearStack();
								stack.clearStack();
							}
						} else {
							aStack.clearStack();
							bStack.clearStack();
							cStack.clearStack();
							dStack.clearStack();
							stack.clearStack();
						}
					} else {
						aStack.clearStack();
						bStack.clearStack();
						cStack.clearStack();
						dStack.clearStack();
						stack.clearStack();
					}
				} else {
					aStack.clearStack();
					bStack.clearStack();
					cStack.clearStack();
					dStack.clearStack();
					stack.clearStack();
				}
			} else {
				aStack.clearStack();
				bStack.clearStack();
				cStack.clearStack();
				dStack.clearStack();
				stack.clearStack();
			}
		} else {
			aStack.clearStack();
			bStack.clearStack();
			cStack.clearStack();
			dStack.clearStack();
		}

		// Check stack sizes for language adherence
		if (4 * aStack.size() == bStack.size() 
				&& 3 * aStack.size() == cStack.size()
				&& 5 * aStack.size() == dStack.size() & aStack.size() != 0) {
			results = results + "L5 ";
		}
	} // end L5_Check

} // end LanguageChecker