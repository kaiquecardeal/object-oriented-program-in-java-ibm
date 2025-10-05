/**
 * Classe que imprime a data e hora atual
 * Autor: Kaique Cardeal
 *
 */

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimePrinter {
    // Menu para escolher o formato desejado para a data
    public static void displayDateMenu() {
        System.out.println("Digite o formato que você deseja exibir: ");
        System.out.println("dd para data, ");
        System.out.println("M para mês, MM com o zero do mês, MMM para abreviar o mês, MMMM para o nome completo, ");
        System.out.println("yy ou yyyy para ano.");
    }

    // Menu para escolher o formato desejado para a hora
    public static void displayTimeMenu() {
        System.out.println("Digite o formato que você deseja exibir: ");
        System.out.println("H para hora, HH com o zero da hora, ");
        System.out.println("m para minuto, mm com o zero do minuto, ");
        System.out.println("s para segundo, ss com o zero do segundo.");
    }

    public static void main(String[] args) {
        // Cria um objeto LocalDate
        LocalDate todayDate = LocalDate.now();
        // Cria um scanner
        Scanner scanner = new Scanner(System.in);
        // Exibe um menu para escolher o formato desejado para a data
        displayDateMenu();
        // Lê o formato desejado pelo usuário
        String strDateFormat = scanner.nextLine();
        // Cria um objeto DateTimeFormatter
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(strDateFormat);
        // Formata e exibe a data
        System.out.println("A data é " + todayDate.format(dateFormatter));
        // Cria um objeto LocalTime
        LocalTime nowTime = LocalTime.now();
        // Exibe um menu para escolher o formato desejado para a hora
        displayTimeMenu();
        // Lê o formato desejado pelo usuário
        String strTimeFormat = scanner.nextLine();
        // Cria um objeto DateTimeFormatter
        DateTimeFormatter newTimeFormatter = DateTimeFormatter.ofPattern(strTimeFormat);
        // Formata e exibe a hora
        System.out.println("A hora é: " + nowTime.format(newTimeFormatter));
        // Cria um objeto LocalDateTime
        LocalDateTime nowDateTime = LocalDateTime.now();
        // Exibe a data e hora atual
        System.out.println(nowDateTime);
        // Solicita o usuário para inserir o formato desejado para a data e hora
        System.out.println("\n\nInsira o formato que você gostaria de exibir a data e hora:");
        // Lê o formato desejado pelo usuário
        String strDateTimeFormat = scanner.nextLine();
        // Cria um objeto DateTimeFormatter
        DateTimeFormatter newDateTimeFormatter = DateTimeFormatter.ofPattern(strDateTimeFormat);
        // Formata e exibe a data e hora
        System.out.println("A data e a hora é: " + nowDateTime.format(newDateTimeFormatter));
    }
}
