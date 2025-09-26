public class BookAccess { // Classe
    public static boolean BookAccess(Book b1, Book b2){
        if (b1 == null) return b2 == null;
        return b1.equals(b2);
    }

    public static void main(String[] args) throws CloneNotSupportedException{// Qualquer método dentro do do qual 'clone()' o método de um objeto esteja sendo invocado deve tratar.
        // Seta os valores da variavel book1
        Book book1 = new Book("Atomics Habits", "James Clear", 30.00f);

        // Seta os valores da variavel book2
        Book book2 = new Book();
        book2.setTitle("Sapiens");
        book2.setAuthor("Yuval Noah Harari");
        book2.setPrice(25.00f);

        System.out.println("O primeiro 'Objeto' Livro é: ");
        System.out.println(book1);
        System.out.println("O segundo 'Objeto' Livro é: ");
        System.out.println(book2);

        Book book3 = (Book)(book1.clone()); // Isso cria um clone do objeto book identicos, porém são dois objetos diferentes.
        System.out.println("O terceiro livro clonado de um objeto é: ");
        System.out.println(book3);

        System.out.println("Livro 1 é igual ao Livro 2? " + BookAccess(book1, book2)); // falso
        System.out.println("Livro 1 é igual ao Livro 3? " + BookAccess(book1, book3)); // verdadeiro(clone)
    }
}