import java.util.Scanner; // Importa a classe Scanner

public class BooksMenu {
    private static void compareBooks(Book book1, Book book2) {
        if (book1.equals(book2)) {
            System.out.println("Os livros são iguais");
        } else {
            System.out.println("Os livros são diferentes");
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in); // Usado para ler dados do usuário no console.
        Book[] books = new Book[10]; // Cria um array com 10 posições
        int bkIdx = 0; // Mantém o controle de quantos livros foram adicionados ao array.

        while (true) { // O programa executa um loop infinito para exibir o menu continuamente até que o usuário decida sair
            System.out.println("Pressione 1 para ver os livros," +
                    "\n2 para adicionar, " +
                    "\n3 para mudar o preço de um livro" +
                    "\n4 para comparar os livros ou qualquer tecla para sair");
            String userAction = scanner.nextLine();
            if (userAction.equals("1")) { // '1' para visualizar os livros
                for (int i = 0; i < books.length; i++) {
                    if (books[i] != null) {
                        System.out.println(books[i]);
                    }
                }
            } else if (userAction.equals("2")) { // '2' para adicionar livros
                if (bkIdx == 10) {// Caso aja mais que 10 livros no vetor, o programa entra neste if
                    System.out.println("Já foi preenchido 10 livros. Não é possível adicionais mais livros!");
                    continue; // Pula a interação do loop
                }
                // Pergunta ao usuário qual constructor usar
                System.out.println("Qual 'constructor' você deseja usar? \nPressione 1 para o padrão " +
                        "\n2 para criar um clone de um objeto existente " +
                        "\nQualquer tecla para um construtor sobrecarregado");
                String constructor = scanner.nextLine();
                if (constructor.equals("1")) {
                    System.out.println("Insira o título do livro");
                    String tmpTitle = scanner.nextLine();
                    System.out.println("Insira o autor do livro");
                    String tmpAuthor = scanner.nextLine();
                    System.out.println("Insira o valor do livro");
                    float tmpPrice = Float.parseFloat(scanner.nextLine());
                    Book bkTmp = new Book();
                    bkTmp.setTitle(tmpTitle);
                    bkTmp.setAuthor(tmpAuthor);
                    bkTmp.setPrice(tmpPrice);
                    books[bkIdx++] = bkTmp;
                } else if (constructor.equals("2")) {
                    System.out.println("Entre com o índice do livro para clonagem");
                    int cloneIdx = Integer.parseInt(scanner.nextLine());
                    if (books[cloneIdx] != null) {
                        books[bkIdx++] = (Book) books[cloneIdx].clone();
                    }
                } else {
                    System.out.println("Insira o título do livro");
                    String tmpTitle = scanner.nextLine();
                    System.out.println("Insira o autor do livro");
                    String tmpAuthor = scanner.nextLine();
                    System.out.println("Insira o valor do livro");
                    float tpmPrice = Float.parseFloat(scanner.nextLine());
                    books[bkIdx++] = new Book(tmpTitle, tmpAuthor, tpmPrice);
                }
            } else if (userAction.equals("3")) { // '3' para alterar o preço do livro
                System.out.println("Entre com o índice do livro para alteração");
                int idx = Integer.parseInt(scanner.nextLine());
                if (books[idx] != null) {
                    System.out.println("Entre com o novo preço do livro");
                    float newPrice = Float.parseFloat(scanner.nextLine());
                    books[idx].setPrice(newPrice);
                }
            } else if (userAction.equals("4")) {
                System.out.println("Insira o índice do livro 1");
                int book1Idx = Integer.parseInt(scanner.nextLine());
                System.out.println(("Insira o índice do livro 2"));
                int book2Idx = Integer.parseInt(scanner.nextLine());

                if (books[book1Idx] != null && books[book2Idx] != null) {
                    compareBooks(books[book1Idx], books[book2Idx]);
                } else {
                    System.out.println("Um dos livros é nulo.");
                }
            } else {
                break;
            }
        }
    }
}