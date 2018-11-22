import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * author: Mike Macey
 * 
 * This class runs a heap sort and four different shell sorts on different
 * types of data - ordered, reverse ordered, random order and duplicate 
 * data - over variant of sizes: 50 records, 500 records, 1K records,
 * 2K records, 5K records, 10K records and 20K records. The analysis 
 * of 50 records is printed to the console.
 * 
 */
public class Runner {

	public static void main(String[] args) {
	
		// Variables to assist with analysis
		Scanner in = new Scanner(System.in);
		String inputFilePath;
		String outputFilePath;
		String inputFile;
		String outputFile;
		int tableIndex = 1;
		int n = 0;
		long heapTime = 0, shell1Time = 0, shell2Time = 0, shell3Time = 0, shell4Time = 0;
		String[] fileTypes = {"asc","dup","ran","rev"};
		String[] fileSizes = {"50", "500", "1K", "2K", "5K", "10K", "20K"};
		
		try {
			
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Please provide the path to your input file: ");
			System.out.println("Example: /Users/mmacey1/input_folder/");
			System.out.print(">>> ");
			inputFilePath = scan.next();
			
			System.out.println("Please provide the path for your output file: ");
			System.out.println("Example: /Users/mmacey1/output_folder/");
			System.out.print(">>> ");
			outputFilePath = in.next();
			System.out.print("\n");
			
			FileWriter metaWriter = new FileWriter(outputFilePath + "MMacey_Lab04_Sorting_Analysis.txt");
			
			// Compute each sort over each file type and size
			for (String type : fileTypes) {
				for (String size : fileSizes) {
					
					if (size.equals("50")) {
						n = 50;
					}
					else if (size.equals("500")){
						n = 500;
					}
					else if (size.equals("1K")) {
						n = 1000;
					}
					else if (size.equals("2K")) {
						n = 2000;
					}
					else if (size.equals("5K")) {
						n = 5000;
					}
					else if (size.equals("10K")) {
						n = 10000;
					}
					else {
						n = 20000;
					}
					
					metaWriter.write(tableIndex + ") Sorting Analysis of File " + type + size + ":\n");
					metaWriter.write("   -----------------------------------------------\n");
					tableIndex++;
					
					inputFile = type + size + ".txt";
					
					// --------------------------------------------------------------
					// 							Heap Sort
					// --------------------------------------------------------------
					
					int[] heapSortData = new int[n];
					Scanner heapScan = new Scanner(new File(inputFilePath + inputFile));
					
					outputFile = "heap_sort_" + type + size + ".txt";
					FileWriter heapWriter = new FileWriter(outputFilePath + outputFile);
					
					int heapData = 0;
					int heapIndex = 0;
					
					// Read in input data
					while (heapScan.hasNextInt()){
						heapData = heapScan.nextInt();
						heapSortData[heapIndex] = heapData;
						heapIndex++;
					}
					
					// Write sorted data to output file
					HeapSort heap_sort = new HeapSort(heapSortData);
					heap_sort.heapSort();
					for (int i = 0; i < n; i++) {
						heapWriter.write(heap_sort.array[i] + "\n");
					}
					
					metaWriter.write("   SORT: Heap Sort    | TIME: " + heap_sort.getTime()
							+ " nanoseconds\n");
					heapTime = heapTime + heap_sort.getTime();
					
					heapScan.close();
					heapWriter.close();
					
					
					// --------------------------------------------------------------
					// 							Shell Sort 1
					// --------------------------------------------------------------
					
					int[] shellSort1Data = new int[n];
					Scanner shell1Scan = new Scanner(new File(inputFilePath + inputFile));
					
					outputFile = "shell_sort_1_" + type + size + ".txt";
					FileWriter shell1Writer = new FileWriter(outputFilePath + outputFile);
					
					int shell1Data = 0;
					int shell1Index = 0;
					
					// Read in input data
					while (shell1Scan.hasNextInt()){
						shell1Data = shell1Scan.nextInt();
						shellSort1Data[shell1Index] = shell1Data;
						shell1Index++;
					}
					
					// Write sorted data to output file
					ShellSort shell_sort_1_sort = new ShellSort(shellSort1Data);
					shell_sort_1_sort.shellSort_1();
					for (int i = 0; i < n; i++) {
						shell1Writer.write(shell_sort_1_sort.array[i] + "\n");
					}
					
					metaWriter.write("   SORT: Shell Sort 1 | TIME: " + shell_sort_1_sort.getTime()
							+ " nanoseconds\n");
					shell1Time = shell1Time + shell_sort_1_sort.getTime();
					
					shell1Scan.close();
					shell1Writer.close();
					
					// --------------------------------------------------------------
					// 							Shell Sort 2
					// --------------------------------------------------------------
					
					int[] shellSort2Data = new int[n];
					Scanner shell2Scan = new Scanner(new File(inputFilePath + inputFile));
					
					outputFile = "shell_sort_2_" + type + size + ".txt";
					FileWriter shell2Writer = new FileWriter(outputFilePath + outputFile);
					
					int shell2Data = 0;
					int shell2Index = 0;
					
					// Read in input data
					while (shell2Scan.hasNextInt()){
						shell2Data = shell2Scan.nextInt();
						shellSort2Data[shell2Index] = shell2Data;
						shell2Index++;
					}
					
					// Write sorted data to output file
					ShellSort shell_sort_2_sort = new ShellSort(shellSort2Data);
					shell_sort_2_sort.shellSort_2();
					for (int i = 0; i < n; i++) {
						shell2Writer.write(shell_sort_2_sort.array[i] + "\n");
					}
					
					metaWriter.write("   SORT: Shell Sort 2 | TIME: " + shell_sort_2_sort.getTime()
							+ " nanoseconds\n");
					shell2Time = shell2Time + shell_sort_2_sort.getTime();
					
					shell2Scan.close();
					shell2Writer.close();
					
					// --------------------------------------------------------------
					// 							Shell Sort 3
					// --------------------------------------------------------------
					
					int[] shellSort3Data = new int[n];
					Scanner shell3Scan = new Scanner(new File(inputFilePath + inputFile));
					
					outputFile = "shell_sort_3_" + type + size + ".txt";
					FileWriter shell3Writer = new FileWriter(outputFilePath + outputFile);
					
					int shell3Data = 0;
					int shell3Index = 0;
					
					// Read in input data
					while (shell3Scan.hasNextInt()){
						shell3Data = shell3Scan.nextInt();
						shellSort3Data[shell3Index] = shell3Data;
						shell3Index++;
					}
					
					// Write sorted data to output file
					ShellSort shell_sort_3_sort = new ShellSort(shellSort3Data);
					shell_sort_3_sort.shellSort_3();
					for (int i = 0; i < n; i++) {
						shell3Writer.write(shell_sort_3_sort.array[i] + "\n");
					}
					
					metaWriter.write("   SORT: Shell Sort 3 | TIME: " + shell_sort_3_sort.getTime()
							+ " nanoseconds\n");
					shell3Time = shell3Time + shell_sort_3_sort.getTime();
					
					shell3Scan.close();
					shell3Writer.close();
					
					// --------------------------------------------------------------
					// 							Shell Sort 4
					// --------------------------------------------------------------
					
					int[] shellSort4Data = new int[n];
					Scanner shell4Scan = new Scanner(new File(inputFilePath + inputFile));
					
					outputFile = "shell_sort_4_" + type + size + ".txt";
					FileWriter shell4Writer = new FileWriter(outputFilePath + outputFile);
					
					int shell4Data = 0;
					int shell4Index = 0;
					
					// Read in input data
					while (shell4Scan.hasNextInt()){
						shell4Data = shell4Scan.nextInt();
						shellSort4Data[shell4Index] = shell4Data;
						shell4Index++;
					}
					
					// Write sorted data to output file
					ShellSort shell_sort_4_sort = new ShellSort(shellSort4Data);
					shell_sort_4_sort.shellSort_4();
					for (int i = 0; i < n; i++) {
						shell4Writer.write(shell_sort_4_sort.array[i] + "\n");
					}
					
					metaWriter.write("   SORT: Shell Sort 4 | TIME: " + shell_sort_4_sort.getTime()
							+ " nanoseconds\n");
					shell4Time = shell4Time + shell_sort_4_sort.getTime();
					metaWriter.write("   -----------------------------------------------\n\n");
					
					shell4Scan.close();
					shell4Writer.close();
					
					// If n is 50, print analysis to console
					if (n == 50) {
						System.out.print("--------------------------------\n"+
								"Sorting Analysis of File " + type + size + 
								"\n--------------------------------\n" + "     Heap Sort: ");
						for (int i = 0; i < n; i ++) {
							System.out.print(heap_sort.array[i] + " ");
						}
						System.out.print("\n          Time: " + heap_sort.getTime() + 
								" nanoseconds\n\n" + "  Shell Sort 1: ");
						for (int i = 0; i < n; i ++) {
							System.out.print(shell_sort_1_sort.array[i] + " ");
						}
						System.out.print("\n          Time: " + shell_sort_1_sort.getTime() + 
								" nanoseconds\n\n" + "  Shell Sort 2: ");
						for (int i = 0; i < n; i ++) {
							System.out.print(shell_sort_2_sort.array[i] + " ");
						}
						System.out.print("\n          Time: " + shell_sort_2_sort.getTime() + 
								" nanoseconds\n\n" + "  Shell Sort 3: ");
						for (int i = 0; i < n; i ++) {
							System.out.print(shell_sort_3_sort.array[i] + " ");
						}
						System.out.print("\n          Time: " + shell_sort_3_sort.getTime() + 
								" nanoseconds\n\n" + "  Shell Sort 4: ");
						for (int i = 0; i < n; i ++) {
							System.out.print(shell_sort_4_sort.array[i] + " ");
						}
						System.out.println("\n          Time: " + shell_sort_4_sort.getTime() +
								" nanoseconds\n" + "--------------------------------\n\n");
					}
				}
			}
			
			// Format overall sort analysis section in output file
			metaWriter.write("\n              OVERALL SORTING ANALYSIS\n" +
			"-----------------------------------------------------\n" +
			"SORT: Heap Sort    | TOTAL TIME: " + heapTime + " nanoseconds\n" +
					"SORT: Shell Sort 1 | TOTAL TIME: " + shell1Time + " nanoseconds\n" +
					"SORT: Shell Sort 2 | TOTAL TIME: " + shell2Time + " nanoseconds\n" +
					"SORT: Shell Sort 3 | TOTAL TIME: " + shell3Time + " nanoseconds\n" +
					"SORT: Shell Sort 4 | TOTAL TIME: " + shell4Time + " nanoseconds\n" +
					"-----------------------------------------------------");
			
			metaWriter.close();
			scan.close();
			
			System.out.println("Program Done.");
		}
		catch (FileNotFoundException exception) {
			System.out.println("*** File was not found. Please try " +
		"another file and/or file path. ***");
		} 
		catch (IOException exception) {
			System.out.println("*** I/O error. ***");
		}

	} // end main

} // end Runner
