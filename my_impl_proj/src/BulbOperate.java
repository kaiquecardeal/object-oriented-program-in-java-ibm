public class BulbOperate {
    public static void main(String[] args) {
        // Cria uma array para Objetos Switchable segurar diferentes tipos de bulbs
        Switchable switchable[] = new Switchable[3];

        // Cria instancias de SmartBulb, DimmableBulb e RegularBulb
        SmartBulb smartBulb = new SmartBulb();
        DimmableBulb dimmableBulb = new DimmableBulb();
        RegularBulb regularBulb = new RegularBulb();

        // Adiciona as instancias ao array de bulbs
        switchable[0] = smartBulb;
        switchable[1] = dimmableBulb;
        switchable[2] = regularBulb;

        // Loop para ligar e desligar cada bulb no array
        for (Switchable bulb : switchable) {
            bulb.turnOn();
            bulb.turnOff();
        }


        // Ajusta a luminosidade do SmartBulb
        smartBulb.increase();

        // Ajusta a luminosidade do DimmableBulb
        ((Adjustable) switchable[1]).decrease();

        // Conecta o SmartBulb à internet
        ((Connectable) switchable[0]).connect();
    }
}
