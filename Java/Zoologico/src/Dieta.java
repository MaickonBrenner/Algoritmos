
public class Dieta {
	
	//Variaveis
	private String tipoAlimento;
	private int quantidade;
	
	// Construtor da classe Dieta. 
    // É usado para inicializar uma nova instancia da classe com valores específicos para tipoAlimento e quantidade.
	public Dieta(String tipoAlimento, int quantidade) {
		this.tipoAlimento = tipoAlimento;
	    this.quantidade = quantidade;
	}
	
	// É a "especialista" quando se trata de informar a quantidade e o tipo de alimento
	// que um animal deve receber.
	
	// Método que fornece uma representação string da dieta.
    // Ele combina tipoAlimento e quantidade para criar uma descrição concisa da dieta.
    public String informarDieta() {
        return tipoAlimento + ": " + quantidade + " gramas";
    }
	
	
	//GETTES E SETTES
	public String getTipoAlimento() {
		return tipoAlimento;
	}
	public void setTipoAlimento(String tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
