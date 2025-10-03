import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileSystemManager - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 * @version 1.0
 */
public class FileSystemManager {

    // The current working directory
    private File currentDirectory;

    // Scanner for user input
    private Scanner scanner;

    // Date formatter for file timestamps
    private SimpleDateFormat dateFormat;

    /**
     * Constructor to initialize the file system manager
     */
    public FileSystemManager() {
        // TODO: Initialize the current directory to the user's current directory
        // Hint: Use System.getProperty("user.dir") to get the current working directory
        currentDirectory = new File(System.getProperty("user.dir"));

        // TODO: Initialize the scanner for reading user input
        scanner = new Scanner(System.in);

        // TODO: Initialize the date formatter for displaying timestamps
        // Hint: Use "yyyy-MM-dd HH:mm:ss" as the date format pattern
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Start the file system manager
     */
    public void start() {
        System.out.println("Bem-vindo ao FileSystemManager!");
        System.out.println("Digite 'help' para ver os comandos disponíveis.");

        boolean running = true;
        while (running) {
            // TODO: Display the current directory path as a prompt
            System.out.print("> ");

            // TODO: Read user command
            String command = scanner.nextLine();

            // TODO: Process the command
            // If command is "exit", set running to false
            // Otherwise, call processCommand() method
            running = processCommand(command);
            if (!running) {
                break;
            } else {
                System.out.println("Diretório Atual: " + currentDirectory.getAbsolutePath());
            }
        }

        // TODO: Close the scanner before exiting
        scanner.close();
    }

    /**
     * Process a user command
     *
     * @param command The command entered by the user
     * @return true to continue, false to exit
     */
    private boolean processCommand(String command) {
        // Split the command into parts (command name and arguments)
        String[] parts = command.trim().split("\\s+", 2);
        String commandName = parts[0].toLowerCase();
        String args = (parts.length > 1) ? parts[1] : "";

        switch (commandName) {
            case "help":
                displayHelp();
                break;
            case "ls":
                // TODO: Implement listing files and directories
                listFiles();
                break;
            case "cd":
                // TODO: Implement changing directories
                // Hint: Handle "cd .." (parent directory) and "cd directoryName"
                if (args.equals("..")) {
                    changeDirectory("..");
                } else if (!args.isEmpty()) {
                    changeDirectory(args);
                } else {
                    System.out.println("Por favor, forneça um nome de diretório válido.");
                }
                break;
            case "pwd":
                // TODO: Implement displaying current directory path
                System.out.println(currentDirectory.getAbsolutePath());
                break;
            case "mkdir":
                // TODO: Implement creating a new directory
                createDirectory(args);
                break;
            case "touch":
                // TODO: Implement creating a new file
                createFile(args);
                break;
            case "rm":
                // TODO: Implement deleting a file or directory
                delete(args);
                break;
            case "rename":
                // TODO: Implement renaming a file or directory
                // Hint: The args will contain both old and new names
                String[] renameParts = args.split("\\s+", 2);
                if (renameParts.length == 2) {
                    rename(renameParts[0], renameParts[1]);
                } else {
                    System.out.println("Por favor, forneça os nomes antigo e novo.");
                }
                break;
            case "find":
                // TODO: Implement searching for files by name pattern
                findFiles(args);
                break;
            case "info":
                // TODO: Implement displaying file information
                displayFileInfo(args);
                break;
            case "exit":
                return false;
            default:
                System.out.println("Unknown command. Type 'help' for available commands.");
        }

        return true;
    }

    /**
     * Display help information
     */
    private void displayHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("  help              - Display this help message");
        System.out.println("  ls                - List files in current directory");
        System.out.println("  cd <directory>    - Change to specified directory (use .. for parent)");
        System.out.println("  pwd               - Print current directory path");
        System.out.println("  mkdir <name>      - Create a new directory");
        System.out.println("  touch <name>      - Create a new file");
        System.out.println("  rm <name>         - Delete a file or directory");
        System.out.println("  rename <old> <new> - Rename a file or directory");
        System.out.println("  find <pattern>    - Search for files matching pattern");
        System.out.println("  info <name>       - Display file information");
        System.out.println("  exit              - Exit the program");
    }

    /**
     * List files and directories in the current directory
     */
    private void listFiles() {
        // TODO: Get the list of files and directories in the current directory
        File[] files = currentDirectory.listFiles();
        if (files == null) {
            System.out.println("Erro ao listar arquivos: diretório inválido ou sem permissão.");
            return;
        } else if (files.length == 0) {
            System.out.println("O diretório está vazio.");
            return;
        }

        // TODO: Display the list of files and directories
        // For each file, show:
        // - 'd' if it's a directory or '-' if it's a file
        // - The file name
        for (File file : files) {
            String type = file.isDirectory() ? "d" : "-";
            System.out.println(type + " " + file.getName());
        }
        System.out.println("\nTotal de arquivos: " + files.length);
    }

