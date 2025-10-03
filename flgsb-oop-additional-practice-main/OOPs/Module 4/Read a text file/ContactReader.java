// ContactReader.java
// This program reads contact information from a file and displays it in a formatted way
// Step 1: Import necessary packages for file I/O operations
// Hint: You'll need classes from java.io or java.nio.file packages
// You'll also need Scanner for user input
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Leitor de contatos - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 * @version 1.0
 */

public class ContactReader {
    public static void main(String[] args) {
        // Step 2: Create a Scanner object to read user input
        Scanner input = new Scanner(System.in);

        // Step 3: Prompt the user to enter the file name containing contacts
        // Example: "Enter the name of the contacts file:"
        System.out.println("Insira o nome do arquivo de contatos: ");

        // Step 4: Read the file name entered by the user
        String fileName = input.nextLine();

        BufferedReader bufferedReader = null;
        try {
            // Step 5: Create a FileReader or similar object to read the file
            // Hint: You can use FileReader
            FileReader fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            // Step 6: Read the file line by line
            // Hint: Use a loop to process each line
            String line;
            // Optional Bonus:
            // Step 11: Add a feature to count and display the total number of contacts read
            int contactCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                // Each line is expected to be in the format: "Name:PhoneNumber"

                // Step 7: Parse each line to extract name and phone number
                // Hint: Use String methods like split() to separate by colon
                // Step 8: Display the contact information in a formatted way
                // Example: "Contact: John Doe | Phone: +1-555-123-4567"
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String phoneNumber = parts[1].trim();
                    System.out.println("Contato: " + name + " | Telefone: " + phoneNumber);
                    contactCount++;
                } else {
                    System.out.println("Formato inválido na linha: " + line);
                }
            }
            System.out.println("Total de contatos lidos: " + contactCount);

            // Step 9: Close the file reader when done
            bufferedReader.close();

        } catch (Exception e) {
            // Step 10: Handle exceptions appropriately
            // Display a user-friendly error message
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());

        }

    }
}
