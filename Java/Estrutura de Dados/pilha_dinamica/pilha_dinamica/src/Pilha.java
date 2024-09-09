import java.util.EmptyStackException;
import java.util.Scanner;

public class Pilha<T> {
    private Node<T> top;
    private int size;

    public Pilha() {
        this.top = null;
        this.size = 0;
    }
    Scanner scanner = new Scanner(System.in);
    Produto produto = new Produto();
    public void push(T data) { //Adicionar
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() { //Vender
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public T peek() { //Visualizar
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

