# Analysis

Java version: jdk1.8.0_102.jdk

Java IDE: Eclipse - neon

Instructions: To run file, insert the input and output file in a folder that is easily accessible. Run the program, input the input file path followed by a separate input for the output file path. The program should finish should there be no errors.

If there are errors, read what is printed to the console to determine where the error might lie.

### Data Structures – Justification and Implementation
In order to construct each matrix structure, I found it best to create 2-dimensional arrays where each array is of the same length, given that our matrices for this problem needed to be normal or of the same size. Arrays were suitable to use for a couple reasons. Since it was already determined how many spaces would be needed for each matrix, we could save resources by using arrays instead of a linked implementation. Storing information such as the data, how it realtes to other data and its location within the matrix would get costly. There was also no real need to insert or delete information from our matrices, thus making it an even better option to use arrays compared to a linked implementation.

### Application, Design and Efficiency
I designed my determinant computation method to work around the inputs of a singel matrix and a number that represents the order of the mtrix. This method would recursively call istelf, ultimately shirnking the inserted matrix by one order every time to come up with the minor of the preceding matrix. The method would create a temporary matgrix of the same order as the inserted matrix, loop through both and make sure that the temporary matrix’s row and column indexes were not the same as the inserted matrix, and copmute across the other rows and columnsto eventually get to the stopping case where the matrix’s order is 1.

I solved this problem using only one method that would recursively call itslef. However, I believe there are ways to further break up this method that may make things easier to interpret when analyzing the code. Nevertheless, I believe my solution is still fairly efficient when computing the determinat of a given matrix. This solution is scalable to larger matrices, but when testing out larger matrices (such as a matrix with an order of 20) my perosnal machine became slow and was unable to carry out the entire program. I can see why now it is imporat to make solutions as efficient as possible as complexity truly does matter when scaling algorithms.

The complexity of this insertion algorithm would be O(N) since each line from the input file is read in one line at a time. The overall computation for one matrix depends on how many integers are inserted into the matrix making the program run in a linear fashion. Thus, no matter how many matrices are inserted into the program for computing the determiant, the isnertion will take O(N). The actual copmutation of the determinat will be O(N^2) however because as the order of the matrix increases, the algorithm will need to check n^2 more integers and return one more minor.

### Learning Component
Working through this problem taught me about the effectiveness of recursive solutions and where they can be applied. It was also intersting to incorporate linear algebra material as I was familiar with some of these terms but not all. It was also intersting to, once again, see the real life trade off decisions being made on data structures. This time, we where told to use a particular implementation but it was still necessary to see why this implementation was suited best for this problem. I also learned more about file I/O as this is an area that I am still freshening up in. 

### Iterative Implementation Conisderation
An iterative solution, in my opinion, would start of with computing the stoppping case first versus copmuting this last in the recursive solution. After returing the 1x1 matrix, a new matrix would be constructed of an order one level higher, so 2x2. This data would be pulled from the initial matrix that was insterd into the program. This same pattern would continue until the matrix reaches the order of the intital matrix. I believe this process would be less efficinet than a recursive implementation because one would have to keep referencing the same starting matrix to pull all the infromation from instead of building of the data that was already computed like in the recursive solution.

### Enhancements
I wanted to make things easier for the user when determing where errors may take place when reading in/writing different matrices so I created a lindex along the side of my output file. The amount of space between the line index and actual output is detemrined based on how many digits the line index is to make for a more streamlined output look.