    /**
     * Change to a different directory
     *
     * @param dirName The name of the directory to change to
     */
    private void changeDirectory(String dirName) {
        // TODO: Implement changing to a directory
        // If dirName is "..", go to parent directory
        // Otherwise, change to the specified directory if it exists
        if (dirName.equals("..")) {
            File parent = currentDirectory.getParentFile();
            if (parent != null) {
                currentDirectory = parent;
            } else {
                System.out.println("Já está no diretório raiz.");
            }
        } else {
            File newDirectory = new File(currentDirectory, dirName);
            if (newDirectory.exists() && newDirectory.isDirectory()) {
                currentDirectory = newDirectory;
            } else {
                System.out.println("Diretório não encontrado: " + dirName);
            }
        }
    }

    /**
     * Create a new directory
     *
     * @param dirName The name of the directory to create
     */
    private void createDirectory(String dirName) {
        // TODO: Implement creating a new directory
        // Create a new directory with the given name in the current directory
        if (dirName == null || dirName.trim().isEmpty()) {
            System.out.println("Por favor, forneça um nome de diretório válido.");
            return;
        }
        File newDir = new File(currentDirectory, dirName);
        if (newDir.exists()) {
            System.out.println("Diretório já existe.");
            return;
        }
        if (newDir.mkdir()) {
            System.out.println("Diretório criado com sucesso.");
        } else {
            System.out.println("Erro ao criar diretório.");
        }
    }

    /**
     * Create a new file
     *
     * @param fileName The name of the file to create
     */
    private void createFile(String fileName) {
        // TODO: Implement creating a new file
        // Create a new empty file with the given name in the current directory
        if (fileName == null || fileName.trim().isEmpty()) {
            System.out.println("Por favor, forneça um nome de arquivo válido.");
            return;
        }
        File newFile = new File(currentDirectory, fileName);
        if (newFile.exists()) {
            System.out.println("Arquivo já existe.");
            return;
        }
        try {
            if (newFile.createNewFile()) {
                System.out.println("Arquivo criado com sucesso.");
            } else {
                System.out.println("Erro ao criar arquivo.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo: " + e.getMessage());
        }
    }

    /**
     * Delete a file or directory
     *
     * @param name The name of the file or directory to delete
     */
    private void delete(String name) {
        // TODO: Implement deleting a file or directory
        // If it's a directory, provide a warning and confirm deletion
        File target = new File(currentDirectory, name);
        if (!target.exists()) {
            System.out.println("Arquivo ou diretório não encontrado.");
            return;
        } else if (target.isDirectory()) {
            System.out.println("Aviso: Você está prestes a deletar um diretório. Isso removerá todos os arquivos dentro dele.");
            System.out.print("Digite 'yes' para confirmar: ");
            String confirmation = scanner.nextLine();
            if (!confirmation.equalsIgnoreCase("yes")) {
                System.out.println("Operação cancelada.");
                return;
            }
        }
        if (target.delete()) {
            System.out.println("Arquivo ou diretório deletado com sucesso.");
        } else {
            System.out.println("Erro ao deletar arquivo ou diretório.");
        }
    }

    /**
     * Rename a file or directory
     *
     * @param oldName The current name of the file or directory
     * @param newName The new name for the file or directory
     */
    private void rename(String oldName, String newName) {
        // TODO: Implement renaming a file or directory
        File oldFile = new File(currentDirectory, oldName);
        File newFile = new File(currentDirectory, newName);
        if (!oldFile.exists()) {
            System.out.println("Arquivo ou diretório não encontrado.");
            return;
        } else if (newFile.exists()) {
            System.out.println("Já existe um arquivo ou diretório com o novo nome.");
            return;
        }
        if (oldFile.renameTo(newFile)) {
            System.out.println("Arquivo ou diretório renomeado com sucesso.");
        } else {
            System.out.println("Erro ao renomear arquivo ou diretório.");
        }
    }

    /**
     * Search for files matching a pattern
     *
     * @param pattern The pattern to search for
     */
    private void findFiles(String pattern) {
        System.out.println("Procurando arquivos com padrão: " + pattern);
        findFilesRecursive(currentDirectory, pattern);
    }

    private void findFilesRecursive(File directory, String pattern) {
        // TODO: Implement searching for files by name pattern
        // Use recursive method to search through directories
        File[] files = currentDirectory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.getName().toLowerCase().contains(pattern.toLowerCase())) {
                String relativePath = currentDirectory.toPath().relativize(file.toPath()).toString();
                System.out.println(relativePath + (file.isDirectory() ? " (diretório)" : ""));
            }
            if (file.isDirectory()) {
                findFilesRecursive(file, pattern);
            }
        }
    }

    /**
     * Display detailed information about a file
     *
     * @param fileName The name of the file to display information for
     */
    private void displayFileInfo(String fileName) {
        // TODO: Implement displaying file information
        // Show file size, last modified date, whether it's a directory, etc.
        File file = new File(currentDirectory, fileName);
        if (!file.exists()) {
            System.out.println("Arquivo não encontrado.");
            return;
        }
        System.out.println("Nome: " + file.getName());
        System.out.println("Tamanho: " + file.length() + " bytes");
        System.out.println("Última modificação: " + dateFormat.format(new Date(file.lastModified())));
        System.out.println("É diretório: " + file.isDirectory());
        System.out.println("Permissões: Leitura=" + file.canRead() + ", Escrita=" + file.canWrite() + ", Execução=" + file.canExecute());
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        FileSystemManager manager = new FileSystemManager();
        manager.start();
    }
}
