import Abstract.Device;

public class RemoteAccessDecorator extends DeviceDecorator{
    public RemoteAccessDecorator(Device decorator){
        super(decorator);
    }

    @Override
    public void turnOn() {
        System.out.println("Remote access: turn on");
        decorator.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Remote access: turn off");
        decorator.turnOff();
    }

    @Override
    public void operate() {
        System.out.println("Remote access: checking the connection");
        decorator.operate();
    }

    @Override
    public String getName() {
        return decorator.getName()+" Remote access";
    }
}
