import Abstract.Device;

public class RemoteAccessDecorator extends DeviceDecorator{
    private boolean connected=false;
    private final String deviceId;

    public RemoteAccessDecorator(Device decorator){
        super(decorator);
        this.deviceId= decorator.getName().replaceAll("\\s+","_").toLowerCase();
    }

    public void connect(){
        if (!connected){
            System.out.println("Remote Access: ");
        }
        else{
            System.out.println("already connected");
        }
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
