public class OldRadio {
    private final String model;
    private boolean powered = false;
    private int volume = 0;

    public OldRadio(String model) {
        this.model = model;
    }

    public void powerOn() {
        powered = true;
        System.out.println(model + " speaker powered ON");
    }

    public void powerOff() {
        powered = false;
        System.out.println(model + " speaker powered OFF");
    }

    public void playSound() {
        if (powered)
            System.out.println(model + " speaker playing sound at volume " + volume);
        else
            System.out.println(model + " speaker is OFF");
    }

    public void setVolume(int level) {
        this.volume = level;
        System.out.println(model + " speaker volume set to " + level);
    }

    public boolean isPowered() {
        return powered;
    }

    public String label() {
        return model;
    }
}
