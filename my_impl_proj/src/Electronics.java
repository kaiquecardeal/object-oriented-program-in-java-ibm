//Programa pratico - OOP
interface Volume {
    void increaseVol();

    void decreaseVol();
}

interface Switchable1 {
    void turnOn();

    void turnOff();
}

interface Connectable1 {
    void connect();

    void disconnect();
}

interface Adjustable1 {
    void increaseSpeed();

    void decreaseSpeed();
}


class SmartSpeaker implements Switchable, Connectable, Volume {
    @Override
    public void turnOn() {
        System.out.println("SmartSpeaker is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("SmartSpeaker is turned off.");
    }

    @Override
    public void connect() {
        System.out.println("SmartSpeaker is connected.");
    }

    @Override
    public void disconnect() {
        System.out.println("SmartSpeaker is disconnected.");
    }

    @Override
    public void increaseVol() {
        System.out.println("SmartSpeaker volume increased.");
    }

    @Override
    public void decreaseVol() {
        System.out.println("SmartSpeaker volume decreased.");
    }
}

class Fan implements Switchable1, Adjustable1 {
    @Override
    public void turnOn() {
        System.out.println("Fan is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is turned off.");
    }

    @Override
    public void increaseSpeed() {
        System.out.println("Fan speed increased.");
    }

    @Override
    public void decreaseSpeed() {
        System.out.println("Fan speed decreased.");
    }
}

public class Electronics {
    public static void main(String[] args) {

        //Demonstrate polymorphism
        Switchable speaker1 = new SmartSpeaker();
        Switchable fan1 = new Switchable() {
            @Override
            public void turnOn() {

            }

            @Override
            public void turnOff() {

            }
        };

        speaker1.turnOn();
        speaker1.turnOff();
        fan1.turnOn();
        fan1.turnOff();

        //Multiple inheritance through interfaces
        SmartSpeaker smartSpeaker = new SmartSpeaker();
        // Using SmartSpeaker methods
        smartSpeaker.turnOn();
        smartSpeaker.connect();
        smartSpeaker.increaseVol();
        smartSpeaker.decreaseVol();
        smartSpeaker.disconnect();
        smartSpeaker.turnOff();

        //Multiple inheritance through interfaces
        Fan fan = new Fan();
        // Using Fan methods
        fan.turnOn();
        fan.increaseSpeed();
        fan.decreaseSpeed();
        fan.turnOff();
    }
}