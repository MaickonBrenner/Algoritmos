public class InsertionSort {
    ExibirVetor alg = new ExibirVetor();
    public void insertionSort(int[] A, int n) {
        for(int j = 1; j < n; j++) {
            int key = A[j];
            int i = j - 1;
                while ((i >= 0) && (A[i] > key)) {
                    A[i + 1] = A[i];
                    i--; //i = i - 1;
                }
            A[i + 1] = key;
            alg.exibir(n, A); //<-
        }
    }
}
//https://www.youtube.com/watch?v=ROalU379l3U


