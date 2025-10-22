import java.util.*;
import Abstract.Device;

public final class HomeAutomationFacade {

    private final Map<String, Device> devices = new LinkedHashMap<>();

    public HomeAutomationFacade() { }

    public HomeAutomationFacade(Collection<Device> initial) {
        if (initial != null) {
            for (Device d : initial) addDevice(d);
        }
    }

    public void addDevice(Device d) {
        if (d == null || d.getName() == null || d.getName().isBlank()) return;
        devices.put(d.getName(), d);
    }

    public boolean removeDevice(String name) { return devices.remove(name) != null; }

    public Device get(String name) { return devices.get(name); }

    public Collection<Device> listDevices() {
        return Collections.unmodifiableCollection(devices.values());
    }

    public void activateNightMode() {
        System.out.println("\n--- Night mode ---");
        for (Device d : devices.values()) {
            Object core = coreOf(d);

            if (core instanceof Light) {
                d.turnOff();

            } else if (core instanceof Thermostat) {
                Thermostat th = (Thermostat) core;
                safeSetTemp(th, 22.0);
                d.turnOn();

            } else if (core instanceof SecurityCamera) {
                d.turnOn();
                d.operate();

            } else if (core instanceof SmartDoorLock) {
                d.turnOff();

            } else if (core instanceof AirPurifier) {
                d.turnOn();

            } else {
                d.turnOff();
            }
        }
        System.out.println("Night Mode: done.");
    }

    public void startPartyMode() {
        System.out.println("\n--- Start Party Mode ---");
        for (Device d : devices.values()) {
            Object core = coreOf(d);

            if (core instanceof Light) {
                System.out.println(d.getName() + " : spec effects");
                d.turnOn();

            } else if (core instanceof MusicSystem) {
                MusicSystem m = (MusicSystem) core;
                d.turnOn();
                safeSetVolume(m, 80);
                d.operate();

            } else if (core instanceof SmartTV) {
                SmartTV tv = (SmartTV) core;
                d.turnOn();
                safeSetTvVolume(tv, 50);

            } else if (core instanceof SecurityCamera) {
                d.turnOff();

            } else if (core instanceof AirPurifier) {
                d.turnOn();

            } else if (core instanceof Thermostat) {
                Thermostat th = (Thermostat) core;
                safeSetTemp(th, 23.0);
                d.turnOn();

            } else if (core instanceof SmartDoorLock) {
            }
        }
        System.out.println("Party Mode: done.");
    }

    public void leaveHome() {
        System.out.println("--- Leave Home ---");
        for (Device d : devices.values()) d.turnOff();

        for (Device d : devices.values()) {
            Object core = coreOf(d);
            if (core instanceof SecurityCamera) {
                d.turnOn();
                d.operate();
            } else if (core instanceof SmartDoorLock) {
                d.turnOff();
            }
        }
        System.out.println("Leave Home: done.");
    }


    public void cleaningMode() {
        System.out.println("\n--- Cleaning Mode ---");
        for (Device d : devices.values()) {
            Object core = coreOf(d);

            if (core instanceof Light) {
                d.turnOn();

            } else if (core instanceof MusicSystem) {
                MusicSystem m = (MusicSystem) core;
                d.turnOn();
                safeSetVolume(m, 65);
                d.operate();

            } else if (core instanceof AirPurifier) {
                d.turnOn();

            } else if (core instanceof SmartTV || core instanceof SecurityCamera) {
                d.turnOff();

            } else if (core instanceof Thermostat) {
                d.turnOn();
            }
        }
        System.out.println("Cleaning Mode: done.");
    }

    public void vacationMode() {
        System.out.println("--- Vacation Mode ---");
        for (Device d : devices.values()) d.turnOff();

        for (Device d : devices.values()) {
            Object core = coreOf(d);

            if (core instanceof SecurityCamera) {
                d.turnOn();
                d.operate();

            } else if (core instanceof SmartDoorLock) {
                d.turnOff();

            } else if (core instanceof Thermostat) {
                Thermostat th = (Thermostat) core;
                safeSetTemp(th, 18.0);
                d.turnOn();
            }
        }
        System.out.println("Vacation Mode: done.");
    }

    public void securityAlert() {
        System.out.println("--- Security Alert ---");
        for (Device d : devices.values()) {
            Object core = coreOf(d);

            if (core instanceof Light) {
                d.turnOn();

            } else if (core instanceof SecurityCamera) {
                d.turnOn();
                d.operate();

            } else if (core instanceof SmartDoorLock) {
                d.turnOff();

            } else {
                d.turnOff();
            }
        }
        System.out.println("Security Alert: done.");
    }

    public void printStatus() {
        System.out.println("--- Devices status ---");
        for (Device d : devices.values()) {
            Object core = coreOf(d);
            System.out.println(" • " + d.getName() + " : " + (d.isOn() ? "ON" : "OFF")
                    + " [" + core.getClass().getSimpleName() + "]");
        }
    }



