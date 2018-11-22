/**
 * author: Mike Macey
 * 
 * This class establishes the nodes that will be used to construct our linked
 * lists. Each node will have a piece of data and one pointer that will point
 * the the next node in the linked list.
 */
public class ListNode {

	char data;
	ListNode next; // pointer

	/**
	 * Constructor for the ListNode object
	 * 
	 * @param data - character that will be stored as a piece of data in a
	 *         given node
	 */
	public ListNode(char data) {
		this.data = data;
		this.next = null;
	}

	public char getData() {
		return data;
	}

} // end ListNode
