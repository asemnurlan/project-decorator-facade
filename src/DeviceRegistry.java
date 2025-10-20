import Abstract.Device;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class DeviceRegistry {
    private final Map<String,Device> devices=new HashMap<>();
    public final Device light;
    public final Device audio;
    public final Device camera;
    public final Device thermostat;

    public DeviceRegistry(){
        Light baseLight=new Light("house light");
        MusicSystem baseMusic=new MusicSystem("house music");
        SecurityCamera baseCamera=new SecurityCamera("house camera");
        Thermostat baseThermostat=new Thermostat("house thermostat");

        Device decoratedLight=new VoiceControlDecorator(new EnergySavingDecorator(baseLight));
        Device decoratedAudio=new RemoteAccessDecorator(new EnergySavingDecorator(baseMusic));
        Device decoratedCamera=new RemoteAccessDecorator(baseCamera);
        Device
    }
}