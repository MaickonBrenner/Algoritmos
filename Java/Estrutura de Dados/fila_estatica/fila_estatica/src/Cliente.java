public class Cliente {
    String nomeCliente;
    int quantItens;

    public Cliente(String nomeCliente, int quantItens) {
        this.nomeCliente = nomeCliente;
        this.quantItens = quantItens;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", quantItens=" + quantItens +
                '}';
    }
}
