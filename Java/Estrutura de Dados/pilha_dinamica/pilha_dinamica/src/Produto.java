public class Produto {
    private int id;
    private String nome;
    private int qtd;

    public Produto(int id, String nome, int qtd) {
        this.id = id;
        this.nome = nome;
        this.qtd = qtd;
    }

    public Produto() {

    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", qtd=" + qtd +
                '}';
    }
}
