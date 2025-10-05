/**
 * Essa classe faz a leitura de um arquivo texto. IBM - Coursera
 * Autor: Kaique Cardeal
 */

// Crie um programa Java onde você obterá o nomes de arquivos em loop enquanto os usuários quiserem inserir, ler e exibir o conteúdo.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;

// Definindo a classe principal
public class ReadFileExercise {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler o nome do arquivo
        Scanner scanner = new Scanner(System.in);
        String continueChoice;
        // Loop para ler cada arquivo e se o usuário quiser continuar
        do {
            // Comanda o usuário para inserir o nome do arquivo que ele quer ler
            System.out.println("Insira o nome do arquivo que você quer ler: ");
            Path filePath = Paths.get(scanner.nextLine());
            // Bloco try-catch para tratar exceções
            try {
                String content = Files.readString(filePath);
                System.out.println(content);
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao tentar ler o arquivo: " + e.getMessage());
            }
            // Pergunta se o usuário quer continuar lendo arquivos
            System.out.println("Deseja continuar? (S/N)");
            continueChoice = scanner.nextLine();
        } while (continueChoice.equalsIgnoreCase("s"));
        // Fecha o Scanner
        scanner.close();
    }
}
