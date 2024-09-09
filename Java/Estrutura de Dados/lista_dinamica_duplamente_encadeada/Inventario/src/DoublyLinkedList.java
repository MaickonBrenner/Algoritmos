public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
}
/*
Adicionar
        boolean continuar = true;
        do {
            System.out.println("Digite o nome do produto: ");
            String nomeP = scanner.next();
            System.out.println("Digite o valor: ");
            double precoP = scanner.nextDouble();
            System.out.println("Digite a quantidade: ");
            int quantP = scanner.nextInt();

            Produto novoProduto = new Produto(nomeP, precoP, quantP);

            System.out.println("Deseja adicionar mais algum produto?: (s/n)");
            scanner.nextLine();
            String escolha = scanner.nextLine();
            if (escolha.equalsIgnoreCase("n")){
                continuar = false;
            }
        } while (continuar);
    }

listar
 boolean continuar = true;
        do {
            for (Produto produto : produtos) {
                System.out.println("-------------------------");
                System.out.println("Produto: " + produto.nome);
                System.out.println("Preço: " + produto.preco);
                System.out.println("Quantidade: " + produto.quantidade);
            }

            System.out.println("Deseja adicionar mais algum produto?: (s/n)");
            scanner.nextLine();
            String escolha = scanner.nextLine();
            if (escolha.equalsIgnoreCase("n")){
                continuar = false;
            }
        } while (continuar);
 */
