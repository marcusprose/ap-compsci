import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Sorting {

	public static void main(String[] args) {
		String[] algorithms = {"bubble", "selection"};
		for(int num = 1000; num < 1000000; num = num * 2){
			System.out.println(num);
			int[] randomArray = randomArr(num);
			for(String a : algorithms){
				System.out.print(a + ": ");
				double time = testSort(a,randomArray) / 1000000.0;
				System.out.println(time);
			}
		}
		// selection(randomArray);
		// printArr(randomArray);

	}

	// Bubble Sort
	public static void bubble(int[] arr){
		boolean done = false;
		while (!done){
			done = true;
			for(int i = 0; i < arr.length-1; i++){
				if(arr[i]>arr[i+1]){
					int extra = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = extra;
					done=false;
				}
			}
		}
	}

	// Selection Sort
	public static void selection(int[] arr){
		for(int i = 0; i < arr.length - 1; i++){
			int mIndex = i;
			for(int j = i; j < arr.length; j++){
				if(arr[j] < arr[mIndex]){
					mIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[mIndex];
			arr[mIndex] = temp;
		}
	}

	// Insertion Sort

	// Merge Sort

	/* Runs the indicated sorting algorithm on a
	 * copy of the provided array. Returns the
	 * time taken in nanoseconds, or -1 if the
	 * sort fails for any reason
	 */
	public static long testSort(String sort, int[] arr) {
		// Create a copy of the array
		int[] tester = clone(arr);
		try {
			// Get the desired method from this class
			Class<?> c = Class.forName("Sorting");
			Method m = c.getDeclaredMethod(sort, arr.getClass());
			// Start the timer
			long time = System.nanoTime();
			// Run the sort algorithm
			m.invoke(null, tester);
			// Calculate elapsed time
			time = System.nanoTime() - time;
			// If the array is not sorted, fail
			if (!isSorted(tester)) {
				System.out.println("Not sorted!");
				return -1;
			}
			return time;
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (NoSuchMethodException nsme) {
			nsme.printStackTrace();
		} catch (IllegalAccessException iae) {
			iae.printStackTrace();
		} catch (InvocationTargetException ite) {
			ite.printStackTrace();
		}
		return -1;
	}

	/* Create and return a copy of the provided
	 * array
	 */
	public static int[] clone(int[] arr) {
		int[] arr1 = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			arr1[i] = arr[i];
		}
		return arr1;

	}

	/* Returns true if the provided array is
	 * sorted, false otherwise
	 */
	public static boolean isSorted(int[] arr) {
		for(int i = 0; i < arr.length-1; i++){
			if (arr[i] > arr[i+1]){
				return false;
			}
		}
		return true;
	}

	public static int[] randomArr(int num){
		int[] arr = new int[num];
		for(int i = 0; i < num;i++){
			arr[i] = (int)(num * Math.random());
		}
		return arr;
	}

	public static void printArr(int[] arr){
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

}
