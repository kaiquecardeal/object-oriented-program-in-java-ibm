/**
 * This class provides functionality to explore directories and their contents.
 * It allows for listing files and directories within a specified path. - IBM Coursera
 * Autor: Kaique Cardeal
 */
// Importando a classe File para operações de arquivo e diretório

import java.io.File;
// Importando a classe Scanner para obter entrada de dados
import java.util.Scanner;
// Importando o IOException class para tratamento de exceções relacionadas a I/O
import java.io.IOException;

public class DirectoryExplorer {

    // Método para exibir o menu de opções ao usuário
    public static void displayMenu() {
        System.out.println("\nPressione 1 para File Management");
        System.out.println("\nQualquer outra tecla para sair");
    }

    // Método para lidar com o gerenciamento de arquivos
    public static void fileManagement(File file) {
        System.out.println("\nPressione 1 para renomear o arquivo");
        System.out.println("\nPressione 2 para deletar o arquivo");
        System.out.println("\nQualquer outra tecla para sair");

        Scanner scanner = new Scanner(System.in);
        String userAction = scanner.nextLine();

        if (userAction.equals("1")) {
            // Renomear o arquivo
            System.out.println("Digite o novo nome do arquivo: " + file.getName());
            String newName = scanner.nextLine();
            //  Tenta renomear o arquivo
            boolean renamed = file.renameTo(new File(file.getParent(), newName));
            // Verifica se o renomeamento foi bem-sucedido
            if (renamed) {
                System.out.println("O arquivo foi renomeado com sucesso.");
            } else {
                System.out.println("Ocorreu um erro ao renomear o arquivo.");
            }
        } else if (userAction.equals("2")) {
            // Deletar o arquivo
            boolean deleted = file.delete();
            // Verifica se o arquivo foi deletado
            if (deleted) {
                System.out.println("O arquivo foi deletado com sucesso.");
            } else {
                System.out.println("Ocorreu um erro ao deletar o arquivo.");
            }

        }

    }

    // Método para lidar com o gerenciamento de diretórios
    public static void directoryManagement(File dirObj) {
        System.out.println("Pressione 1 para listar o diretório");
        System.out.println("Pressione 2 para renomear um diretório");
        System.out.println("Pressione 3 para deletar o diretório");

        Scanner scanner = new Scanner(System.in);
        String userAction = scanner.nextLine();

        if (userAction.equals("1")) {
            // Lista o conteúdo do diretório
            String fileNames[] = dirObj.list();
            if (fileNames.length == 0) {
                System.out.println("O diretório está vazio.");
            } else {
                for (String fileName : fileNames) {
                    System.out.println(fileName);
                }
            }
        } else if (userAction.equals("2")) {
            // Renomeia o diretório
            System.out.println("Insira o novo nome do novo diretório: " + dirObj.getName());
            String newDirName = scanner.nextLine();

            boolean changed = dirObj.renameTo(new File(dirObj.getParent(), newDirName));

            if (changed) {
                System.out.println("O diretório foi renomeado com sucesso.");
            } else {
                System.out.println("Ocorreu um erro ao renomear o diretório.");
            }
        } else if (userAction.equals("3")) {
            // Deleta o diretório
            boolean deleted = dirObj.delete();
            // Verifica se o diretório foi deletado
            if (deleted) {
                System.out.println("O diretório foi deletado com sucesso.");
            } else {
                System.out.println("Ocorreu um erro ao deletar o diretório. Certifique-se de que o diretório está vazio.");
            }
        }
    }

    public static void main(String[] args) {
        // Criando um objeto Scanner para obter entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Loop infinito para manter o programa em execução até o usuário decidir sair
        while (true) {
            // Exibindo o menu de opções
            displayMenu();
            // Lê a ação do usuário
            String userAction = scanner.nextLine();
            // Opção 1: File Management
            if (userAction.equals("1")) {
                // Solicita ao usuário o caminho do diretório ou arquivo
                System.out.println("Digite o caminho do diretório ou arquivo: ");
                // Lê o caminho do arquivo
                String fileName = scanner.nextLine();
                // Cria o objeto File representando o arquivo ou diretório
                File file = new File(fileName);
                // Checa se o arquivo existe
                if (file.exists()) {
                    // Verifica se é arquivo ou diretório
                    if (file.isFile()) {
                        System.out.println("O arquivo " + fileName + " existe.");
                        fileManagement(file);
                    } else {
                        System.out.println("O arquivo" + fileName + " é um diretório.");
                        directoryManagement(file);
                    }
                } else {
                    // Se o diretório ou arquivo não existir, solicita ao usuário para cria-lo
                    System.out.println("O arquivo" + fileName + " não é um arquivo ou diretório válido.");
                    System.out.println("Para criar um arquivo pressione 1\n");
                    System.out.println("Para criar um diretório pressione 2\n");
                    System.out.println("Para não fazer nada e continuer, pressione qualquer outra tecla");

                    // Lê a ação do usuário
                    String createAction = scanner.nextLine();
                    // Cria o arquivo
                    if (createAction.equals("1")) {
                        // Obtem o diretório pai
                        String parentDirStr = file.getParent();
                        File parentDir = new File(parentDirStr);
                        // Cria o diretório pai, se necessário
                        if (parentDir.exists()) {
                            boolean created = parentDir.mkdirs();
                            if (!created) {
                                System.out.println("Não foi possível criar o diretório pai.");
                                continue;
                            }
                        }
                        // Cria o arquivo
                        try {
                            file.createNewFile();
                            System.out.println("O arquivo foi criado com sucesso.");
                        } catch (IOException e) {
                            System.out.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
                        }
                    } // Cria o diretório
                    else if (createAction.equals("2")) {
                        boolean created = file.mkdirs();
                        if (created) {
                            System.out.println("O diretório foi criado com sucesso.");
                        } else {
                            System.out.println("Não foi possível criar o diretório.");
                        }
                    }
                }
            }
            //Saí do programa
            else {
                System.out.println("Obrigado por usar nosso programa.");
                break;
            }
        }
    }
}
