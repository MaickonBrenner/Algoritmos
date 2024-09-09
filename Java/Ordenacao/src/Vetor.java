import java.util.Scanner;

public class Vetor {
    Scanner scanner = new Scanner(System.in);
    int[] vetor = new int[6];
    int n = vetor.length;
    public int[] pegarVetor() {
        for(int i = 0; i < n; i++) {
            System.out.println("Digite o " + (i + 1) + "º Posição: ");
            vetor[i] = scanner.nextInt();
        }
        return vetor;
    }
    public void exibirVetor() {
        for(int i = 0; i < n; i++) {
            System.out.println("Valor na " + (i + 1) + "º Posição: ");
        }
    }
}
//https://pt.stackoverflow.com/questions/48370/retornar-vetor-de-inteiros-em-java
