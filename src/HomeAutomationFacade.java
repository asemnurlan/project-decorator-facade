public class HomeAutomationFacade {
    private Light light;
    private MusicSystem musicSystem;
    private Thermostat thermostat;
    private SecurityCamera camera;

    public HomeAutomationFacade(DeviceRegistry registry){
        this.light=registry.kitchenLight;
        this.musicSystem=registry.kitchenAudio;
        this.thermostat=registry.kitchenThermostat;
        this.camera=registry.kitchenCamera;
    }

    public void activateNightMode() {
        System.out.println("night mode");
        light.turnOff();

        thermostat.turnOff();
        System.out.println("eco regime ");

        camera.turnOn();
        camera.operate();

        System.out.println("night mode is activated");
    }

    public void startPartyMode() {
        System.out.println("party mode");

        light.turnOn();
        System.out.println("light with speceffects");

        musicSystem.turnOn();
        musicSystem.operate();
        System.out.println("music is loud");

        camera.turnOff();

        System.out.println("party mode is activated");
    }

    public void leaveHome() {
        System.out.println("leave home");

        light.turnOff();
        musicSystem.turnOff();
        thermostat.turnOff();

        camera.turnOn();
        camera.operate();
        System.out.println("Security mode is active");

        System.out.println("everything is turn off, home is safe");
    }
}
