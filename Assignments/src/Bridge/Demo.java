package Bridge;

import Bridge.devices.Device;
import Bridge.devices.Radio;
import Bridge.devices.SmartSpeaker;
import Bridge.devices.TV;
import Bridge.remotes.AdvancedRemote;
import Bridge.remotes.BasicRemote;
import Bridge.remotes.VoiceControlledRemote;

public class Demo {
    public static void main(String[] args) {
        testDevice(new TV());
        testDevice(new Radio());
        testDevice(new SmartSpeaker());
    }

    public static void testDevice(Device device) {
        System.out.println("Testing " + device.getName() + " with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Testing " + device.getName() + " with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();

        System.out.println("Testing " + device.getName() + " with voice controlled remote.");
        VoiceControlledRemote vcr = new VoiceControlledRemote(device);
        vcr.power();
        vcr.volumeUp();
        vcr.voiceCommand("soita Paranoid");
        device.printStatus();
        vcr.voiceCommand("stop");
        device.printStatus();

        vcr.volumeUp();
        vcr.voiceCommand("play Oops I did it again");
        device.printStatus();

        vcr.power();
        device.printStatus();
    }
}