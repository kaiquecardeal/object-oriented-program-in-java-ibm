import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MoodTracker {
    public static void displayMenu() {
        System.out.println("Digite 'a' para adicionar mood");
        System.out.println("'d' para deletar moods");
        System.out.println("'e' para editar moods");
        System.out.println("'s' para procurar moods");
        System.out.println("'M' para mostrar todos os moods");
        System.out.println("'w' para escrever moods em arquivo");
        System.out.println("'sair' para sair");
    }

    public static void displayDeleteMenu() {
        System.out.println("Digite '1' para deletar mood por data ");
        System.out.println("Digite '2' para deletar mood específico ");
        System.out.println("Digite '3' para voltar ao menu principal. ");
    }

    public static void displaySearchMenu() {
        System.out.println("Digite '1' para procurar todos os moods por data");
        System.out.println("Digite '2' para procurar um mood especifico.");
    }

    public static boolean isMoodValid(Mood mood, ArrayList<Mood> moodsList) throws InvalidMoodException {
        for (Mood tempMood : moodsList) {
            if (tempMood.equals(mood)) {
                throw new InvalidMoodException("Mood já existe na lista.");
            }
        }
        return true;
    }

    public static boolean deleteMoodsByDate(LocalDate moodDate, ArrayList<Mood> moodsList) {
        boolean removed = false;
        Iterator<Mood> iterator = moodsList.iterator();
        while (iterator.hasNext()) {
            Mood tempMood = iterator.next();
            if (tempMood.getDate().equals(moodDate)) {
                iterator.remove();
                removed = true;
            }
        }
        return removed;
    }

    public static boolean deleteMood(Mood mood, ArrayList<Mood> moodsList) {
        Iterator<Mood> iterator = moodsList.iterator();
        while (iterator.hasNext()) {
            Mood tempMood = iterator.next();
            if (tempMood.equals(mood)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public static boolean editMood(Mood moodToEdit, ArrayList<Mood> moodsList) {
        for (Mood tempMood : moodsList) {
            if (tempMood.equals(moodToEdit)) {
                tempMood.setNotes(moodToEdit.getNotes());
                return true;
            }
        }
        return false;
    }

    public static void searchMoodsByDate(LocalDate moodDate, ArrayList<Mood> moodsList) {
        boolean found = false;
        for (Mood tempMood : moodsList) {
            if (tempMood.getDate().equals(moodDate)) {
                found = true;
                System.out.println(tempMood);
            }
        }
        if (!found) {
            System.out.println("Nenhum mood foi encontrado.");
        }
    }

    public static void searchMood(Mood mood, ArrayList<Mood> moodsList) {
        boolean found = false;
        for (Mood tempMood : moodsList) {
            if (tempMood.equals(mood)) {
                found = true;
                System.out.println(tempMood);
            }
        }
        if (!found) {
            System.out.println("Nenhum mood foi encontrado.");
        }
    }

    public static void main(String[] args) {
        ArrayList<Mood> moods = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            String menuOption = scanner.nextLine();
            switch (menuOption) {
                case "a":
                    System.out.println("Digite o nome do mood:");
                    String moodName = scanner.nextLine();
                    System.out.println("Você está monitorando um mood de um dia atual? (s/n)");
                    String isForCurrentDate = scanner.nextLine();
                    Mood moodToAdd = null;
                    if (isForCurrentDate.equalsIgnoreCase("n")) {
                        try {
                            System.out.println("Digite a data do mood no formato dd/MM/yyyy:");
                            String moodDateStr = scanner.nextLine();
                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                            System.out.println("Digite a hora do mood no formato HH:mm:");
                            String moodTimeStr = scanner.nextLine();
                            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                            LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
                            System.out.println("Adicione notas ao mood (opcional):");
                            String moodNotes = scanner.nextLine();
                            if (moodNotes.strip().equalsIgnoreCase("")) {
                                moodToAdd = new Mood(moodName, moodDate, moodTime);
                            } else {
                                moodToAdd = new Mood(moodName, moodNotes, moodDate, moodTime);
                            }
                        } catch (DateTimeParseException dfe) {
                            System.out.println("Formato incorreto. Tente novamente.");
                            continue;
                        }
                    } else {
                        System.out.println("Adicione notas ao mood (opcional):");
                        String moodNotes = scanner.nextLine();
                        if (moodNotes.strip().equalsIgnoreCase("")) {
                            moodToAdd = new Mood(moodName);
                        } else {
                            moodToAdd = new Mood(moodName, moodNotes);
                        }
                    }
                    try {
                        if (isMoodValid(moodToAdd, moods)) {
                            moods.add(moodToAdd);
                            System.out.println("Mood adicionado com sucesso!");
                            continue;
                        }
                    } catch (InvalidMoodException ime) {
                        System.out.println("O mood não é valido");
                    }
                    continue;
                case "d":
                    displayDeleteMenu();
                    String deleteOption = scanner.nextLine();
                    if (deleteOption.equals("1")) {
                        try {
                            System.out.println("Digite a data em formato dd/MM/yyyy:");
                            String moodDateStr = scanner.nextLine();
                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                            boolean areMoodsDeleted = deleteMoodsByDate(moodDate, moods);
                            if (areMoodsDeleted) {
                                System.out.println("Moods removidos com sucesso!");
                            } else {
                                System.out.println("Nenhum mood foi encontrado.");
                            }
                        } catch (DateTimeParseException nfe) {
                            System.out.println("Formato de data inválido. Tente novamente.");
                            continue;
                        }
                    } else if (deleteOption.equals("2")) {
                        try {
                            System.out.println("Digite o nome do mood:");
                            String moodNameToDelete = scanner.nextLine();
                            System.out.println("Digite a data do mood no formato dd/MM/yyyy:");
                            String moodDateStr = scanner.nextLine();
                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                            System.out.println("Digite a hora do mood no formato HH:mm:");
                            String moodTimeStr = scanner.nextLine();
                            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                            LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
                            Mood moodToDelete = new Mood(moodNameToDelete, moodDate, moodTime);
                            boolean isMoodDeleted = deleteMood(moodToDelete, moods);
                            if (isMoodDeleted) {
                                System.out.println("Mood removido com sucesso!");
                            } else {
                                System.out.println("Nenhum mood foi encontrado.");
                            }
                        } catch (DateTimeParseException nfe) {
                            System.out.println("Formato de data ou hora inválido. Tente novamente.");
                            continue;
                        }
                    }
                    continue;
                case "e":
                    Mood moodToEdit = null;
                    try {
                        System.out.println("Digite o nome do mood:");
                        moodName = scanner.nextLine();
                        System.out.println("Digite a data do mood no formato dd/MM/yyyy:");
                        String moodDateStr = scanner.nextLine();
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                        System.out.println("Digite a hora do mood no formato HH:mm:");
                        String moodTimeStr = scanner.nextLine();
                        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                        LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
                        System.out.println("Adicione notas ao mood (opcional):");
                        String moodNotes = scanner.nextLine();
                        if (moodNotes.strip().equalsIgnoreCase("")) {
                            continue;
                        } else {
                            moodToEdit = new Mood(moodName, moodNotes, moodDate, moodTime);
                        }
                        boolean isMoodEdited = editMood(moodToEdit, moods);
                        if (isMoodEdited) {
                            System.out.println("Mood editado com sucesso!");
                        } else {
                            System.out.println("Nenhum mood foi encontrado.");
                        }
                    } catch (DateTimeParseException dfe) {
                        System.out.println("Formato de data ou hora inválido. Tente novamente.");
                        continue;
                    }
                    continue;
                case "s":
                    displaySearchMenu();
                    String searchOption = scanner.nextLine();
                    if (searchOption.equals("1")) {
                        try {
                            System.out.println("Digite a data em formato dd/MM/yyyy:");
                            String moodDateStr = scanner.nextLine();
                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                            searchMoodsByDate(moodDate, moods);
                        } catch (DateTimeParseException dfe) {
                            System.out.println("Formato de data ou hora inválido. Tente novamente.");
                            continue;
                        }
                    } else if (searchOption.equals("2")) {
                        try {
                            System.out.println("Digite o nome do mood: ");
                            moodName = scanner.nextLine();
                            System.out.println("Digite a data do mood no formato dd/MM/yyyy:");
                            String moodDateStr = scanner.nextLine();
                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                            System.out.println("Digite a hora do mood no formato HH:mm:");
                            String moodTimeStr = scanner.nextLine();
                            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                            LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
                            Mood moodToSearch = new Mood(moodName, moodDate, moodTime);
                            searchMood(moodToSearch, moods);
                        } catch (DateTimeParseException dfe) {
                            System.out.println("Formato de data ou hora inválido. Tente novamente.");
                            continue;
                        }
                    }
                    continue;
                case "M":
                    for (Mood tempMood : moods) {
                        System.out.println(tempMood);
                    }
                    break;
                case "w":
                    try (PrintWriter writer = new PrintWriter(new FileWriter("moods.txt"))) {
                        for (Mood tempMood : moods) {
                            writer.println(tempMood);
                        }
                        System.out.println("Moods escritos em moods.txt com sucesso!");
                    } catch (IOException ioe) {
                        System.out.println("Erro ao escrever no arquivo. Tente novamente.");
                    }
                    continue;
                case "sair":
                    System.out.println("Obrigado por usar nosso programa!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

        }

    }
}
