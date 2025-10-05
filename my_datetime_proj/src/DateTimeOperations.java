import java.time.ZonedDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class DateTimeOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZonedDateTime dateTime = ZonedDateTime.now();
        System.out.println("\nFormato padrão: " + dateTime);

        while (true) {
            System.out.println("\nPressione 1 para adicionar ou deletar a data/hora atuais,");
            System.out.println("\nPressione 2 para mudar o fuso horário");
            System.out.println("\nQualquer outra tecla para sair.");

            String userAction = scanner.nextLine();

            if (userAction.equals("1")) {
                System.out.println("Digite a data/hora que deseja adicionar ou deletar:");
                String unitToChange = scanner.nextLine();

                System.out.println("Digite a quantidade para mudar(por exemplo: 3): ");
                long qtyToChange = Long.parseLong(scanner.nextLine());

                System.out.println("\nPressione 'a' para adicionar ou 'd' para deletar:");
                System.out.println("\nQualquer outra tecla para voltar ao menu anterior.");
                String addOrDelete = scanner.nextLine();

                ZonedDateTime updatedDateTime = dateTime;

                if (addOrDelete.equals("a")) {

                    switch (unitToChange) {
                        case "d":
                            updatedDateTime = updatedDateTime.plusDays(qtyToChange);
                            break;
                        case "M":
                            updatedDateTime = updatedDateTime.plusMonths(qtyToChange);
                            break;
                        case "y":
                            updatedDateTime = updatedDateTime.plusYears(qtyToChange);
                            break;
                        case "h":
                            updatedDateTime = updatedDateTime.plusHours(qtyToChange);
                            break;
                        case "m":
                            updatedDateTime = updatedDateTime.plusMinutes(qtyToChange);
                            break;
                        case "s":
                            updatedDateTime = updatedDateTime.plusSeconds(qtyToChange);
                            break;
                        case "w":
                            updatedDateTime = updatedDateTime.plusWeeks(qtyToChange);
                            break;
                        default:
                            System.out.println("Unidade inválida. Use 'd', 'M', 'y', 'h', 'm', 's' ou 'w'.");
                            continue;
                    }
                } else if (addOrDelete.equals("d")) {

                    switch (unitToChange) {
                        case "d":
                            updatedDateTime = updatedDateTime.minusDays(qtyToChange);
                            break;
                        case "M":
                            updatedDateTime = updatedDateTime.minusMonths(qtyToChange);
                            break;
                        case "y":
                            updatedDateTime = updatedDateTime.minusYears(qtyToChange);
                            break;
                        case "h":
                            updatedDateTime = updatedDateTime.minusHours(qtyToChange);
                            break;
                        case "m":
                            updatedDateTime = updatedDateTime.minusMinutes(qtyToChange);
                            break;
                        case "s":
                            updatedDateTime = updatedDateTime.minusSeconds(qtyToChange);
                            break;
                        case "w":
                            updatedDateTime = updatedDateTime.minusWeeks(qtyToChange);
                            break;
                        default:
                            System.out.println("Unidade inválida. Use 'd', 'M', 'y', 'h', 'm', 's' ou 'w'.");
                            continue;
                    }
                } else {
                    System.out.println("Entrada inválida. Use 'a' ou 'd'.");
                    continue;
                }
                System.out.println("\nInsira o formato que voce deseja exibir o horario (dd/MM/yyyy HH:mm:ss): ");
                String strDateFormat = scanner.nextLine();

                DateTimeFormatter newDateTimeFormatter = DateTimeFormatter.ofPattern(strDateFormat);
                System.out.println("A data e a hora é: " + updatedDateTime.format(newDateTimeFormatter));
            } else if (userAction.equals("2")) {
                System.out.println("Marque as seguintes opções de fuso: ");
                Object[] zoneIds = ZoneId.getAvailableZoneIds().toArray();
                for (Object zoneId : zoneIds) {
                    System.out.println(zoneId);
                }

                System.out.println("\n\nInsira o fuso horário que você deseja obter a data/hora atual: ");
                String newZone = scanner.nextLine();

                ZonedDateTime newDateTime = dateTime.withZoneSameInstant(ZoneId.of(newZone));

                DateTimeFormatter newDateTimeFormat = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss a zzz");

                System.out.println("A data e a hora é: " + newDateTime.format(newDateTimeFormat));
            } else {
                break;
            }
        }
    }
}
