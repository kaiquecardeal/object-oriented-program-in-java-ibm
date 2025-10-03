/**
 * StudentRegistry Class para testar o estudante - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 * @version 1.0
 */
public class StudentRegistry {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Student class
        Student student1 = new Student();
        Student student2 = new Student();
        
        
        // Step 2: Use setter methods to set values for all attributes of first student
        // Example values: ID "S001", name "John Doe", grade 85.5, active true
        student1.setStudentId("S001");
        student1.setName("João Dias");
        student1.setGrade(85.5);
        student1.setIsActive(true);
        
        // Step 3: Set values for second student
        // Example values: ID "S002", name "Jane Smith", grade 92.0, active true
        student2.setStudentId("S002");
        student2.setName("Ricardo Correia");
        student2.setGrade(92.0);
        student2.setIsActive(true);

        // Step 4: Display details of both students
        student1.displayDetails();
        student2.displayDetails();

        // Step 5: Compare the grades of the two students and print who has the higher grade
        // Hint: Create a separate method for this comparison
        Student higherGradeStudent = compareGrades(student1, student2);

        // Step 6: Test the letter grade method for both students
        System.out.println("Estudante com a maior nota: " + higherGradeStudent.getName());


        // Step 7: Test the passing status method for both students
        System.out.println("Status de aprovação do estudante 1: " + student1.isPassing());
        System.out.println("Status de aprovação do estudante 2: " + student2.isPassing());
        
        
        // Step 8: Change one student to inactive and display the updated information
        student1.setIsActive(false);
        student1.displayDetails();
    }

    // Step 9: Create a static method to compare two students' grades and return the student with the higher grade
    // Hint: Take two Student objects as parameters
    public static Student compareGrades(Student student1, Student student2) {
        return student1.getGrade() > student2.getGrade() ? student1 : student2;
    }
}
