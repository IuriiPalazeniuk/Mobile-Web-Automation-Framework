package core.environment.emulator;

import utilProperties.Config;

public class AndroidSDK {

    static final String skdPath = System.getenv("LOCALAPPDATA") + "/Android/Sdk/";
    static final String deviceNameDef = Config.getAndroidProperty("deviceName");
    static final String deviceNameCMD = deviceNameDef.replace(" ", "_");
}
