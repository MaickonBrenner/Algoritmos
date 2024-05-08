public class Node {
    int chave;
    int bool;
    Node primeiroFilho, irmao;

    public Node(int chave) {
        this.chave = chave;
        this.primeiroFilho = null;
        this.irmao = null;
    }
}
