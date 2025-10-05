public abstract class ClassWithAbstractMeth { // Isso declarará uma classe como abstrata.
    public abstract String absMeth1(int num); // Define um método abstrato que é público, que recebe um int como parâmetro e retorna uma String, que pode ser sobrescrito em qualquer subclasse herdeira.
    protected abstract boolean absMeth2(String str); // Define um método abstrato que é protegido, que recebe uma String como parâmetro e retorna um boolean, que pode ser sobrescrito em subclasses dentro do pacote e em subclasses fora do pacote.
    abstract float absMeth3(int num, String str); // Define um método abstrato que é padrao, que recebe uma String como parâmetero e retorna um booleano. Isso pode ser sobrescrito apenas em subclasses dentro do pacote.

    public static void main(String[] args) {
        System.out.println("This is a class with abstract methods");
    }
}
