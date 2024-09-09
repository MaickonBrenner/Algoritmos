
public class Main {
    public static void main(String[] args) {

        Pilha pilha = new Pilha(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        System.out.println("Elemento no topo: " + pilha.peek());
        System.out.println("Tamanho da pilha: " + pilha.tamanho());

        pilha.pop();
        System.out.println("Elemento no topo após o pop: " + pilha.peek());
        System.out.println("Tamanho da pilha após o pop:" + pilha.tamanho());
    }
}