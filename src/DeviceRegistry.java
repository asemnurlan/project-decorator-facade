public class DeviceRegistry {
    public Light kitchenLight;
    public MusicSystem kitchenAudio;
    public Thermostat kitchenThermostat;
    public SecurityCamera kitchenCamera;

    public DeviceRegistry(){
        kitchenLight=new Light("kitchen light");
        kitchenAudio=new MusicSystem("living room audio");
        kitchenThermostat=new Thermostat("kitchen thermostata");
        kitchenCamera = new SecurityCamera("kitchen camera");

        new VoiceControlDecorator(kitchenLight);
    }
}
