import Abstract.Device;

public class VoiceControlDecorator extends DeviceDecorator{
    public VoiceControlDecorator(Device decorator){
        super(decorator);
    }
    public void voice(String command){
        if (command==null) return;
        String cmd=command.trim().toLowerCase();
        System.out.println("VoiceControl received command: "+command);

        if (cmd.contains("turn on")){
            System.out.println("VoiceControl: turn on");
            decorator.turnOn();
        }
        else if(cmd.contains("turn off")){
            System.out.println("VoiceControl: turn off");
            decorator.turnOff();
        }
        else if(cmd.contains("toggle")){
            System.out.println("VoiceControl: operate");
            decorator.operate();
        }
        else if(cmd.contains("status")){
            boolean state= decorator.isOn();
            System.out.println("VoiceControl: status"+(state ? "on":"off"));
        }

        else if (cmd.startsWith("set volume")){
            try{
                int volume=Integer.parseInt(cmd.replace("set volume","").trim());
                if (decorator instanceof MusicSystem music){
                    music.setVolume(volume);
                }
                else{
                    System.out.println("VoiceControl: this device has no volume");
                }
            }
            catch (NumberFormatException e){
                System.out.println("VoiceControl: invalid volume command");
            }
        }
        else if (cmd.startsWith("set temperature")) {
            try {
                double temp = Double.parseDouble(cmd.replace("set temperature", "").trim());
                if (decorator instanceof Thermostat thermostat) {
                    thermostat.setTemperature(temp);
                } else {
                    System.out.println("VoiceControl: this device has no temperature control");
                }
            } catch (NumberFormatException e) {
                System.out.println("VoiceControl: invalid temperature command");
            }
        }
        else if (cmd.contains("start recording")) {
            if (decorator instanceof SecurityCamera camera) {
                System.out.println("VoiceControl: start recording");
                camera.turnOn();
                camera.operate();
            } else {
                System.out.println("VoiceControl: not a camera");
            }
        }
        else if (cmd.contains("stop recording")) {
            if (decorator instanceof SecurityCamera camera) {
                System.out.println("VoiceControl: stop recording");
                camera.turnOff();
            } else {
                System.out.println("VoiceControl: not a camera");
            }
        }
        else if (cmd.contains("ionizer on")) {
            if (decorator instanceof AirPurifier purifier) {
                System.out.println("VoiceControl: enabling ionizer mode");
                purifier.operate();
            } else {
                System.out.println("VoiceControl: not an air purifier");
            }
        }
        else if (cmd.contains("lock door")) {
            if (decorator instanceof SmartDoorLock lock) {
                System.out.println("VoiceControl: locking the door");
                lock.turnOff();
            } else {
                System.out.println("VoiceControl: not a smart lock");
            }
        }
        else if (cmd.contains("unlock door")) {
            if (decorator instanceof SmartDoorLock lock) {
                System.out.println("VoiceControl: unlocking the door");
                lock.turnOn();
            } else {
                System.out.println("VoiceControl: not a smart lock");
            }
        }
        else if (cmd.contains("next channel")) {
            if (decorator instanceof SmartTV tv) {
                System.out.println("VoiceControl: switching channel");
                tv.operate();
            } else {
                System.out.println("VoiceControl: not a TV");
            }
        }
        else if (cmd.startsWith("set volume")) {
            if (decorator instanceof SmartTV tv) {
                try {
                    int vol = Integer.parseInt(cmd.replace("set volume", "").trim());
                    tv.setVolume(vol);
                } catch (Exception e) {
                    System.out.println("VoiceControl: invalid TV volume");
                }
            }
        }
        else if (cmd.contains("mute")) {
            if (decorator instanceof SmartTV tv) {
                System.out.println("VoiceControl: muting TV");
                tv.mute();
            } else {
                System.out.println("VoiceControl: not a TV");
            }
        }
        else {
            System.out.println("VoiceControl: command not recognized");
        }
    }

    @Override
    public void turnOn() {
        System.out.println("Voice control: turn on");
        decorator.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println(("Voice control: turn off"));
        decorator.turnOff();
    }

    @Override
    public void operate() {
        System.out.println("Voice control: operate");
        decorator.operate();
    }

    @Override
    public boolean isOn() {
        boolean status = decorator.isOn();
        System.out.println("Voice control: status check: "+(status ? "on" : "off"));
        return status;
    }

    @Override
    public String getName() {
        return decorator.getName()+" Voice Control";
    }
}
