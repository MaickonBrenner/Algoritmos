public class main {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        // Inserindo elementos na árvore
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);

        // Calculando o tamanho da árvore
        System.out.println("Tamanho da árvore: " + tree.size());

        // Buscando um nó na árvore
        int keyToSearch = 70;
        if (tree.search(keyToSearch)) {
            System.out.println(keyToSearch + " encontrado na árvore.");
        } else {
            System.out.println(keyToSearch + " não encontrado na árvore.");
        }
    }
}