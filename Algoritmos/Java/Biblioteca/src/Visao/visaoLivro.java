package Visao;

import java.util.Scanner;

public class visaoLivro {
	
	Scanner scanner = new Scanner(System.in);
	
	public String pegarTituloDoLivro() {
		System.out.println("Digite o título do livro: ");
		return scanner.next();
	}
	
	public String pegarAutorDoLivro() {
		System.out.println("Digite o autor do livro: ");
		return scanner.next();
	}
	
	public int pegarAnoDoLivro() {
		System.out.println("Digite o ano do livro: ");
		
		while(!scanner.hasNextInt()) {
			System.out.println("Por favor... Digite apenas numeros: ");
			scanner.next();
		}	
		
		return scanner.nextInt();
	}
		
	
	public void exibeDetalhesDoLivros(String titulo, String autor, int ano) {
		System.out.println("Título: [" + titulo + "] , Autor: [" + autor + "] , Ano de Publicação: [" + ano + "]");
	}
}
