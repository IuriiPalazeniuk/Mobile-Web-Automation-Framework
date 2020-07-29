package core.environment.emulator;

import utilProperties.CMDExecution;

public class Emulator extends AndroidSDK {
    //HELP: https://developer.android.com/studio/run/emulator-commandline.html

    private static final String emulatorName = "emulator";
    private static final String emulatorNameExe = emulatorName + ".exe";
    private static final String emulatorPath = skdPath + emulatorName + "/";
    private static final String emulatorExePath = emulatorPath + emulatorNameExe;
    private static final String skinLocation = skdPath + "skins";
    private static final String createDeviceCmd = emulatorExePath + " -avd " + deviceNameCMD + " -skindir " + skinLocation + " -skin " + deviceNameCMD;

    public static void emulateDevice() {
        AVDManager.createDevice();
        CMDExecution.executeWithOutWait(createDeviceCmd);
        AndroidDebugBridge.waitWhileDeviceIsReady(90);
    }
}
