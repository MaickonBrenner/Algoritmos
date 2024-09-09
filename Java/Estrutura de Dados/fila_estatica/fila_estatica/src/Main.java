
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FilaSupermercado fila = new FilaSupermercado(5);
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        int quantAtend = 0;
        //fila.entrarNaFila(new Cliente("João", 5));

        do {
            System.out.println("Digite um número: (1 - Entrar na Fila, 2 - Atender, 3 - Verificar, 4 - Sair)");
            int resp = scanner.nextInt();

            switch (resp) {
                case 1:
                    System.out.println("Digite o nome do cliente: ");
                    String nomeC = scanner.next();
                    System.out.println("Digite a quantidade de produtos: ");
                    int quantP = scanner.nextInt();
                    fila.entrarNaFila(new Cliente(nomeC, quantP));
                    quantAtend++;
                    System.out.println("O cliente " + nomeC + " foi adicionado a fila!");
                    break;
                case 2:
                    System.out.println("Cliente em atendimento...");
                    Cliente clienteAtendido = (Cliente)fila.atenderCliente();
                    System.out.println("O cliente " + clienteAtendido.nomeCliente + " foi atendido!");
                    quantAtend--;

                    if (quantAtend == 0) {
                        System.out.println("Todos os clientes foram atendidos!");
                    } else {
                        System.out.println("Cliente(s) restante(s): " + quantAtend + " cliente(s)");
                    }
                    break;
                case 3:
                    fila.tamanhoDaFila();
                    System.out.println("No momento, existe(m): " + quantAtend + " clientes.");
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    System.exit(0);
            }

            System.out.println("Deseja continuar? ");
            String op = scanner.next();
            if (op.equalsIgnoreCase("n")) {
                cont = false;
            }

        } while (cont);

    }
}