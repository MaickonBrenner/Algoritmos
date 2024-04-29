
public class Animal {
	
	//Variaveis
	private String nome;
	private Dieta dieta; // Variavel de instancia do tipo Dieta
	
	//Construtor
	public Animal(String nome, Dieta dieta) {
		this.nome =  nome;
		this.setDieta(dieta);
	}
	
	//GETS E SETS
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
	}
	
	

}
