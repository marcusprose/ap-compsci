import java.util.ArrayList;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Sorting {

	public static void main(String[] args) {
		ArrayList<String> ignore = new ArrayList<String>();
		String[] algorithms = {"bubble", "selection", "insertion", "merge"};
		System.out.print("Size      ");
		for (String a : algorithms) {
			System.out.printf("%15s", a);
		}
		System.out.println();
		printArr(reverseArr(20));
		for(int num = 100; num < 10000000; num = num * 2){
			System.out.printf("%-10d", num);
			int[] randomArray = randomArr(num);
			// int[] randomArray = reverseArr(num);
			// int[] randomArray = new int[num];
			for(String a : algorithms){
				if (!ignore.contains(a)) {
					double time = testSort(a,randomArray) / 1000000.0;
					System.out.printf("%,15.3f", time);
					if (time > 15000) {
						ignore.add(a);
					}
				} else {
					System.out.printf("%15s", "---");
				}
			}
			System.out.println();
		}
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
	public static void insertion(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			for (int j = i - 1; j >= 0 && arr[j] > temp; j--) {
				arr[j + 1] = arr[j];
				arr[j] = temp;
			}

		}



	}

	// Merge Sort

	public static void merge(int[] arr) {
		merge(arr, 0, arr.length);
	}

	public static void merge(int[] arr, int start, int end) {
		if (end - start <= 1) {
			return;
		}
		int mid = start + (end - start) / 2;
		merge(arr, start, mid);
		merge(arr, mid, end);
		int[] half = new int[end - start];
		int left = start;
		int right = mid;
		int index = 0;
		while (left != mid && right != end) {
			if (arr[left] <= arr [right]) {
				half[index] = arr[left];
				left++;
			} else {
				half[index] = arr[right];
				right++;
			}
			index++;
		}
		while (right != end) {
			half[index] = arr[right];
			right++;
			index++;
		}
		while (left != mid) {
			half[index] = arr[left];
			left++;
			index++;
		}
		for (int i = start; i < end; i++) {
			arr[i] = half[i - start];
		}
	}

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
		int[] ar = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			ar[i] = arr[i];
		}
		return ar;

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

	public static int[] reverseArr(int num) {
		int[] arr = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = num - i;
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
