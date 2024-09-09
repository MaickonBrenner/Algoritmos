public class QuickSort {
    ExibirVetor alg = new ExibirVetor();
    public void quickSort(int[] A, int p, int r) {// p = inicio e r = fim
        if (p < r) {
            int pivot = partition(A, p, r); //Pivô
            quickSort(A, p, pivot - 1);
            quickSort(A, pivot + 1, r);
        }
    }
    public int partition(int[] A, int p, int r) {
        int pivot = A[p];
        int i = p + 1, f = r;
        while (i <= f) {
            if (A[i] <= pivot) {
                i++;
            } else if (pivot < A[f]) {
                f--;
            } else {
                int change = A[i];
                A[i] = A[f];
                A[f] = change;
                i++;
                f--;
            }
        }
        A[p] = A[f];
        A[f] = pivot;
        return f;
    }
}
//https://www.youtube.com/watch?v=ywWBy6J5gz8
//https://www.youtube.com/watch?v=es2T6KY45cA