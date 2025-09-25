public class Book { // Classe
    private String title; // Atributos
    private String author;
    private float price;

    // Getters e Setters
    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public String getTitle(){
        return this.title;
    }

    public String getAuthor(){
        return this.author;
    }

    public float getPrice(){
        return this.price;
    }

    // Método toString
    public String toString(){
        return "Título - "+ this.title + "\nAutor - "
                + this.author + "\nPreço - "+ String.format("%.2f", this.price);
    }

}