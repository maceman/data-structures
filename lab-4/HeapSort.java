
/**
 * author: Mike Macey
 * 
 * This class initiates a heap sort by first constructing a max heap
 * of a given array and sorting through each node in the tree.
 */
public class HeapSort {
	
	public static int[] array;
	private static int n;
	private long time = 0;
	
	/**
	 * Constructor for HeapSort object
	 * 
	 * @param array - set of data to be sorted
	 */
	public HeapSort(int[] array) {
		
		HeapSort.array = array;
		n = array.length;
		
	}
	
	/**
	 * Initiates heap sort for a given array
	 */
    public void heapSort() {
    	
    	long begin = System.nanoTime();
    	
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeap(array, i, n);
        }
        
        for (int i = n - 1; i > 0; i--) {
            exchange(array, 0, i);
            maxHeap(array, 0, i);
        }
        
        long end = System.nanoTime();
        time = end - begin;
        
    } // end heapSort
 
    /**
     * Constructs a max heap for a given array to be sorted
     * 
     * @param array - array to be sorted
     * @param i - index of data in array
     * @param n - length of array
     */
    private void maxHeap(int[] array, int i, int n) {
    	
        int index, j;
 
        for (j = array[i]; 2 * i + 1 < n; i = index) {
        	
            index = 2 * i + 1;
            
            if (index != n - 1 && (array[index] < array[index + 1])) {
                index++;
            }
            
            if (j < array[index]) {
                array[i] = array[index];
            }
            else {
                break;
            }
        }
        
        array[i] = j;
        
    } // end maxHeap
	
    /**
     * Exchanges two data points in an array
     * 
     * @param array - array in which data should be exchanged
     * @param a - piece of data to exchange with b
     * @param b - piece of data to exchange with a
     * @return - return a new array with a and b switching 
     * locations in the given array
     */
	public int[] exchange(int[] array, int a, int b) {
		
		int c = array[a];
		array[a] = array[b];
		array[b] = c;
		
		return array;
		
	} // end exchange
	
	/**
	 * Gets the amount of time taken for a heap sort
	 * 
	 * @return time of sort in nanoseconds
	 */
	public long getTime() {
		
		return time;
		
	} // end getTime
	
	/**
	 * Displays all data points in heap sort array
	 */
	public void displayArray() {
		
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		
	} // end displayArray

} // end HeapSort
