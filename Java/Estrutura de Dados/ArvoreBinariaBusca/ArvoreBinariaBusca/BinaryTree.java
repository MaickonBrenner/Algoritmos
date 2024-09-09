public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    // Método para calcular o tamanho da árvore
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            return size(node.left) + 1 + size(node.right);
        }
    }

    // Método para inserir um novo nó na árvore
    // Node root: Representa a raiz da subárvore atual onde o novo nó será inserido.
    // int key: O valor do novo nó a ser inserido.
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        //Se a raiz da subárvore atual (root) for nula, significa que a subárvore está vazia, então criamos um novo nó com o valor key e o tornamos a raiz da subárvore.
        if (root == null) {
            root = new Node(key);
            return root;
        }

        //Se key for menor que o valor do nó atual (root.data), então o novo nó deve ser inserido na subárvore esquerda. Portanto, fazemos uma chamada recursiva para insertRec passando a subárvore esquerda (root.left) como a nova raiz.
        if (key < root.data) {
            root.left = insertRec(root.left, key);
        }
        //Se key for maior, então o novo nó deve ser inserido na subárvore direita, e fazemos uma chamada recursiva para insertRec passando a subárvore direita (root.right) como a nova raiz.
        else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Método para buscar um nó na árvore
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        //Se o nó atual (root) for nulo, significa que não achamos o valor desejados, então root != null é falso
        //Se o valor do nó atual (root.data) for igual a key, significa que achamos o valor desejados, então root != null é verdadeiro
        if (root == null || root.data == key) {
            return root != null;
        }

        //Se o valor desejado (key) for menor que o valor do nó atual (root.data), então sabemos que o nó procurado está na esquerda. Portanto, fazemos uma chamada recursiva para searchRec com a subárvore esquerda (root.left) como a nova raiz.
        if (key < root.data) {
            return searchRec(root.left, key);
        }
        //Se o valor desejado for maior, então sabemos que o nó procurado está na direita, e fazemos uma chamada recursiva para searchRec com a subárvore direita (root.right) como a nova raiz.
        else {
            return searchRec(root.right, key);
        }
    }
}