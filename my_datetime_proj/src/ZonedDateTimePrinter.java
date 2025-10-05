import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Classe que imprime a data e hora atual com fuso horário
 * Autor: Kaique Cardeal
 *
 */

public class ZonedDateTimePrinter {

    public static void displayMenu() {
        ZonedDateTime nowDateTime = ZonedDateTime.now();
        System.out.println("\nFormato padrão: " + nowDateTime);
        System.out.println("\n\nInsira o formato desejado para a data e hora: ");
        System.out.println("dd para Data, ");
        System.out.println("M para mês, MM com o zero do mês, MMM para abreviar o mês, MMMM para o nome completo, ");
        System.out.println("yy ou yyyy para ano, ");
        System.out.println("H para hora, HH com o zero da hora, ");
        System.out.println("m para minuto, mm com o zero do minuto, ");
        System.out.println("s para segundo, ss com o zero do segundo, ");
        System.out.println("z para fuso horário(por exemplo: GMT-03:00), zzz: TimeZone (por exemplo: Pacific Daylight Time, Eastern Standard Time). ");
        System.out.println("Z para fuso horário com offset, ZZ: fuso horário com offset, ZZZ: fuso horário com nome, ZZZZ: fuso horário com nome, ZZZZZ: fuso horário com nome.   ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayMenu();

        String strDateTimeFormat = scanner.nextLine();
        DateTimeFormatter newDateTimeFormatter = DateTimeFormatter.ofPattern(strDateTimeFormat);
        System.out.println("A data e a hora é: " + ZonedDateTime.now().format(newDateTimeFormatter));
        scanner.close();
    }
}
