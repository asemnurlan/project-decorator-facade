import Abstract.Device;
import java.time.LocalTime;


public class SchedulerDecorator extends DeviceDecorator{
    private final LocalTime onTime;
    private final LocalTime offTime;

    public SchedulerDecorator(Device decorator, LocalTime onTime, LocalTime offTime){
        super(decorator);
        this.onTime=onTime;
        this.offTime=offTime;
    }

    @Override
    public void turnOn() {
        LocalTime now=LocalTime.now();
        if (now.isAfter(onTime) && now.isBefore(offTime)){
            System.out.println(now+"-within schedule. turning on");
            decorator.turnOn();
        }else{
            System.out.println(now+"-outside of schedule. skip ");
        }
    }

    @Override
    public void turnOff() {
        System.out.println("turning off device");
        decorator.turnOff();
    }

    @Override
    public void operate() {
        System.out.println("checking schedule");
        decorator.operate();
    }

    @Override
    public String getName() {
        return decorator.getName()+" scheduled";
    }
}
