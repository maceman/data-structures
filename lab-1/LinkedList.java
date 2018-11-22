/**
 * author: Mike Macey
 * 
 * This class establishes a linked list data structure to be used for the
 * implementation of our stacks.
 */
public class LinkedList {

	/**
	 * Data for linked list (stack): pointer and size of stack
	 */
	ListNode header = null;
	private int listSize = 0;

	/**
	 * Determines whether or not a stack is empty.
	 * 
	 * @return the state of the stack: empty or not
	 */
	public boolean isEmpty() {
		return header == null;
	}

	/**
	 * Determines the size of a stack.
	 * 
	 * @return size of stack
	 */
	public int size() {
		return listSize;
	}

	/**
	 * Pushes an item onto a stack by creating a new node and storing the input
	 * as the node's data.
	 * 
	 * @param data - item to store in a node
	 */
	public void push(char data) {
		ListNode newNode = new ListNode(data);
		newNode.next = header;
		header = newNode;
		listSize++;
	}

	/**
	 * Pops an item off a stack and prints out the said item.
	 * 
	 * @return item being popped off a stack
	 */
	public char pop() {
		if (this.isEmpty()) {
			return '0'; // returns zero if there is no data, i.e. null
		} else {
			char temp = header.data;
			header = header.next;
			listSize--;
			return temp;
		}
	}

	/**
	 * Prints and returns the top item of a stack.
	 * 
	 * @return the top item of a stack
	 */
	public char peek() {
		if (isEmpty()) {
			return '0'; // returns zero if there is no data, i.e. null
		} else {
			return header.getData();
		}
	}

	/**
	 * Pops all the items off a stack and sets the stack size to zero.
	 */
	public void clearStack() {
		while (!this.isEmpty()) {
			this.pop();
		}
		listSize = 0;
	}

} // end LinkedList