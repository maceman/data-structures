# README

Java version: jdk1.8.0_102.jdk

Java IDE: Eclipse - neon

Instructions: To run file, insert the input and output file in a folder that is easily accessible. Run the program and insert the input file path followed by a separate input for the output file path. 

Files in the preferred folder location need to have the following naming convention to run the program:

*DATA TYPE*

- Ordered data: asc
- Duplicated data: dup
- Random data: ran
- Reverse ordered data: rev

*DATA SIZE*

- 50 
- 500 
- 1K
- 2K
- 5K
- 10K
- 20K

Input file should be named data_type + data_size + .txt

Examples:
An input file of duplicated data with 10,000 records should be named as follows:
dup10K.txt

An input file of random data with 500 records should be named as follows:
ran500.txt

### Data Structures – Justification and Implementation
From the start of my initial thought process, I believed it would serve best to implement each sort structure as an array. Taking advantage of random access and understanding that the size of the data would not change led me to this decision. It was not necessary to store any further information about each data point in every input file. All that was needed were the data itself and its position within the array. Each array would be used to create either a HeapSort object or a ShellSort object to carry out all the necessary procedures for this analysis.

### Application, Design and Efficiency
To make the program run more efficiently, I found it best to make two separate objects, HeapSort and ShellSort, so that each sort could have its own implementation when sorting a given array. The HeapSort object has three helper methods to assist in conducting my variation of a heap sort. The heapSort method is the runner method that loops through all the data points in an array. The maxHeap method recreates a max heap for a given array after typically an exchange of data has taken place. This ensures the heapSort method can continue to run correctly as it can only do so if the data stored in a max heap structure.

I found the shell sort implementation to be quite interesting. Unlike my heap sort implementation, I did not create any helper methods that specifically relate to running each shell sort. I created four unique shell sorts that took advantage of different shell sizes. The first set of shells was based on Knuth’s sequence. The second and third were given, and the fourth was created by myself. All sequences had the same idea – count the number of data points in an array, find the first number in the given sequence that is larger than the size of the array, and from here move back to indexes to determine the shell size that the algorithm will start of with. From there, the shell sizes will continue to get smaller until a shell size of one is reached where a simple insertion search will essentially sort the rest of the array. 

With both sorts being turned into objects, I was able to implement getTime and displayArray methods to assist with the pre-processing of the data. I eventually used the getTime method to extract the amount of time taken for each sort, but the displayArray method really only helped when I was debugging my program throughout its multiple stages. One key characteristic to note about each object is that all of the data is private except the array that is being sorted. I needed to be able to access this outside the objects so I could show the difference in the sorted versus unsorted arrangements.

The complexity of this heap sort is O(n log n) while the complexity of the shell sorts depends on the sequence with the best case performance being O(n log n) and the worst case performance being O(n2).  Below is a table that lists the total time taken in nanoseconds to sort each variation of data files:

*Total Time Taken to Sort All Input Data Files (ns = nanoseconds)*
- Heap Sort	
  - *16,461,411 ns*
- Shell Sort (Shells: 1, 4, 13, 40, 121, 364, 1093, 3280, 9841,29524)	
  - *19,171,745 ns*
- Shell Sort (Shells: 1, 5, 17, 53, 149, 373, 1123, 3371, 10111, 30341)	
  - *15,880,688 ns*
- Shell Sort (Shells: 1, 10, 30, 60, 120, 360, 1080, 3240, 9720, 29160)	
  - *31,610,806 ns*
- Shell Sort (Shells: 1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049)	
  - *27,209,609 ns*

Based on the data illustrated above, the second shell sort variation had the fastest, most efficient sort time followed closely by heap sort. This is consistent with what is to be expected. With smaller ordered data files, shell search proved to be best, but at these files increased on size, heap sort started to prove more successful, generally. Duplicated data files typically had heap sort running with the fastest time no matter what the size of the file was. The random files were evenly split with smaller files, but again heap sort proved to be the most efficient as the file sizes increased. Finally, with reversed data, shell sort was for the most part noticeably better than heap sort overall. As for the differences in performance for shell sorts, Knuth’s sequence proved to be the best in most cases. It appears that starting off with too large of a number after one in a sequence can affect the performance of the sort. This is why shell sort variation 3 was the worst performing sort overall. Even if there is a formulaic way of computing the shell sizes, this doesn’t always mean the sort will run perform better (See shell sort 4). As for space, the larger the shell sizes are the more space is needed to hold those partitions of data. Thus, as we’ve seen in every lab there are trade offs with every implementation decision.

I would imagine there is a way to make my runner class more efficient but due to time constraints, I wanted to focus more on my sorting algorithms. However, this is something I would spend more time on the next time around. My current implementation does not affect the sorting time of any of the sorting algorithms but as a professional programmer, I would expect this be written more efficiently when placed into production. 

### Learning Component
I learned a great deal about how to actually implement sorting algorithms, heap sort and shell sort specifically, and how to analyze them to infer what makes an efficient algorithm. It was also interesting to again visit the array implementation of a data structure and take advantage of proper characteristics. Similarly to the previous labs, File I/O is always great to work on because typically different systems have different ways of managing their data and how it gets processed. 

### Recursive Implementation Consideration
A recursive implementation definitely seemed like a plausible way of conducting each sort, given the fact that sorts are done over and over again in each algorithm. For heap sort, it would be possible to recursively call the heapSort method over and over again since the data needs to be in a max heap data structure. However, I found it best to only call the maxHeap helper method as this would take less space than a recursive implementation. The shell sorts would act in a similar fashion. As each shell is sorted, the algorithm would recursively call itself to change from one shell size to the next. But again, this would take a lot of space to hold each already sorted array in memory, thus making the algorithm less efficient. 

### Enhancements
To make things easier, as mentioned before, I decided to construct objects for my sorts so I could run helper methods outside the Runner class. I also thought it was important actually make this Runner class only focus on running the program and not containing any other code. To me, it was important to test each sort over a varying number of file sizes so I also included the 20K file size in this analysis. 
