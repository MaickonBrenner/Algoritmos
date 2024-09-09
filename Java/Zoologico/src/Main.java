public class Main {
	
    public static void main(String[] args) {
    	
        // Aqui, estamos criando dois animais com suas respectivas dietas.
        // O primeiro animal é um leão que consome 5 kg de carne.
        // O segundo animal é uma girafa que consome 2 kg de folhas.
        Animal leo = new Animal("Leão", new Dieta("Carne", 5000));
        Animal girafa = new Animal("Girafa", new Dieta("Folhas", 2000));
        
        // Este é o diário de alimentação, onde registraremos cada alimentação fornecida aos animais.
        DiarioAlimentacao diario = new DiarioAlimentacao();

        // Aqui, estamos registrando a alimentação dos animais no diário.
        // Estamos dizendo que ambos os animais foram alimentados em 17/08/2023.
        diario.registrarAlimentacao(leo, "17/08/2023");
        diario.registrarAlimentacao(girafa, "17/08/2023");
        
        // Este loop percorre todos os registros de alimentação no diário e os imprime.
        // Assim, podemos ver quais animais foram alimentados e qual foi a alimentação fornecida.
        for (RegistroAlimentacao registro : diario.getRegistros()) {
            System.out.println(registro.informacaoAlimentacao());
        }
        
    }
    
}