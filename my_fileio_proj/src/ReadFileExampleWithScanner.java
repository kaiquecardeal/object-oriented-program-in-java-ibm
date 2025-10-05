/**
 * Essa classe faz a leitura de um arquivo texto. IBM - Coursera
 * Autor: Kaique Cardeal
 */

// Importe as classes necessarias para ler o arquivo
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

// Definindo a classe principal
public class ReadFileExampleWithScanner {
    public static void main(String[] args) {
        // Especificando o nome do arquivo
        try {
            // Cria um objeto Scanner para ler o nome do arquivo
            Scanner scanner = new Scanner(System.in);
            // Comanda o usuário para inserir o nome do arquivo
            System.out.println("Insira o nome do arquivo:");
            // Cria um novo Scanner para ler o conteúdo do arquivo
            // FileReader é usado para ler o arquivo
            Scanner fileScanner = new Scanner(new FileReader(scanner.nextLine()));
            // Loop para ler cada linha do arquivo
            while (fileScanner.hasNext()) {
                // Lê a próxima linha do arquivo
                String fileLine = fileScanner.nextLine();
                // Imprime a linha lida
                System.out.println(fileLine);
            }
            // Fecha o Scanner
            fileScanner.close();
        } catch (FileNotFoundException e) {
            // Imprime uma mensagem de erro
            System.out.println("Arquivo não encontrado." + e.getMessage());
        }
    }
}
