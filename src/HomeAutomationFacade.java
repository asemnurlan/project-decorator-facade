
import java.util.*;
import Abstract.Device;


public final class HomeAutomationFacade {


    private final Map<String, Device> devices = new LinkedHashMap<>();

    public HomeAutomationFacade() { }

    public HomeAutomationFacade(DeviceRegistry registry) {
        if (registry != null) {
            addIfNotNull(registry.kitchenLight);
            addIfNotNull(registry.kitchenAudio);
            addIfNotNull(registry.kitchenThermostat);
            addIfNotNull(registry.kitchenCamera);
        }
    }


    public boolean addDevice(Device d) {
        if (d == null || d.getName() == null || d.getName().isBlank()) return false;
        devices.put(d.getName(), d);
        System.out.println("[facade] added: " + d.getName() + " (" + d.getClass().getSimpleName() + ")");
        return true;
    }

    public boolean removeDevice(String name) {
        if (name == null) return false;
        Device removed = devices.remove(name);
        if (removed != null) {
            System.out.println("[facade] removed: " + name);
            return true;
        }
        System.out.println("[facade] not found: " + name);
        return false;
    }

    public boolean contains(String name) { return devices.containsKey(name); }

    public Device get(String name) { return devices.get(name); }

    public Collection<Device> listDevices() { return Collections.unmodifiableCollection(devices.values()); }

    public List<String> listNames() { return new ArrayList<>(devices.keySet()); }



    public boolean addLight(String name)          { return addDevice(new Light(name)); }
    public boolean addMusicSystem(String name)    { return addDevice(new MusicSystem(name)); }
    public boolean addThermostat(String name)     { return addDevice(new Thermostat(name)); }
    public boolean addSecurityCamera(String name) { return addDevice(new SecurityCamera(name)); }



    public String on(String name)     { return doAndStatus(name, Device::turnOn); }
    public String off(String name)    { return doAndStatus(name, Device::turnOff); }
    public String toggle(String name) { return doAndStatus(name, Device::operate); }

    public String operate(String name) { return doAndStatus(name, Device::operate); }

    public String status(String name) {
        Device d = devices.get(name);
        if (d == null) return name + " : NOT FOUND";
        return name + " : " + (d.isOn() ? "ON" : "OFF");
    }

    public String statusAll() {
        if (devices.isEmpty()) return "[facade] no devices";
        StringBuilder sb = new StringBuilder("[facade] devices status:\n");
        for (Device d : devices.values()) {
            sb.append(" - ").append(d.getName())
                    .append(" [").append(d.getClass().getSimpleName()).append("] : ")
                    .append(d.isOn() ? "ON" : "OFF").append('\n');
        }
        return sb.toString();
    }

    public void allOn()  { devices.values().forEach(Device::turnOn);  }
    public void allOff() { devices.values().forEach(Device::turnOff); }



    public void activateNightMode() {
        System.out.println("[scene] night mode");
        for (Device d : devices.values()) {
            String n = d.getName().toLowerCase();
            if (n.contains("camera")) {
                d.turnOn();
                d.operate();
            } else {
                d.turnOff();
            }
        }
        System.out.println("[scene] night mode is activated");
    }


    public void startPartyMode() {
        System.out.println("[scene] party mode");
        for (Device d : devices.values()) {
            d.turnOn();
            if (d instanceof MusicSystem) d.operate(); // включить проигрывание
            if (d.getName().toLowerCase().contains("camera")) d.turnOff();
        }
        System.out.println("[scene] party mode is activated");
    }

    /** Уходим из дома: всё off, камеры on + запись */
    public void leaveHome() {
        System.out.println("[scene] leave home");
        for (Device d : devices.values()) {
            d.turnOff();
        }
        for (Device d : devices.values()) {
            if (d.getName().toLowerCase().contains("camera")) {
                d.turnOn();
                d.operate();
            }
        }
        System.out.println("[scene] everything is turned off, home is safe");
    }

    // ===== Внутренние помощники =====
    private void addIfNotNull(Device d) { if (d != null) addDevice(d); }

    private String doAndStatus(String name, java.util.function.Consumer<Device> action) {
        Device d = devices.get(name);
        if (d == null) return name + " : NOT FOUND";
        action.accept(d);
        return status(name);
    }
}



































    /*private Light light;
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
}*/
