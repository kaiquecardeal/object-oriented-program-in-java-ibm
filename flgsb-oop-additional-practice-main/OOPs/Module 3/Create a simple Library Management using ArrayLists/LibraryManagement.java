import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * LibraryManagement para administrar a classe 'Book' - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 * @version 1.0
 */
public class LibraryManagement {
    // Step 3: Implement a menu-driven program with the following options:
    // 1. Add a book
    // 2. View all books
    // 3. Search for a book by title
    // 4. Check out a book
    // 5. Return a book
    // 6. Sort books (by title, author, or publication year)
    // 7. View available books only
    // 8. Exit
    public static void displayMenu() {
        System.out.println("1. Adicionar Livro" +
                "\n2. Visualizar Todos os Livros" +
                "\n3. Buscar Livro por Título" +
                "\n4. Emprestar Livro" +
                "\n5. Devolver Livro" +
                "\n6. Ordenar Livros (por título, autor ou ano de publicação)" +
                "\n7. Visualizar Livros Disponíveis Somente" +
                "\n8. Sair");
        System.out.println("Escolha: ");
    }

    // Step 13: Create additional helper methods as needed
    // Examples: findBookByTitle(), findBookByIndex(), etc.
    public static ArrayList<Book> findBookByTitle(ArrayList<Book> books, String title) {
        ArrayList<Book> foundBooks = new ArrayList<>();
        for (Book b : books) {
            if (b.getBookTitle().equals(title)) {
                foundBooks.add(b);
            }
        }
        return foundBooks;
    }

    public static Book findBookByIndex(ArrayList<Book> books, int index) {
        if (index >= 0 && index < books.size()) {
            return books.get(index);
        }
        return null;
    }


    public static void main(String[] args) {
        // Step 1: Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Step 2: Create an ArrayList to store Book objects
        // Hint: Use ArrayList<Book>
        ArrayList<Book> books = new ArrayList<>();


        // Step 4: Create the main menu loop
        // Hint: Use a while loop with a boolean flag or a while(true) with a break
        while (true) {
            displayMenu();
            int choice = input.nextInt();
            input.nextLine(); // Consume newline
            if (choice == 8) {
                break;
            }
            // Step 5: Implement case handling for each menu option
            // Hint: Use switch-case or if-else if statements
            switch (choice) {
                // Step 6: Implement the addBook functionality
                // Hint: Prompt the user for title, author, and publication year

                // Step 7: Implement the viewAllBooks functionality
                // Hint: Use a loop or forEach to display all books

                // Step 8: Implement the search functionality
                // Hint: Take user input for search term and check each book

                // Step 9: Implement the checkOut functionality
                // Hint: Find the book by index and use the checkOut() method

                // Step 10: Implement the returnBook functionality
                // Hint: Find the book by index and use the returnBook() method

                // Step 11: Implement the sortBooks functionality
                // Hint: Use Collections.sort() with a Comparator

                // Step 12: Implement the viewAvailableBooks functionality
                // Hint: Use ArrayList's stream() or loop through to filter
                case 1:
                    // Add a book
                    System.out.println("Digite o título do livro:");
                    String title = input.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String author = input.nextLine();
                    System.out.println("Digite o ano de publicação do livro:");
                    int year = input.nextInt();
                    input.nextLine(); // Consume newline
                    books.add(new Book(title, author, year));
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 2:
                    // View all books
                    if (books.isEmpty()) {
                        System.out.println("Nenhum livro disponível.");
                    } else {
                        for (int i = 0; i < books.size(); i++) {
                            Book b = books.get(i);
                            System.out.printf("%d. %s by %s (%d) - %s\n", i + 1, b.getBookTitle(), b.getAuthor(), b.getPublicationYear(), b.getIsAvailable() ? "Disponível" : "Indisponível");
                        }
                    }
                    break;
                case 3:
                    // Search for a book by title
                    System.out.println("Digite o título do livro para buscar:");
                    String searchTitle = input.nextLine();
                    ArrayList<Book> foundBooks = findBookByTitle(books, searchTitle);
                    if (foundBooks.isEmpty()) {
                        System.out.println("Nenhum livro encontrado com esse título.");
                    } else {
                        for (Book b : foundBooks) {
                            System.out.printf("%s by %s (%d)\n", b.getBookTitle(), b.getAuthor(), b.getPublicationYear(), b.getIsAvailable() ? "Disponível" : "Indisponível");
                        }
                    }
                    break;
                case 4:
                    // Check out a book
                    System.out.println("Digite o número do livro para emprestar:");
                    int checkOutIndex = input.nextInt() - 1;
                    input.nextLine(); // Consume newline
                    Book bookToCheckOut = findBookByIndex(books, checkOutIndex);
                    if (bookToCheckOut != null) {
                        if (bookToCheckOut.checkOut()) {
                            System.out.println("Livro emprestado com sucesso!");
                        } else {
                            System.out.println("Livro não está disponível para empréstimo.");
                        }
                    } else {
                        System.out.println("Índice inválido.");
                        break;
                    }
                    break;
                case 5:
                    // Return a book
                    System.out.println("Digite o número do livro para devolver:");
                    int returnIndex = input.nextInt() - 1;
                    input.nextLine(); // Consume newline
                    Book bookToReturn = findBookByIndex(books, returnIndex);
                    if (bookToReturn != null) {
                        if (bookToReturn.returnBook()) {
                            System.out.println("Livro devolvido com sucesso!");
                        } else {
                            System.out.println("Este livro não foi emprestado.");
                        }
                    } else {
                        System.out.println("Índice inválido.");
                        break;
                    }
                    break;
                case 6:
                    // Sort books
                    System.out.println("Ordenar por: 1. Título 2. Autor 3. Ano de Publicação");
                    int sortChoice = input.nextInt();
                    input.nextLine(); // Consume newline
                    switch (sortChoice) {
                        case 1:
                            Collections.sort(books, Comparator.comparing(Book::getBookTitle));
                            break;
                        case 2:
                            Collections.sort(books, Comparator.comparing(Book::getAuthor));
                            break;
                        case 3:
                            Collections.sort(books, Comparator.comparing(Book::getPublicationYear));
                            break;
                        default:
                            System.out.println("Opção inválida. Ordenando por título.");
                            Collections.sort(books, Comparator.comparing(Book::getBookTitle));
                    }
                    break;
                case 7:
                    // View available books only
                    boolean anyAvailable = false;
                    for (Book b : books) {
                        if (b.getIsAvailable()) {
                            System.out.printf("%s by %s (%d) - Disponível\n", b.getBookTitle(), b.getAuthor(), b.getPublicationYear());
                            anyAvailable = true;
                        }
                    }
                    if (!anyAvailable) {
                        System.out.println("Nenhum livro disponível.");
                    }
                    break;
                case 8:
                    // Exit
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        input.close();
    }
}


