import java.util.Scanner; // Importa a classe Scanner

public class BooksMenu {

    // Um método auxiliar para comparar dois livros e devolver aquele com o preço mais alto.
    private static Book getExpensiveBook(Book book1, Book book2) {
        if (book1.getPrice() < book2.getPrice()) {
            return book2; // retorna o livro 2, caso ele seja mais caro.
        } else {
            return book1; // se não, retorna o primeiro livro.
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Usado para ler dados do usuário no console.
        Book[] books = new Book[10]; // Cria um array com 10 posições
        int bkIdx = 0; // Mantém o controle de quantos livros foram adicionados ao array.

        while (true) { // O programa executa um loop infinito para exibir o menu continuamente até que o usuário decida sair
            System.out.println("Pressione 1 para ver os livros, 2 para adicionar livros e qualquer outra tecla para sair");
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
                // Solicitar ao usuário detalhes do livro
                System.out.println("Insira o nome do livro");
                String tmpTitle = scanner.nextLine();
                System.out.println("Insira o nome do autor");
                String tmpAuthor = scanner.nextLine();
                System.out.println("Insira o preço do livro");
                float tpmPrice = Float.parseFloat(scanner.nextLine());

                // Criando um novo 'objeto' do tipo livro
                Book bkTmp = new Book();
                bkTmp.setTitle(tmpTitle);
                bkTmp.setAuthor(tmpAuthor);
                bkTmp.setPrice(tpmPrice);
                books[bkIdx++] = bkTmp;

            } else if (userAction.equals("3")) { // '3' para comparar o preço dos livros e retornar o mais caros.

                // Solicitar ao usuário os índices dos livros para comparação
                System.out.println("Entre com o primeiro livro: ");
                int book1Idx = Integer.parseInt(scanner.nextLine());
                System.out.println("Entre com o segundo livro: ");
                int book2Idx = Integer.parseInt(scanner.nextLine());
                // Checando se os indices selecionados tem 'objetos' Livro válidos.
                if (books[book1Idx] != null && books[book2Idx] != null) {
                    // Comparando os livros e retornando o mais caro.
                    System.out.println("Os detalhes do livro caro são: \n" +
                            getExpensiveBook(books[book1Idx], books[book2Idx]));
                } else {
                    System.out.println("Um dos livros é nulo!"); // Mensagem de erro sobre o indice vazio.
                }
            } else {
                break;
            }
        }
    }
}