    private Object coreOf(Device d) {
        Device cur = d;
        while (cur instanceof DeviceDecorator) {
            cur = ((DeviceDecorator) cur).decorator;
        }
        return cur;
    }

    private void safeSetVolume(MusicSystem ms, int vol) {
        try { ms.setVolume(vol); } catch (Throwable ignored) {}
    }
    private void safeSetTvVolume(SmartTV tv, int vol) {
        try { tv.setVolume(vol); } catch (Throwable ignored) {}
    }
    private void safeSetTemp(Thermostat th, double t) {
        try { th.setTemperature(t); } catch (Throwable ignored) {}
    }
}




















/*import java.util.*;
import Abstract.Device;

public final class HomeAutomationFacade {


    private final Map<String, Device> devices = new LinkedHashMap<>();

    public HomeAutomationFacade() {
    }

    public HomeAutomationFacade(Collection<Device> initial) {
        if (initial != null) {
            for(Device d : initial) addDevice(d);
        }
    }

    public void addDevice(Device d) {
        if (d == null || d.getName() == null || d.getName().isBlank()) return;
        devices.put(d.getName(), d);
    }

    public boolean removeDevice(String name) {
        return devices.remove(name) != null;
    }

    public Device get(String name) {
        return devices.get(name);
    }

    public Collection<Device> listDevices() {
        return Collections.unmodifiableCollection(devices.values());
    }


    public void activateNightMode() {
        System.out.println("---Night mode---");
        for (Device d : devices.values()) {
            Object core = coreOf(d);
        }
        if (core instanceof SecurityCamera) {
            d.turnOn();
            d.operate();
        } else if (core instanceof Thermostat) {
            d.turnOn();
            d.setTemperature();
        } else if (core instanceof SmartDoorLock) {
            d.turnOff();
        } else if (core instanceof AirPurifier) {
            d.operate();
            d.turnOn();
        } else {
            d.turnOff();
        }
    }

    public void startPartyMode() {
        System.out.println("---Start Party Mode---");
        for (Device d : devices.values()) {
            Object core = coreOf(d);
        }
        if (core instanceof Light) {
            System.out.println(d.getName() + "spec effects+");
            d.turnOn();
        } else if (core instanceof MusicSystem m) {
            d.turnOn();
            d.setVolume(m, 80);
            d.operate();
        } else if (core instanceof SmartTV) {
            d.turnOn();
            d.setVolume(50);
        } else if (core instanceof SecurityCamera) {
            d.turnOn();
        } else if (core instanceof AirPurifier) {
            d.turnOn();
        } else if (core instanceof Thermostat) {
            d.turnOn();
            d.setTemperature(18.0);
        }
        System.out.println("---party mode is on");
    }

    public void leaveHome() {
        System.out.println("---Leave Home---");
        for (Device d : devices.values()) {
            Object core = coreOf(d);
            if (core instanceof SecurityCamera) {
                d.turnOn();
                d.operate();
            } else if (core instanceof SmartDoorLock) {
                d.turnOff();
            } else {
                d.turnOff();
            }
        }
        System.out.println("Leave Home: done.");
    }


    public void cleaningMode() {
        System.out.println("---cleaning Mode---");
        for (Device d : devices.values()) {
            Object core = coreOf(d);
            if (core instanceof Light) {
                d.turnOn();
            } else if (core instanceof MusicSystem) {
                d.turnOn();
                d.operate();
            } else if (core instanceof AirPurifier) {
                d.turnOn();
            } else if (core instanceof SmartTV || core instanceof SecurityCamera) {
                d.turnOff();
            } else if (core instanceof Thermostat) {
                d.turnOn();
            }
        }
        System.out.println("Cleaning Mode: done.");
    }
    public void vacationMode() {
        System.out.println("---Vacation Mode---");
        devices.values().forEach(Device::turnOff);
        for (Device d : devices.values()) {
            Object core = coreOf(d);
            if (core instanceof SecurityCamera) {
                d.turnOn();
                d.operate();
            } else if (core instanceof SmartDoorLock) {
                d.turnOff();
            } else if (core instanceof Thermostat th) {
                d.turnOn();
            }
        }
        System.out.println("Vacation Mode: done.");
    }

    public void securityAlert() {
        System.out.println("---Security Alert---");
        for (Device d : devices.values()) {
            Object core = coreOf(d);
            if (core instanceof Light) {
                d.turnOn();
            } else if (core instanceof SecurityCamera) {
                d.turnOn();
                d.operate();
            } else {
                d.turnOff();
            }
        }
        System.out.println("Security Alert: done.");
    }

    public void printStatus() {
        System.out.println("\n--- Devices status ---");
        for (Device d : devices.values()) {
            System.out.println(d.getName() + " : " + (d.isOn() ? "ON" : "OFF")
                    + " [" + coreOf(d).getClass().getSimpleName() + "]");
        }
    }

    private Object coreOf(Device d) {
        Device cur = d;
        while (cur instanceof DeviceDecorator dd) {
            cur = dd.decorator;
        }
        return cur;
    }
}*/