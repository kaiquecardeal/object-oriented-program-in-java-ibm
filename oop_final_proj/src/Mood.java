import java.time.LocalDate;
import java.time.LocalTime;

public class Mood {

    public String name;
    public String notes;
    public LocalDate date;
    public LocalTime time;

    public Mood(String name) {
        this.name = name;
    }

    public Mood(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public Mood(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Mood(String name, String notes) {
        this.name = name;
        this.notes = notes;
    }

    public Mood(String name, String notes, LocalDate date) {
        this.name = name;
        this.notes = notes;
        this.date = date;
    }

    public Mood(String name, String notes, LocalDate date, LocalTime time) {
        this.name = name;
        this.notes = notes;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String toString() {
        return name + " - " + date + " " + time + "\n" + notes;
    }

    public boolean equals(Mood mood) {
        if (mood.name.equals(this.name) && mood.date.equals(this.date) && mood.time.equals(this.time)) {
            return true;
        } else {
            return false;
        }
    }

}
