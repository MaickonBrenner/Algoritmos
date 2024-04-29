package Controlador;

import java.util.Scanner;
import Modelo.modeloLivro;
import Visao.visaoLivro;

public class controladorLivro {
	
	private modeloLivro modeloLivro; 
	private visaoLivro visaoLivro;
	Scanner scanner = new Scanner(System.in);
	
	public controladorLivro() {
		this.modeloLivro = new modeloLivro();
		this.visaoLivro = new visaoLivro();
	}
	
	public void registrarLivro() {
		
		modeloLivro.setTitulo(visaoLivro.pegarTituloDoLivro());
				
		modeloLivro.setAutor(visaoLivro.pegarAutorDoLivro());
		
		modeloLivro.setAnoPublicacao(visaoLivro.pegarAnoDoLivro());
		
		visaoLivro.exibeDetalhesDoLivros(modeloLivro.getTitulo(),modeloLivro.getAutor(), modeloLivro.getAnoPublicacao());
	}
}
