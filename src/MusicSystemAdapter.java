import Abstract.Device;
public class MusicSystemAdapter implements Device {
    private final OldRadio speaker;

    public MusicSystemAdapter(OldRadio speaker) {
        this.speaker = speaker;
    }

    @Override
    public void turnOn() {
        if (!speaker.isPowered()) {
            speaker.powerOn();
            speaker.setVolume(30);
        } else {
            System.out.println(speaker.label() + " already ON");
        }
    }

    @Override
    public void turnOff() {
        if (speaker.isPowered()) {
            speaker.powerOff();
        } else {
            System.out.println(speaker.label() + " already OFF");
        }
    }

    @Override
    public boolean isOn() {
        return speaker.isPowered();
    }

    @Override
    public String getName() {
        return speaker.label() + " Adapted Speaker";
    }

    @Override
    public void operate() {
        if (speaker.isPowered()) {
            speaker.playSound();
        } else {
            System.out.println(speaker.label() + " is OFF, turning ON now...");
            speaker.powerOn();
            speaker.playSound();
        }
    }

    public void setVolume(int level) {
        if (speaker.isPowered()) {
            speaker.setVolume(level);
        } else {
            System.out.println(speaker.label() + " is OFF, can't change volume");
        }
    }
}
