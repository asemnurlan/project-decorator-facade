import Abstract.Device;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DeviceRegistry {
    private final Map<String, Device> devices=new LinkedHashMap<>();
    public void register(Device device){
        if(device ==null||device.getName()==null || device.getName().isBlank()){
            System.out.println("cannot registry null device ");
            return;
        }
        devices.put(device.getName(),device);
        System.out.println("Registered: "+device.getName());
    }

    public boolean unregister(String name){
        if(devices.remove(name)!=null){
            System.out.println("registry removed: "+name);
            return true;
        }
        System.out.println("Registry not found: "+name);
        return false;
    }

    public Device get(String name){
        return devices.get(name);
    }

    public Collection<Device> list(){
        return Collections.unmodifiableCollection(devices.values());
    }

    public boolean contains(String name){
        return devices.containsKey(name);
    }

    public void printAll(){
        System.out.println("---Device Registry---");
        for (Device d : devices.values()){
            System.out.println(d.getName()+" ("+d.getClass().getSimpleName()+") --"+(d.isOn()?"ON":"OFF"));
        }
    }

    public static DeviceRegistry createDefault(){
        DeviceRegistry registry =new DeviceRegistry();

        Device light = new VoiceControlDecorator(new EnergySavingDecorator(new Light("Kitchen Light")));
        Device audio=new RemoteAccessDecorator(new RemoteAccessDecorator(new MusicSystem("Living room music")));
        Device camera=new RemoteAccessDecorator(new SecurityCamera("backyard camera"));
        Device thermostat=new Thermostat("home thermostat");
        Device door=new RemoteAccessDecorator(new SmartDoorLock("main door"));
        Device tv = new VoiceControlDecorator(new EnergySavingDecorator(new SmartTV("tv")));
        Device purifier=new RemoteAccessDecorator(new EnergySavingDecorator(new AirPurifier("main air purifier")));

        registry.register(light);
        registry.register(audio);
        registry.register(camera);
        registry.register(thermostat);
        registry.register(door);
        registry.register(tv);
        registry.register(purifier);

        return registry;
    }




}