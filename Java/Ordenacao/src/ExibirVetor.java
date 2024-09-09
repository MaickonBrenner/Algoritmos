public class ExibirVetor {
    public void exibir(int n, int[] A) {
        System.out.print("{");
        for(int i = 0; i < n; i++) {
            System.out.print(" " + A[i] + " ");
        }
        System.out.println("}");
    }
}
