/**
 * TestEncapsulation para demonstrar encapsulamento - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 * @version 1.0
 */
public class TestEncapsulation {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Employee class
        // One using the parameterized constructor and one using default constructor with setters
        Employee employee1 = new Employee("João", 30, 10000);
        Employee employee2 = new Employee();

        // Step 2: Print details of both employees
        employee1.displayDetails();
        employee2.displayDetails();

        // Step 3: Try setting invalid values (null name, age outside range, negative salary)
        // and see if your validation works
        employee1.setName(null);
        employee1.setAge(100);
        employee1.setSalary(-1000);
        employee1.displayDetails();

        // Step 4: Give both employees a 10% raise and display their details again
        employee1.giveRaise(10);
        employee2.giveRaise(10);
        employee1.displayDetails();
        employee2.displayDetails();

        // Step 5: Clone the first employee and display the cloned employee details
        // Hint: Use try-catch block to handle CloneNotSupportedException
        // Employee clonedEmployee = (Employee) employee1.clone();
        try {
            Employee clonedEmployee = (Employee) employee1.clone();
            clonedEmployee.displayDetails();
        } catch (CloneNotSupportedException e) {
            System.out.println("Clonagem não suportada.");
            e.printStackTrace();
            return;
        }

        // Step 6: Modify the original employee and verify that the clone remains unchanged
        // This demonstrates that cloning creates a separate object
        employee1.setName("Carlos");
        employee1.displayDetails();

        // Step 7: Create a method that compares the salaries of two employees
        // and returns the name of the employee with the higher salary
        // If salaries are equal, return "Equal salaries"
        String higherSalaryEmployee = compareSalaries(employee1, employee2);
        System.out.println(higherSalaryEmployee);

    }

    private static String compareSalaries(Employee employee1, Employee employee2) {
        if (employee1.getSalary() > employee2.getSalary()) {
            return employee1.getName();
        } else if (employee1.getSalary() < employee2.getSalary()) {
            return employee2.getName();
        } else {
            return "Salários iguais";
        }
    }
}
