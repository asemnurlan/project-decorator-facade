import Abstract.Device;
public class SmartTV implements Device{
    private String name;
    private boolean power=false;
    private int channel=1;
    private int volume=1;
    public SmartTV(String name){
        this.name=name;
    }

    @Override
    public void turnOn() {
        power=true;
        channel=1;
        volume=5;
        System.out.println(name+" tv is on"+channel+" channel");
    }

    @Override
    public void turnOff() {
        power=false;
        System.out.println(name+ " tv is off");
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
            if(channel<5){
                channel++;
                System.out.println(name+" switched to "+channel+" channel");
            }
            else{
                channel=1;
                System.out.println(name+" channel 1");
            }
        }
    }

    public void setVolume(int newVolume){
        if(!isOn()){
            System.out.println(name+" tv is off bro");
        }
        else if (newVolume<0 || newVolume>100){
            System.out.println(name+" invalid condition");
        }
        else{
            this.volume=newVolume;
            System.out.println(name+ " volume set to "+volume);
        }
    }

    public void mute(){
        if (isOn()){
            volume=0;
            System.out.println(name+" tv is muted");
        }
        else{
            System.out.println(name+" tv is off");
        }
    }
}
