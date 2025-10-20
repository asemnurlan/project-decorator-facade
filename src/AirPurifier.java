import Abstract.Device;

public class AirPurifier implements Device {
    private String name;
    private boolean power=false;
    private boolean ionizer=false;

    public AirPurifier(String name){
        this.name=name;
    }

    @Override
    public void turnOn() {
        power=true;
        System.out.println(name+" air purifier is on");
    }

    @Override
    public void turnOff() {
        power=false;
        ionizer=false;
        System.out.println(name+" air purifier is off");
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
        }
        else{
            if(ionizer==false){
                ionizer=true;
                System.out.println(name+ "ionizer mode is on");
            }
            else{
                ionizer=false;
                System.out.println(name+ "ionizer mode is off");
            }
        }
    }

    public void filterReminder(){
        System.out.println(name+" change air filter bro");
    }
}
