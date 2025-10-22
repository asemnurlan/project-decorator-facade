import java.util.List;
import java.util.ArrayList;
import Abstract.Device;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SMART HOME AUTOMATION SYSTEM ===");

        DeviceRegistry registry = new DeviceRegistry();

        HomeAutomationFacade facade = new HomeAutomationFacade(registry.list());
        System.out.println("Status");
        facade.printStatus();

        facade.startPartyMode();
        facade.printStatus();

        facade.activateNightMode();
        facade.printStatus();

        facade.leaveHome();
        facade.printStatus();


        Device oldSpeaker = new MusicSystemAdapter(new OldRadio("Retro JBL 1980"));
        registry.register(oldSpeaker);
        facade.addDevice(oldSpeaker);

        System.out.println("Added OldSpeaker (via Adapter)");
        facade.printStatus();

        facade.securityAlert();
        facade.printStatus();

        System.out.println("=== END OF DEMO ===");
    }
}