/**
 * author: Mike Macey
 * 
 * This class establishes the nodes that will be used to construct the linked
 * matrices. Each node will have three pieces of data constructed from
 * the NodeFeatures class - data, row and column.
 */
public class ListNode {

	private NodeFeatures info;
	private int data;
	private int row;
	private int col;
	ListNode next;

	/**
	 * Constructor for ListNode object
	 * 
	 * @param data - int that will be stored as a piece of data in a
	 *         given node
	 * @param row - row of matrix where data sits
	 * @param col - column of matrix where data sits
	 */
	public ListNode(int data, int row, int col) {
		this.data = data;
		this.row = row;
		this.col = col;

	}
	
	// Various constructors
	public ListNode(NodeFeatures group) {
		this.info = group;
	}
	
	public ListNode(int data, ListNode node) {}
	
	public ListNode(ListNode node) {}
	
	public ListNode() {}
	
	/**
	 * Gets data for a given node
	 * 
	 * @return info
	 */
	public int getData() {
		return info.getData();
	}
	
	/**
	 * Gets row id for a given node
	 * 
	 * @return row
	 */
	public int getRow() {
		return info.getRow();
	}
	
	/**
	 * Gets column id for a given node
	 * 
	 * @return col
	 */
	public int getCol() {
		return info.getCol();
	}
	
	/**
	 * Sets row id for a given node
	 * 
	 * @param row
	 * @return row
	 */
	public int setRow(int row) {
		return info.getRow();
	}
	
	/**
	 * Sets column id for a given node
	 * 
	 * @param col
	 * @return col
	 */
	public int setCol(int col) {
		return info.getCol();
	}
	
	/**
	 * Sets the next node for a given node
	 * 
	 * @param node
	 */
	public void setNext(ListNode node) {
		this.next = node;
	}
	
	/**
	 * Displays info for a given node
	 */
	public String toString() {
		return info.toString();
	}

} // end ListNode

class NodeFeatures {
	int data;
	int row;
	int col;
	
	/**
	 * Constructor for NodeFeatures object
	 * 
	 * @param data - int that will be stored as a piece of data in a
	 *         given node
	 * @param row - row of matrix where data sits
	 * @param col - column of matrix where data sits
	 */
	public NodeFeatures(int data, int row, int col) {
		this.data=data;
		this.row=row;
		this.col=col;
	}
	
	/**
	 * Gets data for a given node
	 * 
	 * @return data
	 */
	public int getData() {
		return data;
	}
	
	/**
	 * Gets row id for a given node
	 * 
	 * @return row
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Gets column id for a given node
	 * 
	 * @return col
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * Sets row id for a given node
	 * 
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * Sets column id for a given node
	 * 
	 * @param col
	 */
	public void setCol(int col) {
		this.col = col;
	}
	
	/**
	 * Displays all data for a given node
	 */
	public String toString() {
		return "Data: " + data + ", at (" + row + "," + col + ")";
	}
} // end DataGrouping
