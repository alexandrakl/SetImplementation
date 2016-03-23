/**
 * Alexandra Klimenko CS 240 - 02
 * Set Implementation
 * The SashaSet Class is the set class with all operations.
 * 
 * @author alexa
 */
public class SashaSet {

	private Node head = new Node(null, null);
	private int size;

	private static class Node {
		Object data;
		Node next;

		Node(Object data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * Create a method searchPrevNode in order to search for the object and use
	 * in the contain and remove methods. However, the method return the
	 * previous object in order to implement the remove method more easily.
	 * 
	 * @param objectToSearch
	 * @return
	 */
	private Node searchPrevNode(Object objectToSearch) {

		Node prev = head;
		Node current = head.next;

		while (current != null) {

			if (objectToSearch.equals(current.data)) {
				break;
			}

			prev = current;
			current = current.next;
		}

		if (current == null)
			return null;

		return prev;
	}

	/**
	 * The method contain calls the searchPrevNode method to check whether the
	 * object is found and return true, otherwise return false.
	 * 
	 * @param objectContained
	 * @return
	 */
	public Boolean contain(Object objectContained) {

		Node result = searchPrevNode(objectContained);

		if (result == null) {
			return false;
		}
		return true;
	}

	/**
	 * The remove method calls the searchPrevNode method. If the previous node
	 * is not null, it removes the current node and returns true, otherwise
	 * returns false. To remove an object, we set the link of the previous node
	 * pointing to the node's next and the node's link to null.
	 * 
	 * @param objectToRemove
	 * @return
	 */
	public Boolean remove(Object objectToRemove) {

		Node previousObject = searchPrevNode(objectToRemove);

		if (previousObject == null) {
			return false;
		} else {
			Node current = previousObject.next;
			previousObject.next = current.next;
			current.next = null;
			--size;
		}

		return true;
	}

	/**
	 * The addElement method adds an element to the set if it not there yet. It
	 * calls the contain method to check whether the object is in the set
	 * already and returns false if it is, otherwise adds the element to the
	 * head and returns true.
	 * 
	 * @param objectToAdd
	 *            - the data to be added to the Set
	 * @return
	 */
	public Boolean addElement(Object objectToAdd) {

		if (this.contain(objectToAdd)) {
			return false;
		} else {
			head.next = new Node(objectToAdd, head.next);
			++size;
		}

		return true;
	}

	/**
	 * The method size returns an integer equal to the number of distinct
	 * objects that are in the Set.
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * The method SubsetOf returns true if every element in Subset A is in set
	 * B, and returns false otherwise. 
	 * 
	 * @param SetB
	 * @return
	 */
	public Boolean SubsetOf(SashaSet SetB) {

		Node tempA = head;

		for (int i = 0; i < size; ++i) {
			tempA = tempA.next;

			if (!SetB.contain(tempA.data)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * The method isEqual compares the elements in both sets not taking in the
	 * consideration order. If they are the same, returns true, otherwise
	 * returns false.
	 * 
	 * @param SetB
	 * @return
	 */
	public Boolean isEqual(SashaSet SetB) {

		Node tempA = head;

		if (size != SetB.size) {
			return false;
		}

		for (int i = 0; i < size; ++i) {
			tempA = tempA.next;

			if (!SetB.contain(tempA.data)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * The union method returns a set that contains all the elements that are in
	 * both sets A and B. The union set is called SetC, where it takes the form
	 * C = A.union(B) and has all elements listed only once.
	 * 
	 * @param SetB
	 * @return
	 */
	public SashaSet union(SashaSet SetB) {

		SashaSet SetC = new SashaSet();
		Node tempA = head;
		Node tempB = SetB.head;

		for (int i = 0; i < SetB.size; ++i) {
			tempB = tempB.next;
			SetC.addElement(tempB.data);
		}

		for (int i = 0; i < size; ++i) {
			tempA = tempA.next;
			if (SetB.contain(tempA.data)) {

			} else {
				SetC.addElement(tempA.data);
			}
		}
		return SetC;

	}

	/**
	 * The method intersection compares SetA and SetB and returns a Set C which
	 * contains only their common elements, but without any duplicates.
	 * 
	 * @param SetB
	 * @return
	 */
	public SashaSet intersection(SashaSet SetB) {
		SashaSet SetC = new SashaSet();
		Node tempA = head;

		for (int i = 0; i < size; ++i) {
			tempA = tempA.next;
			if (SetB.contain(tempA.data)) {
				SetC.addElement(tempA.data);
			}
		}
		return SetC;
	}

	/**
	 * The method complement returns a set that contains only elements which are
	 * in Set A, but not in set B. The form of SetC is C=A.complement(B)
	 * 
	 * @param SetB
	 * @return
	 */
	public SashaSet complement(SashaSet SetB) {

		SashaSet SetC = new SashaSet();

		Node tempA = head;

		for (int i = 0; i < size; i++) {
			tempA = tempA.next;

			if (!SetB.contain(tempA.data)) {
				SetC.addElement(tempA.data);
			}
		}

		return SetC;
	}

	/**
	 * The toString method displays the data stored in the object field at any
	 * given moment
	 * 
	 * @param objectToDisplay
	 * @return
	 */
	public String toString() {
		String toReturn = "";
		Node temp = head;
		toReturn += "{ ";
		for (int i = 0; i < size; ++i) {
			temp = temp.next;
			toReturn += temp.data;
			toReturn += i == size - 1 ? "" : ", ";
		}
		toReturn += " }";
		return toReturn;
	}
}
