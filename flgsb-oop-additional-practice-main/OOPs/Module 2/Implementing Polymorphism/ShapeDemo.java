import java.util.Scanner;

/**
 * Shape demo para demonstrar polimorfismo com formas - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 * @version 1.0
 */
public class ShapeDemo {

    public static void displayMenu() {
        System.out.println("1. Adicionar circulo" +
                "\n2. Adicionar retangulo" +
                "\n3. Adicionar triangulo" +
                "\n4. Visualizar todas as formas" +
                "\n5. Sair");
        System.out.print("Escolha: ");
    }

    public static void main(String[] args) {
        // Step 1: Create an array of Shape objects with size 5
        // Hint: Shape[] shapes = new Shape[5];
        Shape[] shapes = new Shape[5];

        // Step 2: Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Step 3: Create an interactive menu to add shapes to the array
        // Hint: Use a loop and a counter to keep track of how many shapes are added
        // The menu should allow users to:
        // 1. Add a Circle
        // 2. Add a Rectangle
        // 3. Add a Triangle
        // 4. Display all shapes
        // 5. Exit
        // Step 4: For each shape type, prompt the user for the required attributes
        // For Circle: name, color, radius
        // For Rectangle: name, color, length, width
        // For Triangle: name, color, side1, side2, side3

        // Step 5: After adding a shape, display its details

        // Step 6: When displaying all shapes, loop through the array and call each shape's
        // toString(), area(), and perimeter() methods
        // This will demonstrate polymorphism as each shape type will use its own implementation
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 5) {
                break;
            }
            switch (choice) {
                case 1:
                    // Add Circle
                    System.out.print("Nome: ");
                    String circleName = scanner.nextLine();
                    System.out.print("Cor: ");
                    String circleColor = scanner.nextLine();
                    System.out.print("Raio: ");
                    double radius = Double.parseDouble(scanner.nextLine());
                    Circle circle = new Circle(circleName, circleColor, radius);
                    for (int i = 0; i < shapes.length; i++) {
                        if (shapes[i] == null) {
                            shapes[i] = circle;
                            System.out.println("Círculo adicionado: " + circle);
                            break;
                        }
                    }
                    break;
                case 2:
                    // Add Rectangle
                    System.out.print("Nome: ");
                    String rectName = scanner.nextLine();
                    System.out.print("Cor: ");
                    String rectColor = scanner.nextLine();
                    System.out.print("Comprimento: ");
                    double length = Double.parseDouble(scanner.nextLine());
                    System.out.print("Largura: ");
                    double width = Double.parseDouble(scanner.nextLine());
                    Rectangle rectangle = new Rectangle(rectName, rectColor, length, width);
                    for (int i = 0; i < shapes.length; i++) {
                        if (shapes[i] == null) {
                            shapes[i] = rectangle;
                            System.out.println("Retângulo adicionado: " + rectangle);
                            break;
                        }
                    }
                    break;
                case 3:
                    // Add Triangle
                    System.out.print("Nome: ");
                    String triName = scanner.nextLine();
                    System.out.print("Cor: ");
                    String triColor = scanner.nextLine();
                    System.out.print("Lado 1: ");
                    double side1 = Double.parseDouble(scanner.nextLine());
                    System.out.print("Lado 2: ");
                    double side2 = Double.parseDouble(scanner.nextLine());
                    System.out.print("Lado 3: ");
                    double side3 = Double.parseDouble(scanner.nextLine());
                    Triangle triangle = new Triangle(triName, triColor, side1, side2, side3);
                    for (int i = 0; i < shapes.length; i++) {
                        if (shapes[i] == null) {
                            shapes[i] = triangle;
                            System.out.println("Triângulo adicionado: " + triangle);
                            break;
                        }
                    }
                    break;
                case 4:
                    // Display all shapes
                    System.out.println("Todas as formas:");
                    for (Shape shape : shapes) {
                        if (shape != null) {
                            System.out.println(shape);
                            System.out.printf("Área: %.2f\n", shape.area());
                            System.out.printf("Perímetro: %.2f\n", shape.perimeter());
                            System.out.println();
        }                }
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
        scanner.close();

    }

}
