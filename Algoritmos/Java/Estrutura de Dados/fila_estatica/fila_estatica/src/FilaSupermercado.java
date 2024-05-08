public class FilaSupermercado {

    private int maxSize;
    private int front ;
    private int rear;
    private Cliente[] queue;

    public FilaSupermercado(int size) {
        maxSize = size;
        front = 0;
        rear = -1;
        queue = new Cliente[maxSize];
    }

    public void entrarNaFila(Cliente cliente) { //Enqueue ou "Push"
        if(isFull()) {
            System.err.println("A fila está cheia! Não é possível adicionar elementos.");
        } else {
            queue[++rear] = cliente;
        }
    }

    public Cliente atenderCliente() { //Dequeue
        if(isEmpty()) {
            System.err.println("A fila está vazia. Não é possível remover elementos.");
        } else {
            Cliente cliente = queue[front];
            for (int i = 0; i < rear; i++) {
                queue[i] = queue[i + 1];
            }
            rear--;
            return cliente;
        }
        return null;
    }

    public Cliente tamanhoDaFila() { //Peek
        if(isEmpty()) {
            System.err.println("A fila está vazia! Não é possível obter elementos.");
        } else {
            System.out.println("A fila não está vazia!");
            return queue[front];
        }
        return null;
    }

    public int filaVazia() { //Size
        return rear - front + 1;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }
}
