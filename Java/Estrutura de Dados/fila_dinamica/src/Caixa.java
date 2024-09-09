public class Caixa {

    boolean caixaAberto = false;

    public void abrirCaixar() {
        if (!caixaAberto) {
            caixaAberto = true;
            System.out.println("-----------------------------------------");
            System.out.println("|          O caixa está aberto!         |");
            System.out.println("-----------------------------------------");
        }


    }

    public void fecharCaixa() {
        if (caixaAberto) {
            caixaAberto = false;
            System.out.println("Encerrando o caixa...");
        } else {
            System.err.println("O caixa já está fechado!");
        }
    }
}
