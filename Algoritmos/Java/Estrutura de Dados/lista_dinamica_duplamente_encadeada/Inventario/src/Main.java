import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();

        boolean continuar = true;
        do {
            System.out.println("O que deseja realizar: (1 - Adicionar, 2 - Remover, 3 - Listar, 4 - Total), 5 - Consultar");
            int resp = scanner.nextInt();

            switch (resp) {
                case 1:
                    inventario.adicionarProduto(1); //Chamada do Método
                    break;

                case 2:
                    inventario.removerProduto();
                    break;

                case 3:
                    inventario.mostrarInventario();
                    break;

                case 4:
                    inventario.valorTotal();
                    break;

                case 5:
                    inventario.atualizar();
                    break;

                case 6:
                    inventario.consultarProduto();
                    break;
            }
            System.out.println("Deseja realizar algo mais? (s/n)");
            scanner.nextLine();
            String escolha = scanner.nextLine();

            if (escolha.equalsIgnoreCase("n")) {
                continuar = false;
                System.exit(0);
            }
        } while (continuar);
    }
}