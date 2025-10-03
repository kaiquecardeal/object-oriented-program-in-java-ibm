/**
 * Classe que representa livro - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 * @version 1.0
 */
public class Book {
    // Step 1: Declare private variables for bookTitle, author, publicationYear, and isAvailable
    // Hint: Use appropriate data types (String for title/author, int for year, boolean for availability)
    private String bookTitle;
    private String author;
    private int publicationYear;
    private boolean isAvailable;
    
    // Step 2: Create a constructor that accepts bookTitle, author, and publicationYear
    // Hint: Initialize all fields including setting isAvailable to true by default
    public Book(String bookTitle, String author, int publicationYear) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isAvailable = true;
    }
    
    // Step 3: Create public getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()
    public String getBookTitle() {
        return bookTitle;
    }
    public String getAuthor() {
        return author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }
    
    // Step 4: Create public setter methods for relevant variables
    // Hint: You might not need setters for all variables
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    
    // Step 5: Create methods to check out and return a book
    // checkOut() method should set isAvailable to false and return true if the book was available
    // returnBook() method should set isAvailable to true and return true if the book was checked out
    public boolean checkOut() {
        if (this.isAvailable) {
            this.isAvailable = false;
            return true;
        }
        return false;
    }
    public boolean returnBook() {
        if (!this.isAvailable) {
            this.isAvailable = true;
            return true;
        }
        return false;
    }
    
    // Step 6: Override toString() method to display book details
    // Hint: Show title, author, year, and availability status
    @Override
    public String toString() {
        return "Título: " + bookTitle + ", Autor: " + author + ", Ano de Publicação: " + publicationYear + ", Disponível: " + isAvailable;
    }

}
