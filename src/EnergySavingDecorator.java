import Abstract.Device;

public class EnergySavingDecorator extends DeviceDecorator{
    public EnergySavingDecorator(Device decorator){
        super(decorator);
    }

    @Override
    public void turnOn() {
        System.out.println("energy saving mode: turn on");
        decorator.turnOn();
    }

    @Override
    public void turnOff() {
        if(isOn()){
            System.out.println("energy saving: turn off");
        }
        decorator.turnOff();
    }

    @Override
    public void operate() {
        System.out.println("check status of device");
        decorator.operate();
    }

    @Override
    public String getName() {
        return decorator.getName()+" energy save mode";
    }
}
