/**
 * author: Mike Macey
 * 
 * This class establishes a linked list data structure to be used for the
 * implementation of matrices.
 */
public class LinkedMatrix {
	
	// Data for linked matrix
	private ListNode head;
	private ListNode tail;
	private int rowLen = 0;
	private int colLen = 0;
	public int size = 0;
	public int order;
	
	/**
	 * LinkedMatrix Constructor
	 */
	public LinkedMatrix() {
		head = null;
		tail = null;
	}
	
	/**
	 * Determines if a matrix is empty.
	 * 
	 * @return matrix state
	 */
	public boolean isEmpty() {
		return head == null;
	}
	
	/**
	 * Determines size of matrix
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Inserts a node into matrix and adjusts pointers
	 * 
	 * @param node
	 */
	public void insertNode(ListNode node) {
		if (isEmpty()) {
			head = tail = node;
			size++;
		} else {
			tail.setNext(node);
			tail = node;
			size++;
		}
	}

	/**
	 * Gets row length of a given matrix
	 * 
	 * @return rowLen
	 */
	public int getRowDim() {
		return rowLen;
	}
	
	/**
	 * Gets column length of a given matrix
	 * 
	 * @return size of stack
	 */
	public int getColDim() {
		return colLen;
	}
	
	/**
	 * Gets the data of the header node
	 * 
	 * @return data
	 */
	public int getHeadData() {
		return head.getData();
	}
	
	/**
	 * Gets the head node of a given matrix
	 * 
	 * @return head
	 */
	public ListNode getHead() {
		return head;
	}
	
	/**
	 * Sets the order of a given matrix
	 * 
	 * @param order
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	
	/**
	 * Displays all data for a given matrix
	 */
	public void displayMatrix() {
		
		ListNode tempNode = head;
		while(tempNode != null) {
			System.out.println(tempNode.toString());
			tempNode = tempNode.next;
		}
		
	}

} // end LinkedMatrix