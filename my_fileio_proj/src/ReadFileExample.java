/*
 * Essa classe faz a leitura de um arquivo texto. IBM - Coursera
 * Autor: Kaique Cardeal
 */

// Importe as classes necessarias para ler o arquivo

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;

// Definindo a classe principal
public class ReadFileExample {
    public static void main(String[] args) {
        // Cria um objeto Scanner para ler o nome do arquivo
        Scanner scanner = new Scanner(System.in);
        // Comanda o usuário para inserir o nome do arquivo que ele quer ler
        System.out.println("Insira o nome do arquivo que você quer ler: ");
        // Lê o nome do arquivo inserido pelo usuário e converte para um objeto Path
        Path filePath = Paths.get(scanner.nextLine());

        try {
            // Lê o conteúdo do arquivo e armazena na variável content
            String content = Files.readString(filePath);
            // Imprime o conteúdo do arquivo
            System.out.println(content);
        } catch (IOException e) {
            // Imprime uma mensagem de erro
            System.out.println("Ocorreu um erro ao tentar ler o arquivo: " + e.getMessage());
        }
    }
}
