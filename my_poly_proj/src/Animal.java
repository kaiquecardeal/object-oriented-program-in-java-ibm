public class Animal {
    private final String name;
    private String food;

    public Animal(String name) {
        this.name = name;
    }

    public String sound() {
        return null;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }

    public String toString() {
        return name.concat(" diz ").concat(sound().concat(" e comeram ").concat(food));
    }

}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    public String sound() {
        return "au au";
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    public String sound() { //
        return "miau";
    }
}

class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    public String sound() {
        return "muu";
    }
}
