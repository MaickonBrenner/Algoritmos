public class MergeSort {
    ExibirVetor alg = new ExibirVetor();
    public void mergeSort(int[] v, int n) {
        if (n < 2) {
            return;
        }
        int middle = n / 2;
        int[] left = new int[middle];
        int[] right = new int[n - middle];
        for (int i = 0; i < middle; i++) {
            left[i] = v[i];
        }
        for (int i = middle; i < n; i++) {
            right[i - middle] = v[i];
        }
        mergeSort(left, middle);
        mergeSort(right, n - middle);
        merge(v, left, right, middle, n - middle);
        alg.exibir(n, v);
    }
    public void merge(int[] v, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                v[k++] = left[i++];
            } else {
                v[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            v[k++] = left[i++];
        }
        while (j < rightSize) {
            v[k++] = right[j++];
        }
    }
}
//https://joaoarthurbm.github.io/eda/posts/merge-sort/
//https://www.youtube.com/watch?v=XaqR3G_NVoo
