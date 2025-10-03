import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * TravelPlanner - Controle de Viagens - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 */

public class TravelPlanner {

    // Step 1: Declare a DateTimeFormatter for the standard date format "dd/MM/yyyy"
    // Hint: Use DateTimeFormatter.ofPattern()
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Calculates the duration of a trip in days
     *
     * @param departureDate The date of departure
     * @param returnDate    The date of return
     * @return The number of days between departure and return
     */
    public static long calculateTripDuration(LocalDate departureDate, LocalDate returnDate) {
        // Step 2: Calculate and return the number of days between departure and return dates
        if (departureDate == null || returnDate == null) {
            throw new IllegalArgumentException("Data de partida e data de retorno não podem ser nulas.");
        } else if (!validateTravelDates(departureDate, returnDate)) {
            throw new IllegalArgumentException("Datas de viagem inválidas.");
        }
        // Hint: Use ChronoUnit.DAYS.between()
        return ChronoUnit.DAYS.between(departureDate, returnDate);
    }

    /**
     * Validates that the provided dates make logical sense for a trip
     *
     * @param departureDate The date of departure
     * @param returnDate    The date of return
     * @return true if dates are valid, false otherwise
     */
    public static boolean validateTravelDates(LocalDate departureDate, LocalDate returnDate) {
        // Step 3: Implement validation logic:
        // - Departure date should not be in the past
        // - Return date should be after departure date
        // - Trip should not be longer than 90 days
        // Hint: Use LocalDate.now() for current date and various comparison methods
        return !departureDate.isBefore(LocalDate.now()) && !returnDate.isBefore(departureDate) && ChronoUnit.DAYS.between(departureDate, returnDate) <= 90;
    }

    /**
     * Calculates hotel check-in and check-out dates based on travel dates
     *
     * @param departureDate The date of departure
     * @param returnDate    The date of return
     * @return A string containing the check-in and check-out dates
     */
    public static String calculateHotelDates(LocalDate departureDate, LocalDate returnDate) {
        // Step 4: Calculate hotel dates:
        // - Check-in is usually the same day as departure
        // - Check-out is usually the same day as return
        // Hint: Format the dates using the formatter declared in Step 1
        String checkInDate = DATE_FORMATTER.format(departureDate);
        String checkOutDate = DATE_FORMATTER.format(returnDate);

        return checkInDate + " - " + checkOutDate; // Replace with actual calculation
    }

    /**
     * Checks if a trip overlaps with a specific holiday
     *
     * @param departureDate The date of departure
     * @param returnDate    The date of return
     * @param holidayDate   The date of the holiday
     * @return true if the trip overlaps with the holiday, false otherwise
     */
    public static boolean tripOverlapsHoliday(LocalDate departureDate, LocalDate returnDate, LocalDate holidayDate) {
        // Step 5: Check if the holiday date falls between departure and return dates
        // Hint: Use isAfter() and isBefore() methods or similar
        if (holidayDate.isAfter(departureDate) && holidayDate.isBefore(returnDate)) {
            return true;
        } else return holidayDate.isEqual(departureDate) || holidayDate.isEqual(returnDate);// Replace with actual check
    }

    public static void displayMenu() {
        System.out.println("\nTravel Planner Menu");
        System.out.println("1. Insira data de partida e retorno");
        System.out.println("2. Calcular duração da viagem");
        System.out.println("3. Validar datas de viagem");
        System.out.println("4. Calcular datas de check-in e check-out");
        System.out.println("5. Verificar se a viagem se sobrepõe aos feriados");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
    }

    /**
     * Main method to run the TravelPlanner application
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Step 6: Implement a menu-driven interface allowing the user to:
        // - Enter departure and return dates
        // - Calculate trip duration
        // - Validate travel dates
        // - Calculate hotel check-in and check-out dates
        // - Check if trip overlaps with holidays
        LocalDate departureDate = null;
        LocalDate returnDate = null;

        System.out.println("Bem-vindo ao Travel Planner!");

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Digite a data de partida (dd/MM/yyyy): ");
                    String departureDateString = scanner.nextLine();
                    System.out.println("Digite a data de retorno (dd/MM/yyyy): ");
                    String returnDateString = scanner.nextLine();
                    try {
                        departureDate = LocalDate.parse(departureDateString, DATE_FORMATTER);
                        returnDate = LocalDate.parse(returnDateString, DATE_FORMATTER);
                        System.out.println("Data inserida!");
                    } catch (DateTimeParseException e) {
                        System.out.println("Data inválida. Por favor, use o formato dd/MM/yyyy.");
                    }
                    break;

                case 2:
                    if (departureDate != null && returnDate != null) {
                        try {
                            long duration = calculateTripDuration(departureDate, returnDate);
                            System.out.println("Duração da viagem: " + duration + " dias.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Por favor, insira as datas de partida e de retorno.");
                    }
                    break;

                case 3:
                    if (departureDate != null && returnDate != null) {
                        boolean isValid = validateTravelDates(departureDate, returnDate);
                        System.out.println("Datas são válidas: " + (isValid ? "Sim" : "Não"));
                    } else {
                        System.out.println("Por favor, insira as datas de partida e de retorno.");
                    }
                    break;
                case 4:
                    if (departureDate != null && returnDate != null) {
                        String hotelDates = calculateHotelDates(departureDate, returnDate);
                        System.out.println("Datas de check-in e check-out: " + hotelDates);
                    } else {
                        System.out.println("Por favor, insira as datas de partida e de retorno.");
                    }
                    break;
                case 5:
                    if (departureDate != null && returnDate != null) {
                        System.out.println("Digite a data do feriado (dd/MM/yyyy): ");
                        String holidayStr = scanner.nextLine();
                        try {
                            LocalDate holidayDate = LocalDate.parse(holidayStr, DATE_FORMATTER);
                            boolean overlaps = tripOverlapsHoliday(departureDate, returnDate, holidayDate);
                            System.out.println("A viagem se sobrepõe ao feriado: " + (overlaps ? "Sim." : "Não."));
                        } catch (DateTimeParseException e) {
                            System.out.println("Formato de data inválido. Use dd/MM/yyyy.");
                        }
                    } else {
                        System.out.println("Por favor, insira as datas de partida e de retorno.");
                    }
                    break;
                case 0:
                    System.out.println("Obrigado por usar o Travel Planner!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
            System.out.println();
        }
    }

}
