import Abstract.Device;
public class DeviceDecorator implements Device {
    public Device decorator;

    public DeviceDecorator(Device decorator){
        this.decorator=decorator;
    }

    @Override
    public void turnOn() {
        decorator.turnOn();
    }

    @Override
    public void turnOff() {
        decorator.turnOff();
    }

    @Override
    public boolean isOn() {
        return decorator.isOn();
    }

    @Override
    public String getName() {
        return decorator.getName();
    }

    @Override
    public void operate() {
        decorator.operate();
    }
}