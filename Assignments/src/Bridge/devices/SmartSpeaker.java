package Bridge.devices;

public class SmartSpeaker implements Device {
    private boolean on = false;
    private int volume = 50;
    private String song = "No song playing";
    private String name = "Smart Speaker";

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("SmartSpeaker: Starting up...");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("SmartSpeaker: Shutting down...");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
        System.out.println("SmartSpeaker: Volume set to " + this.volume + "%");
    }

    @Override
    public int getChannel() {
        throw new UnsupportedOperationException("SmartSpeaker doesn't support channels.");
    }

    @Override
    public void setChannel(int channel) {
        throw new UnsupportedOperationException("SmartSpeaker doesn't support channels.");
    }

    @Override
    public String getName() {
        return name;
    }

    public void playSong(String song) {
        if (on) {
            this.song = song;
            System.out.println("SmartSpeaker: Now playing \"" + song + "\"");
        } else {
            System.out.println("SmartSpeaker: Can't play song, the device is off!");
        }
    }

    public void stopMusic() {
        if (on && !song.equals("No song playing")) {
            System.out.println("SmartSpeaker: Stopping \"" + song + "\"");
            song = "No song playing";
        } else {
            System.out.println("SmartSpeaker: No music to stop!");
        }
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm a Smart Speaker.");
        System.out.println("| I'm " + (on ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + volume + "%");
        System.out.println("| " + (on ? "Currently playing: " + song : "No music playing."));
        System.out.println("------------------------------------\n");
    }
}
