import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

/**
 * LibraryManagement com HashMap para administrar a classe 'Book' - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 * @version 1.0
 */

public class LibraryManagementSystem {
    // Book class to represent book information
    static class Book {
        // Step 1: Declare variables for title, author, genre, and publication year
        // Hint: Use appropriate data types (String for text, int for year)
        private String title;
        private String author;
        private String genre;
        private int publicationYear;

        // Step 2: Create a constructor for the Book class
        // Hint: The constructor should take parameters for all book attributes
        public Book(String title, String author, String genre, int publicationYear) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.publicationYear = publicationYear;
        }

        // Step 3: Create getter methods for each attribute
        // Hint: Use the format: public dataType getAttribute()
        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public String getGenre() {
            return genre;
        }

        public int getPublicationYear() {
            return publicationYear;
        }

        // Step 4: Create a method to display book details
        // Hint: Return a formatted string with all book information
        public String toString() {
            return "Título: " + title + ", Autor: " + author + ", Gênero: " + genre + ", Ano de Publicação: " + publicationYear;
        }
    }

    // Method to validate if the title and author have valid formats
    private static boolean isValidText(String text) {
        // Step 5: Implement validation for title and author
        // Hint: Check if the text is not empty and contains only letters and spaces
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        for (char c : text.toCharArray()) {
            if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                return false;
            }
        }
        return true;
    }

    // Method to validate publication year
    private static boolean isValidYear(int year) {
        // Step 6: Implement validation for publication year
        // Hint: Check if the year is reasonable (e.g., between 1000 and current year)
        if (year >= 1000 && year <= 2025) {
            return true;
        }
        return false; // Replace this with your implementation
    }

    public static void displayMenu() {
        System.out.println("1. Adicionar Livro" +
                "\n2. Visualizar Todos os Livros" +
                "\n3. Remover Livro" +
                "\n4. Ordenar Livros (por título, autor ou ano de publicação)" +
                "\n5. Sair");
        System.out.println("Escolha: ");
    }

    public static void main(String[] args) {
        // Step 7: Create a Scanner for user input
        Scanner input = new Scanner(System.in);

        // Step 8: Create a HashMap to store books (with ISBN as the key)
        HashMap<String, Book> books = new HashMap<>();

        // Step 9: Implement the main loop with menu options
        // Hint: Options should include adding a book, viewing all books, 
        // searching for books, removing a book, viewing sorted books, and exiting
        while (true) {
            displayMenu();
            int choice = input.nextInt();
            input.nextLine(); // Consume newline
            if (choice == 5) {
                break;
            }
            switch (choice) {
                // Step 10: Implement the "Add a book" option
                // Hint: Prompt user for book details (ISBN, title, author, genre, year)
                // Validate input and add to the HashMap
                case 1:
                    System.out.println("Digite o ISBN do livro:");
                    String isbn = input.nextLine();
                    if (books.containsKey(isbn)) {
                        System.out.println("Livro com este ISBN já existe.");
                        break;
                    }
                    System.out.println("Digite o título do livro:");
                    String title = input.nextLine();
                    if (!isValidText(title)) {
                        System.out.println("Título inválido. Deve conter apenas letras e espaços.");
                        break;
                    }
                    System.out.println("Digite o autor do livro:");
                    String author = input.nextLine();
                    if (!isValidText(author)) {
                        System.out.println("Autor inválido. Deve conter apenas letras e espaços.");
                        break;
                    }
                    System.out.println("Digite o gênero do livro:");
                    String genre = input.nextLine();
                    System.out.println("Digite o ano de publicação do livro:");
                    int year = input.nextInt();
                    input.nextLine(); // Consume newline
                    if (!isValidYear(year)) {
                        System.out.println("Ano de publicação inválido. Deve estar entre 1000 e 2022.");
                        break;
                    }
                    Book newBook = new Book(title, author, genre, year);
                    books.put(isbn, newBook);
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                // Step 11: Implement the "View all books" option
                // Hint: Iterate through the HashMap and display all books
                case 2:
                    if (books.isEmpty()) {
                        System.out.println("Nenhum livro cadastrado.");
                    } else {
                        for (Map.Entry<String, Book> entry : books.entrySet()) {
                            System.out.println(entry.getValue());
                        }
                    }
                    break;
                // Step 13: Implement the "Remove a book" option
                // Hint: Remove a book from the collection using its ISBN
                case 3:
                    System.out.println("Digite o ISBN do livro a ser removido:");
                    String isbnToRemove = input.nextLine();
                    if (books.containsKey(isbnToRemove)) {
                        books.remove(isbnToRemove);
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                // Step 14: Implement the "View sorted books" option
                // Hint: Use TreeMap to sort books by title or author
                case 4:
                    TreeMap<String, Book> sortedBooks = new TreeMap<>(books);
                    for (Map.Entry<String, Book> entry : sortedBooks.entrySet()) {
                        System.out.println(entry.getValue());
                    }
                    break;
                case 5:
                    System.out.println("Obrigado por usar o sistema de gerenciamento de biblioteca!");
                    System.exit(0);
                    break;
            }
        }
        input.close();
    }
}