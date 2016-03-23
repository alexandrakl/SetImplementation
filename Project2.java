/**
 * Alexandra Klimenko CS 240 - 02 Set Implementation The Project2 is class used
 * for the set implementation. It instantiazes the sets, and checks all the
 * operation with 5 cases. It has 3 methods, including main.
 * 
 * @author alexa
 */
public class Project2 {

	/**
	 * The main method calls in the printMethods with all the operations, and
	 * resets the sets for new values by calling the makeSet.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		SashaSet setA = new SashaSet();
		SashaSet setB = new SashaSet();

		System.out.println("Case1: ");
		setA = makeSet(new int[] { 1, 2, 3 });
		setB = makeSet(new int[] { 2, 1, 3 });

		printMethods(setA, setB);

		System.out.println("\nCase2: ");
		setA = makeSet(new int[] { 1 });
		setB = makeSet(new int[] { 1, 2 });

		printMethods(setA, setB);

		System.out.println("\nCase3: ");
		setA = makeSet(new int[] { 1, 2, 3 });
		setB = makeSet(new int[] { 2, 3, 4, 5 });

		printMethods(setA, setB);

		System.out.println("\nCase4: ");
		setA = makeSet(new int[] { 1 });
		setB = makeSet(new int[] { 2, 3 });

		printMethods(setA, setB);

		System.out.println("\nCase5: ");
		setA = makeSet(new int[] { 1 });
		setB = makeSet(new int[] {});

		printMethods(setA, setB);
	}

	/**
	 * The makeSet is implemented for easier testing.
	 * 
	 * @param toAdd
	 * @return
	 */
	public static SashaSet makeSet(int[] toAdd) {
		SashaSet s = new SashaSet();
		for (int i = 0; i < toAdd.length; ++i) {
			s.addElement(toAdd[i]);
		}
		return s;
	}

	/**
	 * Method prntMethods displays all the operations in main, also implemented
	 * for easier testing.
	 * 
	 * @param setA
	 * @param setB
	 */
	private static void printMethods(SashaSet setA, SashaSet setB) {
		System.out.println("Set A is: " + setA);
		System.out.println("Set B is: " + setB);

		System.out.println("Set A contains element 1: " + setA.contain(1));
		System.out.println("Set A adds element 1: " + setA.addElement(1));
		System.out.println("Set A removes element 1: " + setA.remove(1));
		System.out.println("Size of set A is: " + setA.size());

		System.out.println("Set A is a subset of set B: " + setA.SubsetOf(setB));
		System.out.println("Set A is equal to set B" + setA.isEqual(setB));

		System.out.println("Set A in union with B is: " + setA.union(setB));
		System.out.println("Set A in intersection with B is: " + setA.intersection(setB));
		System.out.println("Set A complement with B: " + setA.complement(setB));

		System.out.println("toString method of Set A: " + setA.toString());
	}
}
