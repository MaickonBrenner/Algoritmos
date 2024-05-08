import java.util.ArrayList;
import java.util.Scanner;

public class Inventario { //DoublyLinkedList
    private Node head;
    private Node tail;

    public Inventario() {
        this.head = null;
        this.tail = null;
    }
    Scanner scanner = new Scanner(System.in);
    ArrayList<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(int data) {

        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void removerProduto() {

    }

    public void mostrarInventario() {
        Node current = head;
        System.out.println("Lista: ");
        while (current != null) {
            System.out.println(current.data + ", ");
            current = current.next;
        }
        System.err.println("null");
    }

    public void valorTotal() {

    }

    public void atualizar() {

    }

    public void consultarProduto() {

    }
}
