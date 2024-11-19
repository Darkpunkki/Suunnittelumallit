package Bridge.remotes;

import Bridge.devices.Device;

public class VoiceControlledRemote extends BasicRemote {

    public VoiceControlledRemote(Device device) {
        super(device);
    }

    public void voiceCommand(String command) {
        if (device instanceof Bridge.devices.SmartSpeaker) {
            Bridge.devices.SmartSpeaker speaker = (Bridge.devices.SmartSpeaker) device;
            if (command.startsWith("play ")) {
                String song = command.substring(5);
                speaker.playSong(song);
            }
            else if (command.startsWith("soita "))
            {
                String song = command.substring(6);
                speaker.playSong(song);
            }
            else if (command.equals("stop")) {
                speaker.stopMusic();
            } else {
                System.out.println("Voice controlled remote: Unknown command \"" + command + "\"");
            }
        } else {
            System.out.println("Voice controlled remote: Voice commands are only supported for SmartSpeaker.");
        }
    }
}
