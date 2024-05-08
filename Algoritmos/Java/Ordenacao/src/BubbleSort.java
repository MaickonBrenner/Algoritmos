public class BubbleSort {
    public void bubbleSort(int[] A, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(A[j] > A[j + 1]) {
                    int aux = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = aux;
                }
            }
        }
    }
}

//https://www.devmedia.com.br/entendendo-o-algoritmo-bubble-sort-em-java/24812
