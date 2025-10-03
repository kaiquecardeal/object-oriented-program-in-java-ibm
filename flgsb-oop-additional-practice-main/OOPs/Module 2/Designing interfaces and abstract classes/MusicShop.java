/**
 * Music Shop - IBM OOP Java Course.
 *
 * @author Kaique D. Cardeal
 * @version 1.0
 */
// Step 1: Create an abstract class Instrument
// This should include:
// - private String name
// - protected int year (year of manufacture)
// - constructor that initializes both fields
// - abstract method play() that returns a String
// - concrete method getInstrumentDetails() that returns information about the instrument
abstract class Instrument {
    private String name;
    protected int year;

    public Instrument(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public abstract String play();

    public String getInstrumentDetails() {
        return "Instrumento: " + name + ", Ano: " + year;
    }
}

// Step 2: Create an interface Tunable
// This should include:
// - abstract method tune() that returns a String
// - abstract method adjustPitch(boolean up) that returns a String (up means increase pitch)
interface Tunable {
    String tune();
    String adjustPitch(boolean up);
}


// Step 3: Create an interface Maintainable
// This should include:
// - abstract method clean() that returns a String
// - abstract method inspect() that returns a String
interface Maintainable {
    String clean();
    String inspect();
}


// Step 4: Create a concrete class StringedInstrument that extends Instrument
// This should include:
// - private int numberOfStrings
// - constructor that initializes name, year, and numberOfStrings
// - implementation of the abstract play() method
// - override getInstrumentDetails() to include number of strings
class StringedInstrument extends Instrument {
    private int numberOfStrings;

    public StringedInstrument(String name, int year, int numberOfStrings) {
        super(name, year);
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public String play() {
        return "Instrumento cordado";
    }

    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Número de cordas: " + numberOfStrings;
    }
}

// Step 5: Create a concrete class Guitar that extends StringedInstrument 
// and implements Tunable and Maintainable
// This should include:
// - private String guitarType (acoustic, electric, etc.)
// - constructor that initializes all fields
// - implementation of all required interface methods
class Guitar extends StringedInstrument implements Tunable, Maintainable {
    private String guitarType;

    public Guitar(String name, int year, int numberOfStrings, String guitarType) {
        super(name, year, numberOfStrings);
        this.guitarType = guitarType;
    }

    @Override
    public String play() {
        return "Guitarra";
    }
    @Override
    public String tune() {
        return "Tunando guitarra";
    }
    @Override
    public String adjustPitch(boolean up) {
        return "Ajustando pitch da guitarra";
    }
    @Override
    public String clean() {
        return "Limpando guitarra";
    }
    @Override
    public String inspect() {
        return "Inspecionando guitarra";
    }
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Tipo: " + guitarType;
    }
}

// Step 6: Create a concrete class Piano that extends Instrument
// and implements Tunable and Maintainable
// This should include:
// - private boolean isGrand
// - constructor that initializes all fields
// - implementation of the abstract play() method
// - implementation of all required interface methods
class Piano extends Instrument implements Tunable, Maintainable {
    private boolean isGrand;

    public Piano(String name, int year, boolean isGrand) {
        super(name, year);
        this.isGrand = isGrand;
    }

    @Override
    public String play() {
        return "Piano";
    }
    @Override
    public String tune() {
        return "Tunando piano";
    }
    @Override
    public String adjustPitch(boolean up) {
        return "Ajustando pitch do piano";
    }
    @Override
    public String clean() {
        return "Limpando piano";
    }
    @Override
    public String inspect() {
        return "Inspecionando piano";
    }
    @Override
    public String getInstrumentDetails() {
        return super.getInstrumentDetails() + ", Grand: " + isGrand;
    }
}


// Step 7: Create a public class MusicShop to test the classes
// This should include:
// - main method that:
//   1. Creates an array of Instrument objects including Guitar and Piano instances
//   2. Iterates through the array calling play() for each instrument
//   3. Demonstrates polymorphism by testing if each instrument is Tunable or Maintainable
//      and if so, calls the appropriate methods
public class MusicShop {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[2];
        instruments[0] = new Guitar("Fender Stratocaster", 2020, 6, "Electric");
        instruments[1] = new Piano("Yamaha Grand", 2018, true);

        for (Instrument instrument : instruments) {
            System.out.println(instrument.getInstrumentDetails());
            System.out.println("Tocando: " + instrument.play());

            if (instrument instanceof Tunable) {
                Tunable tunable = (Tunable) instrument;
                System.out.println(tunable.tune());
                System.out.println(tunable.adjustPitch(true));
            }

            if (instrument instanceof Maintainable) {
                Maintainable maintainable = (Maintainable) instrument;
                System.out.println(maintainable.clean());
                System.out.println(maintainable.inspect());
            }

            System.out.println();
        }
    }
}
