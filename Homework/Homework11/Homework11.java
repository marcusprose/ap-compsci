import java.util.ArrayList;

public class Homework11 {

public ArrayList<Integer> list;
	/* Finish the constructor and create any necessary instance
	 * variables. The constructor should create and save an
	 * ArrayList of int values
	 */
	public Homework11() {
		list = new ArrayList<Integer>();
	}

	/* Return the stored ArrayList
	 */
	public ArrayList<Integer> getList() {
		return list;
	}

	/* Fill the stored array list with integers, starting
	 * at n and up to, but not including, m. The size of
	 * the resultant ArrayList should be n - m.
	 */

	public void problem1(int n, int m) {
		int num = n;
		for (int i = 0; i < (m - n); i++) { //???
			list.add(num);
			num += 1;
		}
	}

	/* Remove from the stored array list all numbers that
	 * are evenly divisible by n. Remember that when you
	 * remove an item from the ArrayList, all elements to
	 * the right shift their indices down one.
	 */

	public void problem2(int n) {
	int i = 0;
	while (i < list.size()) {
			if ((list.get(i) % n) == 0) {
				list.remove(i);
			} else {
				i += 1;
			}
		}
	}

	/* Problem 3:
	 * Write the class Homework11A that extends this
	 * class. Ensure that you create the constructor
	 * appropriately and import java.util.ArrayList.
	 */

	/* Problem 4:
	 * Write the method problem4 in the Homework11A
	 * class. This should calculate and return the sum
	 * of the values in the stored ArrayList. The method
	 * header is:
	 * public int problem4() {
	 */

	/* Problem 5:
	 * In the Homework11A class, override the problem2
	 * method. problem2 in Homework11A should instead
	 * only keep the elements that evenly divide n
	 */

	public static void main(String[] args) {
		boolean passed = true;
		Homework11 hw11 = new Homework11();

		hw11.problem1(5, 13);
		ArrayList<Integer> al = hw11.getList();
		if (al.size() != 8) {
			System.out.println("Fail 1.1");
			passed = false;
		} else if (al.get(3) != 8) {
			System.out.println("Fail 1.2");
			passed = false;
		} else {
			System.out.println("Pass 1");
		}

		hw11.problem2(3);
		if (al.size() != 5) {
			System.out.println("Fail 2.1");
			passed = false;
		} else if (al.get(3) != 10) {
			System.out.println("Fail 2.2");
			passed = false;
		} else {
			System.out.println("Pass 2");
		}

		Homework11A hw11a = new Homework11A();

		hw11a.problem1(3, 13);
		al = hw11a.getList();
		if (al.size() != 10) {
			System.out.println("Fail 3.1");
			passed = false;
		} else if (al.get(4) != 7) {
			System.out.println("Fail 3.2");
			passed = false;
		} else {
			System.out.println("Pass 3");
		}

		if (hw11a.problem4() != 75) {
			System.out.println("Fail 4");
			passed = false;
		} else {
			System.out.println("Pass 4");
		}

		hw11a.problem2(12);
		if (al.size() != 4) {
			System.out.println(al.size());
			passed = false;
		} else if (al.get(3) != 12) {
			System.out.println("Fail 5.2");
			passed = false;
		} else {
			System.out.println("Pass 5");
		}

		if (passed) {
			System.out.println("All Pass");
		} else {
			System.out.println("Fail");
		}

	}
}
