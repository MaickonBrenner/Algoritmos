public class HeapSort {
    public void maxHeapify(int[] A, int i, int n) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * 1 + 2;
        if (l < n && A[l] > A[largest]) {
            largest = l;
        }
        if (r < n && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            int change = A[i];
            A[i] = A[largest];
            A[largest] = change;
            maxHeapify(A, largest, n);
        }
    }

    public void buildMaxHeap(int[] A, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(A, i, n);
        }
    }

    public void heapSort(int[] A, int n) {
        buildMaxHeap(A, n);
        for (int i = n - 1; i >= 0; i--) {
            int temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            maxHeapify(A, i, n);
        }
    }
}
//https://www.youtube.com/watch?v=Xw2D9aJRBY4
//https://www.youtube.com/watch?v=Vc5M9rvCD5E