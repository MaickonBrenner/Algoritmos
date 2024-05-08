
public class FilaVarejo<T> {
    //private int maxSize;
    private Node<T> front;
    private Node<T> rear;

    public FilaVarejo() {
        front = rear = null;
    }

    public void adicionarCliente(T item) { //Enqueue ou "Push"
        Node<T> newNode = new Node<>(item);
        if(isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }
    public Cliente atenderCliente() { //Dequeue
        if(isEmpty()) {
            System.err.println("A fila está vazia. Não é possível atender!");
        }
        T item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return (Cliente) item;
    }
    public boolean isEmpty() {
        return front == null;
    }
}
