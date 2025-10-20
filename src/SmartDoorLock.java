import Abstract.Device;
public class SmartDoorLock implements Device{
    private String name;
    private boolean locked=true;

    public SmartDoorLock(String name){
        this.name=name;
    }

    @Override
    public void turnOn() {
        locked=false;
        System.out.println(name+ " door is open");
    }

    @Override
    public void turnOff() {
        locked=true;
        System.out.println(name+" door is locked");
    }

    @Override
    public boolean isOn() {
        return !locked;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void operate() {
        if(locked){
            turnOn();
        }
        else{
            turnOff();
        }
    }
}
