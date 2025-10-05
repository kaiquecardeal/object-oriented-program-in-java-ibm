/**
 * Classe responsável por uma lista de contato
 *
 * @author Kaique Cardeal
 * @version 1.0
 */


import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookHashMap {

    // Método para validar se o nome contem apenas letras, espaços, hiféns e apóstrofos
    private static boolean isValidName(String name) {
        if (!name.matches("^[a-zA-Z\\s-']+$")) {
            System.out.println("Nome inválido!");
            return false;
        }
        return true;
    }

    // Método para validar se o número de telefone está em um formato aceitável
    private static boolean isProneNumberValid(String phoneNumber) {
        return phoneNumber.matches("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{3,4}[-.\\s]?\\d{4,5}(?<!\\d)");
    }

    private static void displayMenu() {
        System.out.println("1. Adicionar contato");
        System.out.println("2. Ver todos os contatos");
        System.out.println("3. Procurar contato por nome");
        System.out.println("4. Deletar um contato");
        System.out.println("Qualquer outra tecla para sair");
    }

    public static void main(String[] args) {
        try {
            // Cria um objeto scanner para ler entradas do usuário
            Scanner scanner = new Scanner(System.in);

            // Cria um HashMap para armazenar nomes e números de telefone
            HashMap<String, String> phoneBook = new HashMap<>();

            //Loop Infinito para parar o programar quando o usuário quiser
            label:
            while (true) {
                // Mostra o menu de opções para o usuario
                displayMenu();

                // Lê a ação do usuário
                String userAction = scanner.nextLine();

                // Opção 1: Adicionar contato
                switch (userAction) {
                    case "1":
                        System.out.println("Digite o nome do contato:");
                        String name = scanner.nextLine();

                        if (isValidName(name)) {
                            continue;
                        }
                        if (phoneBook.containsKey(name)) {
                            System.out.println("Contato já existe!");
                            String repChoice = scanner.nextLine();

                            if (repChoice.equalsIgnoreCase("n")) {
                                continue;
                            }
                        }

                        // Comanda para o usuário inserir o número de telefone
                        System.out.println("Insira o número de telefone:");
                        String phoneNumber = scanner.nextLine();
                        // Valida o formato do número de telefone
                        if (!isProneNumberValid(phoneNumber)) {
                            continue;
                        }
                        // Adiciona o nome e o telefone no HashMap
                        phoneBook.put(name, phoneNumber);
                        System.out.println("Contato adicionado com sucesso!");
                        break;
                    // Opção 2: Mostra todos os contatos
                    case "2":
                        // Verifica se a lista está vazia
                        if (phoneBook.isEmpty()) {
                            System.out.println("Nenhum contato na lista!");
                        } else {
                            System.out.println("Contatos:");
                            for (String contactName : phoneBook.keySet()) {
                                System.out.println("Nome: " + contactName + ", Telefone: " + phoneBook.get(contactName));
                            }
                        }
                        break;
                    // Opção 3: Procura contato por nome
                    case "3":
                        System.out.println("Digite o nome do contato que deseja procurar:");
                        String nameToSearch = scanner.nextLine();
                        if (phoneBook.containsKey(nameToSearch)) {
                            System.out.println("Contato encontrado: Nome: " + nameToSearch + ", Telefone: " + phoneBook.get(nameToSearch));
                        } else {
                            System.out.println("Contato não encontrado!");
                        }

                        break;
                    // Opção 4: Deleta um contato
                    case "4":
                        System.out.println("Digite o nome do contato que deseja deletar:");
                        String nameToDelete = scanner.nextLine();
                        if (phoneBook.containsKey(nameToDelete)) {
                            phoneBook.remove(nameToDelete);
                            System.out.println("Contato deletado com sucesso!");
                        } else {
                            System.out.println("Contato não encontrado!");
                        }
                        break;
                    default:
                        break label;
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Opção inválida!");
        }
    }
}
