public class Main {
    public static void main(String[] args) {
        DeviceRegistry reg = new DeviceRegistry();         // твой стартовый реестр
        HomeAutomationFacade f = new HomeAutomationFacade(reg);

        // динамическое добавление
        f.addLight("hall light");
        f.addMusicSystem("party audio");

        // управление по имени
        System.out.println(f.on("hall light"));
        System.out.println(f.toggle("party audio"));
        System.out.println(f.statusAll());

        // удаление
        f.removeDevice("party audio");
        System.out.println(f.statusAll());

        // сцены
        f.activateNightMode();
        f.startPartyMode();
        f.leaveHome();

    }
}