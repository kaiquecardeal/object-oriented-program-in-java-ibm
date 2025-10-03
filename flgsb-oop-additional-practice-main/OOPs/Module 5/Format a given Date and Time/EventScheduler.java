/**
 * Lista de eventos - Controle de Viagens - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 */

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class EventScheduler {
    private List<Event> events;
    private Scanner scanner;

    public EventScheduler() {
        // Step 7: Initialize the events list and scanner
        events = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public static void displayMenu() {
        System.out.println("\nLista de eventos");
        System.out.println("1. Adiciona evento");
        System.out.println("2. Mostra eventos");
        System.out.println("3. Mostra o tempo até o evento");
        System.out.println("4. Converte evento para outra hora");
        System.out.println("5. Encontra eventos futuros");
        System.out.println("6. Sair");
        System.out.print("Escolha: ");

    }

    public void run() {
        boolean running = true;
        while (running) {
            // Step 8: Display menu options
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            // Step 9: Implement menu choices using switch-case
            switch (choice) {
                case 1:
                    // Call method to add event
                    addEvent();
                    break;
                case 2:
                    // Call method to display all events
                    displayAllEvents();
                    break;
                case 3:
                    // Call method to show time until event
                    showTimeUntilEvent();
                    break;
                case 4:
                    // Call method to convert event time
                    convertEventTime();
                    break;
                case 5:
                    // Call method to find upcoming events
                    findUpcomingEvents();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the Event Scheduler. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addEvent() {
        // Step 10: Implement method to get event details from user and create a new Event
        // Hint: Get name, date, time, duration, and timezone from user
        // Parse the date and time strings into LocalDateTime
        // Get a ZoneId from the timezone string
        // Create a ZonedDateTime from LocalDateTime and ZoneId
        // Create a Duration object from hours and minutes
        // Create a new Event object and add it to the events list
        try {

            System.out.println("Insira o nome do evento: ");
            String eventName = scanner.nextLine();
            System.out.println("Insira a data do evento (dd/MM/yyyy): ");
            String eventDate = scanner.nextLine();
            System.out.println("Insira a hora do evento (HH:mm): ");
            String eventTime = scanner.nextLine();
            System.out.println("Insira a duração do evento em horas: ");
            int durationHours = Integer.parseInt(scanner.nextLine());
            System.out.println("Insira a duração do evento em minutos: ");
            int durationMinutes = Integer.parseInt(scanner.nextLine());
            System.out.println("Insira o fuso horário do evento (ex: America/New_York): ");
            String timezone = scanner.nextLine();

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime eventDateTime = LocalDateTime.parse(eventDate + " " + eventTime, dateFormatter);

            ZoneId zoneId = ZoneId.of(timezone);
            ZonedDateTime eventZonedDateTime = ZonedDateTime.of(eventDateTime, zoneId);
            Duration duration = Duration.ofHours(durationHours).plusMinutes(durationMinutes);
            Event newEvent = new Event(eventName, eventZonedDateTime, duration);
            events.add(newEvent);

            System.out.println("Evento adicionado com sucesso!");
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data ou hora inválido. Por favor, tente novamente.");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar evento: " + e.getMessage());
        }
    }

    private void displayAllEvents() {
        // Step 11: Implement method to display all events
        // Hint: Get format pattern from user
        // Loop through events list and display each event with the specified format
        if (events.isEmpty()) {
            System.out.println("Nenhum evento para mostrar.");
            return;
        }
        System.out.println("Digite o padrão de data e hora (ex: dd/MM/yyyy HH:mm): ");
        String pattern = scanner.nextLine();

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            System.out.println("Eventos:");

            for (Event event : events) {
                String formattedDateTime = event.getDateTime().format(formatter);
                System.out.println("Nome: " + event.getName() + ", Data e Hora: " + formattedDateTime + ", Duração: " + event.getDuration().toHours() + " horas" + event.getDuration().toMinutesPart() + " minutos");
            }
        } catch (Exception e) {
            System.out.println("Formato inválido. Por favor, tente novamente.");
            DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            for (Event event : events) {
                String formattedDateTime = event.getDateTime().format(defaultFormatter);
                System.out.println("Nome: " + event.getName() + ", Data e Hora: " + formattedDateTime + ", Duração: " + event.getDuration().toHours() + " horas" + event.getDuration().toMinutesPart() + " minutos");
            }
        }

    }

    private void showTimeUntilEvent() {
        // Step 12: Implement method to calculate and display time until a specific event
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Calculate and display time until the selected event
        if (events.isEmpty()) {
            System.out.println("Nenhum evento para mostrar.");
            return;
        }

        System.out.println("Selecione o evento:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getName());
        }
        int eventSelection = Integer.parseInt(scanner.nextLine());
        Event selectedEvent = events.get(eventSelection - 1);
        long timeUntilEvent = selectedEvent.getTimeUntilEvent();
        System.out.println("Tempo restante até o evento: " + timeUntilEvent + " horas");
    }

    private void convertEventTime() {
        // Step 13: Implement method to convert event time to a different timezone
        // Hint: Show list of events with numbers
        // Get event selection from user
        // Get target timezone from user
        // Convert and display event time in the target timezone
        if (events.isEmpty()) {
            System.out.println("Nenhum evento para mostrar.");
            return;
        }

        System.out.println("Selecione o evento:");
        for (int i = 0; i < events.size(); i++) {
            System.out.println((i + 1) + ". " + events.get(i).getName());
        }
        int eventSelection = Integer.parseInt(scanner.nextLine());
        Event selectedEvent = events.get(eventSelection - 1);
        System.out.println("Insira o fuso horário alvo (ex: America/New_York): ");
        String targetTimezone = scanner.nextLine();
        ZonedDateTime convertedDateTime = selectedEvent.convertToTimezone(targetTimezone);
        System.out.println("Data e hora convertida: " + convertedDateTime);
    }

    private void findUpcomingEvents() {
        // Step 14: Implement method to find events within a specific number of days
        // Hint: Get number of days from user
        // Loop through events and display those within the specified days
        if (events.isEmpty()) {
            System.out.println("Nenhum evento para mostrar.");
            return;
        }

        System.out.println("Insira o número de dias para encontrar eventos futuros: ");
        int days = Integer.parseInt(scanner.nextLine());
        System.out.println("Eventos dentro dos próximos " + days + " dias:");
        for (Event event : events) {
            if (event.getTimeUntilEvent() <= days * 24) {
                System.out.println(event.getName());
            }
        }
    }

    public static void main(String[] args) {
        // Step 15: Create an EventScheduler object and call its run method
        EventScheduler scheduler = new EventScheduler();
        scheduler.run();
    }
}
