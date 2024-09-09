public class Main {
    public static void main(String[] args) {

    LinkedList<Alunos> lista = new LinkedList<>();

    lista.add(new Alunos("João", 123));
    lista.add(new Alunos("Maria", 456));
    lista.add(new Alunos("Ana", 789));

    System.out.println("Lista: ");
    lista.printList();

    lista.remove(new Alunos("Maria", 456));
        System.out.println("Nova lista");
        lista.printList();
    }
}