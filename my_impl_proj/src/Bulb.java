// Interface para dispositivos que podem ser ligados e desligados
interface Switchable {
    void turnOn();

    void turnOff();
}

// Interface para dispositivos com ajuste de opções
interface Adjustable {
    void increase();

    void decrease();
}

// Interface para dispositivos que podem conectar-se a internet.
interface Connectable {
    void connect();

    void disconnect();
}

// SmartBulb class implementará todas as interfaces.
class SmartBulb implements Switchable, Adjustable, Connectable {
    private boolean isOn = false;
    private int brightness = 0;
    private boolean isConnected = false;

    // Métodos Switchable para ligar e desligar o SmartBulb.
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("SmartBulb está Ligado!");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("SmartBulb está Desligado!");
    }

    // Métodos adjustable para ajustar a luminosidade do SmartBulb.
    @Override
    public void increase() {
        if (brightness < 100) {
            brightness += 10;
            System.out.println("Luminosidade aumentada para: " + brightness + "%");
        } else {
            System.out.println("Luminosidade já está no máximo!");
        }
    }

    @Override
    public void decrease() {
        if (brightness > 0) {
            brightness -= 10;
            System.out.println("Luminosidade diminuída para: " + brightness + "%");
        } else {
            System.out.println("Luminosidade já está no mínimo!");
        }
    }

    // Métodos Connectable para informar se o SmartBulb está conectado na internet.
    @Override
    public void connect() {
        isConnected = true;
        System.out.println("SmartBulb conectado à internet!");
    }

    @Override
    public void disconnect() {
        isConnected = false;
        System.out.println("SmartBulb desconectado da internet!");
    }
}

// Classe DimmableBulb implementando duas interfaces
class DimmableBulb implements Switchable, Adjustable {
    private boolean isOn = false;
    private int brightness = 0;

    // Métodos Switchable para ligar e desligar o DimmableBulb.
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("DimmableBulb está Ligado!");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("DimmableBulb está Desligado!");
    }

    // Métodos adjustable para ajustar a luminosidade do DimmableBulb.
    @Override
    public void increase() {
        if (brightness < 100) {
            brightness += 10;
            System.out.println("DimmableBulb aumentada para: " + brightness + "%");
        } else {
            System.out.println("Luminosidade já está no máximo!");
        }
    }

    @Override
    public void decrease() {
        if (brightness > 0) {
            brightness -= 10;
            System.out.println("Luminosidade diminuída para: " + brightness + "%");
        } else {
            System.out.println("Luminosidade já está no mínimo!");
        }
    }
}

// RegularBulb implementara apenas a interface Switchable.
class RegularBulb implements Switchable {
    private boolean isOn = false;

    // Métodos Switchable para ligar e desligar o RegularBulb.
    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("RegularBulb está Ligado!");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("RegularBulb está Desligado!");
    }
}