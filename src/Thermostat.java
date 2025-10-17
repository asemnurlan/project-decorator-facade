import Abstract.Device;

public class Thermostat implements Device {
    private String name;
    private boolean power=false;
    private double temp=18.0;

    public Thermostat(String name){
        this.name=name;
    }

    @Override
    public void turnOn() {
        power=true;
        System.out.println(name+"thermostat is turn on. current temperature is "+temp);
    }

    @Override
    public void turnOff() {
        power=false;
        System.out.println(name+"is turn off");
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
            temp+=1.0;
            System.out.println(name+"temperatur is increased. noe current temp is "+temp);
        }
        else{
            turnOn();
        }
    }
    public void setTemperature(double tem){
        this.temp=tem;
        System.out.println(tem+" temperature set");
    }
}
