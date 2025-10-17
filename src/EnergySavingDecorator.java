import Abstract.Device;

public class EnergySavingDecorator extends DeviceDecorator{
    public EnergySavingDecorator(Device decorator){
        super(decorator);
        System.out.println("energy mode"+super.getName());
    }

    @Override
    public void turnOn() {
        System.out.println("energy mode is on");
        super.turnOn();
    }

    @Override
    public void turnOff() {
        if(isOn()){
            System.out.println("energysave is off");
        }
        super.turnOff();
    }

    @Override
    public void operate() {
        System.out.println("check status of device");
        super.operate();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
