package core.environment.emulator;

import utilProperties.CMDExecution;

public class AndroidDebugBridge extends core.environment.emulator.AndroidSDK {
    private static final String adbExeName = "adb.exe";
    private static final String adbExePath = skdPath + "platform-tools/" + adbExeName;
    private static final String checkStatusCmd = " shell getprop init.svc.bootanim";

    private static String getDeviceStatus() {
        String status = CMDExecution.executeWithWait(adbExePath + checkStatusCmd).toString().replace("[", "").replace("]", "").trim();
        return status.contains(",") ? status.replace(",", "") : status;
    }

    public static boolean waitWhileDeviceIsReady(long timeout) {
        do {
            String deviceStatus = getDeviceStatus();
            if (deviceStatus.contains("stopped")) {
                System.out.println("Device is ready for use");
                return true;
            } else {
                try {
                    java.util.concurrent.TimeUnit.SECONDS.sleep(1);
                    timeout--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (timeout != 0);
        return false;
    }
}
