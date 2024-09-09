import java.util.ArrayList;
import java.util.List;

public class DiarioAlimentacao {
    
	// Variável de instância que mantém uma lista dos registros de alimentação.
    // Uma lista foi usada porque o diário irá armazenar vários registros ao longo do tempo.
	private List<RegistroAlimentacao> registros;

	// Construtor da classe DiarioAlimentacao.
    // Inicializa uma nova lista vazia para armazenar registros de alimentação.
    public DiarioAlimentacao() {
        this.registros = new ArrayList<>();
    }

    // Método que cria e adiciona um novo registro de alimentação à lista.
    // Utiliza os princípios do GRASP: Expert (para obter a dieta do animal) e Creator (para criar um novo RegistroAlimentacao).
    public void registrarAlimentacao(Animal animal, String data) {
        RegistroAlimentacao registro = new RegistroAlimentacao(animal, data);
        registros.add(registro);
    }

    // Método que retorna todos os registros de alimentação do diário em forma de string.
    public List<RegistroAlimentacao> getRegistros() {
        return registros;
    }
    
}