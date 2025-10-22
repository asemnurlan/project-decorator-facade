import Abstract.Device;

public class EnergySavingDecorator extends DeviceDecorator{
    public EnergySavingDecorator(Device decorator){
        super(decorator);
    }

    @Override
    public void turnOn() {
        System.out.println("Energy saving mode: turn on");
        applyEnergySaving();
        decorator.turnOn();
    }

    @Override
    public void turnOff() {
        if(isOn()){
            System.out.println("Energy saving: turn off");
        }
        decorator.turnOff();
    }

    @Override
    public void operate() {
        System.out.println("Energy saving mode: check status of device");
        decorator.operate();
    }

    @Override
    public String getName() {
        return decorator.getName()+" energy save mode";
    }

    private void applyEnergySaving(){
        if (decorator instanceof Light light) {
            System.out.println("EnergySaving: reducing light brightness to 60%");
        }
        else if (decorator instanceof MusicSystem music) {
            System.out.println("EnergySaving: reducing music volume to 30%");
            music.setVolume(30);
        }
        else if (decorator instanceof Thermostat thermostat) {
            System.out.println("EnergySaving: Setting optimal temperature: 22°C");
            thermostat.setTemperature(22.0);
        }
        else if (decorator instanceof SecurityCamera) {
            System.out.println("EnergySaving: lowering camera frame rate for energy saving");
        }
        else if (decorator instanceof AirPurifier) {
            System.out.println("EnergySaving: switching purifier to silent eco mode");
        }
        else if (decorator instanceof SmartDoorLock) {
            System.out.println("EnergySaving: lock sensors in low-power standby mode");
        }
        else if (decorator instanceof SmartTV) {
            System.out.println("EnergySaving: dimming TV screen brightness to 50%");
        }
        else {
            System.out.println("EnergySaving: Generic energy optimization applied");
        }
    }
}
