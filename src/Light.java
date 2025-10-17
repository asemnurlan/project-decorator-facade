import Abstract.Device;

public class Light implements Device {
    private String name;
    private boolean power=false;

    public Light(String name){
        this.name=name;
    }

    @Override
    public void turnOn() {
        power=true;
        System.out.println(name+"light is turn on");
    }

    @Override
    public void turnOff() {
        power=false;
        System.out.println(name+"Light is turn off");
    }

    @Override
    public boolean isOn() {
        return power;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void operate() {
        if (isOn()){
            turnOff();
        }
        else {
            turnOn();
        }
    }
}
