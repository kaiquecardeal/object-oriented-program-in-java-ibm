public class Book implements Cloneable { // Classe - implements cloneable diz explicitamente que a classe implementara o método clone;
    private String title; // Atributos
    private String author;
    private float price;


    public Book() { // Construtor Padrão
    }

    public Book(String title, String author, float price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Overriding the clone method
    @Override
    protected Object clone() throws CloneNotSupportedException { // este método classifica o método de superclasse clone.
        return super.clone();
    }

    // Getters e Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public float getPrice() {
        return this.price;
    }

    // Método toString
    public String toString() {
        return "Título - " + this.title + "\nAutor - "
                + this.author + "\nPreço - " + String.format("%.2f", this.price);
    }

    public boolean equals(Book book2) {
        if (this.title.equals(book2.getTitle()) &&
                this.author.equals(book2.getAuthor()) &&
                this.price == book2.getPrice()) {
            return true;
        }
        return false;
    }

}