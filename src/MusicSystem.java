import Abstract.Device;

public class MusicSystem implements Device {
    private String name;
    private boolean power=false;
    private boolean playing=false;

    public MusicSystem(String name){
        this.name=name;
    }

    @Override
    public void turnOn() {
        power=true;
        System.out.println(name+"music system is turn on");
    }

    @Override
    public void turnOff() {
        power=false;
        playing=false;
        System.out.println(name+"music system is turn off");
    }

    @Override
    public boolean isOn() {
        return power;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setVolume(int volume){
        if(isOn()){
            System.out.println(getName()+" volume set to "+volume);
        } else{
            System.out.println(getName()+ " is off");
        }
    }

    @Override
    public void operate() {
        if(!isOn()){
            turnOn();
            playing=true;
            System.out.println(name+"music starts playing");
        } else if (playing) {
            playing=false;
            System.out.println(name+"music paused");
        }
        else {
            playing=true;
            System.out.println(name+"music is playing");
        }

    }
}
