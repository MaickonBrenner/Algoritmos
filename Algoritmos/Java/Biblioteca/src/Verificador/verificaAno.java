package Verificador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class verificaAno {
	
	private Visao.visaoLivro visaoLivro;
	Scanner scanner = new Scanner(System.in);
	
	public boolean verificar(int Ano) {
		
		boolean resposta = false;
		
		do {
			System.out.println("Digite o ano de publicação: ");
			try {
				
				visaoLivro.pegarAnoDoLivro();
						
			} catch (InputMismatchException e) {
				System.err.println("Entrada inválida. Por favor, digite apenas números inteiros.");
				scanner.nextLine();
				resposta = true;
			}	
		} while(resposta);
		
		return true;
	}
}
