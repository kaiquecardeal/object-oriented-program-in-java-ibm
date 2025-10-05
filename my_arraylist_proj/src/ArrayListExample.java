/**
 * Classe que representa um exemplo de ArrayList - IBM Course
 *
 * @author Kaique Cardeal
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void displayMenu() {
        System.out.println("1 - Adicionar tarefa");
        System.out.println("2 - Listar tarefas");
        System.out.println("3 - Mudar Status da tarefa");
        System.out.println("4 - Deletar tarefa");
        System.out.println("5 - Para ordenar a lista baseado em prioridade");
        System.out.println("Qualquer outra tecla para sair");
    }

    public static void main(String[] args) {
        try {
            // Cria um objeto scanner para ler dados do teclado
            Scanner scanner = new Scanner(System.in);
            // Cria um objeto ArrayList para armazenar os dados
            ArrayList<Task> todoList = new ArrayList<Task>();

            // Loop infinito para parar o programa quando o usuário escolher sair
            while (true) {
                //Display Menu para o usuário
                displayMenu();

                //Lê a opção do usuário
                String userAction = scanner.nextLine();

                if (userAction.equals("1")) {
                    //Adiciona uma nova tarefa
                    System.out.println("Digite o nome da tarefa:");
                    String taskName = scanner.nextLine();
                    System.out.println("Digite a prioridade da tarefa (1 - Baixa, 2 - Média, 3 - Alta):");
                    int priority = Integer.parseInt(scanner.nextLine());
                    Task newTask = new Task(taskName, priority);
                    todoList.add(newTask);
                    System.out.println("Tarefa adicionada com sucesso!");
                } else if (userAction.equals("2")) {
                    //Lista todas as tarefas
                    System.out.println("Lista de tarefas:");
                    for (int i = 0; i < todoList.size(); i++) {
                        System.out.println(i + " - " + todoList.get(i).toString());
                    }
                } else if (userAction.equals("3")) {
                    //Muda o status de uma tarefa
                    System.out.println("Digite o índice da tarefa que deseja mudar o status:");
                    int taskIndex = Integer.parseInt(scanner.nextLine());
                    if (taskIndex >= 0 && taskIndex < todoList.size()) {
                        Task taskToUpdate = todoList.get(taskIndex);
                        System.out.println("Status atual: " + taskToUpdate.getStatus());
                        System.out.println("Digite o novo status (Novo, Em processo, Completo):");
                        String newStatus = scanner.nextLine();
                        taskToUpdate.setStatus(newStatus);
                        System.out.println("Status atualizado com sucesso!");
                    } else {
                        System.out.println("Índice inválido!");
                    }
                } else if (userAction.equals("4")) {
                    //Deleta uma tarefa
                    System.out.println("Digite o índice da tarefa que deseja deletar:");
                    int taskIndex = Integer.parseInt(scanner.nextLine());
                    if (taskIndex >= 0 && taskIndex < todoList.size()) {
                        todoList.remove(taskIndex);
                        System.out.println("Tarefa deletada com sucesso!");
                    } else {
                        System.out.println("Índice inválido!");
                    }
                } else if (userAction.equals("5")) {
                    //Ordena a lista baseado na prioridade
                    todoList.sort((task1, task2) -> task2.getPriority() - task1.getPriority());
                    System.out.println("Lista ordenada por prioridade com sucesso!");

                } else {
                    //Sai do programa
                    System.out.println("Saindo...");
                    break;
                }
            }
            scanner.close();
        } catch (NumberFormatException e) {

            System.out.println("Entrada inválida! Por favor, insira um número válido.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
