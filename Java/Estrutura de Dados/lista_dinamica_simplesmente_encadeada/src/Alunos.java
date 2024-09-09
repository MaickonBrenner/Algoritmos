public class Alunos {

    String nome;
    int id;

    public Alunos(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Alunos() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Alunos{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                '}';
    }
}
