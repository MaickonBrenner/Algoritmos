public class main {

        public static void main(String[] args) {
            // Criando uma árvore n-ária
            ArvoreNaria arvoreNaria = new ArvoreNaria();
    
            // Inserindo elementos na árvore
            arvoreNaria.inserir(50, 0);
            arvoreNaria.inserir(30, 0);
            arvoreNaria.inserir(70, 0);
            arvoreNaria.inserir(20, 50);
            arvoreNaria.inserir(40, 50);
            arvoreNaria.inserir(60, 70);
            arvoreNaria.inserir(80, 50);
    
            // Imprimindo a árvore
            System.out.println("Árvore original:");
            arvoreNaria.imprimirArvore();
    
            // Calculando o tamanho da árvore
            System.out.println("Tamanho da árvore: " + arvoreNaria.tamanho());
    
            // Buscando um nó na árvore
            int chaveParaBuscar = 70;
            if (arvoreNaria.buscar(chaveParaBuscar)) {
                System.out.println(chaveParaBuscar + " encontrado na árvore.");
            } else {
                System.out.println(chaveParaBuscar + " não encontrado na árvore.");
            }
    
            // Excluindo um nó da árvore
            int chaveParaExcluir = 50;
            arvoreNaria.excluir(chaveParaExcluir);
            System.out.println("Após excluir o nó " + chaveParaExcluir + ":");
            arvoreNaria.imprimirArvore();
        }
}
