/**
 * Classe de aluno para armazenar e gerenciar informações de alunos - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 * @version 1.0
 */
public class Student {
    // Step 1: Declare private variables for studentId, name, grade, and isActive
    // Hint: Use appropriate data types (String, String, double, boolean)
    private String studentId;
    private String name;
    private double grade;
    private boolean isActive;
    
    
    // Step 2: Create getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()
    public String getStudentId() {
        return studentId;
    }
    public String getName() {
        return name;
    }
    public double getGrade() {
        return grade;
    }
    public boolean getIsActive() {
        return isActive;
    }
    
    
    // Step 3: Create setter methods for each variable
    // Hint: Use the format: public void setVariableName(parameter)
    // Add simple validation:
    // - For grade: Ensure it is between 0 and 100
    // - For studentId: No special validation needed
    // - For name: No special validation needed
    // - For isActive: No special validation needed
    public void setGrade(double grade) {
        if (grade < 0 || grade > 100) {
            this.grade = 0.0;
        } else {
            this.grade = grade;
        }
    }
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // Step 4: Create a method to display student details
    // Hint: Use System.out.println() to print all student information
    // Format should include ID, name, grade, and status (Active/Inactive)
    public void displayDetails() {
        System.out.println("ID: " + this.studentId);
        System.out.println("Nome: " + this.name);
        System.out.println("Nota: " + this.grade);
        System.out.println("Status: " + (this.isActive ? "Ativo" : "Inativo"));
    }
    
    
    // Step 5: Create a method that returns a letter grade based on the numeric grade
    // Hint: A: 90-100, B: 80-89, C: 70-79, D: 60-69, F: below 60
    public String getLetterGrade() {
        if (this.grade >= 90) {
            return "A";
        } else if (this.grade >= 80) {
            return "B";
        } else if (this.grade >= 70) {
            return "C";
        } else if (this.grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    
    // Step 6: Create a method to check if the student is passing (grade >= 60)
    // Hint: Return a boolean value
    public boolean isPassing() {
        return this.grade >= 60;
    }
}
