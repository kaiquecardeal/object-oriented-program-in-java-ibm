public class BookAccess { // Classe
    public static void main(String[] args){
        // Seta os valores da variavel book1
        Book book1 = new Book();
        book1.setTitle("Atomic Habits");
        book1.setAuthor("James Clear");
        book1.setPrice(30.00f);

        // Seta os valores da variavel book2
        Book book2 = new Book();
        book2.setTitle("Sapiens");
        book2.setAuthor("Yuval Noah Harari");
        book2.setPrice(25.00f);

        System.out.println("O primeiro 'Objeto' Livro é: ");
        System.out.println(book1);
        System.out.println("O segundo 'Objeto' Livro é: ");
        System.out.println(book2);
    }
}