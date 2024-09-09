import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { //Maickon Brenner - 2224203

        Pilha<Produto> pilha = new Pilha<>();
        Produto produto = new Produto();
        Scanner scanner = new Scanner(System.in);

        boolean cont = true;
        do {
            System.out.println("Digite um número: (1 - Adicionar, 2 - Vender, 3 - Visualizar, 4 - Verificar, 5 - Sair)");
            int resp = scanner.nextInt();

            switch(resp) {
                case 1:
                    System.out.println("Digite o ID: ");
                    int idP = scanner.nextInt();
                    System.out.println("Digite o nome do produto: ");
                    String nomeP = scanner.next();
                    System.out.println("Digite a quantidade: ");
                    int qtdP = scanner.nextInt();
                    pilha.push(new Produto(idP, nomeP, qtdP));
                    /* Também:
                        Produto novoProduto = new Produto(idP, nomeP, qtdP);
                        pilha.push(novoProduto);
                     */
                    break;
                case 2:
                    Produto produtoVendindo = pilha.pop();
                    System.out.println("O produto " + produtoVendindo +" foi vendindo e removido do estoque!");
                    break;
                case 3:
                    Produto produtoTopo = pilha.peek();
                    System.out.println("Último produto adicionado (No topo): " + produtoTopo);
                    break;
                case 4:
                    if(pilha.isEmpty()) {
                        System.err.println("O estoque está vazio!");
                    } else {
                        System.out.println("O estoque não está vazio!");
                    }
                    break;
                case 5:
                    System.out.println("O programa será encerrado...");
                    System.exit(0);
                    break;
            }

            System.out.println("Deseja continuar? ");
            String op = scanner.next();
            if (op.equalsIgnoreCase("n")) {
                cont = false;
            }
        } while (cont);
    }
}