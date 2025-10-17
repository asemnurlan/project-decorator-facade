import Abstract.Device;

public class VoiceControlDecorator extends DeviceDecorator{
    public VoiceControlDecorator(Device decorator){
        super(decorator);
        System.out.println("voice control works for "+getName());
    }
    public void process(String command){
        String lowerCommand=command.toLowerCase();
        String deviceName=super.getName();

        System.out.println("command is got");

        if (lowerCommand.contains("turn on")){
            turnOn();
        }
        else if (lowerCommand.contains("turn off")) {
            turnOff();
        }
        else if (lowerCommand.contains("toggle")) {
            operate();
        }
        else if (lowerCommand.contains("status")) {
            isOn();
        }
        else{
            System.out.println("command is not found");
        }
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
