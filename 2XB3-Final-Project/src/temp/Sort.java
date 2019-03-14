package temp;

public class Sort {

	// referred to Algorithms, 4th Edition, page 245
	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	// referred to Algorithms, 4th Edition, page 270-271
	private static void merge(Comparable[] x, Comparable[] aux, int begin, int mid, int end) {
		for (int i = begin; i <= end; i++) {
			aux[i] = x[i];
		}
		int i = begin, j = mid + 1;
		for (int k = begin; k <= end; k++) {
			if (i > mid) {
				x[k] = aux[j];
				j++;

			} else if (j > end) {
				x[k] = aux[i];
				i++;
			} else if (less(aux[i], aux[j])) {
				x[k] = aux[i];
				i++;
			} else {
				x[k] = aux[j];
				j++;
			}
		}
	}

	// referred to Algorithms, 4th Edition, page 272-273
	private static void sortTD(Comparable[] x, Comparable[] aux, int begin, int end) {
		if (end <= begin) {
			return;
		}
		// this is integer division
		sortTD(x, aux, begin, begin + (end - begin) / 2);
		sortTD(x, aux, begin + (end - begin) / 2 + 1, end);
		merge(x, aux, begin, begin + (end - begin) / 2, end);
	}

	/**
	 * top-down merge sort using Comparable; referred to Algorithms, 4th Edition,
	 * page 272-273
	 * 
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMergeTD(Comparable[] x, int n) {
		Comparable[] aux = new Comparable[n];
		sortTD(x, aux, 0, n - 1);
	}

}
