public class Pilha {
    private int tamanho;
    private int topo;
    private int[] elementos;

    public Pilha(int tamanho) {
        this.tamanho = tamanho;
        this.topo = -1;
        this.elementos = new int [tamanho];
    }

    public boolean isEmpty() {

        return topo == -1;
    }

    public boolean isFull() {

        return topo == tamanho - 1;
    }

    public void push(int elemento) {
        if (isFull()) {
            System.err.println("Erro: A pilha está cheia. Não é possível adicionar mais elementos.");
        } else {
            topo++;
            elementos[topo] = elemento;
        }
    }

    public int pop() {
        if (isFull()) {
            System.err.println("Erro: A pilha está cheia. Não é possível adicionar mais elementos.");
            return -1;
        } else {
            int elementoRemovido = elementos[topo];
            topo--;
            return elementoRemovido;
        }
    }
    public int peek() {
        if (isFull()) {
            System.err.println("Erro: A pilha está cheia. Não é possível adicionar mais elementos.");
            return -1;
        } else {
            return elementos[topo];
        }
    }

    public int tamanho() {

        return topo + 1;
    }
}
