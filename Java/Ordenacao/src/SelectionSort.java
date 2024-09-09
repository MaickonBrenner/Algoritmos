public class SelectionSort {
    ExibirVetor alg = new ExibirVetor();
    public void selectionSort(int[] A, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            int aux = A[i];
            A[i] = A[min];
            A[min] = aux;
            alg.exibir(n, A);
        }
    }

}
//https://joaoarthurbm.github.io/eda/posts/selection-sort/
//https://www.youtube.com/watch?v=MxEooU-8ps8