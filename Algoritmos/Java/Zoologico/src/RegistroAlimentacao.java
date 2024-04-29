public class RegistroAlimentacao {
	
    private Animal animal; // Variavel de instancia do tipo Animal
    private String data;

    // Construtor da classe RegistroAlimentacao.
    // É usado para inicializar uma nova instância da classe com valores específicos para o animal e data.
    public RegistroAlimentacao(Animal animal, String data) {
        this.animal = animal;
        this.data = data;
    }

    // Método que fornece uma representação string do registro de alimentação.
    // Ele combina informações do animal e da data para criar uma descrição completa do registro.
    public String informacaoAlimentacao() {
        return "Animal: " + animal.getNome() + 
        		" Alimentado em: " + data + 
        		" com " + animal.getDieta().informarDieta();
    }
    
}