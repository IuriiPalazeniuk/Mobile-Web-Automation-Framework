package core.environment.emulator;

import utilProperties.CMDExecution;

import java.util.ArrayList;


class AVDManager extends core.environment.emulator.AndroidSDK {

    //HELP: https://developer.android.com/studio/command-line/avdmanager.html

    private static final String ADVManagerBatName = "avdmanager.bat";
    private static final String ADVManagerBatPath = skdPath + "tools/bin/";
    private static final String ADVManagerBat = ADVManagerBatPath + ADVManagerBatName;
    private static final String deviceListCmd = " -s - list device";

    //https://github.com/NativeScript/NativeScript/issues/5667
    //https://github.com/NativeScript/NativeScript/issues/5690#issuecomment-381722271

    private static final String createDeviceCmd = ADVManagerBat + " -s - create avd -n " + deviceNameCMD + " -k \"system-images;android-25;google_apis;x86\" -c 100M -d " + getDeviceID() + " -f -b x86";

    static void  createDevice() {
        CMDExecution.executeWithWait(createDeviceCmd);
    }

    private static String getDeviceID() {
        java.util.ArrayList<String> avalibleDevices = CMDExecution.executeWithWait(ADVManagerBat + deviceListCmd);

        for (String device : avalibleDevices) {
            if (device.contains(deviceNameDef)) {
                device = device.substring(device.indexOf(" "), device.indexOf("or")).trim();
                return device;
            }
        }
        System.out.println("Could not found index of the device");
        return deviceNameDef;
    }
}
