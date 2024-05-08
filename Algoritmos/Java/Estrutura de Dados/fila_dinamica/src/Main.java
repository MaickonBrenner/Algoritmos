import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FilaVarejo<Cliente> filaVarejo = new FilaVarejo<>();
        Caixa caixa = new Caixa();
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;

        System.out.println("-----------------------------------------");
        System.out.println("         Bem vindo(a) ao Sistema!        ");
        System.out.println("-----------------------------------------");

        do {
            System.out.println("Digite um número: (1 - Abrir o Caixa, 2 - Fechar o Caixa)");
            int escolha = scanner.nextInt();
            int quantAtend = 0;

            switch (escolha) {
                case 1:
                    caixa.abrirCaixar();
                    boolean cont1 = true;

                    do {
                        System.out.println("Digite um número: (1 - Adicionar, 2 - Atender, 3 - Voltar)");
                        int escolha1 = scanner.nextInt();

                        switch (escolha1) {
                            case 1:
                                System.out.println("Digite o nome do cliente: ");
                                String nomeC = scanner.next();
                                System.out.println("Digite a quantidade de produtos: ");
                                int quantP = scanner.nextInt();
                                filaVarejo.adicionarCliente(new Cliente(nomeC, quantP));
                                quantAtend++;
                                System.out.println("O cliente " + nomeC + " foi adicionado a fila!");

                                if (quantAtend == 0) {
                                    System.out.println("Todos os clientes foram atendidos!");
                                } else {
                                    System.out.println("No momento temos: " + quantAtend + " cliente(s) na fila");
                                }

                                break;
                            case 2:
                                System.out.println("Cliente em atendimento...");
                                Cliente clienteAtendido = filaVarejo.atenderCliente();
                                System.out.println("O cliente " + clienteAtendido.nomeCliente + " foi atendido!");
                                quantAtend--;

                                if (quantAtend == 0) {
                                    System.out.println("Todos os clientes foram atendidos!");
                                } else {
                                    System.out.println("Cliente(s) restante(s): " + quantAtend + " cliente(s)");
                                }
                                break;
                            case 3:
                                System.out.println("Voltando para o menu...");
                                cont1 = false;
                        }

                        System.out.println("Deseja voltar para o menu principal? ");
                        String op = scanner.next();
                        if (op.equalsIgnoreCase("n")) {
                            cont1 = false;
                        }

                    } while (cont1);

                    break;
                case 2:
                    caixa.fecharCaixa();
            }

            System.out.println("Deseja continuar no sistema? ");
            String op = scanner.next();
            if (op.equalsIgnoreCase("n")) {
                System.out.println("Encerrando sistema...");
                cont = false;
            }

        } while(cont);

        System.exit(0);
    }
}