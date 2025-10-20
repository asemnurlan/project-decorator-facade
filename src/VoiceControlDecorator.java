import Abstract.Device;

public class VoiceControlDecorator extends DeviceDecorator{
    public VoiceControlDecorator(Device decorator){
        super(decorator);
    }
    public void voice(String command){
        if (command==null) return;
        
    }

    @Override
    public void turnOn() {
        System.out.println("Voice control: turn on");
        decorator.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println(("Voice control: turn off"));
        decorator.turnOff();
    }

    @Override
    public void operate() {
        System.out.println("Voice control: operate");
        decorator.operate();
    }

    @Override
    public boolean isOn() {
        boolean status = decorator.isOn();
        System.out.println("Voice control: status check: "+(status ? "on" : "off"));
        return status;
    }

    @Override
    public String getName() {
        return decorator.getName()+" Voice Control";
    }
}
