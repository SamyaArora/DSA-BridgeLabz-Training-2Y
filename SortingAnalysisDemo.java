import java.util.*;
class SortingAnalysisDemo {

	 
		static void bubbleSort(int[] a) {
	        for (int i = 0; i < a.length - 1; i++) {
	            boolean swapped = false;
	            for (int j = 0; j < a.length - i - 1; j++) {
	                if (a[j] > a[j + 1]) {
	                    int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t;
	                    swapped = true;
	                }
	            }
	            if (!swapped) break;
	        }
	    }

	    // Insertion Sort
	    static void insertionSort(int[] a) {
	        for (int i = 1; i < a.length; i++) {
	            int key = a[i], j = i - 1;
	            while (j >= 0 && a[j] > key) a[j + 1] = a[j--];
	            a[j + 1] = key;
	        }
	    }

	    // Merge Sort
	    static void mergeSort(int[] a, int l, int r) {
	        if (l < r) {
	            int m = (l + r) / 2;
	            mergeSort(a, l, m);
	            mergeSort(a, m + 1, r);
	            merge(a, l, m, r);
	        }
	    }

	    static void merge(int[] a, int l, int m, int r) {
	        int[] t = new int[r - l + 1];
	        int i = l, j = m + 1, k = 0;
	        while (i <= m && j <= r) t[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];
	        while (i <= m) t[k++] = a[i++];
	        while (j <= r) t[k++] = a[j++];
	        System.arraycopy(t, 0, a, l, t.length);
	    }

	    // Quick Sort
	    static void quickSort(int[] a, int l, int h) {
	        if (l < h) {
	            int p = partition(a, l, h);
	            quickSort(a, l, p - 1);
	            quickSort(a, p + 1, h);
	        }
	    }

	    static int partition(int[] a, int l, int h) {
	        int p = a[h], i = l - 1;
	        for (int j = l; j < h; j++)
	            if (a[j] <= p) { int t = a[++i]; a[i] = a[j]; a[j] = t; }
	        int t = a[i + 1]; a[i + 1] = a[h]; a[h] = t;
	        return i + 1;
	    }

	    // Complexity comparison
	    static long mysteryCost(long n) { return 5*n*n + 100*n + 1000; }
	    static double mergeCost(long n) { return 10*n*Math.log(n)/Math.log(2); }

	    public static void main(String[] args) {
	        int[] data = new Random().ints(20, 1, 100).toArray();
	        System.out.println("Original: " + Arrays.toString(data));

	        int[] b = data.clone(); bubbleSort(b);
	        int[] i = data.clone(); insertionSort(i);
	        int[] m = data.clone(); mergeSort(m, 0, m.length - 1);
	        int[] q = data.clone(); quickSort(q, 0, q.length - 1);

	        System.out.println("Bubble: " + Arrays.toString(b));
	        System.out.println("Insertion: " + Arrays.toString(i));
	        System.out.println("Merge: " + Arrays.toString(m));
	        System.out.println("Quick: " + Arrays.toString(q));

	        System.out.println("\nMystery vs Merge:");
	        for (int n = 10; n <= 1000; n *= 10)
	            System.out.println("n=" + n + " | Mystery=" + mysteryCost(n) +
	                               " | Merge=" + (long) mergeCost(n));
	    

	}

}
