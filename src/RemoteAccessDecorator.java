import Abstract.Device;

public class RemoteAccessDecorator extends DeviceDecorator{
    private String remoteId;
    public RemoteAccessDecorator(Device decorator, String remoteId){
        super(decorator);
        this.remoteId=remoteId;
        System.out.println("Remote access "+super.getName()+" id:"+ remoteId);
    }
    public void remoteControl(String action){
        System.out.println("command is got "+action+" id: "+remoteId);

        String lowerCommand=action.toLowerCase();
        String deviceName=super.getName();


        if (lowerCommand.contains("on")){
            turnOn();
        }
        else if (lowerCommand.contains("off")) {
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
