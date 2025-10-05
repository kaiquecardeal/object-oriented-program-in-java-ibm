/**
 * Classe que calcula a diferença entre duas datas.
 * Autor: Kaique Cardeal
 * versão: 1.0
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class DateDiffCalculator {
    public static String getDiff(LocalDate d1, LocalDate d2) {
        Period period = d1.until(d2);
        String diffStr = "A diferença é: ";

        if (period.getYears() != 0) {
            diffStr += period.getYears() + " anos, ";
        }

        if (period.getMonths() != 0) {
            diffStr += period.getMonths() + " meses, ";
        }

        if (period.getDays() != 0) {
            diffStr += period.getDays() + " dias.";
        }

        return diffStr;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o formato que deseja utilizar para a data dd/MM/yyyy: ");
        String dateFormatStr = scanner.nextLine();

        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern(dateFormatStr);

        try {

            System.out.println("Insira a data em formato " + dateFormatStr + " :");
            String rawDate1 = scanner.nextLine();

            LocalDate givenDate1 = LocalDate.parse(rawDate1, dateTimeFormat);

            System.out.println("Insira outra data em formator " + dateFormatStr + " :");
            String rawDate2 = scanner.nextLine();
            LocalDate givenDate2 = LocalDate.parse(rawDate2, dateTimeFormat);

            System.out.println("A data 1 é: " + givenDate1);

            System.out.println("A data 2: é " + givenDate2);

            if (givenDate1.isEqual(givenDate2)) {
                System.out.println("As datas informadas é igual à data atual.");
            } else {
                if (givenDate1.isBefore(givenDate2)) {
                    System.out.println(getDiff(givenDate1, givenDate2));
                } else {
                    System.out.println(getDiff(givenDate2, givenDate1));
                }
            }
        } catch (DateTimeParseException dte) {
            System.out.println("Formato de data inválido. Por favor, use dd/MM/yyyy.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
