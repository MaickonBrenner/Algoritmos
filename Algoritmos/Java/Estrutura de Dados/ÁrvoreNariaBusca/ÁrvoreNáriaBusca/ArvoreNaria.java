
public class ArvoreNaria {
    Node raiz;

    public ArvoreNaria() {
        this.raiz = null;
    }

    public int tamanho() {
        return tamanho(raiz);
    }

    private int tamanho(Node no) {
        if (no == null) {
            return 0;
        }

        int count = 1; // inclui o próprio nó
        Node filhoAtual = no.primeiroFilho;
        while (filhoAtual != null) {
            count += tamanho(filhoAtual); // chamada recursiva para calcular o tamanho do nó filho
            filhoAtual = filhoAtual.irmao;
        }

        return count;
    }


    public boolean inserir(int novaChave, int chavePai) {
        boolean pai = buscar(chavePai);

        if (!pai) {
            return false;
        }

        Node filho = new Node(novaChave);

        Node p = raiz.primeiroFilho;

        if (p == null) {
            raiz.primeiroFilho = filho;
        } else {
            while (p.irmao != null) {
                p = p.irmao;
            }

            p.irmao = filho;
        }

        return true;
    }

    public boolean buscar(int chave) {
        return buscar(raiz, chave);
    }

    private boolean buscar(Node no, int chave) {
        if (no == null) {
            return false;
        }

        if (chave == no.chave) {
            return true;
        }

        return chave < no.chave ? buscar(no.primeiroFilho, chave) : buscar(no.irmao, chave);
    }

    public void excluir(int chave) {
        raiz = excluir(raiz, chave);
    }

    private Node excluir(Node no, int chave) {
        if (no == null) {
            return null;
        }

        if (chave == no.chave) {
            // caso 1: o nó é uma folha
            if (no.primeiroFilho == null && no.irmao == null) {
                return null;
            }

            // caso 2: o nó não tem filhos ou tem apenas um filho
            if (no.primeiroFilho == null) {
                return no.irmao;
            } else if (no.irmao == null) {
                return no.primeiroFilho;
            }

            // caso 3: o nó tem dois filhos
            // encontra o sucessor em ordem ou predecessor em ordem (pode usar qualquer abordagem)
            // então substitui o valor do nó pelo valor do sucessor ou predecessor em ordem
            // finalmente, exclui o sucessor ou predecessor em ordem (ambos funcionarão)
            // usaremos a abordagem de predecessor em ordem neste caso
            Node predecessorEmOrdem = encontrarMaximo(no.primeiroFilho);
            no.chave = predecessorEmOrdem.chave;
            no.primeiroFilho = excluir(no.primeiroFilho, predecessorEmOrdem.chave);

            return no;
        }

        if (chave < no.chave) {
            no.primeiroFilho = excluir(no.primeiroFilho, chave);
        } else {
            no.irmao = excluir(no.irmao, chave);
        }

        return no;
    }

    private Node encontrarMaximo(Node no) {
        while (no.irmao != null) {
            no = no.irmao;
        }
        return no;
    }

    public void imprimirArvore() {
        imprimirArvore(raiz);
        System.out.println();
    }
    
    private void imprimirArvore(Node no) {
        if (no == null) {
            return;
        }
    
        System.out.print(no.chave + "( ");
    
        imprimirFilhos(no.primeiroFilho);
    
        System.out.print(") ");
    }
    
    private void imprimirFilhos(Node no) {
        if (no == null) {
            return;
        }
    
        imprimirArvore(no);
    
        if (no.irmao != null) {
            System.out.print(", ");
        }
    
        imprimirFilhos(no.irmao);
    }
}


