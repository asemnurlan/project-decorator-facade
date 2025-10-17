import Abstract.Device;

public class SecurityCamera implements Device {
    private String name;
    private boolean power=false;
    private boolean recording=false;

    public SecurityCamera(String name){
        this.name=name;
    }

    @Override
    public void turnOn() {
        power=true;
        System.out.println(name+"camera is recording");
    }

    @Override
    public void turnOff() {
        power=false;
        recording=false;
        System.out.println(name+"camera is off");
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
        if (!isOn()){
            turnOn();
            recording=true;
            System.out.println(name+"camera starts recording");
        }
        else{
            recording=false;
            System.out.println(name+" stop recording");
        }

    }
}
