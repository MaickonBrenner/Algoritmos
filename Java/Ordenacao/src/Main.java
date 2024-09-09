import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExibirVetor alg = new ExibirVetor();
        Vetor vetor = new Vetor();

        int[] vet = vetor.pegarVetor();
        int n = vet.length;

        boolean cont = true;

        do {
            System.out.println("[1] - InsertionSort");
            System.out.println("[2] - MergeSort");
            System.out.println("[3] - BubbleSort");
            System.out.println("[4] - QuickSort");
            System.out.println("[5] - HeapSort");
            System.out.println("[6] - SelectionSort");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Vetor Desordenado: ");
                    alg.exibir(n, vet);
                    InsertionSort insertionSort = new InsertionSort();
                    insertionSort.insertionSort(vet, n);
                    System.out.print("Vetor Ordenado: ");
                    alg.exibir(n, vet);
                    break;
                case 2:
                    System.out.println("Vetor Desordenado: ");
                    alg.exibir(n, vet);
                    MergeSort mergeSort = new MergeSort();
                    mergeSort.mergeSort(vet, n);
                    System.out.print("Vetor Ordenado: ");
                    alg.exibir(n, vet);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Vetor Desordenado: ");
                    alg.exibir(n, vet);
                    QuickSort quickSort = new QuickSort();
                    quickSort.quickSort(vet, vet[0], n - 1);
                    System.out.print("Vetor Ordenado: ");
                    alg.exibir(n, vet);
                    break;
                case 5:
                    System.out.println("Vetor Desordenado: ");
                    alg.exibir(n, vet);
                    HeapSort heapSort = new HeapSort();
                    heapSort.heapSort(vet, n);
                    System.out.print("Vetor Ordenado: ");
                    alg.exibir(n, vet);
                    break;
                case 6:
                    break;
            }
            System.out.println("Deseja voltar para o menu principal? ");
            String op = scanner.next();
            if (op.equalsIgnoreCase("n")) {
                cont = false;
            }
        } while(cont);
    }
}
/*
https://www.devmedia.com.br/algoritmos-de-ordenacao-em-java/32693
Comparação de Algoritmos 1:
https://www.youtube.com/watch?v=kPRA0W1kECg
Comparação de Algoritmos 2:
https://www.youtube.com/watch?v=ZZuD6iUe3Pc
*/