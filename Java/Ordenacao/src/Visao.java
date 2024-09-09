import java.util.Scanner;

public class Visao {
    Scanner scanner = new Scanner(System.in);
    public void pegarVetor() {
        System.out.println("Digite o vetor: ");
        int[] vetor = new int[]{scanner.nextInt()};
        int n = vetor.length;
    }
}
