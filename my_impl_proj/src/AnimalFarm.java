import java.util.Scanner;

public class AnimalFarm {
    private static final int MAX_ANIMALS = 10;

    private static void displayMenu() {
        System.out.println("Pressione 1 para visualizar um animal, " +
                "\n2 para adicionar animais," +
                "\nPressione qualquer tecla para sair.");
    }

    private static void displayAnimal() {
        System.out.println("Qual animal você quer criar? \nPressione 1 para cachorro, " +
                "\n2 para gato " +
                "\n3 para vaca");
    }

    private static Animal createAnimal(String type, Scanner scanner) {
        String animalName = getAnimalName(type);
        System.out.println("Entre com o nome do " + animalName + ": ");
        String name = scanner.nextLine().trim();

        System.out.println("Entre com o que o " + animalName + " come: ");
        String food = scanner.nextLine().trim();

        if (name.isEmpty() || food.isEmpty()) {
            System.out.println("Nome ou comida inválidos.");
            return null;
        }

        Animal animal = null;
        switch (type) {
            case "1":
                animal = new Dog(name);
                break;
            case "2":
                animal = new Cat(name);
                break;
            case "3":
                animal = new Cow(name);
                break;
        }

        if (animal != null) {
            animal.setFood(food);
        }

        return animal;
    }

    private static String getAnimalName(String type) {
        switch (type) {
            case "1":
                return "cachorro";
            case "2":
                return "gato";
            case "3":
                return "vaca";
            default:
                return "animal";
        }

    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Animal[] animals = new Animal[MAX_ANIMALS];
            int animalIndex = 0;

            while (true) {
                displayMenu();
                String userAction = scanner.nextLine().trim();
                if (userAction.equals("1")) {
                    if (animalIndex == 0) {
                        System.out.println("Nenhum animal adicionado.");
                        continue;
                    }
                    for (Animal animal : animals) {
                        if (animal != null) {
                            System.out.println(animal);
                        }
                    }
                } else if (userAction.equals("2")) {
                    if (animalIndex == MAX_ANIMALS) {
                        System.out.println(MAX_ANIMALS + " Animais já adicionados. Não é possível mais adicionar.");
                        continue;
                    }
                    displayAnimal();
                    String animalType = scanner.nextLine().trim();

                    Animal newAnimal = createAnimal(animalType, scanner);
                    if (newAnimal != null) {
                        animals[animalIndex++] = newAnimal;
                        System.out.println("Animal adicionado com sucesso.");
                    }
                } else {
                    break;
                }
            }
        }
    }
}