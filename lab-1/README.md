# README
Java version: jdk1.8.0_102.jdk

Java IDE: Eclipse - neon

## Analysis

### Data Structures – Justification and Implementation
The purpose of this exercise was to emphasize the importance of stacks and how to take advantage of their LIFO functionality. I chose to implement my stacks using a linked list implementation. I thought it would be important to take advantage of a list’s ability to be dynamic in size. Since the size of strings in the input file could change, I figured this implementation would be a better option than an array-based implementation. I also considered whether or not random access would play a role in this analysis. I ultimately decided that dynamic lists would be more ideal to work with compared to static arrays so this was a trade off I was willing to make. 

### Application, Design and Efficiency
Utilizing the stacks ability to push and pop items into and out of a linked list proved to be far more efficient than individually counting the characters from the input strings. If this problem set were to scale to more complex languages, working with strings would get cumbersome and be hard to work with. Stacks give us the ability to store data that references other pieces of data; something strings cannot do. Thus, the constructed methods that make up a stack’s functionality aided in the language analysis component of this lab. 

I solved this problem set by designing three classes – a list node class to store the data, a linked list class to implement my stacks as a linked list, and a tester class to run the language checks. The list node object has a data component and a pointer component that points to the preceding node, thus resulting in a singular linked list. I gave my stack the standard push, pop, peek and isEmpty methods while also constructing clearStack and size method to extend the stacks functionality and enhance its utility. 

The complexity for this set of language check algorithms are O(N) since each check steps through every input string character by character. This means that the time of the algorithm is dependent on how many characters are in the input string. In regards to space, stacks allow for dynamic space allocation. I used reference stacks to hold certain language constructs at times, but for the most part the stacks used throughout the program are fluid. This ensures that the optimal amount of space is being used and data isn’t being stored anywhere unless for a certain purpose.

### Learning Component
The biggest takeaway from this lab was seeing the utility that stacks can provide and actually implementing linked lists as a data structure. It’s one thing to see and hear about these concepts, it’s another thing to apply them to a problem set. I learned the purpose of having push, pop, peek and isEmpty methods and why these are “must haves” when implementing stacks. Thinking about the trade offs between data structures and seeing how these trade offs impacted the analysis was also interesting to put into perspective. Again, it is one thing to talk about these in our group discussions and another thing to see the actual effects of our decisions. 
